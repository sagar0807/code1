package gov.naco.soch.cst.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinkedFacilityBeneficiaryMapperUtil {

	public static List<String> queryCreaterForAdvanceSearch(Map<String, String> searchValue, Long facilityId,
			Long facilityTypeId) {
		String firstName = searchValue.get("firstName");
		String lacname = searchValue.get("lacName");
		String contactNumber = searchValue.get("contactNumber");
		String preArtNumber = searchValue.get("preArtNumber");
		String artNumber = searchValue.get("artNumber");
		
		List<String> searchQueryList = new ArrayList<>();
		
		if(facilityId != null) {
			String searchQuery = "select * from soch.facility_linked_facility_beneficiary as fb join soch.beneficiary as b on b.id = fb.beneficiary_id " 
					  +"join soch.facility as fl on fl.id=fb.linked_facility_id where " ;
			
			if(firstName != null && firstName != " ") {
				searchQuery = searchQuery.concat("lower(b.first_name) like '%" + firstName + "%' and ");
			}
	
			if(contactNumber != null && contactNumber != " ") {
				searchQuery = searchQuery.concat("lower(b.mobile_number) like '%" + contactNumber + "%' and ");
			}
			if(lacname != null && lacname != " ") {
				/* Long gender = Long.valueOf(genderId); */
				searchQuery = searchQuery.concat("lower(fl.name) like '%" + lacname + "%' and " );
			}
			if(preArtNumber != null && preArtNumber != " ") {
				//Long category = Long.valueOf(categoryId);
				searchQuery = searchQuery.concat("lower(b.pre_art_number) like '%" + preArtNumber + "%' and " );
			}
			if(artNumber != null && artNumber != " ") {
				searchQuery = searchQuery.concat("lower(b.art_number) like '%" + artNumber + "%' and ");
			}
			
			searchQuery = searchQuery.concat(" fb.is_active = true and fb.is_delete = false and fb.parent_facility_id = " + facilityId + " and "
					+ " fb.facility_type = " + facilityTypeId + " ");
			
			searchQueryList.add(searchQuery);
		}
		return searchQueryList;
	}

	public static List<String> queryCreaterForBenListAdvanceSearch(Map<String, String> searchValue, Long facilityId) {
		String firstName = searchValue.get("firstName");
		String preArtNumber = searchValue.get("preArtNumber");
		String artNumber = searchValue.get("artNumber");
		String gender = searchValue.get("gender");
		String age = searchValue.get("age");
		String status = searchValue.get("status");
		
		List<String> searchQueryList = new ArrayList<>();
		
		if(facilityId != null) {
			String searchQuery = "select * from soch.facility_linked_facility_beneficiary as fb join soch.beneficiary as b on b.id = fb.beneficiary_id " 
					  +"join soch.master_gender as mg on mg.id=b.gender_id join soch.facility as fl on fl.id=fb.linked_facility_id join soch.art_beneficiary as ab on ab.beneficiary_id=b.id "
					  + "join soch.master_art_beneficiary_status as bs on bs.id=ab.art_beneficiary_status_id where " ;
			
			if(firstName != null && firstName != " ") {
				searchQuery = searchQuery.concat("lower(b.first_name) like '%" + firstName.toLowerCase() + "%' and ");
			}
			if(preArtNumber != null && preArtNumber != " ") {
				searchQuery = searchQuery.concat("lower(b.pre_art_number) like '%" + preArtNumber.toLowerCase() + "%' and " );
			}
			if(artNumber != null && artNumber != " ") {
				searchQuery = searchQuery.concat("lower(b.art_number) like '%" + artNumber.toLowerCase() + "%' and " );
			}
			if(gender != null && gender != " ") {
				searchQuery = searchQuery.concat("lower(mg.name) like '%" + gender.toLowerCase()+ "%' and " );
			}
			if(age != null && age != " ") {
				searchQuery = searchQuery.concat("lower(b.age) like '%" + age.toLowerCase() + "%' and ");
			}
			if(status != null && status != " ") {
				searchQuery = searchQuery.concat("lower(bs.name) like '%" + status.toLowerCase() + "%' and ");
			}
			
			
			searchQuery = searchQuery.concat(" fb.is_active = true and fb.is_delete = false and is_linked = true and fb.linked_facility_id = " + facilityId + " ");
			
			searchQueryList.add(searchQuery);
		}
		return searchQueryList;
	}
	
	

}
