package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtPepDispensationItem;
import gov.naco.soch.projection.ArtDispensationItemProjection;

@Repository
public interface ArtPepDispensationItemRepository extends JpaRepository<ArtPepDispensationItem, Long> {

	@Query(nativeQuery = true, value = "SELECT adi.product_id as productId, pr.product_name as productName, SUM(dispense_quantity) as dispensedQuantity\r\n"
			+ "FROM soch.art_pep_dispensation_item adi join soch.product pr on\r\n"
			+ "(pr.id=adi.product_id) where adi.art_pep_dispensation_id=:artPepDispensedId\r\n"
			+ "GROUP BY product_id,product_name")
	List<ArtDispensationItemProjection> findDispensedProductDetails(@Param("artPepDispensedId")Long artPepDispensedId);

}
