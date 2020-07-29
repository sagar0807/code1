/**
 * 
 */
package gov.naco.soch.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import gov.naco.soch.criteria.SearchCriteria;
import gov.naco.soch.entity.UserMaster;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Feb-20 3:38:44 pm 
 * 
 */
public class UserSpecification implements Specification<UserMaster> {
	private SearchCriteria criteria;

	/**
	 * @param searchCriteria
	 */
	public UserSpecification(SearchCriteria searchCriteria) {
		// TODO Auto-generated constructor stub
		this.criteria=searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<UserMaster> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		  if (criteria.getOperation().equalsIgnoreCase(">")) {
	            return criteriaBuilder.greaterThanOrEqualTo(
	              root.<String> get(criteria.getKey()), criteria.getValue().toString().toLowerCase());
	        } 
	        else if (criteria.getOperation().equalsIgnoreCase("<")) {
	            return criteriaBuilder.lessThanOrEqualTo(
	              root.<String> get(criteria.getKey()), criteria.getValue().toString().toLowerCase());
	        } 
	        else if(criteria.getOperation().equalsIgnoreCase("=")) {
	        	return criteriaBuilder.like(
		                  root.<String>get(criteria.getKey()), "=" + (boolean)criteria.getValue());
	        }
	        else if (criteria.getOperation().equalsIgnoreCase(":")) {
	            if (root.get(criteria.getKey()).getJavaType() == String.class) {
	                return criteriaBuilder.like(
	                  root.<String>get(criteria.getKey()), "%" + criteria.getValue().toString()+ "%");
	            } else {
	                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue().toString());
	            }
	        }
	        return null;
	}

	@Override
	public String toString() {
		return "UserSpecification [criteria=" + criteria + "]";
	}

}
