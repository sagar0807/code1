package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryIptAttDetails;

@Repository
public interface ArtBeneficiaryIptAttDetailsRepository extends JpaRepository<ArtBeneficiaryIptAttDetails, Long> {
	
	@Query(nativeQuery = true, value = "select b.* from soch.art_beneficiary_ipt_att_details as b "
			+ " where b.beneficiary_id = :beneficiaryId and b.visit_register_id = :visterId ")
	Optional<ArtBeneficiaryIptAttDetails> findByBeneficiaryIdAndVisitRegisterId(@Param("beneficiaryId")Long beneficiaryId,
			@Param("visterId")Long visterId);

}
