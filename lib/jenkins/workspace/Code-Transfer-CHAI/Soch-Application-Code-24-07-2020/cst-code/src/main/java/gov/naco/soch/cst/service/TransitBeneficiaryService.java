package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import gov.naco.soch.cst.dto.TransitBeneficiaryDto;
import gov.naco.soch.cst.mapper.TransitBeneficiaryMapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.projection.ArtTransitBeneficiaryProjection;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional

public class TransitBeneficiaryService {
	private static final Logger logger = LoggerFactory.getLogger(TransitBeneficiaryService.class);

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

	public List<TransitBeneficiaryDto> getBeneficiaryByFacility(Long facilityId, String searchText) {
		if (StringUtils.isEmpty(searchText)) {
			throw new ServiceException("Please enter the search text", null, HttpStatus.BAD_REQUEST);
		}

		logger.debug("Entering into getBeneficiaryByFacility method ");
		List<TransitBeneficiaryDto> beneficiaryDtos = new ArrayList<TransitBeneficiaryDto>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<ArtTransitBeneficiaryProjection> beneficiaries = beneficiaryRepository
				.findByFacilityIdAndSearchText(facilityId, searchText.toLowerCase(), currentUser.getFacilityId());
		if (!CollectionUtils.isEmpty(beneficiaries)) {
			beneficiaryDtos = TransitBeneficiaryMapper.mapToTransitBeneficiaryDto(beneficiaries, facilityId);
		}
		return beneficiaryDtos;
	}

	public Boolean assignTransitBeneficiaryQueue(List<TransitBeneficiaryDto> transitBeneficiaryDto) {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails(); // getting the current logged user details
		if (!CollectionUtils.isEmpty(transitBeneficiaryDto)) {
			transitBeneficiaryDto.forEach(row -> {
				Beneficiary beneficiary = new Beneficiary();
				beneficiary.setId(row.getId());

				Facility facility = new Facility();
				facility.setId(currentUser.getFacilityId());

				UserMaster assignTo = new UserMaster();
				assignTo.setId(row.getAssignee());

				UserMaster entryUser = new UserMaster();
				entryUser.setId(currentUser.getUserId());

				Long visterRegister = VisitRegisterService.getVisitRegisterIdForToday(currentUser.getFacilityId(),
						row.getId());
				BeneficiaryVisitRegister beneficiaryVisitRegister = new BeneficiaryVisitRegister();
				beneficiaryVisitRegister.setId(visterRegister);

				ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
				artBeneficiaryQueue.setBeneficiary(beneficiary);
				artBeneficiaryQueue.setFacility(facility);
				artBeneficiaryQueue.setEntryUser(entryUser); // setting entryUser
				artBeneficiaryQueue.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
				artBeneficiaryQueue.setAssignedToUser(assignTo);
				artBeneficiaryQueue.setIsActive(Boolean.TRUE);
				artBeneficiaryQueue.setIsDelete(Boolean.FALSE);
				artBeneficiaryQueue.setIsVisited(Boolean.FALSE);
				artBeneficiaryQueue.setVisitDate(LocalDate.now());

				artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
			});
			return true;
		}
		return false;
	}

}
