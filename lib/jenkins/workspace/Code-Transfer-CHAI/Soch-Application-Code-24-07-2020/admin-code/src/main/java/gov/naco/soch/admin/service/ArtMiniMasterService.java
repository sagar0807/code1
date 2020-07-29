/**
 * 
 */
package gov.naco.soch.admin.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import gov.naco.soch.admin.ArtMiniMasterDto;
import gov.naco.soch.dto.FacilityBasicListDto;
import gov.naco.soch.dto.FacilityUserDto;
import gov.naco.soch.dto.LocationDto;
import gov.naco.soch.dto.MasterDto;
import gov.naco.soch.dto.RegimenDto;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.enums.DivisionEnum;
import gov.naco.soch.enums.FacilityTypeEnum;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jul-20 12:05:09 pm
 * 
 */

@Service
@Transactional
public class ArtMiniMasterService {

	@Autowired
	MasterDataService masterDataService;

	@Autowired
	private FacilityService facilityService;

	@Autowired
	AddressService addressService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	RegimenService regimenService;

	/**
	 * @return
	 */
	@Cacheable(value = "AllMiniMasterForArtAddBenficiaryCache")
	public ArtMiniMasterDto getMiniMasterForAddBenficiary() {
		ArtMiniMasterDto artMiniMasterDto = new ArtMiniMasterDto();
		List<LocationDto> masterState = addressService.getStateList();
		artMiniMasterDto.setMasterState(masterState);

		List<MasterDto> masterRelationType = masterDataService.getRelationType();
		artMiniMasterDto.setMasterRelationType(masterRelationType);

		List<MasterDto> masterPurposes = masterDataService.getPurposes();
		artMiniMasterDto.setMasterPurposes(masterPurposes);

		List<MasterDto> masterOrganisationType = masterDataService.getOrganisationType();
		artMiniMasterDto.setMasterOrganisationType(masterOrganisationType);

		
		List<FacilityBasicListDto> allArtFacility = facilityService.getFacilities(null, null,FacilityTypeEnum.ART_FACILITY.getFacilityType());
		artMiniMasterDto.setAllArtFacility(allArtFacility);
		
		List<MasterDto>masterSocialwelfare=masterDataService.getSocialWelfare();
		artMiniMasterDto.setMasterSocialwelfare(masterSocialwelfare);
		
		List<MasterDto>masterReferralStatus=masterDataService.getReferralStatus();
		artMiniMasterDto.setMasterReferralStatus(masterReferralStatus);
		 
		//List<MasterDto>allFacilityTypeList												// new api will provide by anees
		List<FacilityBasicListDto>artLacList = facilityService.getAllOptimizedFacilityByCurrentFacilityAsParent(FacilityTypeEnum.LAC_FACILITY.getFacilityType()); // new api will provide by anees
		artMiniMasterDto.setArtLacList(artLacList);
		
		List<MasterDto>masterIptstatus=masterDataService.getIptStatus();
		artMiniMasterDto.setMasterIptstatus(masterIptstatus);
		
		List<MasterDto>masterArtTreatmentStatus=masterDataService.getArtTreatmentStatus();
		artMiniMasterDto.setMasterArtTreatmentStatus(masterArtTreatmentStatus);
		
		 List<MasterDto>beneficiaryArtTransferredFrom=masterDataService.getBeneficiaryArtTransferredFrom();
		 artMiniMasterDto.setBeneficiaryArtTransferredFrom(beneficiaryArtTransferredFrom);
		 
		 List<FacilityUserDto>artFacilityUserList=userService.getUserListForCurrentFacility();
		 artMiniMasterDto.setArtFacilityUserList(artFacilityUserList);
		 
		 List<MasterDto>masterPregnancyTypeCase=masterDataService.getPregnancyTypeCase();
		 artMiniMasterDto.setMasterPregnancyTypeCase(masterPregnancyTypeCase);
		 
		 List<Long> divisoinIds=new ArrayList<Long>();
		 divisoinIds.add(DivisionEnum.BSD.getDivision());// ICTC division =6
		 List<FacilityBasicListDto>allICTCcentreList=facilityService.getFacilities(divisoinIds, null, null);
		 artMiniMasterDto.setAllICTCcentreList(allICTCcentreList);
		 
		 List<MasterDto>masterTestType=masterDataService.getTestType(null, null);
		 artMiniMasterDto.setMasterTestType(masterTestType);
		 
		 List<MasterDto>masterTbRegimen=masterDataService.getTbRegimen();
		 artMiniMasterDto.setMasterTbRegimen(masterTbRegimen);
		 
		 List<MasterDto>tbTreatmentStatus = masterDataService.getTbTreatmentStatus();
		 artMiniMasterDto.setTbTreatmentStatus(tbTreatmentStatus);
		 
		 List<MasterDto>fourSScreening = masterDataService.getFourSScreening();
		 artMiniMasterDto.setFourSScreening(fourSScreening);
		 
		 List<MasterDto>beneficiaryActivityStatus = masterDataService.getBeneficiaryActivityStatus();
		 artMiniMasterDto.setBeneficiaryActivityStatus(beneficiaryActivityStatus);
		 
		 List<MasterDto>beneficiaryCategory = masterDataService.getMasterBeneficiaryCategory();
		 artMiniMasterDto.setBeneficiaryCategory(beneficiaryCategory);
		 
		 List<MasterDto>masterGender = masterDataService.getGender();
		 artMiniMasterDto.setMasterGender(masterGender);
		 
		 List<MasterDto>maritalStatus= masterDataService.getMaritalStatus();
		 artMiniMasterDto.setMaritalStatus(maritalStatus);
		 
		 List<MasterDto>occupation = masterDataService.getMasterOccupation();
		 artMiniMasterDto.setOccupation(occupation);
		 
		 List<MasterDto>educationLevel= masterDataService.getMasterEducationLevel();
		 artMiniMasterDto.setEducationLevel(educationLevel);
		 
		 List<RegimenDto>regimenList=regimenService.getRegimens();
		 artMiniMasterDto.setRegimenList(regimenList);
		 
		 List<MasterDto>entryPoint = masterDataService.getEntryPoint();
		 artMiniMasterDto.setEntryPoint(entryPoint);
		 
		 List<MasterDto>riskFactor = masterDataService.getRiskFactor();
		 artMiniMasterDto.setRiskFactor(riskFactor);
		 
		 List<MasterDto>monthlyIncome = masterDataService.getMonthlyIncome();
		 artMiniMasterDto.setMonthlyIncome(monthlyIncome);
		 
		 List<MasterDto>hivType = masterDataService.getHivType();
		 artMiniMasterDto.setHivType(hivType);
		 
		 List<MasterDto>treatmentLine = masterDataService.getTreatmentLine();
		 artMiniMasterDto.setTreatmentLine(treatmentLine);
		 
		 List<MasterDto>deliveryOutcome = masterDataService.getDeliveryOutcome();
		 artMiniMasterDto.setDeliveryOutcome(deliveryOutcome);
		 
		 List<MasterDto>treatmentOutcome = masterDataService.getTreatmentOutcome();
		 artMiniMasterDto.setTreatmentOutcome(treatmentOutcome);
		 
		return artMiniMasterDto;
	}

}
