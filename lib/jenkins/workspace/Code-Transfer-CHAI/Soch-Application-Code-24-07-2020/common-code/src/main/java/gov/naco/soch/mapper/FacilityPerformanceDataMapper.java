package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DailyDosageDto;
import gov.naco.soch.dto.FacilityPerformanceData;
import gov.naco.soch.projection.DailyDosageProjection;
import gov.naco.soch.projection.DailyDosageRegistrationProjection;
import gov.naco.soch.projection.FacilityPerformanceDetailProjection;
import gov.naco.soch.projection.UserDetailsProjection;

public class FacilityPerformanceDataMapper {

	public static List<DailyDosageDto> mapToDailyDosageDtoSet(List<DailyDosageProjection> dailyDosageList) {
		List<DailyDosageDto> dailyDosageDtos = new ArrayList<DailyDosageDto>();

		if (!CollectionUtils.isEmpty(dailyDosageList)) {
			dailyDosageList.forEach(dailyDosage -> {

				DailyDosageDto dailyDosageDto = new DailyDosageDto();

				int totalDays = 0;
				double totalDosage = 0.0;

				dailyDosageDto.setPatientName(dailyDosage.getPatientname());
				dailyDosageDto.setOstRegnNum(dailyDosage.getOstregnnum());

				if (dailyDosage.getDay1() != null) {
					dailyDosageDto.setDay1(Double.toString(dailyDosage.getDay1()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay1();
				} else {
					dailyDosageDto.setDay1("0");
				}

				if (dailyDosage.getDay2() != null) {
					dailyDosageDto.setDay2(Double.toString(dailyDosage.getDay2()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay2();
				} else {
					dailyDosageDto.setDay2("0");
				}

				if (dailyDosage.getDay3() != null) {
					dailyDosageDto.setDay3(Double.toString(dailyDosage.getDay3()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay3();
				} else {
					dailyDosageDto.setDay3("0");
				}

				if (dailyDosage.getDay4() != null) {
					dailyDosageDto.setDay4(Double.toString(dailyDosage.getDay4()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay4();
				} else {
					dailyDosageDto.setDay4("0");
				}

				if (dailyDosage.getDay5() != null) {
					dailyDosageDto.setDay5(Double.toString(dailyDosage.getDay5()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay5();
				} else {
					dailyDosageDto.setDay5("0");
				}

				if (dailyDosage.getDay6() != null) {
					dailyDosageDto.setDay6(Double.toString(dailyDosage.getDay6()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay6();
				} else {
					dailyDosageDto.setDay6("0");
				}

				if (dailyDosage.getDay7() != null) {
					dailyDosageDto.setDay7(Double.toString(dailyDosage.getDay7()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay7();
				} else {
					dailyDosageDto.setDay7("0");
				}

				if (dailyDosage.getDay8() != null) {
					dailyDosageDto.setDay8(Double.toString(dailyDosage.getDay8()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay8();
				} else {
					dailyDosageDto.setDay8("0");
				}

				if (dailyDosage.getDay9() != null) {
					dailyDosageDto.setDay9(Double.toString(dailyDosage.getDay9()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay9();
				} else {
					dailyDosageDto.setDay9("0");
				}

				if (dailyDosage.getDay10() != null) {
					dailyDosageDto.setDay10(Double.toString(dailyDosage.getDay10()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay10();
				} else {
					dailyDosageDto.setDay10("0");
				}

				if (dailyDosage.getDay11() != null) {
					dailyDosageDto.setDay11(Double.toString(dailyDosage.getDay11()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay11();
				} else {
					dailyDosageDto.setDay11("0");
				}

				if (dailyDosage.getDay12() != null) {
					dailyDosageDto.setDay12(Double.toString(dailyDosage.getDay12()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay12();
				} else {
					dailyDosageDto.setDay12("0");
				}

				if (dailyDosage.getDay13() != null) {
					dailyDosageDto.setDay13(Double.toString(dailyDosage.getDay13()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay13();
				} else {
					dailyDosageDto.setDay13("0");
				}

				if (dailyDosage.getDay14() != null) {
					dailyDosageDto.setDay14(Double.toString(dailyDosage.getDay14()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay14();
				} else {
					dailyDosageDto.setDay14("0");
				}

				if (dailyDosage.getDay15() != null) {
					dailyDosageDto.setDay15(Double.toString(dailyDosage.getDay15()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay15();
				} else {
					dailyDosageDto.setDay15("0");
				}

				if (dailyDosage.getDay16() != null) {
					dailyDosageDto.setDay15(Double.toString(dailyDosage.getDay16()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay16();
				} else {
					dailyDosageDto.setDay16("0");
				}

				if (dailyDosage.getDay17() != null) {
					dailyDosageDto.setDay17(Double.toString(dailyDosage.getDay17()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay17();
				} else {
					dailyDosageDto.setDay17("0");
				}

				if (dailyDosage.getDay18() != null) {
					dailyDosageDto.setDay18(Double.toString(dailyDosage.getDay18()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay18();
				} else {
					dailyDosageDto.setDay18("0");
				}

				if (dailyDosage.getDay19() != null) {
					dailyDosageDto.setDay19(Double.toString(dailyDosage.getDay19()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay19();
				} else {
					dailyDosageDto.setDay19("0");
				}

				if (dailyDosage.getDay20() != null) {
					dailyDosageDto.setDay20(Double.toString(dailyDosage.getDay20()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay20();
				} else {
					dailyDosageDto.setDay20("0");
				}

				if (dailyDosage.getDay21() != null) {
					dailyDosageDto.setDay21(Double.toString(dailyDosage.getDay21()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay21();
				} else {
					dailyDosageDto.setDay21("0");
				}

				if (dailyDosage.getDay22() != null) {
					dailyDosageDto.setDay22(Double.toString(dailyDosage.getDay22()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay22();
				} else {
					dailyDosageDto.setDay22("0");
				}

				if (dailyDosage.getDay23() != null) {
					dailyDosageDto.setDay23(Double.toString(dailyDosage.getDay23()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay23();
				} else {
					dailyDosageDto.setDay23("0");
				}

				if (dailyDosage.getDay24() != null) {
					dailyDosageDto.setDay24(Double.toString(dailyDosage.getDay24()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay24();
				} else {
					dailyDosageDto.setDay24("0");
				}

				if (dailyDosage.getDay25() != null) {
					dailyDosageDto.setDay25(Double.toString(dailyDosage.getDay25()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay25();
				} else {
					dailyDosageDto.setDay25("0");
				}

				if (dailyDosage.getDay26() != null) {
					dailyDosageDto.setDay26(Double.toString(dailyDosage.getDay26()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay26();
				} else {
					dailyDosageDto.setDay26("0");
				}

				if (dailyDosage.getDay27() != null) {
					dailyDosageDto.setDay27(Double.toString(dailyDosage.getDay27()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay27();
				} else {
					dailyDosageDto.setDay27("0");
				}

				if (dailyDosage.getDay28() != null) {
					dailyDosageDto.setDay28(Double.toString(dailyDosage.getDay28()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay28();
				} else {
					dailyDosageDto.setDay28("0");
				}

				if (dailyDosage.getDay29() != null) {
					dailyDosageDto.setDay29(Double.toString(dailyDosage.getDay29()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay29();
				} else {
					dailyDosageDto.setDay29("0");
				}

				if (dailyDosage.getDay30() != null) {
					dailyDosageDto.setDay30(Double.toString(dailyDosage.getDay30()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay30();
				} else {
					dailyDosageDto.setDay30("0");
				}

				if (dailyDosage.getDay31() != null) {
					dailyDosageDto.setDay31(Double.toString(dailyDosage.getDay31()));
					totalDays += 1;
					totalDosage += dailyDosage.getDay31();
				} else {
					dailyDosageDto.setDay31("0");
				}

				dailyDosageDto.setTotalDoseDays(totalDays);
				dailyDosageDto.setTotalDose(totalDosage);

				dailyDosageDtos.add(dailyDosageDto);

			});
		}
		return dailyDosageDtos;

	}

	public static FacilityPerformanceData mapReportStaticHeaderData(FacilityPerformanceDetailProjection facility,
			DailyDosageRegistrationProjection registrationCount, UserDetailsProjection userDetails) {
		FacilityPerformanceData dailyDosageExportDto = new FacilityPerformanceData();

		try {

			if (facility != null) {
				dailyDosageExportDto.setFacilityCenterName(facility.getName());
				if (facility.getAddress() != null && facility.getDistrict() != null) {
					dailyDosageExportDto.setFacilityDistrictName(facility.getDistrict());
					dailyDosageExportDto.setOstCode(facility.getOstCode());
					dailyDosageExportDto.setBlock(facility.getBlock());
					dailyDosageExportDto.setCenterEmailId(facility.getcenterEmailId());
					dailyDosageExportDto.setCenterPnNo(facility.getcenterPhNo());
					dailyDosageExportDto.setCity(facility.getCity());
					dailyDosageExportDto.setPincode(facility.getPincode());
					dailyDosageExportDto.setStateName(facility.getState());
					dailyDosageExportDto.setTown(facility.getTown());
					dailyDosageExportDto.setfTypeName(facility.getFacilityTypeName());
					dailyDosageExportDto.setAddress(facility.getAddress());
				}
			}

			if (registrationCount != null) {
				dailyDosageExportDto.setTotalRegisteredCount(registrationCount.getTotalRegTillDate());
				dailyDosageExportDto.setRegistrationThisMonth(registrationCount.getCurrenTMonthReg());
			}
			if (userDetails != null) {
				dailyDosageExportDto.setFirstName(userDetails.getFirstname());
				dailyDosageExportDto.setLastName(userDetails.getLastname());
				dailyDosageExportDto.setMobileNumber(userDetails.getMobileNumber());
				dailyDosageExportDto.setEmail(userDetails.getEmail());
			}
		} catch (Exception e) {
			return dailyDosageExportDto;
		}

		return dailyDosageExportDto;

	}

}
