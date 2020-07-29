package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.projection.ArtIctcReferredProjection;
import gov.naco.soch.projection.BeneficiaryReferralProjection;
import gov.naco.soch.projection.ReferralProjection;
import gov.naco.soch.projection.StatisticsProjection;

@Repository
public interface BeneficiaryReferralRepository
		extends JpaRepository<BeneficiaryReferral, Long>, JpaSpecificationExecutor<BeneficiaryReferral>,CustomRepository{

	List<BeneficiaryReferralProjection> findByFacility1_FacilityType_IdAndFacility2_Id(long l, Long facilityId);

	@Query(nativeQuery = true, value = "SELECT  to_char(DATE_TRUNC('day',br.refer_date),'dd/MM') AS name, "
			+ " COUNT(br.beneficiary_id) AS value  FROM soch.beneficiary_referral br  "
			+ " WHERE refered_from in(select id from soch.facility where facility_type_id in (15,16,17,18) "
			+ " and  facility_type_id not in (select facility_type_id from soch.facility where id= :facilityId))"
			+ " and refered_to=:facilityId and br.refer_date between now()-((interval '1' day )* :days) and  now() "
			+ " and to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') " + "GROUP BY 1 ORDER BY 1")
	List<StatisticsProjection> getArtTransfersIn(@Param("days") Integer days, @Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT  to_char(DATE_TRUNC('day',br.refer_date),'dd/MM') AS name, "
			+ " COUNT(br.beneficiary_id) AS value  FROM soch.beneficiary_referral br  "
			+ " WHERE refered_to in(select id from soch.facility where facility_type_id in (15,16,17,18) "
			+ " and  facility_type_id not in (select facility_type_id from soch.facility where id= :facilityId))"
			+ " and refered_from=:facilityId and br.refer_date between now()-((interval '1' day )* :days) and  now() "
			+ " and to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') " + "GROUP BY 1 ORDER BY 1")
	List<StatisticsProjection> getArtTransfersOut(@Param("days") Integer days, @Param("facilityId") Long facilityId);

	Optional<BeneficiaryReferral> findByBeneficiary_Id(Long beneficiaryId);

	@Query(nativeQuery = true, value = "SELECT  to_char(DATE_TRUNC('day',br.refer_date),'dd/MM') AS name, "
			+ " COUNT(br.beneficiary_id) AS value  FROM soch.beneficiary_referral br join "
			+ " soch.beneficiary_referral_status_master brs on br.referral_status_id=brs.referral_status_id "
			+ " WHERE refered_from in(select id from soch.facility where facility_type_id in (15,16,17,18) "
			+ " and  facility_type_id not in (select facility_type_id from soch.facility where id= :facilityId))"
			+ " and refered_to=:facilityId and br.refer_date between now()-((interval '1' day )* :days) and  now() "
			+ " and brs.referral_status_id<>2 and to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') "
			+ "GROUP BY 1 ORDER BY 1")
	List<StatisticsProjection> getArtReferredNotLinked(@Param("days") Integer days,
			@Param("facilityId") Long facilityId);

	// query to get facility code
	@Query(nativeQuery = true, value = "select code from soch.facility where id=?1")
	String findFacilityCode(Long userFacilityId);

	// query to list all out-referred beneficiaries
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,br.referred_facility,br.referral_status from soch.beneficiary b join soch.ti_beneficiary_referral br on b.id=br.beneficiary_id where br.referral_status='Referred' or br.referral_status='Pending Linkage' or br.referral_status='Linked'")
	List<ReferralProjection> findAllOutRefferals();

	// query to list all in-referral requests
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,br.referred_facility,\r\n"
			+ "br.referral_status from soch.beneficiary b join soch.ti_beneficiary_referral br on b.id=br.beneficiary_id \r\n"
			+ " where br.referral_facility=?1")
	List<ReferralProjection> findAllInwardRefferals(Long userFacilityId);

	// query to list all transfer-in beneficiaries
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,br.transfer_from,\r\n"
			+ "br.transfer_to,br.tranfer_date,br.transfer_status\r\n"
			+ "from soch.beneficiary b join soch.ti_beneficiary_referral br on b.id=br.beneficiary_id \r\n"
			+ " where br.transfer_to=?1")
	List<ReferralProjection> findAllTransferIns(Long userFacilityId);

	// query to list all transfer-due beneficiaries
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,br.transfer_from,\r\n"
			+ "br.transfer_to,br.tranfer_date,br.transfer_status\r\n"
			+ "from soch.beneficiary b join soch.ti_beneficiary_referral br on b.id=br.beneficiary_id \r\n"
			+ " where br.transfer_status='Due to transfer'")
	List<ReferralProjection> findAllTranferDues();

	// query to list all transferred beneficiaries
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,br.transfer_from,\r\n"
			+ "br.transfer_to,br.tranfer_date,br.transfer_status\r\n"
			+ "from soch.beneficiary b join soch.ti_beneficiary_referral br on b.id=br.beneficiary_id \r\n"
			+ " where br.transfer_status='Transferred'")
	List<ReferralProjection> findAllTranferred();

	Optional<BeneficiaryReferral> findByBeneficiary_IdAndFacility1_Id(Long beneficiaryId, Long referredFromFacility);

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_referral where beneficiary_id =:beneficiaryId and referral_status_id  in (1,2,3)")
	List<BeneficiaryReferral> findByBeneficiaryIdForTimeLine(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_referral where beneficiary_id =:beneficiary and is_delete=:isDelete "
			+ "and refered_from=:facility and referral_status_id=1 limit 1")
	Optional<BeneficiaryReferral> findByBeneficiaryAndIsDelete(@Param("beneficiary") Long beneficiary,
			@Param("facility") Long facility, @Param("isDelete") boolean isDelete);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.first_name as firstname, b.middle_name as middleName, b.last_name as lastname, "
			+ "b.gender_id as genderId, ic.pid as pid, b.category_id as categoryId, b.mobile_number as mobileNumber, itr.hiv_status as hivStatusId,  br.refer_date as referDate, " 
			+ "br.id as referralId, br.refered_from as referredFrom ,  b.age as age, itr.tested_date as testedDate, itr.hiv_type as hivTypeId, " 
			+ "br.date_of_visit as dateOfVisit, br.accepted_date as acceptedDate, b.uid as uid, ic.id as ictcId, b.date_of_birth as dateOfBirth " 
			+ "from soch.beneficiary as b join soch.beneficiary_referral as br on br.beneficiary_id = b.id join soch.ictc_beneficiary as ic on ic.beneficiary_id = b.id join " 
			+ "(select MAX(id) as itrid, ictc_beneficiary_id from soch.ictc_test_result group by ictc_beneficiary_id) as resultTable on (resultTable.ictc_beneficiary_id = ic.id) join "
			+ "soch.ictc_test_result as itr on (resultTable.ictc_beneficiary_id = itr.ictc_beneficiary_id ) and resultTable.itrid = itr.id " 
			+  "where br.refered_to =:facilityId and br.referral_status_id =:referralStatus and br.is_active = true and br.is_delete = false ")
	List<ArtIctcReferredProjection> findIctcreferrals(@Param("facilityId") Long facilityId,@Param("referralStatus") Long referralStatus);

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_referral where beneficiary_id = :beneficiaryId and refered_to = :facilityId and referral_status_id in (1,2) limit 1")
	BeneficiaryReferral findByInwardReferral(@Param(value = "beneficiaryId") Long beneficiaryId,@Param(value = "facilityId") Long facilityId);
		
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstname, b.middle_name as middleName, b.age as age, "
			+ " b.last_name as lastname, b.mobile_number as mobileNumber, itr.hiv_status as hivStatusId, itr.hiv_type as hivTypeId, b.date_of_birth as dateOfBirth, b.category_id as categoryId, b.gender_id as genderId, "
			+ " ic.pid as pid, br.refered_from as referredFrom , br.refer_date as referDate, br.date_of_visit as dateOfVisit, br.accepted_date as acceptedDate, "
			+ " br.id as referralId, ic.id as ictcId, itr.tested_date as testedDate from soch.beneficiary as b join soch.beneficiary_referral as br on "
			+ " br.beneficiary_id = b.id join soch.ictc_beneficiary as ic on ic.beneficiary_id = b.id join soch.facility as f on f.id = br.refered_to join "
			+ " (select MAX(id) as itrid, ictc_beneficiary_id from soch.ictc_test_result group by ictc_beneficiary_id) as resultTable on (resultTable.ictc_beneficiary_id = ic.id) join "
			+ " soch.ictc_test_result as itr on (resultTable.ictc_beneficiary_id = itr.ictc_beneficiary_id ) and resultTable.itrid = itr.id " 
			+ " where br.referral_status_id =:referralStatus and f.facility_type_id =:facilityType and br.is_active = true and br.is_delete = false "
			+ " and (lower(b.first_name) like %:searchText% or lower(b.middle_name) like %:searchText% "  
			+ " or lower(b.last_name) like %:searchText%  or lower(b.mobile_number) like %:searchText% or lower(b.uid) like %:searchText% or lower(ic.pid) like %:searchText% )")
		List<ArtIctcReferredProjection> findIctcreferralsBySearch(@Param("searchText") String searchText,@Param("referralStatus") Long referralStatus,@Param("facilityType") Long facilityType);

	List<BeneficiaryReferral> findAllByBeneficiary_Id(Long partnerBeneficiaryId);
       
	@Query(nativeQuery=true,value="select count(br.id) from soch.beneficiary_referral br join soch.typology_facility_mapping tfm on br.refered_to=tfm.facility_id"
		           + " where refered_to=:referredToFacility and tfm.typology_id = 4")
        Long checkIduTypology(@Param("referredToFacility")Long referredToFacility);

}
