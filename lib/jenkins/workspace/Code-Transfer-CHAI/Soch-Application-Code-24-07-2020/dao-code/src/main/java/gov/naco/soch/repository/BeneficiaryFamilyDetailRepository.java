package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryFamilyDetail;

@Repository
public interface BeneficiaryFamilyDetailRepository
		extends JpaRepository<BeneficiaryFamilyDetail, Long>, JpaSpecificationExecutor<BeneficiaryFamilyDetail> {

	boolean existsByBeneficiary_IdAndPartnerBeneficiary_IdAndIsDelete(Long beneficiaryId, Long partnerId,
			boolean isDelete);

	List<BeneficiaryFamilyDetail> findAllByBeneficiary_IdAndIsDelete(Long beneficiaryId, Boolean false1);

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_family_details bfd where bfd.beneficiary_id=:id order by bfd.created_time DESC LIMIT 1")
	BeneficiaryFamilyDetail findLatestByBeneficiary_Id(@Param("id") Long id);

	List<BeneficiaryFamilyDetail> findByPartnerBeneficiary_Id(Long beneficiaryId);
	
	@Query(value = "select * from beneficiary_family_details as bfd where bfd.beneficiary_id = :beneficiaryId "
			+ "and bfd.relationship_id = :relationshipId order by bfd.id desc limit 1", nativeQuery = true)
	Optional<BeneficiaryFamilyDetail> findByBeneficiaryIdAndRelationshipId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("relationshipId") Long relationshipId);

}
