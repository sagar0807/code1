package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.LacAddDto;
import gov.naco.soch.dto.LacUserDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.UserMaster;

public class LacMapper {

	public static Facility mapToFacility(LacAddDto lacAddDto, Facility parentFacility) {
		Facility facility = new Facility();
		Random rand = new Random(); // instance of random class
		int upperbound = 10000;
		FacilityType facilityType = new FacilityType();
		facility.setFacility(parentFacility);
		facility.setName(lacAddDto.getName());
		facility.setIsActive(true);
		facility.setIsDelete(false);
		facility.setCode("LAC" + rand.nextInt(upperbound));
		facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(17l);
		facility.setFacilityType(facilityType);
		facility.setDivision(DivisionMapperUtil.mapToDivisionId(lacAddDto.getDivisionId()));
		return facility;
	}

	public static Facility mapToFacility(LacAddDto lacAddDto, Facility facility, Facility lac) {
		FacilityType facilityType = lac.getFacilityType();
		lac.setFacility(facility);
		lac.setName(lacAddDto.getName());
		lac.setIsActive(true);
		lac.setIsDelete(false);
		facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(17l);
		lac.setFacilityType(facilityType);
		lac.setDivision(DivisionMapperUtil.mapToDivisionId(lacAddDto.getDivisionId()));
		return lac;
	}

	public static List<LacAddDto> mapFacilityToLacAddDto(List<Facility> lacDetails) {
		List<LacAddDto> lacDtoList = new ArrayList<LacAddDto>();
		if (!CollectionUtils.isEmpty(lacDetails)) {
			lacDetails.stream().forEach(lac -> {
				LacAddDto LacAddDtoRow = new LacAddDto();
				LacAddDtoRow.setLacId(lac.getId());
				LacAddDtoRow.setName(lac.getName());
				LacAddDtoRow.setAddress(lac.getAddress().getAddress());
				LacAddDtoRow.setStateId(lac.getAddress().getState().getId());
				LacAddDtoRow.setDistrictId(lac.getAddress().getDistrict().getId());
				LacAddDtoRow.setCity(lac.getAddress().getCity());
				LacAddDtoRow.setPincode(lac.getAddress().getPincode());
				LacAddDtoRow.setCode(lac.getCode());
				lacDtoList.add(LacAddDtoRow);
			});
		}
		return lacDtoList;
	}

	public static LacUserDto mapToLacUserDto(UserMaster user) {
		LacUserDto lacStaffNurseDto = new LacUserDto();
		lacStaffNurseDto.setId(user.getId());
		lacStaffNurseDto.setContactNumber(user.getMobileNumber());
		lacStaffNurseDto.setDesignationId(user.getDesignationId());
		lacStaffNurseDto.setDivisionId(user.getDivision().getId());
		lacStaffNurseDto.setEmail(user.getEmail());
		lacStaffNurseDto.setFirstName(user.getFirstname());
		lacStaffNurseDto.setLastName(user.getLastname());
		lacStaffNurseDto.setRoleId(user.getUserRoleMappings().iterator().next().getRole().getId());
		return lacStaffNurseDto;
	}

}
