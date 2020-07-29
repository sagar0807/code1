package gov.naco.soch.repository;

import gov.naco.soch.domain.Transfers;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Transfers entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransfersRepository extends JpaRepository<Transfers, Long>, JpaSpecificationExecutor<Transfers> {
}
