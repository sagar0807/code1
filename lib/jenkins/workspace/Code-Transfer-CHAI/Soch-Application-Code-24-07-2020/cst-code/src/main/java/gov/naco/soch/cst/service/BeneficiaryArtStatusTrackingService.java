package gov.naco.soch.cst.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryArtStatusTracking;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterArtBeneficiaryStatus;
import gov.naco.soch.repository.BeneficiaryArtStatusTrackingRepository;
import gov.naco.soch.util.DateUtil;

@Transactional
@Service
public class BeneficiaryArtStatusTrackingService {

	@Autowired
	private BeneficiaryArtStatusTrackingRepository beneficiaryArtStatusTrackingRepository;

	private static Beneficiary mapToBeneficiaryDtoId(long beneficiaryId) {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(beneficiaryId);
		return beneficiary;
	}

	public static Facility mapToFacilityId(long facilityId) {
		Facility facility = new Facility();
		facility.setId(facilityId);
		return facility;
	}

	private static MasterArtBeneficiaryStatus mapToMasterArtBeneficiaryStatusId(long masterArtBeneficiaryStatusId) {
		MasterArtBeneficiaryStatus masterArtBeneficiaryStatus = new MasterArtBeneficiaryStatus();
		masterArtBeneficiaryStatus.setId(masterArtBeneficiaryStatusId);
		return masterArtBeneficiaryStatus;
	}

	public Long getBeneficiaryArtStatusTracking(Long beneficiaryId, Long facilityId,
			Long masterArtBeneficiaryStatusId) {
		Optional<BeneficiaryArtStatusTracking> beneficiaryArtStatusTrackingOptional = beneficiaryArtStatusTrackingRepository
				.findByBeneficiaryIdAndFacilityId(beneficiaryId, facilityId);

		if (beneficiaryArtStatusTrackingOptional.isPresent()) {
			BeneficiaryArtStatusTracking artStatusTrackingExist = beneficiaryArtStatusTrackingOptional.get();
			if (artStatusTrackingExist.getCurrentArtBeneficiaryStatus() != null && artStatusTrackingExist
					.getCurrentArtBeneficiaryStatus().getId() == masterArtBeneficiaryStatusId) {
				return artStatusTrackingExist.getId();
			} else {
				BeneficiaryArtStatusTracking artStatusTracking = mapToBeneficiaryStatusTracking(facilityId,
						beneficiaryId);
				if (masterArtBeneficiaryStatusId != null) {
					MasterArtBeneficiaryStatus artBeneficiaryStatus = mapToMasterArtBeneficiaryStatusId(
							masterArtBeneficiaryStatusId);
					artStatusTracking.setCurrentArtBeneficiaryStatus(artBeneficiaryStatus);
				}
				if (artStatusTrackingExist.getCurrentArtBeneficiaryStatus() != null) {
					artStatusTracking
							.setPreviousArtBeneficiaryStatus(artStatusTrackingExist.getCurrentArtBeneficiaryStatus());
				}
				artStatusTracking = beneficiaryArtStatusTrackingRepository.save(artStatusTracking);
				return artStatusTracking.getId();
			}
		} else {
			BeneficiaryArtStatusTracking artStatusTracking = mapToBeneficiaryStatusTracking(facilityId, beneficiaryId);
			if (masterArtBeneficiaryStatusId != null) {
				MasterArtBeneficiaryStatus artBeneficiaryStatus = mapToMasterArtBeneficiaryStatusId(
						masterArtBeneficiaryStatusId);
				artStatusTracking.setCurrentArtBeneficiaryStatus(artBeneficiaryStatus);
			}
			artStatusTracking = beneficiaryArtStatusTrackingRepository.save(artStatusTracking);
			return artStatusTracking.getId();

		}
	}

	public static BeneficiaryArtStatusTracking mapToBeneficiaryStatusTracking(Long facilityId, Long beneficiaryId) {
		BeneficiaryArtStatusTracking artStatusTracking = new BeneficiaryArtStatusTracking();
		Beneficiary beneficiary = mapToBeneficiaryDtoId(beneficiaryId);
		artStatusTracking.setBeneficiary(beneficiary);
		Facility facility = mapToFacilityId(facilityId);
		artStatusTracking.setFacility(facility);
		artStatusTracking.setStatusDate(DateUtil.getTodayDateInIST());
		artStatusTracking.setStatusChangedBy((long) 0);
		artStatusTracking.setIsActive(true);
		artStatusTracking.setIsDelete(false);
		return artStatusTracking;
	}
}
