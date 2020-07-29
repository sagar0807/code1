package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;

@Repository
public interface ArtBeneficiaryClinicalDetailRepository extends JpaRepository<ArtBeneficiaryClinicalDetail, Long> {

	@Query(nativeQuery = true, value = "select b.* from soch.art_beneficiary_clinical_details as b "
			+ "where b.beneficiary_id = :beneficiaryId and b.visit_register_id = :visitRegisterId")
	Optional<ArtBeneficiaryClinicalDetail> findByBeneficiaryIdAndVisitRegisterId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("visitRegisterId") Long visitRegisterId);

}
