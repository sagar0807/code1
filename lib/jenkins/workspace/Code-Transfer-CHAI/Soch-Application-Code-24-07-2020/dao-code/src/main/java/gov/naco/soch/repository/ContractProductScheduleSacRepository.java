package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ContractProductScheduleSac;

@Repository
public interface ContractProductScheduleSacRepository extends JpaRepository<ContractProductScheduleSac, Long> {

	@Query(nativeQuery=true,value = "select * from soch.Contract_product_schedule_sacs cpss join "
			+ "soch.contract_product_schedule cps on (cpss.contract_product_schedule_id=cps.id) join "
			+ " soch.contract_product cp on (cp.id=cps.contract_product_id) join "
			+ "soch.contract c on (c.contract_id=cp.contract_id) where to_facility=(:sacsId)")
	List<ContractProductScheduleSac> findByFacility(@Param("sacsId")Integer sacsId);

}
