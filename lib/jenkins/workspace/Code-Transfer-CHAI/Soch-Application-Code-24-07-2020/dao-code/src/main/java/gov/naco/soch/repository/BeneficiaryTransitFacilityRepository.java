package gov.naco.soch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.BeneficiaryTransitFacility;

@Repository
public interface BeneficiaryTransitFacilityRepository extends JpaRepository<BeneficiaryTransitFacility, Long>, JpaSpecificationExecutor<BeneficiaryTransitFacility>{

	
	List<BeneficiaryTransitFacility> findByBeneficiaryIdAndIsDelete(Long beneficiaryId, boolean b);

}
