package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;

@Service
@Transactional
public class SharedService {

	private static final Logger logger = LoggerFactory.getLogger(SharedService.class);

	private static ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

	private static ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	@PostConstruct
	public void init() {
		SharedService.artBeneficiaryQueueRepository = artBeneficiaryQueueRepository1;
		SharedService.artBeneficiaryDueListRepository = artBeneficiaryDueListRepository1;
	}

	@Autowired
	ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository1;
	
	@Autowired
	ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository1;

	public static ArtBeneficiaryQueue saveQueDetails(Long beneficiaryId, Long userId, Long facilityId) {
		logger.debug("In saveQueDetails() of SharedService");
		ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
		Optional<ArtBeneficiaryQueue> artBeneficiaryQueueOptional = artBeneficiaryQueueRepository
				.findLatestByBeneficiaryIdAndAssignedTo(beneficiaryId, userId, facilityId, LocalDate.now(), false);
		if (artBeneficiaryQueueOptional.isPresent()) {
			artBeneficiaryQueue = artBeneficiaryQueueOptional.get();
			artBeneficiaryQueue.setIsVisited(true);
			artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
		}
		return artBeneficiaryQueue;
	}

	public static void saveDueList(Long beneficiaryId, LocalDate nextAppointmentDate, Long visitRegsiterId, Long userId,
			Long facilityId) {
		logger.debug("In saveDueList() of SharedService");
		ArtBeneficiaryDueList artBeneficiaryDueList = artBeneficiaryDueListRepository
				.findByBeneficiaryIdAssignedToAndNextAppoinmentDate(beneficiaryId, nextAppointmentDate, userId,
						facilityId);
		if (artBeneficiaryDueList == null) {
			artBeneficiaryDueList = mapToArtBeneficiaryDueList(beneficiaryId, nextAppointmentDate, visitRegsiterId,
					userId, facilityId);
			artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
		}
	}

	private static ArtBeneficiaryDueList mapToArtBeneficiaryDueList(Long beneficiaryId, LocalDate nextAppointmentDate,
			Long visitRegsiterId, Long userId, Long facilityId) {
		ArtBeneficiaryDueList artBeneficiaryDueList = new ArtBeneficiaryDueList();
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(beneficiaryId);
		artBeneficiaryDueList.setBeneficiary(beneficiary);
		BeneficiaryVisitRegister beneficiaryVisitRegister = new BeneficiaryVisitRegister();
		beneficiaryVisitRegister.setId(visitRegsiterId);
		artBeneficiaryDueList.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
		artBeneficiaryDueList.setExpectedVisitDate(nextAppointmentDate);
		Facility facility = new Facility();
		facility.setId(facilityId);
		artBeneficiaryDueList.setFacility(facility);
		artBeneficiaryDueList.setIsVisited(false);
		UserMaster userMaster = new UserMaster();
		userMaster.setId(userId);
		artBeneficiaryDueList.setEntryUser(userMaster);
		return artBeneficiaryDueList;
	}

}
