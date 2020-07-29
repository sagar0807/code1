package gov.naco.soch.cst.mapper;

import java.util.ArrayList;
import java.util.List;

import gov.naco.soch.cst.dto.ArtBeneficiaryOpportunisticInfectionDto;
import gov.naco.soch.cst.dto.TbOiDetailsDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryOpportunisticInfection;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterOpportunisticInfection;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.projection.ArtTbOiDetailProjection;

public class TbOiDetailsMapper {

	public static List<ArtBeneficiaryOpportunisticInfection> mapTbOiDetailsDtoToOpportunisticInfection(
			BeneficiaryVisitRegister visitRegister, TbOiDetailsDto tbOiDetailsDto) {
		List<ArtBeneficiaryOpportunisticInfection> infectionList = new ArrayList<ArtBeneficiaryOpportunisticInfection>();
		if (tbOiDetailsDto.getInfectionDto() != null && !tbOiDetailsDto.getInfectionDto().isEmpty()) {

			for (ArtBeneficiaryOpportunisticInfectionDto infect : tbOiDetailsDto.getInfectionDto()) {

				ArtBeneficiaryOpportunisticInfection infection = new ArtBeneficiaryOpportunisticInfection();
				infection.setBeneficiaryVisitRegister(visitRegister);
				infection.setId(tbOiDetailsDto.getId());
				infection.setIsActive(true);
				infection.setIsDelete(false);
				MasterOpportunisticInfection master = new MasterOpportunisticInfection();
				master.setId(infect.getOpportunisticInfectionId());
				infection.setMasterOpportunisticInfection(master);
				infectionList.add(infection);
			}
		}
		return infectionList;
	}

	public static ArtBeneficiaryFollowup mapTbOiDetailsToFollowUp(LoginResponseDto loginResponseDto,
			Beneficiary beneficiary, BeneficiaryVisitRegister visitRegister, TbOiDetailsDto tbOiDetailsDto) {

		ArtBeneficiaryFollowup followup = new ArtBeneficiaryFollowup();
		followup.setBeneficiary(beneficiary);
		UserMaster user = new UserMaster();
		user.setId(loginResponseDto.getUserId());
		followup.setEntryUser(user);
		Facility facility = new Facility();
		facility.setId(loginResponseDto.getFacilityId());
		followup.setFacility(facility);
		followup.setIsActive(true);
		followup.setIsDelete(false);
		followup.setOpportunisticInfectionsRemarks(tbOiDetailsDto.getRemarks());
		followup.setVisitDate(tbOiDetailsDto.getVisitDate());
		followup.setBeneficiaryVisitRegister(visitRegister);
		return followup;
	}

	public static TbOiDetailsDto mapTbOiDetailsToProjection(ArtTbOiDetailProjection optIptAttDetails,
			Long beneficiaryId, List<ArtBeneficiaryOpportunisticInfectionDto> infectionDto) {

		TbOiDetailsDto details = new TbOiDetailsDto();
		details.setBeneficiaryId(beneficiaryId);
		details.setRemarks(optIptAttDetails.getRemarks());
		details.setVisitDate(optIptAttDetails.getDateOfVisit());
		details.setVistorRegisterId(optIptAttDetails.getVisitorRegisterId());
		details.setInfectionDto(infectionDto);
		return details;
	}

	public static List<ArtBeneficiaryOpportunisticInfectionDto> mapArtBeneficiaryOpportunisticInfectionToDto(
			List<ArtBeneficiaryOpportunisticInfection> infection) {
		List<ArtBeneficiaryOpportunisticInfectionDto> dtoList = new ArrayList<ArtBeneficiaryOpportunisticInfectionDto>();
		for (ArtBeneficiaryOpportunisticInfection infect : infection) {
			ArtBeneficiaryOpportunisticInfectionDto dto = new ArtBeneficiaryOpportunisticInfectionDto();
			if (infect.getMasterOpportunisticInfection() != null) {
				dto.setOpportunisticInfection(infect.getMasterOpportunisticInfection().getName());
				dto.setOpportunisticInfectionId(infect.getMasterOpportunisticInfection().getId());
				dtoList.add(dto);
			}
		}

		return dtoList;
	}

}
