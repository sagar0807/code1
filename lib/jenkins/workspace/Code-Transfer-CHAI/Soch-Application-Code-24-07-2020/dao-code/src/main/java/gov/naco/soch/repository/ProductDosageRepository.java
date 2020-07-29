package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductDosage;

@Repository
public interface ProductDosageRepository extends JpaRepository<ProductDosage, Long>, CustomRepository {

	List<ProductDosage> findAllByIsDeleteOrderByProductIdAsc(Boolean false1);

	Optional<ProductDosage> findByIdAndIsDelete(Long dosageId, Boolean false1);

	Optional<ProductDosage> findByProduct_Id(Long productId);

	/*
	 * @Query(value =
	 * "select p from ProductDosage p where p.productId in ('ATV/r-A') ")
	 * List<ProductDosage> findSubstituitionDrugs();
	 */

}
