package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCTestResult;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ICTCTestResult entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCTestResultRepository extends JpaRepository<ICTCTestResult, Long>, JpaSpecificationExecutor<ICTCTestResult> {

	@Modifying
	@Query("update ICTCTestResult itr set itr.isDeleted=true, itr.isActive=false where itr.sample.id=:sampleId")
	void markEntryAsDeletedAndInActiveForASample(@Param("sampleId") Long sampleId);
}
