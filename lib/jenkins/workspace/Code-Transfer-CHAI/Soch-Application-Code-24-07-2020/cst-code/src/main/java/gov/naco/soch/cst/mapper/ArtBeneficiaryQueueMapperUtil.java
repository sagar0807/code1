package gov.naco.soch.cst.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.naco.soch.cst.dto.ArtBeneficiaryQueueDto;
import gov.naco.soch.cst.dto.ArtBeneficiarySearchDto;
import gov.naco.soch.cst.service.ArtBeneficiaryQueueService;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.Beneficiary;

public class ArtBeneficiaryQueueMapperUtil {
	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueMapperUtil.class);

	public static ArtBeneficiaryQueueDto mapArtBeneficiaryQueueArtBeneficiaryQueueDto(
			ArtBeneficiaryQueue artBeneficiaryQueue) {

		ArtBeneficiaryQueueDto artBeneficiaryQueueDto = new ArtBeneficiaryQueueDto();
		Beneficiary beneficiary = artBeneficiaryQueue.getBeneficiary();
		if (beneficiary != null) {
			artBeneficiaryQueueDto.setBeneficiaryId(beneficiary.getId());
			artBeneficiaryQueueDto.setFirstName(Objects.toString(beneficiary.getFirstName(), "") + " "
					+ Objects.toString(beneficiary.getMiddleName(), "") + " "
					+ Objects.toString(beneficiary.getLastName(), ""));
			artBeneficiaryQueueDto.setFirstName(beneficiary.getFirstName());
			artBeneficiaryQueueDto.setLastName(beneficiary.getLastName());
			artBeneficiaryQueueDto.setMiddleName(beneficiary.getMiddleName());
			artBeneficiaryQueueDto.setArtNumber(beneficiary.getArtNumber());
			artBeneficiaryQueueDto.setPreArtNumber(beneficiary.getPreArtNumber());
			if (beneficiary.getGenderId() != null) {
				artBeneficiaryQueueDto.setGender(Objects.toString(beneficiary.getGenderId().getName(), ""));
			}
			artBeneficiaryQueueDto.setAssignedToUser(artBeneficiaryQueue.getAssignedToUser().getFirstname());
			artBeneficiaryQueueDto.setStatus(Objects.toString(beneficiary.getIsActive(), ""));
			artBeneficiaryQueueDto.setUid(beneficiary.getUid());
			artBeneficiaryQueueDto.setAge(beneficiary.getAge());
			artBeneficiaryQueueDto.setBeneficiaryId(beneficiary.getId());
		}
		return artBeneficiaryQueueDto;

	}

	public static List<ArtBeneficiarySearchDto> mapArtBeneficiarySearchQueueDto(
			List<ArtBeneficiaryQueue> beneficiaryQueues) {
		List<ArtBeneficiarySearchDto> artBeneficiaryDtoList = new ArrayList<ArtBeneficiarySearchDto>();
		beneficiaryQueues.forEach(artBeneficiary -> {
			ArtBeneficiarySearchDto artBeneficiarySearchDto = new ArtBeneficiarySearchDto();
			artBeneficiarySearchDto.setBeneficiaryId(artBeneficiary.getBeneficiary().getId());
			if (artBeneficiary.getBeneficiary() != null) {
				artBeneficiarySearchDto.setBeneficiaryId(artBeneficiary.getBeneficiary().getId());
				artBeneficiarySearchDto.setAge(artBeneficiary.getBeneficiary().getAge());
				artBeneficiarySearchDto.setArtNumber(artBeneficiary.getBeneficiary().getArtNumber());
				artBeneficiarySearchDto.setPreArtNumber(artBeneficiary.getBeneficiary().getPreArtNumber());
				artBeneficiarySearchDto
						.setFirstName(Objects.toString(artBeneficiary.getBeneficiary().getFirstName(), "") + ""
								+ Objects.toString(artBeneficiary.getBeneficiary().getMiddleName(), "") + " "
								+ Objects.toString(artBeneficiary.getBeneficiary().getLastName(), ""));
				artBeneficiarySearchDto
						.setGender(Objects.toString(artBeneficiary.getBeneficiary().getGenderId().getName()));
				artBeneficiarySearchDto.setUid(artBeneficiary.getBeneficiary().getUid());

			}
			artBeneficiaryDtoList.add(artBeneficiarySearchDto);
		});

		return artBeneficiaryDtoList;
	}

	public static String createSerachQuery(@Valid Long facilityId, String name, String artNumber, String preArtNumber,
			String uid, String gender, Boolean visited) {
		String subQuery = null;
		String searchQuery = null;
		String str = name;
		String[] temp;
		String delimiter = " ";
		String fName = null;
		String mName = null;
		String lName = null;
		if (str != null) {
			temp = str.split(delimiter);
			if (temp.length == 0) {
				fName = null;
				mName = null;
				lName = null;
			}
			if (temp.length == 1) {
				fName = temp[0];
			}
			if (temp.length == 2) {
				fName = temp[0];
				mName = temp[1];
			}
			if (temp.length == 3) {
				fName = temp[0];
				mName = temp[1];
				lName = temp[2];
			}
		}
		if (visited == false) {
			searchQuery = "select * from soch.art_beneficiary_queue ad join soch.beneficiary b\r\n"
					+ "on(ad.beneficiary_id=b.id) where ad.facility_id=" + facilityId
					+ " and is_active=true and is_delete=false and ad.is_visited=" + visited + " "
					+ " and ad.visit_date='" + LocalDate.now() + "'\r\n";
		}
		if (visited == true) {
			searchQuery = "select * from soch.art_beneficiary_queue ad join soch.beneficiary b\r\n"
					+ "on(ad.beneficiary_id=b.id) where ad.facility_id=" + facilityId
					+ "and ad.is_visited=" + visited + " "
					+ "and ad.visit_date='" + LocalDate.now() + "'\r\n";
		}
		if (name != null && artNumber == null && preArtNumber == null && uid == null) {
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + lName + "%')";
		} else if (artNumber != null && name == null && preArtNumber == null && uid == null) {
			artNumber = artNumber.toLowerCase();
			subQuery = "and LOWER(b.art_number) like '%" + artNumber + "%'";
		} else if (preArtNumber != null && artNumber == null && name == null && uid == null) {
			preArtNumber = preArtNumber.toLowerCase();
			subQuery = "and LOWER(b.pre_art_number) like '%" + preArtNumber + "%'";
		} else if (uid != null && preArtNumber == null && artNumber == null && name == null) {
			uid = uid.toLowerCase();
			subQuery = "and LOWER(b.uid) like '%" + uid + "%'";
		} else if (gender != null && preArtNumber == null && artNumber == null && name == null && uid == null) {
			// gender = gender.toLowerCase();
			subQuery = "and LOWER(b.gender_id) like '%" + gender + "%'";
		} else if (name != null && artNumber != null && preArtNumber == null && uid == null) {
			name = name.toLowerCase();
			artNumber = artNumber.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'or LOWER(b.last_name) like '%" + lName + "%') and LOWER(b.art_number)\r\n" + " like '%"
					+ artNumber + "%'";
		} else if (name != null && preArtNumber != null && artNumber == null && uid == null) {
			name = name.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + lName + "%') and LOWER(b.pre_art_number) like '%"
					+ preArtNumber + "%'";
		} else if (name != null && uid != null && preArtNumber == null && artNumber == null) {
			name = name.toLowerCase();
			uid = uid.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + lName + "%') and LOWER(b.uid) like '%" + uid + "%'";
		} else if (name != null && gender != null && preArtNumber == null && artNumber == null && uid == null) {
			name = name.toLowerCase();
			// gender = gender.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + lName + "%')";
		} else if (artNumber != null && preArtNumber != null && uid == null && name == null) {
			artNumber = artNumber.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			subQuery = "and LOWER(b.art_number) like '%" + artNumber + "%' and LOWER(b.pre_art_number) like '%"
					+ preArtNumber + "%'";
		} else if (artNumber != null && preArtNumber == null && uid != null && name == null) {
			artNumber = artNumber.toLowerCase();
			uid = uid.toLowerCase();
			subQuery = "and LOWER(b.art_number) like '%" + artNumber + "%' and LOWER(b.uid) like '%" + uid + "%'";
		} else if (preArtNumber != null && uid != null && name == null && artNumber == null) {
			preArtNumber = preArtNumber.toLowerCase();
			uid = uid.toLowerCase();
			subQuery = "and LOWER(b.pre_art_number) like '%" + preArtNumber + "%' and LOWER(b.uid) like '%" + uid
					+ "%'";
		} else if (name != null && artNumber != null && preArtNumber != null && uid == null) {
			artNumber = artNumber.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + lName + "%') and LOWER(b.art_number) like '%"
					+ artNumber + "%' and LOWER(b.pre_art_number) like '%" + preArtNumber + "%'";
		} else if (name != null && artNumber != null && preArtNumber == null && uid != null) {
			artNumber = artNumber.toLowerCase();
			uid = uid.toLowerCase();
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + lName + "%') and LOWER(b.art_number) like '%"
					+ artNumber + "%' and LOWER(b.uid) like '%" + uid + "%'";
		} else if (name != null && artNumber == null && preArtNumber != null && uid != null) {
			uid = uid.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + lName + "%')"
					+ " and LOWER(b.pre_art_number) like '%" + preArtNumber + "%'" + "and LOWER(b.uid) like '%" + uid
					+ "%'";
		} else if (name == null && artNumber != null && preArtNumber != null && uid != null) {
			artNumber = artNumber.toLowerCase();
			uid = uid.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			subQuery = "and LOWER(b.art_number) like '%" + artNumber + "%' and LOWER(b.pre_art_number) like '%"
					+ preArtNumber + "%'" + "and LOWER(b.uid) like '%" + uid + "%'";
		} else if (name != null && artNumber != null && preArtNumber != null && uid != null) {
			artNumber = artNumber.toLowerCase();
			uid = uid.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			name = name.toLowerCase();
			subQuery = " and (LOWER(b.first_name) like '%" + fName + "%' or LOWER(b.middle_name) like '%" + mName
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + lName + "%') and LOWER(b.art_number) like '%"
					+ artNumber + "%' and LOWER(b.pre_art_number) like '%" + preArtNumber + "%'"
					+ "and LOWER(b.uid) like '%" + uid + "%'";
		}

		if (subQuery != null) {
			searchQuery = searchQuery + subQuery;
		}
		return searchQuery;
	}
	

}
