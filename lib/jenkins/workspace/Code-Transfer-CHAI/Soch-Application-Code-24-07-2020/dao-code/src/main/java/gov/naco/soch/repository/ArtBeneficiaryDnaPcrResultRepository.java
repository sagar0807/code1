/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryDnaPcrResult;
import gov.naco.soch.entity.ArtBeneficiaryVitaminA;


@Repository
public interface  ArtBeneficiaryDnaPcrResultRepository  extends JpaRepository< ArtBeneficiaryDnaPcrResult , Long> {
	@Query(nativeQuery = true,value ="select * from soch.art_beneficiary_dna_pcr_result where beneficiary_id=:beneficiaryid" )
	List<ArtBeneficiaryDnaPcrResult> findAllByBeneficiaryId(@Param("beneficiaryid") Long beneficiaryid);

	@Query(nativeQuery = true, value = "select count(*) from soch.art_beneficiary_dna_pcr_result where beneficiary_id=:beneficiaryId ")
	int findCountByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	void deleteByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
	}
