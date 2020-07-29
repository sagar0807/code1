package gov.naco.soch.cst.criteria;

import gov.naco.soch.entity.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class SearchSpecficationBuilder<T> {

	private final List<SearchOperationCriteria> params;

	public SearchSpecficationBuilder() {
		params = new ArrayList<>();
	}

	public final SearchSpecficationBuilder with(final String key, final String operation, final Object value) {
		return with(null, key, operation, value);
	}

	public final SearchSpecficationBuilder with(final String orPredicate, final String key, final String operation,
			final Object value) {
		SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
		if (op != null) {
			params.add(new SearchOperationCriteria(orPredicate, key, op, value));
		}
		return this;
	}

	public <T> Specification<T> build() {
		if (params.size() == 0)
			return null;

		Specification<T> result = new SearchSpecification(params.get(0));

		for (int i = 1; i < params.size(); i++) {
			result = params.get(i).isOrPredicate()
					? Specification.where(result).or(new SearchSpecification(params.get(i)))
					: Specification.where(result).and(new SearchSpecification(params.get(i)));
		}

		return result;
	}

	public <T> Specification<T> join(Function<SearchOperationCriteria, Specification<T>> specificationMethod) {
		if (params.size() == 0) {
			return null;
		}

		List<Specification<T>> specs = new ArrayList<>();
		for (SearchOperationCriteria param : params) {
			specs.add(specificationMethod.apply(param));
		}

		Specification<T> result = specs.get(0);
		for (int i = 1; i < specs.size(); i++) {
			result = Specification.where(result).and(specs.get(i));
		}
		return result;
	}

	public Specification<T> joinNumericFields(String entityName, String entityFieldName, Long id) {

		return (root, query, cb) -> cb.equal(root.join(entityName).get(entityFieldName), id);
	}


	public static Specification<Beneficiary> getBeneficiariesInPresentFacility(Long id) {
		return (root, query, criteriaBuilder) -> {
			SetJoin<Beneficiary, ArtBeneficiary> artSetJoin = root.join(Beneficiary_.artBeneficiary,JoinType.LEFT);
			Predicate equalPredicate = criteriaBuilder.equal(artSetJoin.get(ArtBeneficiary_.facility).get("id"), id);
			query.distinct(true);
			return equalPredicate;
		};
	}
	public static Specification<Beneficiary> getTransferredBeneficiaries(Long Id) {
		return (root, query, criteriaBuilder) -> {
			SetJoin<Beneficiary, Transfer> transferSetJoin = root.join(Beneficiary_.transfers,JoinType.LEFT);
			Predicate equalPredicate = criteriaBuilder.equal(transferSetJoin.get(Transfer_.facilityFrom).get("id"), Id);
			query.distinct(true);
			return equalPredicate;
		};
	}


	public Specification<T> join(String entityName, String entityFieldName, Object value) {

		return (root, query, cb) -> cb.equal(root.join(entityName).get(entityFieldName), value);
	}

	public Specification<T> like(String entityName, String entityFieldName, String value) {
		String search = StringUtils.trimAllWhitespace(value);
		if(search.contains("_")) {
			search = search.replaceAll("_", "\\\\_");
		}
		String finalSearch = search;
		return (root, query, cb) -> cb.like(cb.upper(root.join(entityName).get(entityFieldName)), "%" + finalSearch.toUpperCase()+ "%");
	}


	public Specification<T> dateInBetween(String entityFieldName, LocalDate fromDate, LocalDate toDate) {

		return (root, query, cb) -> cb.between(root.get(entityFieldName), fromDate, toDate);

	}

	public Specification<T> equals(String fieldName, String value) {

		return (root, query, cb) -> cb.equal(root.get(fieldName), value);

	}

	public static Specification<Beneficiary> getBeneficiaryDispensationHistory(Long facilityId) {
		return (root, query, criteriaBuilder) -> {
			SetJoin<Beneficiary, ArtDispensation> dispensationSetJoin = root.join(Beneficiary_.artDispensations,JoinType.LEFT);
			//criteriaBuilder.exists(query.subquery(Beneficiary.class).where(criteriaBuilder.equal(dispensationSetJoin.get(ArtDispensation_.facility).get("id"), facilityId));
			return criteriaBuilder.equal(dispensationSetJoin.get(ArtDispensation_.facility).get("id"), facilityId);
		};
	}

	public Specification<T> notEquals(String entityName, String entityFieldName, Long id) {

		return (root, query, cb) -> cb.notEqual(root.join(entityName).get(entityFieldName), id);
	}

	public Specification<T> lessThan(String entityName, String entityFieldName, Long id) {

		return (root, query, cb) -> cb.lessThan(root.join(entityName).get(entityFieldName), id);
	}


	public Specification<T> equalsLong(String fieldName, Long value) {

		return (root, query, cb) -> cb.equal(root.get(fieldName), value);

	}

	public final SearchSpecficationBuilder with(SearchSpecification spec) {
		params.add(spec.getCriteria());

		return this;
	}

	public final SearchSpecficationBuilder with(SearchOperationCriteria criteria) {
		params.add(criteria);
		return this;
	}
}