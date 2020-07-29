package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssWarehouse;

@Repository
public interface CmssWarehouseRepository extends JpaRepository<CmssWarehouse, Long> {

	Boolean existsByStoreId(String storeId);

	@Query(nativeQuery=true,value="select count(c.store_id) from soch.cmss_warehouse c where c.store_id=:storeId and id!=:id")
	int existsByIdAndStoreId(@Param("id")Long id,@Param("storeId") String storeId);

	List<CmssWarehouse> findAllByOrderByIdAsc();

}
