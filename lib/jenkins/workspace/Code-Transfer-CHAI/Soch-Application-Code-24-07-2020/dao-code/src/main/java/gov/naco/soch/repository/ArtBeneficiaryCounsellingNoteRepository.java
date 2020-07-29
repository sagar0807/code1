package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryCounsellingNotes;


@Repository
public interface ArtBeneficiaryCounsellingNoteRepository 
							extends JpaRepository<ArtBeneficiaryCounsellingNotes, Long>, JpaSpecificationExecutor<ArtBeneficiaryCounsellingNotes>{


	@Query(value = "select * from soch.art_beneficiary_counselling_notes cn where cn.beneficiary_id=:beneficiaryId", nativeQuery = true)
	List<ArtBeneficiaryCounsellingNotes> findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
	
}
