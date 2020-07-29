package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.ICTCBeneficiary;

/**
 * Spring Data  repository for the ICTCBeneficiary entity.
 */
@Repository
public interface ICTCBeneficiaryRepository extends JpaRepository<ICTCBeneficiary, Long>, JpaSpecificationExecutor<ICTCBeneficiary> {
	
	@Modifying
	@Query("update ICTCBeneficiary ib set ib.isDeleted=true, ib.isActive=false where ib.id=:id")
	void markEntryAsDeletedAndInActive(@Param("id") Long id);
	
	Long countByPid(String pid);
	
	@Query("select count(ib) from ICTCBeneficiary ib where ib.pid=:pid and (ib.deleteReason != 5 or ib.deleteReason is null)")
	Long countByPidAndDeleteReasonNot(@Param("pid") String pid);
	
	Long countByInfantCode(String infantCode);
	
	@Query("select count(ib) from ICTCBeneficiary ib where ib.beneficiary.id=:beneficiaryId")
	Long countByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
}
