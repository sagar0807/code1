package gov.naco.soch.cst.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArtIctcReferralMapperUtil {

	public static List<String> queryCreaterForAdvanceSearch(Map<String, String> searchValue, Long referralStatus,Long facilityType) {

		String firstName = searchValue.get("firstname");
		String lastName = searchValue.get("lastname");
		String middleName = searchValue.get("middlename");
		String patientPid = searchValue.get("patientpid");
		String mobileNumber = searchValue.get("mobilenumber");
		String genderId = searchValue.get("genderId");
		String categoryId = searchValue.get("categoryId");
		String uId = searchValue.get("uid");

		List<String> searchQueryList = new ArrayList<>();

		String searchQuery = "select b.id, b.first_name, b.middle_name, b.age, "
				+ " b.last_name, b.mobile_number, itr.hiv_status, b.category_id, b.gender_id, "
				+ " ic.pid, br.refered_from, br.refer_date, br.date_of_visit, br.accepted_date, "
				+ " br.id as referralId, b.uid, ic.id as ictcId, itr.hiv_type, b.date_of_birth, cast(itr.tested_date as date) from soch.beneficiary b join soch.beneficiary_referral br on "
				+ " br.beneficiary_id = b.id join soch.ictc_beneficiary ic on ic.beneficiary_id = b.id join soch.facility as f on f.id = br.refered_to join "
				+ " (select MAX(id) as itrid, ictc_beneficiary_id from soch.ictc_test_result group by ictc_beneficiary_id) as resultTable on (resultTable.ictc_beneficiary_id = ic.id) join " 
				+ " soch.ictc_test_result as itr on (resultTable.ictc_beneficiary_id = itr.ictc_beneficiary_id ) and resultTable.itrid = itr.id where ";

		if (firstName != null && firstName != " ") {
			firstName = firstName.toLowerCase();
			searchQuery = searchQuery.concat("lower(b.first_name) like '%" + firstName + "%' and ");
		}
		if (lastName != null && lastName != " ") {
			lastName = lastName.toLowerCase();
			searchQuery = searchQuery.concat("lower(b.last_name) like '%" + lastName + "%' and ");
		}
		if (middleName != null && middleName != " ") {
			middleName = middleName.toLowerCase();
			searchQuery = searchQuery.concat("lower(b.middle_name) like '%" + middleName + "%' and ");
		}
		if (mobileNumber != null && mobileNumber != " ") {
			searchQuery = searchQuery.concat("lower(b.mobile_number) like '%" + mobileNumber + "%' and ");
		}
		if (uId != null && uId != " ") {
			uId = uId.toLowerCase();
			searchQuery = searchQuery.concat("lower(b.uid) like '%" + uId + "%' and ");
		}
		if (genderId != null && genderId != " ") {
			Long gender = Long.valueOf(genderId);
			searchQuery = searchQuery.concat("b.gender_id = " + gender + " and ");
		}
		if (categoryId != null && categoryId != " ") {
			Long category = Long.valueOf(categoryId);
			searchQuery = searchQuery.concat("b.category_id = " + category + " and ");
		}

		if (patientPid != null && patientPid != " ") {
			patientPid = patientPid.toLowerCase();
			searchQuery = searchQuery.concat("lower(ic.pid) like '%" + patientPid + "%' and ");
		}

		searchQuery = searchQuery.concat(" br.is_active = true and br.is_delete = false and "
				+ " br.referral_status_id = " + referralStatus + " and f.facility_type_id = " + facilityType );

		searchQueryList.add(searchQuery);

		return searchQueryList;
	}

}
