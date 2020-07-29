package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCBeneficiaryVisit;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ICTCBeneficiaryVisit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCBeneficiaryVisitRepository extends JpaRepository<ICTCBeneficiaryVisit, Long>, JpaSpecificationExecutor<ICTCBeneficiaryVisit> {
}
