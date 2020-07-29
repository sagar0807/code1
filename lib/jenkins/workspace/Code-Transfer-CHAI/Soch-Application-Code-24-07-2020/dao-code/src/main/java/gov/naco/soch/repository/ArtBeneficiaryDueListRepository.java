/**
 * 
 */
package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.projection.ArtBeneficiaryDueListProjection;
import gov.naco.soch.projection.ArtBeneficiaryQueueProjection;

/**
 * @author Shijithra
 *
 */
@Repository
public interface ArtBeneficiaryDueListRepository extends JpaRepository<ArtBeneficiaryDueList, Long>, CustomRepository {

	// Query for Beneficiary list by facility
	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId "
			+ "and dq.is_visited=:isVisited and dq.expected_visit_date=:VisitedDate and is_active=true and is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryDueList> findAllByFacilityId(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("VisitedDate") LocalDate VisitedDate);
	
	// Query for Beneficiary list by facility
		@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId "
				+ "and dq.is_visited=:isVisited and dq.expected_visit_date=:VisitedDate", nativeQuery = true)
		List<ArtBeneficiaryDueList> findAllByFacilityIdVisited(@Param("facilityId") Long facilityId,
				@Param("isVisited") Boolean isVisited, @Param("VisitedDate") LocalDate VisitedDate);

	// Query for Beneficiary todays list
	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId "
			+ "and dq.visited_date between :fromVisitedDate and :toVisitedDate and is_active=true and is_delete=false ", nativeQuery = true)
	List<ArtBeneficiaryDueList> findAllByTodaysList(@Param("facilityId") Long facilityId,
			@Param("fromVisitedDate") LocalDate fromVisitedDate, @Param("toVisitedDate") LocalDate toVisitedDate);

	// Query for Beneficiary missed and visited list
	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId "
			+ "and dq.visited_date between :fromVisitedDate and :toVisitedDate and dq.is_visited=:isVisited", nativeQuery = true)
	List<ArtBeneficiaryDueList> findAllByBeneficiaryDueList(@Param("facilityId") Long facilityId,
			@Param("fromVisitedDate") LocalDate fromVisitedDate, @Param("toVisitedDate") LocalDate toVisitedDate,
			@Param("isVisited") Boolean isVisited);

	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.beneficiary_id=:beneficiaryId and dq.facility_id=:facilityId and dq.expected_visit_date=:expectedVisitDate and dq.is_delete=:isDelete ", nativeQuery = true)
	Optional<ArtBeneficiaryDueList> findByBeneficiaryNextVisitDateAndIsDelete(
			@Param("beneficiaryId") Long beneficiaryId,@Param("facilityId") Long facilityId, @Param("expectedVisitDate") LocalDate expectedVisitDate,
			@Param("isDelete") boolean isDelete);

	@Query(value = "select distinct beneficiary_id as beneficiaryId from soch.art_beneficiary_due_list dq where "
			+ "dq.facility_id=:facilityId and dq.is_visited=:isVisited and dq.expected_visit_date=:visitDate and is_active=true and is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> getVisitDueCount(@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);
	
	@Query(value = "select distinct beneficiary_id as beneficiaryId from soch.art_beneficiary_due_list dq where "
			+ "dq.facility_id=:facilityId and dq.is_visited=:isVisited and dq.visited_date=:visitDate", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> getVisitedDueCount(@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);


	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_due_list ab join (\r\n"
			+ "select max(id) as id from soch.art_beneficiary_due_list\r\n"
			+ "	where beneficiary_id=:beneficiaryId)res on (ab.id=res.id) where ab.id=res.id")
	ArtBeneficiaryDueList findLatestbyBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(value = "select * from soch.art_beneficiary_due_list dq where "
			+ "dq.visit_register_id=:visitRegisterId and dq.visited_date=:localDate order by dq.id desc limit 1", nativeQuery = true)
	ArtBeneficiaryDueList findByBeneficiaryVisitRegister_Id(@Param("visitRegisterId") Long visitRegisterId,@Param("localDate") LocalDate localDate);

	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_due_list where beneficiary_id=:beneficiaryId and expected_visit_date =:expectedVisitDate and facility_id=:facilityId and is_visited =false")
	ArtBeneficiaryDueList findByBeneficiaryIdAndExpectedVisitDateAndIsvisitedAndFacilityId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("expectedVisitDate") LocalDate expectedVisitDate,
			@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_due_list where beneficiary_id=:beneficiaryId "
			+" and expected_visit_date =:expectedVisitDate and facility_id=:facilityId and is_visited =false "
			+" and entry_user=:userId")
	ArtBeneficiaryDueList findByBeneficiaryIdAssignedToAndNextAppoinmentDate(@Param("beneficiaryId")Long beneficiaryId,
			@Param("expectedVisitDate")LocalDate nextAppointmentDate,@Param("userId")Long userId,@Param("facilityId") Long facilityId);
	
	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.beneficiary_id = :beneficiaryId and dq.facility_id=:facilityId order by dq.visit_register_id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryDueList> findByBeneficiaryIdandFacilityId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true , value="select * from soch.art_beneficiary_due_list where beneficiary_id = :beneficiaryId and facility_id =:facilityId and " 
			+" is_visited = false and is_active=true and is_delete= false order by id desc limit 1;")
	ArtBeneficiaryDueList findByBeneficiaryIdAndFacilityIdAndIsVisited(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

}
