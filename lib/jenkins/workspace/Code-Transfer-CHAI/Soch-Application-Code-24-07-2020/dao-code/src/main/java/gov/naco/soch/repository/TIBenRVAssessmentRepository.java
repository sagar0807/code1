package gov.naco.soch.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenRVAssessment;

/**
 * Spring Data repository for the TIBenRVAssessment entity.
 */
@Repository
public interface TIBenRVAssessmentRepository
		extends JpaRepository<TIBenRVAssessment, Long>, JpaSpecificationExecutor<TIBenRVAssessment> {

	@Query(value = "select t.* from soch.ti_ben_rv_assessment as t where t.facility_id = :facilityId "
			+ "and t.modified_time>=:startDate and t.modified_time <= :endDate", nativeQuery = true)
	List<TIBenRVAssessment> findByFacilityIdAndDate(@Param("facilityId") Long facilityId,
			@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
	
	@Query("select  max(assessmentDate) from TIBenRVAssessment where beneficiary.id=:beneficiaryId ")
	LocalDate findLatestAssessment(@Param("beneficiaryId")Long beneficiaryId);
}
