package gov.naco.soch.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.domain.BeneficiaryIctcStatusTracking;
import gov.naco.soch.repository.BeneficiaryIctcStatusTrackingRepository;

@Service
public class BeneficiaryIctcStatusTrackingService {

	@Autowired
	private BeneficiaryIctcStatusTrackingRepository beneficiaryIctcStatusTrackingRepository;
	
	/**
	 * To save status change
	 * 
	 * @param statusUpdate statusUpdate
	 * @return statusUpdate
	 */
	public BeneficiaryIctcStatusTracking saveBeneficiaryIctcStatusChange(BeneficiaryIctcStatusTracking statusUpdate) {
		statusUpdate.setCreatedTime(LocalDateTime.now());
		statusUpdate.setIsActive(true);
		statusUpdate.setIsDeleted(false);
		return beneficiaryIctcStatusTrackingRepository.save(statusUpdate);
	}
	
	public BeneficiaryIctcStatusTracking saveBeneficiaryIctcStatusChange(Long beneficiaryId, Integer currentStatus, Integer prevStatus, Long facilityId, Integer statusChangedBy) {
		BeneficiaryIctcStatusTracking statusUpdate = new BeneficiaryIctcStatusTracking();
		statusUpdate.setFacilityId(facilityId);
		statusUpdate.setBeneficiaryId(beneficiaryId);
		statusUpdate.setCurrentIctcBeneficiaryStatusId(currentStatus);
		statusUpdate.setPreviousIctcBeneficiaryStatusId(prevStatus);
		statusUpdate.setStatusChangedDate(LocalDateTime.now());
		statusUpdate.setCreatedTime(LocalDateTime.now());
		statusUpdate.setCreatedBy(statusChangedBy);
		statusUpdate.setStatusChangedBy(statusChangedBy);
		statusUpdate.setIsActive(true);
		statusUpdate.setIsDeleted(false);
		return beneficiaryIctcStatusTrackingRepository.save(statusUpdate);
	}
}
