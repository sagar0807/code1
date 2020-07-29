package gov.naco.soch.repository;

import gov.naco.soch.domain.Referrals;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Referrals entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReferralsRepository extends JpaRepository<Referrals, Long>, JpaSpecificationExecutor<Referrals> {
}
