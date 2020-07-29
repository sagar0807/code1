package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.projection.ArtSampleCollectionProjection;

@Repository
public interface LabTestSampleRepository extends JpaRepository<LabTestSample, Long>,CustomRepository {

	List<LabTestSample> findByIsDelete(Boolean isDelete);

	@Query(value = "SELECT s.* FROM soch.lab_test_sample as s join soch.lab_test_sample_batch as b " + 
			"on s.test_batch_id = b.id where b.lab_id = :labId and s.sample_status_id = 1 " + 
			"and b.batch_status_id > 1 and s.result_status_id = 1 " + 
			"and s.is_delete = false", nativeQuery =true)
	List<LabTestSample> findSamplesToRecordResult(@Param("labId") Long labId);
	
	@Query(value = "SELECT s.* FROM soch.lab_test_sample as s join soch.lab_test_sample_batch as b " + 
			"on s.test_batch_id = b.id where b.lab_id = :labId and s.sample_status_id IN (1,4) " + 
			"and b.batch_status_id > 1 and s.result_status_id > 1 " + 
			"and s.is_delete = false", nativeQuery =true)
	List<LabTestSample> findSamplesTestResults(@Param("labId") Long labId);
	
	@Query(value = "SELECT s.* FROM soch.lab_test_sample as s join soch.lab_test_sample_batch as b " + 
			"on s.test_batch_id = b.id where b.lab_id = :labId and s.sample_status_id = 1 " + 
			"and b.batch_status_id > 1 and s.result_status_id = 2 " + 
			"and s.is_delete = false", nativeQuery =true)
	List<LabTestSample> findSamplesForApproval(@Param("labId") Long labId);
	

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where beneficiary_id = :beneficiaryId and is_delete = false")
	List<LabTestSample> findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	Boolean existsByBarcodeNumber(String barcode);

	// @Query(value = "select a from LabTestSample a where a.sampleCollectedDate=?1
	// ")
	// List<LabTestSample> findTodaysSamples(LocalDateTime localDate);

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample a where DATE(a.sample_collected_date) =CURRENT_DATE")
	List<LabTestSample> findTodaysSamples();

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where artc_sample_status='Sample Collected' and test_id=1 "
			+ "and is_delete=false and sample_collected_facility_id=:facilityId")
	List<LabTestSample> findAllCD4List(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where artc_sample_status='Sample Collected' and test_id=2 "
			+ "and is_delete=false and sample_collected_facility_id=:facilityId")
	List<LabTestSample> findAllViralList(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where artc_sample_status='Dispatched' and test_id=1 "
			+ "and is_delete=false and sample_collected_facility_id=:facilityId")
	List<LabTestSample> findAllCD4Dispatchedlist(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where artc_sample_status='Dispatched' and test_id=2 "
			+ "and is_delete=false and sample_collected_facility_id=:facilityId")
	List<LabTestSample> findAllViralDispatchedList(@Param("facilityId") Long facilityId);

	List<LabTestSample> findAllByArtcSampleStatus(String string);

	@Query(nativeQuery = true, value = "select max(id) from soch.lab_test_sample")
	Long findMaxOfId();

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where result_status_id=4 and test_id=1 "
			+ "and is_delete=false and sample_collected_facility_id=:facilityId")
	List<LabTestSample> findAllCD4TestResults(@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample where result_status_id=4 and test_id=1 "
			+ "and is_delete=false and sample_collected_facility_id=:facilityId and beneficiary_id = :beneficiaryId "
			+ "and id < :id order by id desc limit 1")
	Optional<LabTestSample> findPreviousCD4TestResults(@Param("id") Long id, @Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

	List<LabTestSample> findAllByIsDeleteAndSampleCollectedFacilityId(Boolean false1, Long facilityId);

	@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.result_status_id=4 and s.test_id=1 "
			+ "and s.is_delete=false and s.sample_collected_facility_id=:facilityId and s.beneficiary_id = :beneficiaryId "
			+ "and s.type_of_specimen = 'Good'")
	List<LabTestSample> findAllCD4TestResultsOfBeneficiary(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.result_status_id=4 and s.test_id=2 "
			+ "and s.is_delete=false and s.sample_collected_facility_id=:facilityId and s.beneficiary_id = :beneficiaryId")
	List<LabTestSample> findAllVLTestResultsOfBeneficiary(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select s.* from soch.lab_test_sample as s where s.test_id=4 "
			+ "and s.is_delete=false and s.beneficiary_id = :beneficiaryId and s.dispatched_to_lab_id= :facilityId "
			+ "and s.id < :sampleId")
	List<LabTestSample> findPreviousDBSDetails(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("sampleId") Long sampleId);

	@Query(nativeQuery = true, value = "select s.barcode_number from soch.lab_test_sample as s "
			+ "where s.barcode_number is not null")
	List<String> findAllBarcodes();

	Optional<LabTestSample> findByBarcodeNumber(@Valid String barcode);

	@Query(nativeQuery = true, value = "SELECT count(lts.beneficiary_id) as PATIENT_LOAD\r\n"
			+ "FROM soch.lab_test_sample lts where lts.next_appointment_date=:date and \r\n"
			+ "lts.sample_collected_facility_id=:facilityId and lts.dispatched_to_lab_id=85\r\n"
			+ "GROUP BY lts.next_appointment_date")
	Integer findBeneficiaryLoadByDate(@Param("facilityId")Long facilityId,@Param("date")LocalDate date);
	
	@Query(nativeQuery = true, value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.test_type_id as testTypeId, " 
	+ "lts.test_id as testId,lts.artc_sample_status as artcSampleStatus,lts.lab_technician_id as labTechnicianId, " 
	+ "b.id as beneficiaryId,b.uid as uid,b.age as age,b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, " 
	+ "mg.name as genderId,b.art_number as artNumber,b.pre_art_number as preArtNumber, t.type_of_test as test, mt.test_type as testType from " 
	+ "soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id "
	+ "join soch.test as t on (t.id = lts.test_id) left outer join soch.master_test_type mt on (mt.id = lts.test_type_id) where lts.is_delete = false " 
	+ "and lts.sample_collected_facility_id =:facilityId and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% "
	+ "or lower(b.pre_art_number) like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or "
	+ "lower(b.middle_name) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or "
	+ "concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )" )
	List<ArtSampleCollectionProjection> searchInSampleList(@Param("facilityId")Long facilityId,@Param("searchText") String searchValue);
	
	@Query(nativeQuery = true,value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.type_of_specimen as typeOfSpecimen, " 
	+ "lts.result_value as resultValue,lts.result_dispatch_date as resultDispatchDate,b.id as beneficiaryId,b.uid as uid,b.age as age, "
	+ "b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, mab.name as beneficiaryStatus, f.name as facilityName, "
	+ "f.id as facilityId,b.art_number as artNumber,b.pre_art_number as preArtNumber, mg.name as genderId from " 
	+ "soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id join soch.art_beneficiary art on art.beneficiary_id = b.id " 
	+ "join soch.master_art_beneficiary_status mab on mab.id = art.art_beneficiary_status_id join soch.lab_test_sample_batch lb on "
	+ "lb.id = lts.test_batch_id join soch.facility f on f.id = lb.lab_id where lts.is_delete = false and lts.sample_collected_facility_id =:facilityId "
	+ "and lts.result_status_id= 4 and lts.test_id= 1 and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% or lower(b.pre_art_number) "
	+ "like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or lower(b.middle_name) like %:searchText% or "
	+ "concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name)) "
	+ "like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )")
	List<ArtSampleCollectionProjection> searchInCD4TestResults(@Param("facilityId")Long facilityId,@Param("searchText") String searchText);
	
	
	@Query(nativeQuery = true, value = "select lts.id as sampleId,lts.sample_collected_date as sampleCollectedDate,lts.test_type_id as testTypeId, " 
	+ "lts.test_id as testId,lts.artc_sample_status as artcSampleStatus,lts.lab_technician_id as labTechnicianId, " 
	+ "b.id as beneficiaryId,b.uid as uid,b.age as age,b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName, " 
	+ "mg.name as genderId,b.art_number as artNumber,b.pre_art_number as preArtNumber, t.type_of_test as test, mt.test_type as testType from " 
	+ "soch.lab_test_sample lts join soch.beneficiary b on b.id = lts.beneficiary_id join soch.master_gender mg on mg.id = b.gender_id "
	+ "join soch.test as t on (t.id = lts.test_id) left outer join soch.master_test_type mt on (mt.id = lts.test_type_id) where lts.artc_sample_status= 'Dispatched' and lts.test_id= 1 and lts.is_delete = false " 
	+ "and lts.sample_collected_facility_id =:facilityId and (lower(b.age) like %:searchText%  or lower(b.uid) like %:searchText% or lower(b.art_number) like %:searchText% "
	+ "or lower(b.pre_art_number) like %:searchText% or lower(b.first_name) like %:searchText% or lower(b.last_name) like %:searchText% or "
	+ "lower(b.middle_name) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchText% or "
	+ "concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchText% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchText% )" )
	List<ArtSampleCollectionProjection> findAllCD4DispatchedlistByProjection(@Param("facilityId")Long facilityId,@Param("searchText") String searchText);
}
