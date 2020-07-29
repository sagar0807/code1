package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityAggregateStock;
import gov.naco.soch.projection.ProductInventoryProjection;

@Repository
public interface FacilityAggregateStockRepository extends JpaRepository<FacilityAggregateStock, Long> {

	List<FacilityAggregateStock> findAllByFacilityId(Long facilityId);

	FacilityAggregateStock findByFacilityIdAndProductId(Long facilityId, Long productId);

	@Query(nativeQuery = true, value = "select\r\n" + "	p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,\r\n" + "	p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,\r\n" + "	fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity," + "	sum(fas.git) as git\r\n" + "from\r\n"
			+ "	(\r\n" + "	select\r\n" + "		product_id, facility_id, git,damaged_quantity,\r\n" + "		case\r\n"
			+ "			when date(batch_expiry_date) < date(now()) then 0\r\n" + "			else available_quantity\r\n"
			+ "		end as available_quantity,\r\n" + "		case\r\n"
			+ "			when date(batch_expiry_date) < date(now()) then available_quantity\r\n" + "			else 0\r\n"
			+ "		end as expired_quantity\r\n" + "	from\r\n" + "		soch.facility_aggregate_stock\r\n"
			+ "	where\r\n" + "		facility_id = :facilityId) as fas\r\n" + "join soch.product as p on\r\n"
			+ "	p.id = fas.product_id\r\n" + "group by\r\n" + "	fas.product_id,\r\n" + "	fas.facility_id,\r\n"
			+ "	p.product_name,\r\n" + "	p.product_image,p.product_short_code\r\n" + "having\r\n"
			+ "	fas.facility_id = :facilityId")
	List<ProductInventoryProjection> findAllByFacilityIdToProjection(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select\r\n" + "	p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,\r\n" + "	p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,\r\n" + "	fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,\r\n" + "	sum(fas.git) as git\r\n" + "from\r\n"
			+ "	(\r\n" + "	select\r\n" + "		product_id, facility_id, git,damaged_quantity,\r\n" + "		case\r\n"
			+ "			when date(batch_expiry_date) < date(now()) then 0\r\n" + "			else available_quantity\r\n"
			+ "		end as available_quantity,\r\n" + "		case\r\n"
			+ "			when date(batch_expiry_date) < date(now()) then available_quantity\r\n" + "			else 0\r\n"
			+ "		end as expired_quantity\r\n" + "	from\r\n" + "		soch.facility_aggregate_stock\r\n"
			+ "	where\r\n" + "		facility_id = :facilityId\r\n" + "		and product_id = :productId) as fas\r\n"
			+ "join soch.product as p on\r\n" + "	p.id = fas.product_id\r\n" + "group by\r\n" + "	fas.product_id,\r\n"
			+ "	fas.facility_id,\r\n" + "	p.product_name,\r\n" + "	p.product_image,\r\n" + "	p.product_short_code\r\n"
			+ "having\r\n" + "	fas.facility_id = :facilityId\r\n" + "	and fas.product_id = :productId")
	ProductInventoryProjection findByFacilityIdAndProductIdToProjection(@Param("facilityId") Long facilityId,
			@Param("productId") Long productId);

	List<FacilityAggregateStock> findAllByFacilityIdAndProductId(Long facilityId, Long productId);

	@Query(nativeQuery = true, value = "select\r\n" + "	p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,\r\n" + "	p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,p.product_commodity_type_id,\r\n" + "	fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,\r\n" + "	sum(fas.git) as git\r\n" + "from\r\n"
			+ "	(\r\n" + "	select\r\n" + "		product_id, facility_id, git,damaged_quantity,\r\n" + "		case\r\n"
			+ "			when date(batch_expiry_date) < date(now()) then 0\r\n" + "			else available_quantity\r\n"
			+ "		end as available_quantity,\r\n" + "		case\r\n"
			+ "			when date(batch_expiry_date) < date(now()) then available_quantity\r\n" + "			else 0\r\n"
			+ "		end as expired_quantity\r\n" + "	from\r\n" + "		soch.facility_aggregate_stock\r\n"
			+ "	where\r\n" + "		facility_id = :facilityId) as fas\r\n" + "join soch.product as p on\r\n"
			+ "	p.id = fas.product_id\r\n" + "group by\r\n" + "	fas.product_id,\r\n" + "	fas.facility_id,\r\n"
			+ "	p.product_name,p.product_commodity_type_id,\r\n" + "p.product_image,\r\n"
			+ "	p.product_short_code\r\n" + "having\r\n"
			+ "	fas.facility_id = :facilityId and p.product_commodity_type_id=:typeId")
	List<ProductInventoryProjection> findAllARVDrugs(@Param("typeId") Long typeId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,p.product_commodity_type_id,fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,sum(fas.git) as git from\r\n"
			+ "	(select product_id, facility_id, git,damaged_quantity, case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then 0 else available_quantity\r\n"
			+ "	end as available_quantity, case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then available_quantity\r\n" + "			else 0\r\n"
			+ "	end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "	where facility_id = :facilityId) as fas join soch.product as p on\r\n"
			+ "	p.id = fas.product_id group by fas.product_id, fas.facility_id,\r\n"
			+ "	p.product_name,p.product_commodity_type_id, p.product_image, p.product_short_code\r\n"
			+ "having fas.facility_id = :facilityId and (p.product_commodity_type_id!=:typeId or p.product_commodity_type_id IS NULL)")
	List<ProductInventoryProjection> findAllNonARVDrugs(@Param("typeId") Long typeId,
			@Param("facilityId") Long facilityId);

	/*
	 * @Modifying
	 * 
	 * @Query(nativeQuery = true, value =
	 * "update soch.facility_aggregate_stock set expired_quantity = available_quantity, available_quantity=0, modified_time = current_timestamp\r\n"
	 * + " where available_quantity <>0 and date(batch_expiry_date) < now()") int
	 * updateExpiredQuantityInAggregateStock();
	 */

}
