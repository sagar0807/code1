package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiaryMultiFacilityService;

/**
 * Spring Data  repository for the Address entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BeneficiaryMultiFacilityServiceRepository extends JpaRepository<BeneficiaryMultiFacilityService, Long>, JpaSpecificationExecutor<BeneficiaryMultiFacilityService> {
	List<BeneficiaryMultiFacilityService> findAllByBeneficiaryIdAndVisitedFacilityId(Long beneficiaryId, Long visitedFacilityId);
}
