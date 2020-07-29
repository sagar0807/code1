package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiaryIctcStatusTracking;

@Repository
public interface BeneficiaryIctcStatusTrackingRepository extends JpaRepository<BeneficiaryIctcStatusTracking, Long>, JpaSpecificationExecutor<BeneficiaryIctcStatusTracking>{

}
