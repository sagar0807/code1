package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.domain.IctcPartnerDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the IctcPartnerDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IctcPartnerDetailsRepository extends JpaRepository<IctcPartnerDetails, Long> {
	
	@Query("select ipd from IctcPartnerDetails ipd where ipd.ictcBeneficiary.id=:beneficiaryId")
	List<IctcPartnerDetails> findByBeneficaryId(@Param("beneficiaryId") Long beneficiaryId);

}
