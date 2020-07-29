package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.AddressDto;
import gov.naco.soch.dto.DivisionDto;
import gov.naco.soch.dto.FacilityBasicListDto;
import gov.naco.soch.dto.FacilityDto;
import gov.naco.soch.dto.FacilityListByDistrictAndFacilityTypeDTO;
import gov.naco.soch.dto.FacilityRequestDto;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.dto.TypologyDto;
import gov.naco.soch.dto.UserFacilityMappingDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.entity.Contract;
import gov.naco.soch.entity.Division;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.MasterTiOstType;
import gov.naco.soch.entity.TypologyFacilityMapping;
import gov.naco.soch.entity.TypologyMaster;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.entity.UserRoleMapping;
import gov.naco.soch.enums.DivisionEnum;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.util.UserUtils;

//Mapper class for facility to map between bean class with entity class
public class FacilityMapperUtil {

	// function to map FacilityDto class to Facility class
	public static Facility mapToFacility(FacilityDto facilityDto) {
		Facility facility = new Facility();
		FacilityType facilityType = new FacilityType();
		Division division = new Division();
		if (facilityDto != null) {
			facility.setCode(facilityDto.getCode());
			facility.setId(facilityDto.getId());
			facility.setIsActive(facilityDto.getIsActive());
			facility.setIsDelete(facilityDto.getIsDelete());
			facility.setName(facilityDto.getName());
			if (facilityDto.getParentFacilityId() != null && facilityDto.getParentFacilityId() != 0) {
				Facility parentFacility = new Facility();
				parentFacility.setId(facilityDto.getParentFacilityId());
				facility.setFacility(parentFacility);
			}
			division = DivisionMapperUtil.mapToDivisionId(facilityDto.getDivisionId());
			facility.setDivision(division);
			facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(facilityDto.getFacilityTypeId());
			facility.setFacilityType(facilityType);
		}
		return facility;
	}

	private static UserMaster mapToUserMasterDtoId(Long userId) {
		UserMaster userMaster = new UserMaster();
		userMaster.setId(userId);
		return userMaster;

	}

	// function to map facilityList into facilityDtoList
	public static List<FacilityDto> mapToFacilityDtoList(List<Facility> facilityList) {
		List<FacilityDto> facilityDtos = new ArrayList<FacilityDto>();
		if (!CollectionUtils.isEmpty(facilityList)) {
			facilityList.forEach(facility -> {
				AddressDto addressDto = new AddressDto();
				FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
				DivisionDto divisionDto = new DivisionDto();
				Set<UserFacilityMappingDto> userFacilityMappingsList = new HashSet<>();

				FacilityDto facilityDto = new FacilityDto();
				facilityDto.setIsActive(facility.getIsActive());
				facilityDto.setIsDelete(facility.getIsDelete());
				facilityDto.setCode(facility.getCode());
				facilityDto.setId(facility.getId());
				facilityDto.setName(facility.getName());
				facilityDto.setStateId(facility.getAddress().getState().getId());
				facilityDto.setDistrictId(facility.getAddress().getDistrict().getId());
				facilityDto.setDivisionId(facility.getDivision().getId());
				facilityDto.setFacilityTypeId(facility.getFacilityType().getId());
				facilityDto.setAddressId(facility.getAddress().getId());
				if (facility.getFacility() != null) {
					facilityDto.setParentFacilityId(facility.getFacility().getId());
				}
				addressDto = AddressMapperUtil.mapToAddressDto(facility.getAddress());
				facilityTypeDto = FacilityTypeMapperUtil.maptoFacilityTypeDto(facility.getFacilityType());
				divisionDto = DivisionMapperUtil.mapToDivisionDto(facility.getDivision());

				facilityDto.setAddress(addressDto);
				facilityDto.setDivision(divisionDto);
				facilityDto.setFacilityType(facilityTypeDto);
				userFacilityMappingsList.forEach(element -> facilityDto.setUserFacilityMappingId(element.getId()));
				userFacilityMappingsList
						.forEach(element -> facilityDto.setPrimaryUserId(element.getUserMasterDto().getId()));

				facilityDtos.add(facilityDto);
			});
		}
		return facilityDtos;
	}

	// Function to map facility into facilityDto
	public static FacilityDto mapToFacilityDto(Facility facility) {
		FacilityDto facilityDto = new FacilityDto();
		if (facility != null) {
			facilityDto.setIsActive(facility.getIsActive());
			facilityDto.setIsDelete(facility.getIsDelete());
			facilityDto.setCode(facility.getCode());
			facilityDto.setId(facility.getId());
			facilityDto.setName(facility.getName());
			if (facility.getFacility() != null) {
				facilityDto.setParentFacilityId(facility.getFacility().getId());
			}
			AddressDto addressDto = new AddressDto();
			addressDto = AddressMapperUtil.mapToAddressDto(facility.getAddress());
			facilityDto.setAddress(addressDto);
		}
		return facilityDto;
	}

	public static List<FacilityTypeDto> mapObjToFacilityTypeDto(List<Object[]> facilityTypeObj) {
		List<FacilityTypeDto> facilityTypeDtos = facilityTypeObj.stream().map(objects -> {
			FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
			facilityTypeDto.setFacilityTypeName(objects[0].toString());
			return facilityTypeDto;
		}).collect(Collectors.toList());
		return facilityTypeDtos;
	}

	public static Facility mapToFacilityId(FacilityDto facilityDto) {
		Facility facility = new Facility();
		if (facilityDto != null) {
			facility.setId(facilityDto.getId());
		}
		return facility;
	}

	public static Facility mapToFacilityId(Long facilityId) {
		Facility facility = new Facility();
		facility.setId(facilityId);
		return facility;
	}

	public static Facility mapFacilityRequestDto(FacilityRequestDto facilityRequestDto) {
		Facility facility = new Facility();
		facility.setDivision(DivisionMapperUtil.mapToDivisionId(facilityRequestDto.getDivisionId()));
		facility.setFacilityType(FacilityTypeMapperUtil.maptoFacilityTypeId(facilityRequestDto.getFacilityTypeId()));
		facility.setIsDelete(false);
		facility.setIsActive(true);
		return facility;
	}

	public static List<FacilityRequestDto> mapFacilityToFacilityRequestDto(List<Facility> facilityList) {

		List<FacilityRequestDto> facilityRequests = new ArrayList<>();
		facilityList.forEach(facility -> {
			FacilityRequestDto facilityRequest = new FacilityRequestDto();
			facilityRequest.setDivisionId(facility.getDivision().getId());
			facilityRequest.setFacilityTypeId(facility.getFacilityType().getId());
			facilityRequest.setFacilityId(facility.getId());
			facilityRequest.setFacilityName(facility.getName());
			facilityRequests.add(facilityRequest);
		});
		return facilityRequests;
	}

	public static List<FacilityRequestDto> mapObjectToFacilityRequestDto(List<Object[]> facilityList) {

		List<FacilityRequestDto> facilityRequests = facilityList.stream().map(objects -> {
			FacilityRequestDto facilityRequest = new FacilityRequestDto();
			facilityRequest.setDivisionId(Long.valueOf(objects[0].toString()));
			facilityRequest.setFacilityTypeId(Long.valueOf(objects[1].toString()));
			facilityRequest.setFacilityId(Long.valueOf(objects[2].toString()));
			facilityRequest.setFacilityName(objects[3].toString());
			return facilityRequest;
		}).collect(Collectors.toList());
		return facilityRequests;
	}

	public static Facility mapSacsFacilityDtoToFacility(SacsFacilityDto sacsFacilityDto) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Facility facility = new Facility();
		FacilityType facilityType = new FacilityType();
		if (sacsFacilityDto != null) {
			facility.setCode(sacsFacilityDto.getCode());
			facility.setId(sacsFacilityDto.getId());
			facility.setIsActive(sacsFacilityDto.getIsActive());
			facility.setIsDelete(false);
			facility.setName(sacsFacilityDto.getName());
			facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(sacsFacilityDto.getFacilityTypeId());
			facility.setFacilityType(facilityType);
			facility.setFacilityNo(sacsFacilityDto.getFacilityNo());
			if (loginResponseDto.getFacilityTypeId() == FacilityTypeEnum.SACS.getFacilityType()) {
				facility.setSacsId(loginResponseDto.getFacilityId());
			} else {
				facility.setSacsId(sacsFacilityDto.getSacsId());
			}

			if (sacsFacilityDto.getFacilityTypeId() == FacilityTypeEnum.TI_CENTER.getFacilityType()) {
				facility.setMonthlyActiveTarget(sacsFacilityDto.getMonthlyActiveTarget());

				facility.setcBStatus(sacsFacilityDto.getCbStatus());
				facility.setTiType(sacsFacilityDto.getTiType());
				facility.setClinicPresent(sacsFacilityDto.getClinicPresent());
			}
			if (sacsFacilityDto.getFacilityTypeId() == FacilityTypeEnum.OST_FACILITY.getFacilityType()) {
				facility.setMonthlyOstTarget(sacsFacilityDto.getMonthlyOstTarget());
				MasterTiOstType masterTiOstType = null;
				Facility tiCenter = null;
				if (sacsFacilityDto.getTiOstTypeId() != null) {
					masterTiOstType = new MasterTiOstType();
					masterTiOstType.setId(sacsFacilityDto.getTiOstTypeId());
					if (sacsFacilityDto.getTiCenterId() != null) {
						tiCenter = new Facility();
						tiCenter.setId(sacsFacilityDto.getTiCenterId());
					}
				}
				facility.setOstType(masterTiOstType);
				facility.setTiCenter(tiCenter);
			}
			if (sacsFacilityDto.getNationalId() != null && sacsFacilityDto.getNationalId() != "") {
				facility.setNationalId(sacsFacilityDto.getNationalId());
			}
			if (sacsFacilityDto.getFacilityTypeId() == 15l || sacsFacilityDto.getFacilityTypeId() == 16l) {
				facility.setArtcode(sacsFacilityDto.getArtcode());
			}
			if (sacsFacilityDto.getFacilityTypeId() != 7l && sacsFacilityDto.getFacilityTypeId() != 9l
					&& sacsFacilityDto.getFacilityTypeId() != 10l && sacsFacilityDto.getFacilityTypeId() != 29l) {
				facility.setIsLab(sacsFacilityDto.getIsLab());
				facility.setNodalCentre(sacsFacilityDto.getNodalCentre());
			}
			if (sacsFacilityDto.getFacilityTypeId() == FacilityTypeEnum.TI_SATELLITE_OST.getFacilityType()
					&& sacsFacilityDto.getParentOstId() != null && sacsFacilityDto.getParentOstId() != 0) {
				Facility ostParent = new Facility();
				ostParent.setId(sacsFacilityDto.getParentOstId());
				facility.setFacility(ostParent);
			}
			if (sacsFacilityDto.getDivisionId() == DivisionEnum.TI.getDivision()) {
				facility.setValidTill(sacsFacilityDto.getValidTill());
			}
		}
		return facility;
	}

	public static Facility mapSacsFacilityDtoToFacilityInEdit(SacsFacilityDto sacsFacilityDto, Facility facility) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		if (sacsFacilityDto != null) {
			facility.setName(sacsFacilityDto.getName());
			facility.setFacilityNo(sacsFacilityDto.getFacilityNo());
			facility.setCode(sacsFacilityDto.getCode());
			facility.setIsActive(sacsFacilityDto.getIsActive());
			// if (loginResponseDto.getFacilityTypeId() ==
			// FacilityTypeEnum.SACS.getFacilityType()) {
			// facility.setSacsId(loginResponseDto.getFacilityId());
			// } else if (sacsFacilityDto.getFacilityTypeId() ==
			// FacilityTypeEnum.LAC_FACILITY.getFacilityType()
			// && facility.getFacility() != null) {
			// facility.setSacsId(facility.getFacility().getSacsId());
			// } else {
			// facility.setSacsId(sacsFacilityDto.getSacsId());
			// }
			if (sacsFacilityDto.getFacilityTypeId() == 7l) {
				facility.setMonthlyActiveTarget(sacsFacilityDto.getMonthlyActiveTarget());
				facility.setcBStatus(sacsFacilityDto.getCbStatus());
				facility.setTiType(sacsFacilityDto.getTiType());
				facility.setClinicPresent(sacsFacilityDto.getClinicPresent());
			}
			if (sacsFacilityDto.getFacilityTypeId() == FacilityTypeEnum.OST_FACILITY.getFacilityType()) {
				facility.setMonthlyOstTarget(sacsFacilityDto.getMonthlyOstTarget());
				MasterTiOstType masterTiOstType = null;
				Facility tiCenter = null;
				if (sacsFacilityDto.getTiOstTypeId() != null) {
					masterTiOstType = new MasterTiOstType();
					masterTiOstType.setId(sacsFacilityDto.getTiOstTypeId());
					if (sacsFacilityDto.getTiCenterId() != null) {
						tiCenter = new Facility();
						tiCenter.setId(sacsFacilityDto.getTiCenterId());
					}
				}
				facility.setOstType(masterTiOstType);
				facility.setTiCenter(tiCenter);
			}
			if (sacsFacilityDto.getNationalId() != null && sacsFacilityDto.getNationalId() != "") {
				facility.setNationalId(sacsFacilityDto.getNationalId());
			}
			if (sacsFacilityDto.getFacilityTypeId() == 15l || sacsFacilityDto.getFacilityTypeId() == 16l) {
				facility.setArtcode(sacsFacilityDto.getArtcode());
			}
			if (sacsFacilityDto.getFacilityTypeId() != 7l && sacsFacilityDto.getFacilityTypeId() != 9l
					&& sacsFacilityDto.getFacilityTypeId() != 10l && sacsFacilityDto.getFacilityTypeId() != 29l) {
				facility.setIsLab(sacsFacilityDto.getIsLab());
				facility.setNodalCentre(sacsFacilityDto.getNodalCentre());
			}
			if (sacsFacilityDto.getFacilityTypeId() == FacilityTypeEnum.TI_SATELLITE_OST.getFacilityType()
					&& sacsFacilityDto.getParentOstId() != null && sacsFacilityDto.getParentOstId() != 0) {
				Facility ostParent = new Facility();
				ostParent.setId(sacsFacilityDto.getParentOstId());
				facility.setFacility(ostParent);
			}
			if (sacsFacilityDto.getDivisionId() == DivisionEnum.TI.getDivision()) {
				facility.setValidTill(sacsFacilityDto.getValidTill());
			}
		}
		return facility;
	}

	public static SacsFacilityDto mapSacsFacilityDtoBasedOnTypology(SacsFacilityDto sacsFacilityDto) {

		if (sacsFacilityDto.getTypology().size() == 1) {
			sacsFacilityDto.setTiType("Exclusive");
		} else {
			sacsFacilityDto.setTiType("Composite");
		}

		for (int i = 0; i < sacsFacilityDto.getTypology().size(); i++) {
			if (i == 0) {
				if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("FSW")) {
					sacsFacilityDto.setCbStatus("Core");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("MSM")) {
					sacsFacilityDto.setCbStatus("Core");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("TG")) {
					sacsFacilityDto.setCbStatus("Core");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("IDU")) {
					sacsFacilityDto.setCbStatus("Core");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("Migrants")) {
					sacsFacilityDto.setCbStatus("Bridge");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("Truckers")) {
					sacsFacilityDto.setCbStatus("Bridge");
				}
			} else {
				if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("FSW")
						&& sacsFacilityDto.getCbStatus().equals("Core")) {
					sacsFacilityDto.setCbStatus("Core");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("MSM")
						&& sacsFacilityDto.getCbStatus().equals("Core")) {
					sacsFacilityDto.setCbStatus("Core");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("TG")
						&& sacsFacilityDto.getCbStatus().equals("Core")) {
					sacsFacilityDto.setCbStatus("Core");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("IDU")
						&& sacsFacilityDto.getCbStatus().equals("Core")) {
					sacsFacilityDto.setCbStatus("Core");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("Migrants")
						&& sacsFacilityDto.getCbStatus().equals("Bridge")) {
					sacsFacilityDto.setCbStatus("Bridge");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("Truckers")
						&& sacsFacilityDto.getCbStatus().equals("Bridge")) {
					sacsFacilityDto.setCbStatus("Bridge");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("Migrants")
						&& sacsFacilityDto.getCbStatus().equals("Core")) {
					sacsFacilityDto.setCbStatus("Core-Bridge");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("Truckers")
						&& sacsFacilityDto.getCbStatus().equals("Core")) {
					sacsFacilityDto.setCbStatus("Core-Bridge");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("FSW")
						&& sacsFacilityDto.getCbStatus().equals("Bridge")) {
					sacsFacilityDto.setCbStatus("Core-Bridge");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("MSM")
						&& sacsFacilityDto.getCbStatus().equals("Bridge")) {
					sacsFacilityDto.setCbStatus("Core-Bridge");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("TG")
						&& sacsFacilityDto.getCbStatus().equals("Bridge")) {
					sacsFacilityDto.setCbStatus("Core-Bridge");
				} else if (sacsFacilityDto.getTypology().get(i).getTypologyName().equals("IDU")
						&& sacsFacilityDto.getCbStatus().equals("Bridge")) {
					sacsFacilityDto.setCbStatus("Core-Bridge");
				} else {
					sacsFacilityDto.setCbStatus("Core-Bridge");
				}
			}
		}

		return sacsFacilityDto;
	}

	public static TypologyMaster mapTypologyDtoToTypologyMaster(TypologyDto typologyDto) {

		TypologyMaster typologyMaster = new TypologyMaster();
		typologyMaster.setTypologyId(typologyDto.getId());
		typologyMaster.setTypologyName(typologyDto.getTypologyName());
		typologyMaster.setIsActive(true);
		typologyMaster.setIsDelete(false);
		return typologyMaster;
	}

	public static Set<TypologyFacilityMapping> maptToTypologyFacilityMapping(List<TypologyDto> typologyList,
			Facility facility) {
		Set<TypologyFacilityMapping> typologyFacilityMappingList = new HashSet<>();
		typologyList.forEach(element -> {
			TypologyFacilityMapping typologyFacilityMapping = new TypologyFacilityMapping();
			TypologyMaster typologyMaster = FacilityMapperUtil.mapTypologyDtoToTypologyMaster(element);
			typologyFacilityMapping.setTypologyMaster(typologyMaster);
			typologyFacilityMapping.setFacility(facility);
			typologyFacilityMapping.setTypologyTarget(element.getTypologyTarget());
			typologyFacilityMapping.setIsActive(true);
			typologyFacilityMapping.setIsDelete(false);
			typologyFacilityMappingList.add(typologyFacilityMapping);
		});
		return typologyFacilityMappingList;
	}

	public static List<TypologyDto> mapTypologyMasterLitToTypologyDtoList(List<TypologyMaster> typologyMasterList) {

		List<TypologyDto> typologyDtoList = new ArrayList<>();
		typologyMasterList.forEach(element -> {
			TypologyDto typologyDto = new TypologyDto();
			typologyDto.setId(element.getTypologyId());
			typologyDto.setTypologyName(element.getTypologyName());
			typologyDtoList.add(typologyDto);
		});

		return typologyDtoList;
	}

	public static List<SacsFacilityDto> mapToSacsfacilityDto(List<Facility> facilityList) {

		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		if (facilityList != null) {
			facilityList.forEach(facility -> {
				SacsFacilityDto sacsFacilityDto = new SacsFacilityDto();
				sacsFacilityDto.setId(facility.getId());
				sacsFacilityDto.setName(facility.getName());
				sacsFacilityDto.setCode(facility.getCode());
				sacsFacilityDto.setCreatedTime(facility.getCreatedTime());
				sacsFacilityDto.setIsActive(facility.getIsActive());
				sacsFacilityDto.setClinicPresent(facility.getClinicPresent());
				sacsFacilityDto.setValidTill(facility.getValidTill());
				if (facility.getFacilityType() != null) {
					sacsFacilityDto.setFacilityTypeId(facility.getFacilityType().getId());
					sacsFacilityDto.setFacilityTypeName(facility.getFacilityType().getFacilityTypeName());
				}
				if (facility.getDivision() != null) {
					sacsFacilityDto.setDivisionId(facility.getDivision().getId());
					sacsFacilityDto.setDivisionName(facility.getDivision().getName());
				}
				if (facility.getFacility() != null) {
					sacsFacilityDto.setParentFacilityId(facility.getFacility().getId());
				}
				sacsFacilityDto.setSacsId(facility.getSacsId());
				if (facility.getAddress() != null) {
					sacsFacilityDto.setFacilityAddressId(facility.getAddress().getId());
					if (facility.getAddress().getTown() != null) {
						sacsFacilityDto.setTownId(facility.getAddress().getTown().getTownId());
					}
					if (facility.getAddress().getSubdistrict() != null) {
						sacsFacilityDto.setSubDistrictId(facility.getAddress().getSubdistrict().getSubdistrictId());
					}
					sacsFacilityDto.setAddressLineOne(facility.getAddress().getAddressLineOne());
					sacsFacilityDto.setAddressLineTwo(facility.getAddress().getAddressLineTwo());
					sacsFacilityDto.setCountry("India");
					sacsFacilityDto.setStateName(facility.getAddress().getState().getName());
					sacsFacilityDto.setStateId(facility.getAddress().getState().getId());
					sacsFacilityDto.setDistrictId(facility.getAddress().getDistrict().getId());
					sacsFacilityDto.setCity(facility.getAddress().getCity());
					if (facility.getAddress().getPincodeEntity() != null) {
						sacsFacilityDto.setPincode(facility.getAddress().getPincodeEntity().getPincode());
					}
				}
				if (facility.getIsLab() != null) {
					sacsFacilityDto.setIsLab(facility.getIsLab());
				}
				sacsFacilityDto.setArtcode(facility.getArtcode());
				sacsFacilityDto.setNodalCentre(facility.getNodalCentre());
				sacsFacilityDto.setFacilityNo(facility.getFacilityNo());

				// Setting parent facility details
				if (facility.getFacility() != null) {
					if (facility.getFacility().getFacilityType() != null && facility.getFacility().getFacilityType()
							.getId() == FacilityTypeEnum.OST_FACILITY.getFacilityType()) {
						sacsFacilityDto.setParentOstId(facility.getFacility().getId());
						sacsFacilityDto.setParentOstName(facility.getFacility().getName());
					}
				}

				if (facility.getUserMasters() != null) {
					Set<UserMaster> userMasterList = facility.getUserMasters();
					List<UserMasterDto> primaryUserList = new ArrayList<>();
					List<UserMasterDto> alternateUserList = new ArrayList<>();
					userMasterList.forEach(userMaster -> {
						UserMasterDto userMasterDto = UserMapperUtil.mapToUserMasterDto(userMaster);
						userMasterDto.setDivisionId(userMaster.getDivision().getId());

						Set<UserRoleMapping> userRoleMappingSet = userMaster.getUserRoleMappings();
						userRoleMappingSet.forEach(userRoleMapping -> {
							if (userRoleMapping != null && userRoleMapping.getRole() != null) {
								if (userRoleMapping.getRole().getIsPrimary()) {
									userMasterDto.setRoleId(userRoleMapping.getRole().getId());
									primaryUserList.add(userMasterDto);
								} else {
									userMasterDto.setRoleId(userRoleMapping.getRole().getId());
									alternateUserList.add(userMasterDto);
								}
							}

						});
					});
					Collections.sort(primaryUserList);
					Collections.sort(alternateUserList);
					Optional<UserMasterDto> primaryUser = primaryUserList.stream().findFirst();
					if (primaryUser.isPresent()) {
						sacsFacilityDto.setPrimaryUser(primaryUser.get());
					}
					Optional<UserMasterDto> alternateUser = alternateUserList.stream().findFirst();
					if (alternateUser.isPresent()) {
						sacsFacilityDto.setAlternateUser(alternateUser.get());
					}

				}
				if (facility.getTypologyFacilityMappings() != null) {
					Set<TypologyFacilityMapping> typologyFacilityMappings = facility.getTypologyFacilityMappings();
					List<TypologyDto> typologyDto = mapToTypology(typologyFacilityMappings);
					sacsFacilityDto.setTypology(typologyDto);
				}
				if (facility.getTiCenter() != null) {
					sacsFacilityDto.setTiCenterId(facility.getTiCenter().getId());
					sacsFacilityDto.setTiCenterName(facility.getTiCenter().getName());
				}
				if (facility.getOstType() != null) {
					sacsFacilityDto.setTiOstTypeId(facility.getOstType().getId());
					sacsFacilityDto.setTiOstTypeName(facility.getOstType().getName());
				}
				sacsFacilityDto.setTiType(facility.getTiType());
				sacsFacilityDto.setMonthlyActiveTarget(facility.getMonthlyActiveTarget());

				sacsFacilityDto.setMonthlyOstTarget(facility.getMonthlyOstTarget());
				sacsFacilityDto.setCbStatus(facility.getcBStatus());
				if (facility.getMachine() != null) {
					sacsFacilityDto.setMachineId(facility.getMachine().getId());
					sacsFacilityDto.setMachineName(facility.getMachine().getMachineName());
				}
				sacsFacilityDto.setNationalId(facility.getNationalId());

				/**
				 * Finding NOA number and products name for Supplier
				 */
				if (!facility.getContracts().isEmpty()
						&& facility.getFacilityType().getId() == FacilityTypeEnum.SUPPLIER.getFacilityType()) {
					sacsFacilityDto.setNoa(0);
					Set<String> products = new HashSet<String>();
					for (Contract contract : facility.getContracts()) {
						if (contract.getContractStatusMaster().getId() == 3l
								&& contract.getIsDelete() == Boolean.FALSE) {
							if (contract.getNoaNumber() != null && contract.getNoaNumber() != "") {
								int noa = sacsFacilityDto.getNoa() + 1;
								sacsFacilityDto.setNoa(noa);
							}
							if (!contract.getContractProducts().isEmpty()) {
								contract.getContractProducts().forEach(action -> {
									if (action.getProduct() != null) {
										products.add(action.getProduct().getProductName());
									}
								});
							}
						}
					}
					String productName = "";
					if (!products.isEmpty()) {
						productName = String.join(", ", products);
					}
					sacsFacilityDto.setProducts(productName);
				}

				sacsFacilityDtoList.add(sacsFacilityDto);
			});

		}
		return sacsFacilityDtoList;
	}

	public static List<TypologyDto> mapToTypology(Set<TypologyFacilityMapping> typologyFacilityMappings) {

		List<TypologyDto> typologyDtoList = new ArrayList<TypologyDto>();
		if (typologyFacilityMappings != null) {
			typologyFacilityMappings.forEach(typologyMapping -> {
				TypologyDto typologyDto = new TypologyDto();
				if (typologyMapping.getTypologyMaster() != null) {
					typologyDto.setId(typologyMapping.getTypologyMaster().getTypologyId());
					typologyDto.setTypologyName(typologyMapping.getTypologyMaster().getTypologyName());
					typologyDto.setTypologyTarget(typologyMapping.getTypologyTarget());
				}
				typologyDtoList.add(typologyDto);

			});

		}
		return typologyDtoList;
	}

	public static SacsFacilityDto mapFacilityToSacsfacilityDto(Facility facility) {

		SacsFacilityDto sacsFacilityDto = new SacsFacilityDto();
		sacsFacilityDto.setId(facility.getId());
		sacsFacilityDto.setName(facility.getName());
		sacsFacilityDto.setCode(facility.getCode());
		sacsFacilityDto.setCreatedTime(facility.getCreatedTime());
		sacsFacilityDto.setIsActive(facility.getIsActive());
		sacsFacilityDto.setClinicPresent(facility.getClinicPresent());
		sacsFacilityDto.setValidTill(facility.getValidTill());
		if (facility.getFacilityType() != null) {
			sacsFacilityDto.setFacilityTypeId(facility.getFacilityType().getId());
			sacsFacilityDto.setFacilityTypeName(facility.getFacilityType().getFacilityTypeName());
		}
		if (facility.getDivision() != null) {
			sacsFacilityDto.setDivisionId(facility.getDivision().getId());
			sacsFacilityDto.setDivisionName(facility.getDivision().getName());
		}
		if (facility.getFacility() != null) {
			sacsFacilityDto.setParentFacilityId(facility.getFacility().getId());
		}
		sacsFacilityDto.setSacsId(facility.getSacsId());
		if (facility.getAddress() != null) {
			sacsFacilityDto.setFacilityAddressId(facility.getAddress().getId());
			if (facility.getAddress().getTown() != null) {
				sacsFacilityDto.setTownId(facility.getAddress().getTown().getTownId());
			}
			if (facility.getAddress().getSubdistrict() != null) {
				sacsFacilityDto.setSubDistrictId(facility.getAddress().getSubdistrict().getSubdistrictId());
			}
			sacsFacilityDto.setAddressLineOne(facility.getAddress().getAddressLineOne());
			sacsFacilityDto.setAddressLineTwo(facility.getAddress().getAddressLineTwo());
			sacsFacilityDto.setCountry("India");
			sacsFacilityDto.setStateName(facility.getAddress().getState().getName());
			sacsFacilityDto.setStateId(facility.getAddress().getState().getId());
			sacsFacilityDto.setDistrictId(facility.getAddress().getDistrict().getId());
			sacsFacilityDto.setCity(facility.getAddress().getCity());
			if (facility.getAddress().getPincodeEntity() != null) {
				sacsFacilityDto.setPincode(facility.getAddress().getPincodeEntity().getPincode());
			}
		}
		if (facility.getIsLab() != null) {
			sacsFacilityDto.setIsLab(facility.getIsLab());
		}
		sacsFacilityDto.setArtcode(facility.getArtcode());
		sacsFacilityDto.setNodalCentre(facility.getNodalCentre());
		sacsFacilityDto.setFacilityNo(facility.getFacilityNo());

		// Setting parent facility details
		if (facility.getFacility() != null) {
			if (facility.getFacility().getFacilityType() != null && facility.getFacility().getFacilityType()
					.getId() == FacilityTypeEnum.OST_FACILITY.getFacilityType()) {
				sacsFacilityDto.setParentOstId(facility.getFacility().getId());
				sacsFacilityDto.setParentOstName(facility.getFacility().getName());
			}
		}

		if (facility.getUserMasters() != null) {
			Set<UserMaster> userMasterList = facility.getUserMasters();
			List<UserMasterDto> primaryUserList = new ArrayList<>();
			List<UserMasterDto> alternateUserList = new ArrayList<>();
			userMasterList.forEach(userMaster -> {
				UserMasterDto userMasterDto = UserMapperUtil.mapToUserMasterDto(userMaster);
				userMasterDto.setDivisionId(userMaster.getDivision().getId());

				Set<UserRoleMapping> userRoleMappingSet = userMaster.getUserRoleMappings();
				userRoleMappingSet.forEach(userRoleMapping -> {
					if (userRoleMapping != null && userRoleMapping.getRole() != null) {
						if (userRoleMapping.getRole().getIsPrimary()) {
							userMasterDto.setRoleId(userRoleMapping.getRole().getId());
							primaryUserList.add(userMasterDto);
						} else {
							userMasterDto.setRoleId(userRoleMapping.getRole().getId());
							alternateUserList.add(userMasterDto);
						}
					}
				});
			});
			Collections.sort(primaryUserList);
			Collections.sort(alternateUserList);
			Optional<UserMasterDto> primaryUser = primaryUserList.stream().findFirst();
			if (primaryUser.isPresent()) {
				sacsFacilityDto.setPrimaryUser(primaryUser.get());
			}
			Optional<UserMasterDto> alternateUser = alternateUserList.stream().findFirst();
			if (alternateUser.isPresent()) {
				sacsFacilityDto.setAlternateUser(alternateUser.get());
			}

		}
		if (facility.getTypologyFacilityMappings() != null) {
			Set<TypologyFacilityMapping> typologyFacilityMappings = facility.getTypologyFacilityMappings();
			List<TypologyDto> typologyDto = mapToTypology(typologyFacilityMappings);
			sacsFacilityDto.setTypology(typologyDto);
		}
		if (facility.getTiCenter() != null) {
			sacsFacilityDto.setTiCenterId(facility.getTiCenter().getId());
			sacsFacilityDto.setTiCenterName(facility.getTiCenter().getName());
		}
		if (facility.getOstType() != null) {
			sacsFacilityDto.setTiOstTypeId(facility.getOstType().getId());
			sacsFacilityDto.setTiOstTypeName(facility.getOstType().getName());
		}
		sacsFacilityDto.setTiType(facility.getTiType());
		sacsFacilityDto.setMonthlyActiveTarget(facility.getMonthlyActiveTarget());
		sacsFacilityDto.setMonthlyOstTarget(facility.getMonthlyOstTarget());
		sacsFacilityDto.setCbStatus(facility.getcBStatus());
		if (facility.getMachine() != null) {
			sacsFacilityDto.setMachineId(facility.getMachine().getId());
			sacsFacilityDto.setMachineName(facility.getMachine().getMachineName());
		}
		sacsFacilityDto.setNationalId(facility.getNationalId());

		/**
		 * Finding NOA number and products name for Supplier
		 */
		if (!facility.getContracts().isEmpty()
				&& facility.getFacilityType().getId() == FacilityTypeEnum.SUPPLIER.getFacilityType()) {
			sacsFacilityDto.setNoa(0);
			Set<String> products = new HashSet<String>();
			for (Contract contract : facility.getContracts()) {
				if (contract.getContractStatusMaster().getId() == 3l && contract.getIsDelete() == Boolean.FALSE) {
					if (contract.getNoaNumber() != null && contract.getNoaNumber() != "") {
						int noa = sacsFacilityDto.getNoa() + 1;
						sacsFacilityDto.setNoa(noa);
					}
					if (!contract.getContractProducts().isEmpty()) {
						contract.getContractProducts().forEach(action -> {
							if (action.getProduct() != null) {
								products.add(action.getProduct().getProductName());
							}
						});
					}
				}
			}
			String productName = "";
			if (!products.isEmpty()) {
				productName = String.join(", ", products);
			}
			sacsFacilityDto.setProducts(productName);
		}
		return sacsFacilityDto;
	}

	public static List<FacilityListByDistrictAndFacilityTypeDTO> mapToFacilityListByDistrictAndFacilityTypeDTOList(
			List<Facility> facilityList) {
		List<FacilityListByDistrictAndFacilityTypeDTO> FacilityDtos = new ArrayList<>();
		for (Facility facility : facilityList) {
			FacilityListByDistrictAndFacilityTypeDTO facilityDto = new FacilityListByDistrictAndFacilityTypeDTO();
			facilityDto.setFacilityId(facility.getId());
			facilityDto.setFacilityName(facility.getName());
			facilityDto.setFacilityCode(facility.getCode());
			facilityDto.setIsActive(facility.getIsActive());
			if (facility.getFacilityType() != null) {
				facilityDto.setFacilityTypeId(facility.getFacilityType().getId());
				facilityDto.setFailityTypeName(facility.getFacilityType().getFacilityTypeName());
			}
			if (facility.getAddress() != null) {
				List<String> address = new ArrayList<>();
				if (facility.getAddress().getAddressLineOne() != null) {
					address.add(facility.getAddress().getAddressLineOne());
				}
				if (facility.getAddress().getAddressLineTwo() != null) {
					address.add(facility.getAddress().getAddressLineTwo());
				}
				facilityDto.setAddress(String.join(", ", address));
				facilityDto.setCity(facility.getAddress().getCity());
				facilityDto.setState(facility.getAddress().getState().getName());
				facilityDto.setDistrict(facility.getAddress().getDistrict().getName());
				if (facility.getAddress().getPincodeEntity() != null) {
					facilityDto.setPincode(facility.getAddress().getPincodeEntity().getPincode());
				}
				if (facility.getAddress().getSubdistrict() != null) {
					facilityDto.setSubDistrict(facility.getAddress().getSubdistrict().getSubdistrictName());
				}
				if (facility.getAddress().getTown() != null) {
					facilityDto.setTown(facility.getAddress().getTown().getTownName());
				}
			}
			FacilityDtos.add(facilityDto);
		}
		return FacilityDtos;
	}

	public static String advanceSearchQueryCreator(Map<String, String> searchValues, List<Long> facilityTypeIds,
			Long sacsId) {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		String facilityName = searchValues.get("facilityname");
		String facilityType = searchValues.get("facilitytype");
		String code = searchValues.get("code");
		String firstName = searchValues.get("firstname");
		String mobileNumber = searchValues.get("mobilenumber");
		String email = searchValues.get("email");
		String machineType = searchValues.get("machinetype");
		String stateId = searchValues.get("state");
		String facilityTypeIdListAsString = StringUtils.join(facilityTypeIds, ',');
		String searchQuery = "";
		if ((firstName == null || firstName == "") && (mobileNumber == null || mobileNumber == "")
				&& (email == null || email == "")) {
			searchQuery = "select f.* from soch.facility f " + "join soch.address a on a.id=f.address_id "
					+ "where f.is_delete=false and (f.is_external is NULL or f.is_external=false ) ";
		} else {
			searchQuery = "select f.* from soch.facility f \r\n" + "join soch.address a on a.id=f.address_id "
					+ "join soch.user_master um on um.facility_id=f.id \r\n"
					+ "where f.is_delete=false and um.is_delete=false and (f.is_external is NULL or f.is_external=false ) ";
		}

		if (facilityName != null && facilityName != "") {
			searchQuery = searchQuery.concat("and lower(f.name) Like lower('%" + facilityName + "%') ");
		}
		// This Condition only works for sacs login using api for searching facilities
		// created by sacs
		if (facilityType != null && facilityType != "" && (facilityTypeIds == null || facilityTypeIds.isEmpty())
				&& sacsId != 0l) {
			searchQuery = searchQuery.concat("and f.facility_type_id = " + facilityType + " ");
		}
		if (code != null && code != "") {
			searchQuery = searchQuery.concat("and lower(f.code) Like lower('%" + code + "%') ");
		}
		if (firstName != null && firstName != "") {
			searchQuery = searchQuery.concat("and lower(um.firstname) Like lower('%" + firstName + "%') ");
		}
		if (mobileNumber != null && mobileNumber != "") {
			searchQuery = searchQuery.concat("and um.mobile_number Like '%" + mobileNumber + "%' ");
		}
		if (email != null && email != "") {
			searchQuery = searchQuery.concat("and lower(um.email) Like lower('%" + email + "%') ");
		}
		if (stateId != null && stateId != "") {
			searchQuery = searchQuery.concat("and a.state_id = " + stateId + " ");
		}
		if (machineType != null && machineType != "") {
			searchQuery = searchQuery.concat("and f.machine_type_id = " + machineType + " ");
		}
		if (facilityTypeIds != null && !facilityTypeIds.isEmpty()
				&& facilityTypeIds.get(0) == FacilityTypeEnum.LAC_FACILITY.getFacilityType()) {
			searchQuery = searchQuery.concat("and f.parent_facility_id=" + currentUser.getFacilityId() + " ");
		}
		if (facilityTypeIds != null && !facilityTypeIds.isEmpty() && sacsId == 0l) {
			if (facilityType == null || facilityType == "") {
				searchQuery = searchQuery.concat("and f.facility_type_id IN (" + facilityTypeIdListAsString
						+ ") group by f.id order by f.id desc ");
			} else {
				searchQuery = searchQuery
						.concat("and f.facility_type_id =" + facilityType + " group by f.id order by f.id desc ");
			}
		} else if (facilityTypeIds != null && !facilityTypeIds.isEmpty()
				&& facilityTypeIds.get(0) == FacilityTypeEnum.WAREHOUSE.getFacilityType()) {
			searchQuery = searchQuery.concat("and f.sacs_id = " + sacsId + " and f.facility_type_id IN ("
					+ facilityTypeIdListAsString + ") group by f.id order by f.id desc ");
		} else if (sacsId != 0) {
			if (facilityType != null && facilityType != "") {
				searchQuery = searchQuery.concat("and f.sacs_id = " + sacsId + " group by f.id order by f.id desc ");
			} else {
				searchQuery = searchQuery.concat("and f.sacs_id = " + sacsId + " and f.facility_type_id NOT IN ("
						+ FacilityTypeEnum.LAC_FACILITY.getFacilityType() + ","
						+ FacilityTypeEnum.WAREHOUSE.getFacilityType() + ") group by f.id order by f.id desc ");
			}
		} else {
			if (facilityType != null && facilityType != "") {
				searchQuery = searchQuery.concat("and f.facility_type_id =" + facilityType + " ");
			}
			searchQuery = searchQuery.concat("group by f.id order by f.id desc ");
		}
		return searchQuery;
	}

	public static String normalSearchQueryCreator(Map<String, String> searchDetails, Long sacsId) {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		String searchValue = searchDetails.get("searchvalue");
		String facilityTypeId = searchDetails.get("facilitytype");
		String divisionId = searchDetails.get("division");
		// String searchQuery = "select f.* from soch.facility f \r\n"
		// + "join soch.user_master um on um.facility_id=f.id \r\n"
		// + "where f.is_delete=false and um.is_delete=false and (lower(f.name) Like
		// lower('%" + searchValue
		// + "%') or lower(f.code) Like lower('%" + searchValue + "%') or
		// lower(um.firstname) Like lower('%"
		// + searchValue + "%') or um.mobile_number Like '%" + searchValue + "%' or
		// lower(um.email) Like lower('%"
		// + searchValue + "%')) ";

		String searchQuery = "select f.* from soch.facility f \r\n"
				+ "where f.is_delete=false and (f.is_external is NULL or f.is_external=false ) and (lower(f.name) Like lower('%" + searchValue
				+ "%') or lower(f.code) Like lower('%" + searchValue + "%')) ";

		if (sacsId != 0 && facilityTypeId != null && facilityTypeId != "") { // For WareHouse under login sacs
			searchQuery = searchQuery.concat("and f.sacs_id = " + sacsId + " and f.facility_type_id = " + facilityTypeId
					+ " group by f.id order by f.id desc ");
		} else if (facilityTypeId != null && facilityTypeId != "") { // For all facility type
			if (Long.valueOf(facilityTypeId) == FacilityTypeEnum.LAC_FACILITY.getFacilityType()) { // For LAC only
				searchQuery = searchQuery.concat("and f.parent_facility_id=" + currentUser.getFacilityId() + " ");
			}
			searchQuery = searchQuery
					.concat("and f.facility_type_id =" + facilityTypeId + " group by f.id order by f.id desc ");
		} else if (sacsId != 0) { // For facility created by Sacs login except LAC and warehouse
			searchQuery = searchQuery.concat("and f.sacs_id = " + sacsId + " and f.facility_type_id NOT IN ("
					+ FacilityTypeEnum.LAC_FACILITY.getFacilityType() + ","
					+ FacilityTypeEnum.WAREHOUSE.getFacilityType() + ") group by f.id order by f.id desc ");
		} else if (divisionId != null && divisionId != ""
				&& Long.valueOf(divisionId) == DivisionEnum.LABORATORY.getDivision()) { // For Laboratory
			searchQuery = searchQuery.concat("and f.facility_type_id IN ("
					+ FacilityTypeEnum.LABORATORY_EID.getFacilityType() + ","
					+ FacilityTypeEnum.LABORATORY_APEX.getFacilityType() + ","
					+ FacilityTypeEnum.LABORATORY_NRL.getFacilityType() + ","
					+ FacilityTypeEnum.LABORATORY_SRL.getFacilityType() + ","
					+ FacilityTypeEnum.LABORATORY_CD4.getFacilityType() + ","
					+ FacilityTypeEnum.VL_PUBLIC.getFacilityType() + "," + FacilityTypeEnum.VL_PRIVATE.getFacilityType()
					+ "," + FacilityTypeEnum.LABORATORY_ICTC_PPTCT.getFacilityType()
					+ ") group by f.id order by f.id desc ");
		}

		return searchQuery;
	}

	public static String FacilityListQueryCreater(List<Long> divisionIds, Long stateId, Long facilityTypeId) {
		String listQuery = "select f.id as facilityId,f.name,ft.id,ft.facility_type_name from soch.facility f \r\n"
				+ "join soch.address ad on ad.id=f.address_id \r\n"
				+ "join soch.facility_type ft on ft.id=f.facility_type_id \r\n"
				+ "where f.is_delete=false and f.is_active=true and (f.is_external is NULL or f.is_external=false ) ";
		if (divisionIds != null && !divisionIds.isEmpty()) {
			String facilityTypeIdListAsString = StringUtils.join(divisionIds, ',');
			listQuery = listQuery.concat("and f.division_id in (" + facilityTypeIdListAsString + ") ");
		}
		if (facilityTypeId != null && facilityTypeId != 0) {
			listQuery = listQuery.concat("and f.facility_type_id=" + facilityTypeId + " ");
		}
		if (stateId != null && stateId != 0) {
			listQuery = listQuery.concat("and ad.state_id=" + stateId + " ");
		}
		listQuery = listQuery.concat("order by f.name asc");
		return listQuery;
	}

	public static List<FacilityBasicListDto> mapObjToBasicFAcilityList(List<Object[]> facilityListObj) {
		List<FacilityBasicListDto> facilityList = facilityListObj.stream().map(objects -> {
			FacilityBasicListDto facilityBasicListDto = new FacilityBasicListDto();
			facilityBasicListDto.setId((long) ((Integer) objects[0]).intValue());
			facilityBasicListDto.setName(objects[1].toString());
			facilityBasicListDto.setFacilityTypeId((long) ((Integer) objects[2]).intValue());
			facilityBasicListDto.setFacilityTypeName(objects[3].toString());
			return facilityBasicListDto;
		}).collect(Collectors.toList());
		return facilityList;
	}
}
