package gov.naco.soch.cst.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import gov.naco.soch.cst.dto.ArtBeneficiaryIctcReferralDto;
import gov.naco.soch.projection.ArtIctcReferredProjection;

public class ArtBeneficiaryIctcReferralMapper {

	public static List<ArtBeneficiaryIctcReferralDto> mapProjectionToBeneficiaryReferralDto(
			List<ArtIctcReferredProjection> beneficiaryReferral) {

		List<ArtBeneficiaryIctcReferralDto> artBeneficiaryIctcReferralDto = new ArrayList<ArtBeneficiaryIctcReferralDto>();
		if (beneficiaryReferral != null) {

			for (ArtIctcReferredProjection beneficiary : beneficiaryReferral) {
				ArtBeneficiaryIctcReferralDto referralDto = new ArtBeneficiaryIctcReferralDto();
				referralDto.setFirstName(beneficiary.getFirstname());
				referralDto.setMiddleName(beneficiary.getMiddleName());
				referralDto.setLastName(beneficiary.getLastname());
				referralDto.setBeneficiaryId(beneficiary.getBeneficiaryId());
				referralDto.setAge(beneficiary.getAge());
				referralDto.setMobileNumber(beneficiary.getMobileNumber());
				referralDto.setGenderId(beneficiary.getGenderId());
				referralDto.setReferDate(beneficiary.getReferDate());
				referralDto.setDateOfHivTest(beneficiary.getTestedDate());
				referralDto.setCategoryId(beneficiary.getCategoryId());
				referralDto.setPatientPid(beneficiary.getPid());
				referralDto.setId(beneficiary.getReferralId());
				referralDto.setHivStatus(beneficiary.getHivStatusId());
				referralDto.setReferredFrom(beneficiary.getReferredFrom());
				referralDto.setHivTypeId(beneficiary.getHivTypeId());
				referralDto.setDateOfVisit(beneficiary.getDateOfVisit());
				referralDto.setAcceptedDate(beneficiary.getAcceptedDate());
				referralDto.setUid(beneficiary.getUid());
				referralDto.setIctcId(beneficiary.getIctcId());
				referralDto.setDob(beneficiary.getDateOfBirth());
				artBeneficiaryIctcReferralDto.add(referralDto);
			}
		}
		return artBeneficiaryIctcReferralDto;
	}

	public static List<ArtBeneficiaryIctcReferralDto> mapObjectDataBeneficiaryReferralDto(List<Object[]> objList) {

		List<ArtBeneficiaryIctcReferralDto> referralDto = new ArrayList<ArtBeneficiaryIctcReferralDto>();
		if (objList != null && objList.size() > 0) {

			for (Object[] obj : objList) {

				ArtBeneficiaryIctcReferralDto dto = new ArtBeneficiaryIctcReferralDto();
				String benId = String.valueOf(obj[0]);
				dto.setBeneficiaryId(Long.valueOf(benId));
				dto.setFirstName(String.valueOf(obj[1]));
				dto.setMiddleName(String.valueOf(obj[2]));
				dto.setAge(String.valueOf(obj[3]));
				dto.setLastName(String.valueOf(obj[4]));
				dto.setMobileNumber(String.valueOf(obj[5]));
				String hiv = String.valueOf(obj[6]);
				if (!hiv.equals("null") && !hiv.isEmpty()) {
					dto.setHivStatus(Long.valueOf(hiv));
				}
				String category = String.valueOf(obj[7]);
				if (!category.equals("null") && !category.isEmpty()) {
					dto.setCategoryId(Long.valueOf(category));
				}
				String gender = String.valueOf(obj[8]);
				if (!gender.equals("null") && !gender.isEmpty()) {
					dto.setGenderId(Long.valueOf(gender));
				}
				dto.setPatientPid(String.valueOf(obj[9]));
				String referFrom = String.valueOf(obj[10]);
				if (!referFrom.equals("null") && !referFrom.isEmpty()) {
					dto.setReferredFrom(Long.valueOf(referFrom));
				}
				String referDate = String.valueOf(obj[11]);
				if (!referDate.equals("null") && !referDate.isEmpty()) {
					dto.setReferDate(LocalDate.parse(referDate));
				}
				String dateOfVisit = String.valueOf(obj[12]);
				if (!dateOfVisit.equals("null") && !dateOfVisit.isEmpty()) {
					dto.setDateOfVisit(LocalDate.parse(dateOfVisit));
				}
				String acceptDate = String.valueOf(obj[13]);
				if (!acceptDate.equals("null") && !acceptDate.isEmpty()) {
					dto.setAcceptedDate(LocalDateTime.parse(acceptDate));
				}
				String referId = String.valueOf(obj[14]);
				dto.setId(Long.valueOf(referId));
				dto.setUid(String.valueOf(obj[15]));
				String ictcId = String.valueOf(obj[16]);
				if (!ictcId.equals("null") && !ictcId.isEmpty()) {
					dto.setIctcId(Long.valueOf(ictcId));
				}
				String hivType = String.valueOf(obj[17]);
				if (!hivType.equals("null") && !hivType.isEmpty()) {
					dto.setHivTypeId(Long.valueOf(hivType));
				}
				String dob = String.valueOf(obj[18]);
				if (!dob.equals("null") && !dob.isEmpty()) {
					dto.setDob(LocalDate.parse(dob));
				}
				String referDateOfhiv = String.valueOf(obj[19]);
				if(!referDateOfhiv.equals("null") && !referDateOfhiv.isEmpty()) {
					DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
					LocalDateTime dd = LocalDateTime.parse(referDateOfhiv+"-00:00",dtf);
					dto.setDateOfHivTest(dd);
				}	
				referralDto.add(dto);

			}
		}
		return referralDto;
	}
}
