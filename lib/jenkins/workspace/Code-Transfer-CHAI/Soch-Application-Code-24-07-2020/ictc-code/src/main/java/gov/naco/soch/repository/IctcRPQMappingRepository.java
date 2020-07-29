package gov.naco.soch.repository;

import gov.naco.soch.domain.IctcRPQMapping;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the IctcRPQMapping entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IctcRPQMappingRepository extends JpaRepository<IctcRPQMapping, Long>, JpaSpecificationExecutor<IctcRPQMapping> {
}
