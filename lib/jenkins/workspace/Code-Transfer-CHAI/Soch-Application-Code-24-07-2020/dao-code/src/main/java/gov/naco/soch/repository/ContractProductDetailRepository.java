package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ContractProduct;

@Repository
public interface ContractProductDetailRepository extends JpaRepository<ContractProduct, Integer> {

	@Query("select distinct cp.product.id from ContractProduct cp join Contract c on c.contractId=cp.contract.contractId "
			+ "join ContractProductSchedule cps "
			+ "on cp.id=cps.contractProduct.id join ContractProductScheduleSac cpss "
			+ "on cps.id=cpss.contractProductSchedule.id where cpss.facility.id=:sacsId and c.contractStatusMaster.id=3 and c.isDelete=false and c.facility.id=:facilityId")
	List<Long> findBySacs(@Param ("sacsId")Long sacsId, @Param ("facilityId")Long facilityId);

	Optional<ContractProduct> findByContract_ContractIdAndProduct_Id(Long contractId, Long productId);

}
