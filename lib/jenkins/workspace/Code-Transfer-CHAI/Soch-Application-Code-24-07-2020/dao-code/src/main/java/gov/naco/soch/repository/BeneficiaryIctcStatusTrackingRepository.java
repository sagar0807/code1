package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryIctcStatusTracking;

//repository mapped with entity class RoleAccessMapping
@Repository
public interface BeneficiaryIctcStatusTrackingRepository extends JpaRepository<BeneficiaryIctcStatusTracking, Long> {

}
