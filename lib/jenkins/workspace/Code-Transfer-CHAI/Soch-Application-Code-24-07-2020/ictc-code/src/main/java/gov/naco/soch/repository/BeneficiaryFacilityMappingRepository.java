package gov.naco.soch.repository;

import gov.naco.soch.domain.BeneficiaryFacilityMapping;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BeneficiaryFacilityMapping entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BeneficiaryFacilityMappingRepository extends JpaRepository<BeneficiaryFacilityMapping, Long>, JpaSpecificationExecutor<BeneficiaryFacilityMapping> {

}
