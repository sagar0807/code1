package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCBeneficiaryFollowUpView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ICTCBeneficiaryFollowUpView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCBeneficiaryFollowUpViewRepository extends JpaRepository<ICTCBeneficiaryFollowUpView, Long>, JpaSpecificationExecutor<ICTCBeneficiaryFollowUpView> {

}
