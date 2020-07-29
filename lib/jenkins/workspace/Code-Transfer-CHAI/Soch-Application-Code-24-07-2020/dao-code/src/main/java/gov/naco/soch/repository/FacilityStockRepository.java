package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constructordto.ProductDto;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.projection.BatchDetailsProjection;

@Repository
public interface FacilityStockRepository extends JpaRepository<FacilityStock, Long> {

	@Query("select NEW gov.naco.soch.constructordto.ProductDto(fs.product.id,fs.product.productName,fs.product.productCode,"
			+ " SUM(fs.currentQuantity) as currentQuantity,SUM(CASE WHEN (fs.expiredDate<:currentDate) THEN fs.currentQuantity END) as expiredQuantity,fs.product.productImage) from FacilityStock fs "
			+ "  where fs.facility.id=:facilityId GROUP BY fs.product.id,fs.product.productName,fs.product.productCode,fs.product.productImage")
	List<ProductDto> getProductsByFacility(@Param("facilityId") Long facilityId,
			@Param("currentDate") LocalDate currentDate);

	@Query("from FacilityStock where product.id=:productId")
	@EntityGraph(value = "FacilityStockGraph")
	Optional<FacilityStock> findFacilityStockByProduct(@Param("productId") Long productId);

	@Query("From FacilityStock where facility.id=:facilityId and product.id=:productId and batchNumber=:batchNumber")
	Optional<FacilityStock> findProductDetails(@Param("facilityId") Long facilityId, @Param("productId") Long productId,
			@Param("batchNumber") String batchNumber);
	
	List<BatchDetailsProjection> findByProduct_Id(Long productId);
	
	@EntityGraph(value = "FacilityStockGraph")
	List<FacilityStock> findByFacility_Id(Long facilityId);

	@EntityGraph(value = "FacilityStockGraph")
	Optional<FacilityStock> findByFacility_IdAndBatchNumberAndProduct_Id(Long facilityId, String batchNumber,
			Long productId);

	@EntityGraph(value = "FacilityStockGraph")
	List<FacilityStock> findAllByFacility_Id(Long facilityId);

	FacilityStock findByBatchNumberAndProduct_IdAndFacility_Id(String batchNumber, Long productId, Long facilityId);

	List<FacilityStock> findAllByFacilityIdAndProductId(Long facilityId, Long productId);





}
