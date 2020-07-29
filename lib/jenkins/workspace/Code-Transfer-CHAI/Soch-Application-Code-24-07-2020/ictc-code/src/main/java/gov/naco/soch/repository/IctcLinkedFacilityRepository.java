package gov.naco.soch.repository;

import gov.naco.soch.domain.IctcLinkedFacility;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the IctcLinkedFacility entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IctcLinkedFacilityRepository extends JpaRepository<IctcLinkedFacility, Long>, JpaSpecificationExecutor<IctcLinkedFacility> {
}
