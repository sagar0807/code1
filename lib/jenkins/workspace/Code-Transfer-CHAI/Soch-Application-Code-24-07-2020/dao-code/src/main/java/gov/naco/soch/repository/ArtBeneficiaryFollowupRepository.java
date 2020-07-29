package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;

@Repository
public interface ArtBeneficiaryFollowupRepository
		extends JpaRepository<ArtBeneficiaryFollowup, Long>, JpaSpecificationExecutor<ArtBeneficiaryFollowup> {

	ArtBeneficiaryFollowup findByBeneficiaryIdAndAndIsDelete(Long beneficiaryId, boolean b);

	@Query(nativeQuery = true, value = "select f.* from soch.art_beneficiary_followup as f where f.visit_register_id = :visitRegisterId")
	Optional<ArtBeneficiaryFollowup> findByVisitRegisterId(@Param("visitRegisterId") Long visitRegisterId);

	@Query(nativeQuery = true, value = "select b.* from soch.art_beneficiary_followup as b "
			+ "where b.beneficiary_id = :beneficiaryId and b.visit_register_id = :visitRegisterId")
	Optional<ArtBeneficiaryFollowup> findByBeneficiaryIdAndVisitRegisterId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("visitRegisterId") Long visitRegisterId);

	ArtBeneficiaryFollowup findByBeneficiaryVisitRegisterIdAndAndIsDelete(Long id, boolean b);
	
	@Query(nativeQuery = true, value="Select * from soch.art_beneficiary_followup where is_delete=false and beneficiary_id=:beneficiary_id and visit_date= Current_Date ")
    ArtBeneficiaryFollowup findByBeneficiaryIdAndIsdeleteAndVisitDate(@Param ("beneficiary_id") Long beneficiary_id);

	@Query("select adherenceToArt from ArtBeneficiaryFollowup where beneficiary.id=:beneficiaryId and isDelete=:isDelete ")
	Long getAdherence(@Param("beneficiaryId")Long beneficiaryId,@Param("isDelete")boolean isDelete);
}
