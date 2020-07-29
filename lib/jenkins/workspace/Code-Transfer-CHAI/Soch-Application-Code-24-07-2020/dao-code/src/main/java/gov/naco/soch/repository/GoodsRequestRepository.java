package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.GoodsRequest;

@Repository
public interface GoodsRequestRepository extends JpaRepository<GoodsRequest, Long>,CustomRepository{

	@Query(value = "select g.* from soch.goods_request g where g.facility_id = :facilityId", nativeQuery = true)
	List<GoodsRequest> findByFacilityId(@Param("facilityId") Long facilityId);
	
	@Query(value = "select g.* from soch.goods_request g where g.sacs_id = :sacsId", nativeQuery = true)
	List<GoodsRequest> findBySacsId(@Param("sacsId") Long sacsId);

	@Query(value = "select g.* from soch.goods_request g where g.product_id = :productId and g.facility_id = :facilityId order by g.id desc", nativeQuery = true)
	List<GoodsRequest> findByProductIdAndFacilityId(@Param("productId") Long productId, @Param("facilityId") Long facilityId);

	


}
