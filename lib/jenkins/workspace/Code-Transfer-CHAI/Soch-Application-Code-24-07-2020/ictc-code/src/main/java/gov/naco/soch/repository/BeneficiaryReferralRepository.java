package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiaryReferral;

/**
 * Spring Data  repository for the BeneficiaryReferral entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BeneficiaryReferralRepository extends JpaRepository<BeneficiaryReferral, Long>, JpaSpecificationExecutor<BeneficiaryReferral> {
	
	@Query("select br from BeneficiaryReferral br where (br.referDate >=:startDate and br.referDate <=:endDate) and (br.referedFrom.id in :referedFromFacilityIds and br.referedTo.id in :referedToFacilityIds) and br.referralStatusId = 2 and br.isActive = true")
	List<BeneficiaryReferral> findAllByFacilityAndDateForStatusUpdate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("referedFromFacilityIds") Set<Long> referedFromFacilityIds, @Param("referedToFacilityIds") Set<Long> referedToFacilityIds);
	
	@Query("select br from BeneficiaryReferral br where br.beneficiary.id=:beneficiaryId and (br.isDelete != true or br.isDelete = null)")
	List<BeneficiaryReferral> findAllActiveReferralsForABeneficiary(@Param("beneficiaryId")Long beneficiaryId);
	
	@Query("select br from BeneficiaryReferral br where (br.referDate >=:startDate and br.referDate <=:endDate) and br.referedFrom.id in :referedFromFacilityIds and br.referralStatusId = 2 and br.isActive = true")
	List<BeneficiaryReferral> findAllByFacilityAndDateForStatusUpdateByReferredFrom(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("referedFromFacilityIds") Set<Long> referedFromFacilityIds);
	
}
