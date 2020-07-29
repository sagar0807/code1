package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiaryFamilyDetails;

/**
 * Spring Data  repository for the BeneficiaryFamilyDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BeneficiaryFamilyDetailsRepository extends JpaRepository<BeneficiaryFamilyDetails, Long>, JpaSpecificationExecutor<BeneficiaryFamilyDetails> {
	List<BeneficiaryFamilyDetails> findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(Long beneficiaryId, Integer relationshipId);
	List<BeneficiaryFamilyDetails> findByBeneficiaryIdAndMemberBeneficiaryIdOrderByIdDesc(Long beneficiaryId, Long memberBeneficiaryId);
}
