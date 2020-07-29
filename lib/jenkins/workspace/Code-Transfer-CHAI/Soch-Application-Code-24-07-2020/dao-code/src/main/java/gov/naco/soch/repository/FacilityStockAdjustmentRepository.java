package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityStockAdjustment;

@Repository
public interface FacilityStockAdjustmentRepository extends JpaRepository<FacilityStockAdjustment, Long> {

	List<FacilityStockAdjustment> findAllByFacility_IdAndProduct_Id(Long facilityId, Long productId);


	/*
	 * @Query("select NEW gov.naco.soch.constructordto.StockAdjustHistoryDto(fsa.id as id,fsa.facilityStock.product.productName as productName,fsa.facilityStock.batchNumber as batchNumber,fsa.createdTime as date,fsa.currentStockQuantity as"
	 * +
	 * " currentStockQuantity,fsa.adjustStockQuantity as adjustStockQuantity,CASE WHEN fsa.type='add' THEN (fsa.currentStockQuantity + fsa.adjustStockQuantity) "
	 * +
	 * " WHEN fsa.type='subtract' THEN (fsa.currentStockQuantity - fsa.adjustStockQuantity) END as newStock,fsa.type as type,fsa.remark as remark) from FacilityStockAdjustment fsa where fsa.facilityId=:facilityId"
	 * ) List<StockAdjustHistoryDto> findAllByFacilityId(@Param("facilityId")Long
	 * facilityId);
	 */

}
