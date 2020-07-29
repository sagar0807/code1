package gov.naco.soch.cst.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class SearchSpecification<T> implements Specification<T> {

	private static final long serialVersionUID = 1L;
	private SearchOperationCriteria criteria;

	public SearchSpecification(SearchOperationCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	public SearchOperationCriteria getCriteria() {
		return criteria;
	}

	@Override
	public Predicate toPredicate(final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
		switch (criteria.getOperation()) {
			case EQUALITY:
				if (root.get(criteria.getKey()).getJavaType() == String.class) {
					String search = StringUtils.trimAllWhitespace(criteria.getValue().toString());
					return builder.equal(builder.upper(root.get(criteria.getKey())), search.toUpperCase());
				} else if (root.get(criteria.getKey()).getJavaType() == Boolean.class) {
					return builder.equal(root.get(criteria.getKey()), Boolean.parseBoolean(criteria.getValue().toString().trim()));
				} else {
					return builder.equal(root.get(criteria.getKey()), criteria.getValue());
				}

			case LIKE:
				if (root.get(criteria.getKey()).getJavaType() == String.class) {
					String search = StringUtils.trimAllWhitespace(criteria.getValue().toString());


                    if(search.contains("_")) {
                        search = search.replaceAll("_", "\\\\_");
                    }

					return builder.like(builder.upper(
							root.<String>get(criteria.getKey())), "%" + search.toUpperCase() + "%");
				}
			default:
				return null;
		}
	}

}