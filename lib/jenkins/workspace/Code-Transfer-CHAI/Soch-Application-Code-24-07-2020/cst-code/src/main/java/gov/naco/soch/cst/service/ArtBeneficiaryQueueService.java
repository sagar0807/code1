package gov.naco.soch.cst.service;

import gov.naco.soch.cst.dto.ArtBeneficiaryQueueDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryQueueMapperUtil;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryInvestigation;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ArtBeneficiaryQueueService {

	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private UserMasterRepository userMasterRepository;
	
	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueService.class);

	/**
	 * @return
	 */
	public List<ArtBeneficiaryQueueDto> getBeneficiaryQueues() {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<ArtBeneficiaryQueueDto> artBeneficiaryQueueDtoList = new ArrayList<ArtBeneficiaryQueueDto>();
		List<ArtBeneficiaryQueue> beneficiaryQueueList = new ArrayList<ArtBeneficiaryQueue>();
		beneficiaryQueueList = artBeneficiaryQueueRepository.findAllByAssignedTo(loginResponseDto.getUserId(),
				loginResponseDto.getFacilityId(), false, LocalDate.now());
		beneficiaryQueueList.forEach(beneficiaryQueue -> {
			ArtBeneficiaryQueueDto artBeneficiaryQueueDto = ArtBeneficiaryQueueMapperUtil
					.mapArtBeneficiaryQueueArtBeneficiaryQueueDto(beneficiaryQueue);
			artBeneficiaryQueueDtoList.add(artBeneficiaryQueueDto);
		});
		return artBeneficiaryQueueDtoList;
	}

	/**
	 * @return
	 */
	public List<ArtBeneficiaryQueueDto> getBeneficiaryVisitedQueues() {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<ArtBeneficiaryQueueDto> artBeneficiaryQueueDtoList = new ArrayList<ArtBeneficiaryQueueDto>();
		List<ArtBeneficiaryQueue> beneficiaryQueueList = new ArrayList<ArtBeneficiaryQueue>();
		beneficiaryQueueList = artBeneficiaryQueueRepository.findAllByAssignedToVisited(loginResponseDto.getUserId(),
				loginResponseDto.getFacilityId(), true, LocalDate.now());
		beneficiaryQueueList.forEach(beneficiaryQueue -> {
			ArtBeneficiaryQueueDto artBeneficiaryQueueDto = ArtBeneficiaryQueueMapperUtil
					.mapArtBeneficiaryQueueArtBeneficiaryQueueDto(beneficiaryQueue);
			artBeneficiaryQueueDtoList.add(artBeneficiaryQueueDto);
		});
		return artBeneficiaryQueueDtoList;
	}

	/**
	 * save method for beneficiary newly assigned roles
	 */
	public ArtBeneficiaryQueueDto saveNewlyAssignedBneficiaries(List<ArtBeneficiaryQueueDto> dto) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Optional<Facility> facilityOpt = facilityRepository.findById(loginResponseDto.getFacilityId());
		List<ArtBeneficiaryQueue> queuelist = new ArrayList<ArtBeneficiaryQueue>();
		if(dto!=null) {
			logger.debug("dto.parallelStream().count()  ---->"+dto.parallelStream().count());
			//dto.forEach(queueList1 -> {
				for(int i=0;i<dto.parallelStream().count();i++) {
			Optional<Beneficiary> beneficiaryOpt = beneficiaryRepository.findById(dto.get(i).getBeneficiaryId());
			Optional<UserMaster> user = userMasterRepository.findById(loginResponseDto.getUserId());
			UserMaster user1 = userMasterRepository.findByName(dto.get(i).getChangedAssignedTo());
			Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
					dto.get(i).getBeneficiaryId());
			Optional<BeneficiaryVisitRegister> beneficiaryVisitRegister = beneficiaryVisitRegisterRepository
					.findById(visitRegisterId);
			UserMaster assgndUser = new UserMaster();
			assgndUser.setId(user1.getId());
			BeneficiaryVisitRegister visitId = new BeneficiaryVisitRegister();
			visitId.setId(visitRegisterId);
			ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
			artBeneficiaryQueue.setBeneficiary(beneficiaryOpt.get());
			artBeneficiaryQueue.setAssignedToUser(assgndUser);
			artBeneficiaryQueue.setBeneficiaryVisitRegister(visitId);
			artBeneficiaryQueue.setFacility(facilityOpt.get());
			artBeneficiaryQueue.setIsActive(true);
			artBeneficiaryQueue.setIsVisited(false);
			artBeneficiaryQueue.setIsDelete(false);
			artBeneficiaryQueue.setVisitDate(LocalDate.now());
			artBeneficiaryQueue.setEntryUser(user.get());
			artBeneficiaryQueue.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
			queuelist.add(artBeneficiaryQueue);
		}
		logger.debug("queuelist ---->"+queuelist);
		artBeneficiaryQueueRepository.saveAll(queuelist);
		return null;
		}else {
			throw new ServiceException("No beneficiary to save", null,HttpStatus.BAD_REQUEST);
			}
	}

}
