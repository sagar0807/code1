/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryImmunizationReport;

@Repository
public interface ArtBeneficiaryImmunizationReportRepository
		extends JpaRepository<ArtBeneficiaryImmunizationReport, Long> {

	/**
	 * @param beneficiaryid
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_immunization_report where beneficiary_id=:beneficiaryid")
	List<ArtBeneficiaryImmunizationReport> findAllByBeneficiaryId(@Param("beneficiaryid") Long beneficiaryid);

	/*@Modifying
	@Query(nativeQuery = true, value = "delete from soch.art_beneficiary_immunization_report where beneficiary_id=:beneficiaryId ")*/
	void deleteByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select count(*) from soch.art_beneficiary_immunization_report where beneficiary_id=:beneficiaryId ")
	int findCountByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

}
