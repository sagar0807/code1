package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryCounsellingNotes;
import gov.naco.soch.entity.CounsellingNote;
import gov.naco.soch.entity.LinkedFacilityBeneficiary;

@Repository
public interface CounsellingNoteRepository 
							extends JpaRepository<CounsellingNote, Long>, JpaSpecificationExecutor<CounsellingNote> {


	@Query(value = "select * from soch.master_art_counselling_note", nativeQuery = true)
	List<CounsellingNote> findAllData(); 

}
