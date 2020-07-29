package gov.naco.soch.cst.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.naco.soch.cst.dto.ArtBeneficiaryDueListDto;
import gov.naco.soch.cst.dto.ArtBeneficiarySearchDto;
import gov.naco.soch.cst.dto.TodaysDispensedDto;
import gov.naco.soch.cst.service.ArtBeneficiarySearchService;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.entity.Beneficiary;

public class ArtBeneficiaryDueListMapper {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryDueListMapper.class);

	public static ArtBeneficiaryDueListDto mapArtBeneficiaryDueListDto(ArtBeneficiaryDueList artBeneficiaryDueList) {
		ArtBeneficiaryDueListDto artBeneficiaryDueDto = new ArtBeneficiaryDueListDto();
		Beneficiary beneficiary = artBeneficiaryDueList.getBeneficiary();
		if (beneficiary != null) {
			artBeneficiaryDueDto.setFirstName(Objects.toString(beneficiary.getFirstName(), "") + " "
					+ Objects.toString(beneficiary.getMiddleName(), "") + " "
					+ Objects.toString(beneficiary.getLastName(), ""));
			artBeneficiaryDueDto.setArtNumber(Objects.toString(beneficiary.getArtNumber(), ""));
			artBeneficiaryDueDto.setPreArtNumber(Objects.toString(beneficiary.getPreArtNumber(), ""));
			artBeneficiaryDueDto.setAge(beneficiary.getAge());
			if (beneficiary.getGenderId() != null) {
				artBeneficiaryDueDto.setGender(Objects.toString(beneficiary.getGenderId().getName(), ""));
			}
			artBeneficiaryDueDto.setStatus(Objects.toString(beneficiary.getIsActive(), ""));
			artBeneficiaryDueDto.setUid(beneficiary.getUid());
			artBeneficiaryDueDto.setBeneficiaryId(beneficiary.getId());
		}
		return artBeneficiaryDueDto;
	}

	public static List<ArtBeneficiarySearchDto> mapArtBeneficiarySearchDueListDto(
			List<ArtBeneficiaryDueList> beneficiaryDueList) {
		List<ArtBeneficiarySearchDto> artBeneficiaryDueDtoList = new ArrayList<ArtBeneficiarySearchDto>();
		beneficiaryDueList.forEach(artBeneficiary -> {
			ArtBeneficiarySearchDto artBeneficiarySearchDueDto = new ArtBeneficiarySearchDto();
			artBeneficiarySearchDueDto.setBeneficiaryId(artBeneficiary.getBeneficiary().getId());
			if (artBeneficiary.getBeneficiary() != null) {
				artBeneficiarySearchDueDto.setBeneficiaryId(artBeneficiary.getBeneficiary().getId());
				artBeneficiarySearchDueDto.setAge(artBeneficiary.getBeneficiary().getAge());
				artBeneficiarySearchDueDto.setArtNumber(artBeneficiary.getBeneficiary().getArtNumber());
				artBeneficiarySearchDueDto.setPreArtNumber(artBeneficiary.getBeneficiary().getPreArtNumber());
				artBeneficiarySearchDueDto
						.setFirstName(Objects.toString(artBeneficiary.getBeneficiary().getFirstName(), "") + ""
								+ Objects.toString(artBeneficiary.getBeneficiary().getMiddleName(), "") + " "
								+ Objects.toString(artBeneficiary.getBeneficiary().getLastName(), ""));
				artBeneficiarySearchDueDto
						.setGender(Objects.toString(artBeneficiary.getBeneficiary().getGenderId().getName()));
				artBeneficiarySearchDueDto.setUid(artBeneficiary.getBeneficiary().getUid());

			}
			artBeneficiaryDueDtoList.add(artBeneficiarySearchDueDto);
		});

		return artBeneficiaryDueDtoList;
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
			logger.debug("temp.length " + temp.length);
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
			searchQuery = "select * from soch.art_beneficiary_due_list ad join soch.beneficiary b\r\n"
					+ "on(ad.beneficiary_id=b.id) where ad.facility_id=" + facilityId
					+ " and is_active=true and is_delete=false and ad.is_visited=" + visited + " "
					+ " and ad.expected_visit_date='" + LocalDate.now() + "'\r\n";
		}
		if (visited == true) {
			searchQuery = "select * from soch.art_beneficiary_due_list ad join soch.beneficiary b\r\n"
					+ "on(ad.beneficiary_id=b.id) where ad.facility_id=" + facilityId
					+ " and is_active=true and is_delete=false and ad.is_visited=" + visited + " "
					+ "and ad.expected_visit_date='" + LocalDate.now() + "'\r\n";
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
		} else if (name != null && preArtNumber == null && artNumber == null && uid == null) {
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
					+ "and LOWER(b.uid) like '%" + uid + "%' ";
		}

		if (subQuery != null) {
			searchQuery = searchQuery + subQuery;
		}
		return searchQuery;
	}
}
