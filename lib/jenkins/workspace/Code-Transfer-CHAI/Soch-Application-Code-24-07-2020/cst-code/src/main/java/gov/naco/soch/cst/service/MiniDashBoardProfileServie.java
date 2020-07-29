package gov.naco.soch.cst.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import gov.naco.soch.constants.MiniProfileConstant;
import gov.naco.soch.cst.dto.MiniProfileOIDto;
import gov.naco.soch.cst.dto.ProfileDispensationDetailsDto;
import gov.naco.soch.cst.dto.ProfileFamilyDetailsDto;
import gov.naco.soch.cst.dto.ProfileIptStatusDto;
import gov.naco.soch.cst.dto.ProfileTableDataDto;
import gov.naco.soch.cst.dto.ProfileTbStatusDto;
import gov.naco.soch.cst.dto.ProfileTestCountDto;
import gov.naco.soch.cst.dto.ProfileWidgetDashBoardDto;
import gov.naco.soch.cst.dto.ProfileWidgetDto;
import gov.naco.soch.cst.dto.StaffNurseProfileDataDto;
import gov.naco.soch.cst.dto.VlValueConstantsDto;
import gov.naco.soch.cst.enums.RegulationVisitEnum;
import gov.naco.soch.projection.ProfileChartCDAndVLProjection;
import gov.naco.soch.projection.ProfileDispensationDetailsProjection;
import gov.naco.soch.projection.ProfileFamilyDetailsProjection;
import gov.naco.soch.projection.ProfileIptAndTbStatusProjection;
import gov.naco.soch.projection.ProfileOiDetailsProjection;
import gov.naco.soch.projection.ProfileWidgetProjection;
import gov.naco.soch.repository.MiniDashBoardProfileRepository;

@Service
public class MiniDashBoardProfileServie {
	@Autowired
	MiniDashBoardProfileRepository profileRepository;

	public ProfileTableDataDto getProfileNonWidgetDetails(Long beneficairyId, Long facilityId) {
		ProfileTableDataDto profileTableDataDto = new ProfileTableDataDto();

		List<ProfileFamilyDetailsProjection> familyDetailsProjections = profileRepository
				.getprofileFamilyDetails(beneficairyId);
		List<ProfileDispensationDetailsProjection> dispensationDetailsProjections = profileRepository
				.getprofileDispensationDetails(beneficairyId, facilityId);
		if (familyDetailsProjections != null && familyDetailsProjections.size() > 0) {
			List<ProfileFamilyDetailsDto> familyDetailsDtos = new ArrayList<ProfileFamilyDetailsDto>();
			for (ProfileFamilyDetailsProjection profileFamilyDetailsProjection : familyDetailsProjections) {
				ProfileFamilyDetailsDto familyDetailsDto = new ProfileFamilyDetailsDto();
				familyDetailsDto.setBeneficiaryId(profileFamilyDetailsProjection.getBeneficiaryId());
				familyDetailsDto.setBeneficiaryName(profileFamilyDetailsProjection.getBeneficiaryName());
				familyDetailsDto.setRelationType(profileFamilyDetailsProjection.getRelationType());
				familyDetailsDto.setArtStatus(profileFamilyDetailsProjection.getArtStatus());
				familyDetailsDto.setArtNumber(profileFamilyDetailsProjection.getArtNumber());
				familyDetailsDto.setPreArtNumber(profileFamilyDetailsProjection.getPreArtNumber());
				familyDetailsDtos.add(familyDetailsDto);
			}
			profileTableDataDto.setFamilyDetails(familyDetailsDtos);
		}

		if (dispensationDetailsProjections != null && dispensationDetailsProjections.size() > 0) {
			List<ProfileDispensationDetailsDto> dispensationDetailsDtos = new ArrayList<ProfileDispensationDetailsDto>();
			for (ProfileDispensationDetailsProjection dispensationDetailsProjection : dispensationDetailsProjections) {
				ProfileDispensationDetailsDto dispensationDetailsDto = new ProfileDispensationDetailsDto();
				dispensationDetailsDto.setVisitDate(dispensationDetailsProjection.getVisitDate());
				dispensationDetailsDto.setProductname(dispensationDetailsProjection.getProductname());
				dispensationDetailsDto.setGivenQty(dispensationDetailsProjection.getGivenQty());
				dispensationDetailsDto.setAdherencePercentage(dispensationDetailsProjection.getAdherencePercentage());
				dispensationDetailsDto
						.setRegulationOfVisitStatus(getColorCode(dispensationDetailsProjection.getExpectedVisitDate(),
								dispensationDetailsProjection.getDispensedDate()));
				dispensationDetailsDtos.add(dispensationDetailsDto);
			}
			profileTableDataDto.setDispensationDetails(dispensationDetailsDtos);
		}

		return profileTableDataDto;
	}

	public ProfileWidgetDashBoardDto getWidgetDashboardData(Long beneficairyId, Long facilityId) {
		ProfileWidgetDashBoardDto profileWidgetDashBoardDto = new ProfileWidgetDashBoardDto();

		try {
			List<ProfileWidgetProjection> profileCDFourWidgetProjections = profileRepository
					.getProfileCDFourWidgetData(beneficairyId, facilityId);

			if (profileCDFourWidgetProjections != null && profileCDFourWidgetProjections.size() > 0) {
				List<ProfileWidgetDto> profileWidgetDtos = new ArrayList<ProfileWidgetDto>();
				for (ProfileWidgetProjection profileWidgetProjection : profileCDFourWidgetProjections) {
					ProfileWidgetDto profileWidgetDto = new ProfileWidgetDto();
					profileWidgetDto.setResultId(profileWidgetProjection.getResultId());
					profileWidgetDto.setResultType(profileWidgetProjection.getResultType());
					profileWidgetDto.setResultValue(profileWidgetProjection.getResultValue());
					profileWidgetDto.setResultDate(profileWidgetProjection.getResultDate());
					profileWidgetDtos.add(profileWidgetDto);
					profileWidgetDashBoardDto.setCdFourTable(profileWidgetDtos);
				}

				ProfileChartCDAndVLProjection cdAndVLProjection = profileRepository
						.getProfileCDFourCountData(beneficairyId, facilityId);
				if (cdAndVLProjection != null) {
					ProfileTestCountDto testCountDto = new ProfileTestCountDto();
					testCountDto.setMinValue(cdAndVLProjection.getMinValue());
					testCountDto.setMaxValue(cdAndVLProjection.getMaxValue());
					profileWidgetDashBoardDto.setCdTestCount(testCountDto);
				}
			}

			List<ProfileWidgetProjection> profileVLValueWidgetProjections = profileRepository
					.getProfileVLWidgetData(beneficairyId, facilityId);

			if (profileVLValueWidgetProjections != null && profileVLValueWidgetProjections.size() > 0) {
				List<ProfileWidgetDto> profileWidgetDtos = new ArrayList<ProfileWidgetDto>();
				for (ProfileWidgetProjection profileWidgetProjection : profileVLValueWidgetProjections) {
					ProfileWidgetDto profileWidgetDto = new ProfileWidgetDto();
					profileWidgetDto.setResultId(profileWidgetProjection.getResultId());
					profileWidgetDto.setResultType(profileWidgetProjection.getResultType());
					profileWidgetDto.setResultValue(getScalevalue(profileWidgetProjection.getResultType(),
							profileWidgetProjection.getResultValue()));
					profileWidgetDto.setResultDate(profileWidgetProjection.getResultDate());
					profileWidgetDtos.add(profileWidgetDto);
					profileWidgetDashBoardDto.setVlValueTable(profileWidgetDtos);
				}
				ProfileChartCDAndVLProjection cdAndVLProjection = profileRepository
						.getProfileVLFourCountData(beneficairyId, facilityId);
				if (cdAndVLProjection != null) {
					ProfileTestCountDto testCountDto = new ProfileTestCountDto();
					testCountDto.setMinValue(cdAndVLProjection.getMinValue());
					testCountDto.setMaxValue(cdAndVLProjection.getMaxValue());
					profileWidgetDashBoardDto.setVlTestCount(testCountDto);
				}
			}
		} catch (Exception e) {
			return profileWidgetDashBoardDto;
		}

		return profileWidgetDashBoardDto;
	}

	public StaffNurseProfileDataDto getProfileDataForStaffNurse(Long beneficairyId, Long facilityId) {
		StaffNurseProfileDataDto staffNurseProfileDataDto = new StaffNurseProfileDataDto();
		try {
			List<ProfileOiDetailsProjection> profileOiDetailsProjections = profileRepository
					.getProfileOIData(beneficairyId, facilityId);
			ProfileIptAndTbStatusProjection profileIptAndTbStatusProjection = profileRepository
					.getProfileIptAndTbStatusData(beneficairyId, facilityId);
			if (profileOiDetailsProjections != null && profileOiDetailsProjections.size() > 0) {
				List<MiniProfileOIDto> miniProfileOIDtos = new ArrayList<MiniProfileOIDto>();
				for (ProfileOiDetailsProjection profileOiDetailsProjection : profileOiDetailsProjections) {
					MiniProfileOIDto miniProfileOIDto = new MiniProfileOIDto();
					miniProfileOIDto.setVisitId(profileOiDetailsProjection.getVisitId());
					miniProfileOIDto.setBeneficiaryId(profileOiDetailsProjection.getBeneficiaryId());
					miniProfileOIDto.setVisitDate(profileOiDetailsProjection.getVisitDate());
					miniProfileOIDto.setOiItems(profileOiDetailsProjection.getOiItems());
					miniProfileOIDto.setInfectionRemarks(profileOiDetailsProjection.getRemarks());
					miniProfileOIDtos.add(miniProfileOIDto);
				}
				staffNurseProfileDataDto.setMiniProfileOIData(miniProfileOIDtos);
			}
			if (profileIptAndTbStatusProjection != null) {
				ProfileIptStatusDto profileIptStatusDto = new ProfileIptStatusDto();
				ProfileTbStatusDto profileTbStatusDto = new ProfileTbStatusDto();
				profileIptStatusDto.setIptStartDate(profileIptAndTbStatusProjection.getIptStartDate());
				profileIptStatusDto.setIptStopDate(profileIptAndTbStatusProjection.getIptStopDate());
				profileIptStatusDto.setIptRestartDate(profileIptAndTbStatusProjection.getIptRestartDate());
				profileIptStatusDto.setIptEndDate(profileIptAndTbStatusProjection.getIptEndDate());
				profileTbStatusDto.setTbDiagnoseDate(profileIptAndTbStatusProjection.getTbDiagnoseDate());
				profileTbStatusDto.setAttStartDate(profileIptAndTbStatusProjection.getAttStartDate());
				profileTbStatusDto.setTbCompleteDate(profileIptAndTbStatusProjection.getTbCompleteDate());
				staffNurseProfileDataDto.setIptStatus(profileIptStatusDto);
				staffNurseProfileDataDto.setTbStatus(profileTbStatusDto);
			}
		} catch (Exception e) {
			return staffNurseProfileDataDto;
		}
		return staffNurseProfileDataDto;
	}

	public static String getScalevalue(String key, String value) {

		try {
			String tempVLValue = MiniProfileConstant.VL_VALUES;
			Gson gson = new Gson();
			Type vlListType = new TypeToken<ArrayList<VlValueConstantsDto>>() {
			}.getType();
			List<VlValueConstantsDto> founderList = gson.fromJson(tempVLValue, vlListType);
			Optional<VlValueConstantsDto> vlObj = founderList.stream()
					.filter(vlObjs -> vlObjs.getName().equalsIgnoreCase(key)).findFirst();
			VlValueConstantsDto constantsDto = vlObj != null && vlObj.isPresent() ? vlObj.get() : null;
			if (constantsDto != null) {
				value = constantsDto.getValue();
			}
		} catch (JsonSyntaxException e) {
			return value;
		}
		return value;
	}

	static RegulationVisitEnum getColorCode(Date expectedDate, Date dispensedDate) {
		long noofDays = 0L;
		try {
			if (expectedDate == null && dispensedDate == null) {
				return RegulationVisitEnum.white;
			} else if (expectedDate == null && dispensedDate != null) {
				return RegulationVisitEnum.green;
			} else {
				noofDays = getDifferenceDays(expectedDate, dispensedDate);
				if (noofDays >= 0) {
					return RegulationVisitEnum.green;
				} else if (noofDays >= -7) {
					return RegulationVisitEnum.amber;
				} else {
					return RegulationVisitEnum.red;
				}

			}
		} catch (Exception e) {
			return RegulationVisitEnum.white;
		}
	}

	public static long getDifferenceDays(Date expectedDate, Date dispensedDate) {
		long diff = expectedDate.getTime() - dispensedDate.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
}
