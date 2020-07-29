package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.projection.ArtBeneficiaryQueueProjection;

//repository mapped with entity class

@Repository
public interface ArtBeneficiaryQueueRepository extends JpaRepository<ArtBeneficiaryQueue, Long>, CustomRepository {

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.assigned_to=:assignedTo "
			+ "and bq.facility_id=:facilityId and bq.is_visited=:isVisited and bq.visit_date=:visitDate "
			+ "and is_active=true and is_delete=false order by bq.id asc", nativeQuery = true)
	List<ArtBeneficiaryQueue> findAllByAssignedTo(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.assigned_to=:assignedTo and bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate order by bq.id asc", nativeQuery = true)
	List<ArtBeneficiaryQueue> findAllByAssignedToVisited(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	ArtBeneficiaryQueue findByBeneficiaryIdAndIsVisitedAndIsDelete(Long beneficiaryId, boolean b, boolean c);

	@Query(value = "select distinct beneficiary_id as beneficiaryId from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to IN :assignedTo and is_active=true and is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> getQueueCount(@Param("assignedTo") List<Long> assignedTo,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select distinct beneficiary_id as beneficiaryId from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to IN :assignedTo", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> getVisitedQueueCount(@Param("assignedTo") List<Long> assignedTo,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.assigned_to=:assignedTo and "
			+ "bq.facility_id=:facilityId and bq.visit_date=:visitDate and bq.beneficiary_id = :beneficiaryId and is_visited=false order by bq.id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findBeneficiaryAssignedTo(@Param("beneficiaryId") Long beneficiaryId,
			@Param("assignedTo") Long assignedTo, @Param("facilityId") Long facilityId,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select * from soch.art_beneficiary_queue bq where "
			+ "bq.facility_id=:facilityId and bq.visit_date=:visitDate and bq.beneficiary_id = :beneficiaryId and is_visited=false", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findBeneficiaryInQueue(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.visit_register_id = :beneficiaryVisitRegisterId"
			+ " and bq.is_visited = true", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findByVisitRegisterId(
			@Param("beneficiaryVisitRegisterId") Long beneficiaryVisitRegisterId);

	/**
	 * @param beneficiaryid
	 * @param facilityId
	 * @return
	 */
//	@Query(nativeQuery = true,value = "select * from soch.art_beneficiary_queue where beneficiary_id=:beneficiaryId and facility_id=:facilityId and is_visited=false and visit_date= Current_Date")

	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_queue bq where bq.beneficiary_id=:beneficiaryId and bq.facility_id=:facilityId and bq.is_visited=false order by bq.id desc limit 1 ")
	ArtBeneficiaryQueue findByBeneficiaryIdAndCurrentDateAndIsvisitedAndFacilityId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.assigned_to=:assignedTo AND "
			+ "bq.facility_id=:facilityId AND bq.visit_date=:visitDate AND bq.beneficiary_id = :beneficiaryId and bq.is_visited=:b order by bq.created_time DESC LIMIT 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findLatestByBeneficiaryIdAndAssignedTo(@Param("beneficiaryId") Long beneficiaryId,
			@Param("assignedTo") Long assignedTo, @Param("facilityId") Long facilityId,
			@Param("visitDate") LocalDate visitDate, @Param("b") Boolean b);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.beneficiary_id = :beneficiaryId and bq.facility_id=:facilityId order by bq.visit_register_id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findByBeneficiaryIdandFacilityId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

}
