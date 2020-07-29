package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.LabTestSampleBatch;

@Repository
public interface LabTestSampleBatchRepository extends JpaRepository<LabTestSampleBatch, Long>,CustomRepository{

	List<LabTestSampleBatch> findAllByLabId(Long labId);

	List<LabTestSampleBatch> findByLabIdAndIsDelete(Long labId, Boolean isDelete);

	@Query(nativeQuery = true, value = "select * from soch.lab_test_sample_batch ads join soch.lab_test_sample ars on"
			+ " ars.test_batch_id=ads.id where ars.test_id=1 and ars.sample_collected_facility_id=:facilityId order by sample_dispatch_date")
	List<LabTestSampleBatch> findAllCD4(@Param("facilityId") Long facilityId);

	// @Query(nativeQuery = true, value = "select * from soch.lab_test_sample_batch
	// ads join soch.lab_test_sample ars on"
	// + " ars.test_batch_id=ads.id where ars.test_id=2 order by
	// sample_dispatch_date")
	// List<LabTestSampleBatch> findAllViralLoad();
	@Query(nativeQuery = true, value = "select ltsb.* from soch.lab_test_sample_batch ltsb "
			+ "join soch.lab_test_sample lts on lts.test_batch_id=ltsb.id "
			+ "where lts.test_id=2 and lts.sample_collected_facility_id=:facilityId and ltsb.bdn_serial_number IS NOT null "
			+ "group by ltsb.id")
	List<LabTestSampleBatch> findAllViralLoad(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select max(id) from soch.lab_test_sample_batch")
	Long findMaxOfId();

}
