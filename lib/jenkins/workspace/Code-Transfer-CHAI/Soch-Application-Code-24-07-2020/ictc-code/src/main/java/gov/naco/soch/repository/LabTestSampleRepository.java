package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.LabTestSample;

/**
 * Spring Data  repository for the LabTestSample entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LabTestSampleRepository extends JpaRepository<LabTestSample, Long>, JpaSpecificationExecutor<LabTestSample> {
	
	List<LabTestSample> findByBarcodeNumberOrderByIdDesc(String barcode);
}
