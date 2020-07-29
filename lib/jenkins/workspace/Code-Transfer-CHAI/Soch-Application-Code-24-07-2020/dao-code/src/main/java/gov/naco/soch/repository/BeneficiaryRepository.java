package gov.naco.soch.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constructordto.SummaryDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.ArtBeneficiaryRegistrationProjection;
import gov.naco.soch.projection.ArtFollowupListProjection;
import gov.naco.soch.projection.ArtTransitBeneficiaryProjection;
import gov.naco.soch.projection.BeneficiaryBasicProjection;
import gov.naco.soch.projection.FacilityTargetProjection;
import gov.naco.soch.projection.InventoryProjection;
import gov.naco.soch.projection.MasterLineProjection;
import gov.naco.soch.projection.StatisticsProjection;

//Repository mapped with entity class
@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>, JpaSpecificationExecutor<Beneficiary> {

	// Query to search beneficiary with UID or mobile number
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,b.beneficiary_activity_status,"
			+ "br.hrg_primary_category,br.hrg_secondary_category,b.age,b.gender,br.client_status,br.beneficiary_id,b.ti_code from soch.beneficiary b"
			+ " join soch.beneficiary_registration br on b.id=br.beneficiary_id where b.is_delete=false and (b.mobile_number=?1 or UPPER(b.uid)=UPPER(?1) or UPPER(b.first_name)=UPPER(?1))")
	List<Object[]> findBySearchValue(String searchValue);

	// QueryTo Get specific records for Beneficiary - Facility ID:
	@Query(nativeQuery = true, value = "select f.name as MllCenName,a.address AS MllAddr,a.city as MllCity,s.name AS MllState ,d.name AS MllDist,a.pincode as MllPin,b.uid as MllUid,tib.ost_code as MllRegNum,(b.first_name || ' ' || b.last_name) AS MllPatientName,tib.date_of_reg as MllRegDate, b.gender as MllPatGender,b.age as MllPatAge,b.mobile_number as MllPatMobile,\r\n"
			+ "	tib.beneficiary_activity_status as MllCurrStatus,od.current_dose as MllCurrDosage\r\n"
			+ "	from  soch.beneficiary b join soch.ti_beneficiary tib on b.id = tib.beneficiary_id\r\n"
			+ "	join soch.facility f on f.id = tib.facility_id  join soch.address a on f.address_id = a.id\r\n"
			+ "	 join soch.district d on a.district_id = d.id  join soch.state s on a.state_id = s.id \r\n"
			+ "	 left join soch.ti_ost_details od on od.beneficiary_id = b.id AND od.dispensed_last_date = (Select Max(dispensed_last_date) \r\n"
			+ "								                             FROM soch.ti_ost_details\r\n"
			+ "															WHERE beneficiary_id = b.id) where f.id = ?1")
	List<MasterLineProjection> findBeneficiariesByFacility(long facilityId);

	@Query(nativeQuery = true, value = "select b.id,uid,first_name as firstName ,last_name as lastName ,age,mg.name as gender ,reg_date as regDate from beneficiary b inner join master_gender mg on  mg.id = b.gender_id where b.id = :beneficiaryId")
	BeneficiaryBasicProjection getBasicBeneficiaryDetails(@Param("beneficiaryId") Long beneficiaryId);


	// Query to search beneficiary details by UID, mobile number,
	// firstName, LastName, HIVStatus, referralStatus, referralFacility
	@Query(nativeQuery = true, value = "select b.id,b.uid,b.first_name,b.middle_name,b.last_name,b.mobile_number,b.beneficiary_activity_status,br.referral_facility,br.referral_status,br.hiv_status from soch.beneficiary b join soch.ti_beneficiary_referral br "
			+ "on b.id=br.beneficiary_id where b.mobile_number=?1 or UPPER(b.uid)=UPPER(?1) or UPPER(b.first_name)=UPPER(?1) or UPPER(br.referral_facility)=UPPER(?1) or UPPER(br.referral_status)=UPPER(?1) or UPPER(br.hiv_status)=UPPER(?1)")
	List<Object[]> findBySearchValueReferral(String searchValue);

	// query to list all beneficiaries if isDelete = false
	@Query(nativeQuery = true, value = "select * from soch.beneficiary b join soch.beneficiary_facility_mapping bfm on b.id=bfm.beneficiary_id  where b.is_delete=false and bfm.facility_id=?1 order by b.id desc")
	List<Beneficiary> findAll(Long facilityId);

	List<Beneficiary> findAllByIsDelete(boolean isDelete);

	@Query(nativeQuery = true, value = "select registrations,plhivs,active_plhivs,active_hrgs,mtarget from soch.SUMMARYDATA(:facilityId)")
	Object getSummaryData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select registrations,plhivs,active_plhivs,active_ost,total_ost from soch.SUMMARYDATAOST(:facilityId)")
	Object getSummaryOstData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(tib.id) AS value FROM soch.ti_beneficiary tib"
			+ " JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id"
			+ " WHERE tib.facility_id=:facilityId and tib.is_active = true and tib.is_deleted  = false and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(tcb.beneficiary_id) AS value FROM soch.ti_ben_scr_details tsd join soch.ti_core_beneficiary tcb on tcb.beneficiary_id="
			+ " tsd.beneficiary_id "
			+ " WHERE tcb.facility_id=:facilityId  and lower(screening_status_hiv)='positive' and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivReactiveCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name, "
			+ " COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br join soch.art_beneficiary_details ab on ab.beneficiary_id=br.beneficiary_id "
			+ " WHERE refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ " and   refered_from =:facilityId "
			+ " and   to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getMonthwiseBeneficiaryReferralsCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',isc.tested_date),'MONTH') AS name, "
			+ " COUNT(isc.beneficiary_id) AS value " + " FROM soch.ictc_sample_collection isc "
			+ " WHERE lower(isc.hiv_status)='tested' and  to_char(isc.tested_date,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivTestsCount();

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name , "
			+ " COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br "
			+ " WHERE NOT EXISTS(SELECT FROM soch.art_beneficiary_details where beneficiary_id=br.beneficiary_id) "
			+ " and refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ " and refered_from=:facilityId" + " and   to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getArtReferredButNotLinkedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT  TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name, "
			+ "  COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br "
			+ "  join soch.art_beneficiary_details  abd on br.beneficiary_id=abd.beneficiary_id "
			+ "  WHERE  refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ "  and    refered_from=:facilityId and lower(patient_art_status)=:status "
			+ "  and  to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY')" + "  GROUP BY 1")
	List<StatisticsProjection> getArtRefferedLinkedBasedOnStatusCount(@Param("facilityId") Long facilityId,
			@Param("status") String status);

	default SummaryDto getSummaryDashboardDetails(Long facilityId) {

		Object object = getSummaryData(facilityId);
		SummaryDto summaryDto = new SummaryDto();
		if (object instanceof Object[]) {
			Object[] values = (Object[]) object;
			summaryDto.setRegistrations((BigInteger) values[0]);
			summaryDto.setPlhivs((BigInteger) values[1]);
			summaryDto.setActivePlhivs((BigInteger) values[2]);
			summaryDto.setActive_hrgs((BigInteger) values[3]);
			summaryDto.setMonthly_active_target((BigInteger) values[4]);
		}
		return summaryDto;

	}

	default SummaryDto getSummaryOstDashboardDetails(Long facilityId) {
		Object object = getSummaryOstData(facilityId);
		SummaryDto summaryDto = new SummaryDto();
		if (object instanceof Object[]) {
			Object[] values = (Object[]) object;
			summaryDto.setRegistrations((BigInteger) values[0]);
			summaryDto.setPlhivs((BigInteger) values[1]);
			summaryDto.setActivePlhivs((BigInteger) values[2]);
			summaryDto.setActiveOstClients((BigInteger) values[3]);
			summaryDto.setTotalOstClients((BigInteger) values[4]);
		}
		return summaryDto;

	}

	// monthly target from ti_beneficiary as it is present only in this table
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tib.date_of_reg),'MONTH') AS name, "
			+ " fac.monthly_active_target AS value FROM soch.ti_beneficiary tib"
			+ " join soch.facility fac on fac.id = tib.facility_id"
			+ " where tib.facility_id=:facilityId and to_char(tib.date_of_reg,'YYYY')=to_char(now(),'YYYY')")
	List<StatisticsProjection> getMonthwiseMonthlyTarget(@Param("facilityId") Long facilityId);

	// icr.hiv_status =2 , means hiv positive
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tcb.facility_id=:facilityId and mit.id =1 " + " and sti.screening_status_hiv_id IS NOT NULL "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') " + " GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivTested(@Param("facilityId") Long facilityId);

	// screening_status_hiv =reactive
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, \r\n"
			+ "			 COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id \r\n"
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id \r\n"
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id \r\n"
			+ "		 	WHERE tcb.facility_id= :facilityId and mit.id =1  and mhss.id=1\r\n"
			+ "			 and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivReactive(@Param("facilityId") Long facilityId);

	// Beneficairy linked - HIV
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, \r\n"
			+ "			 COUNT(distinct sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id \r\n"
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id \r\n"
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id inner join beneficiary_referral br \r\n"
			+ "			 on br.beneficiary_id  = bn.id \r\n"
			+ "			 inner join master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "			 inner join facility f on br.refered_to  = f.id \r\n"
			+ "		 	WHERE tcb.facility_id=:facilityId and mit.id =1  and mhss.id=1 and mrs.id = 3 and f.facility_type_id  = 11\r\n"
			+ "		 	and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivLinked(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name,\r\n"
			+ "		 COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id \r\n"
			+ "		 inner join master_client_status msc on msc.id = bn.client_status_id \r\n"
			+ "	 WHERE tib.facility_id= :facilityId and msc.id = 1  and tib.is_deleted = false and tib.is_active =true and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseActiveCount(@Param("facilityId") Long facilityId);

	// Used = Distributed - Returned , but condoms returned is not present
	// is tbcd.created_time is correct ?
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbcd.created_time),'MONTH') AS name, "
			+ " coalesce (sum(tbcd.condoms_distributed),0) as value from soch.ti_beneficiary_comm_dis tbcd "
			+ " where tbcd.facility_id =:facilityId and to_char(tbcd.created_time,'YYYY')=to_char(now(),'YYYY') group by 1")
	List<StatisticsProjection> getMonthWiseCondomsUsed(@Param("facilityId") Long facilityId);

	// is tbcd.created_time is correct ?
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbcd.created_time),'MONTH') AS name, "
			+ " coalesce (sum(tbcd.needles_distributed),0)- coalesce (sum(tbcd.syringes_needles_returned),0) as value "
			+ " from soch.ti_beneficiary_comm_dis tbcd where tbcd.facility_id =:facilityId "
			+ " and to_char(tbcd.created_time,'YYYY')=to_char(now(),'YYYY') group by 1 ")
	List<StatisticsProjection> getMonthWiseNeedlesUsed(@Param("facilityId") Long facilityId);

	// is tbcd.created_time is correct ?
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbcd.created_time),'MONTH') AS name, \r\n"
			+ "			 coalesce (sum(tbcd.condoms_distributed),0) as value \r\n"
			+ "			 from soch.ti_beneficiary_comm_dis tbcd inner join ti_beneficiary tb on tb.id = tbcd.beneficiary_id  \r\n"
			+ "			 where tbcd.facility_id =:facilityId and tb.is_active =true and tb.is_deleted =false\r\n"
			+ "			 and to_char(tbcd.created_time,'YYYY')=to_char(now(),'YYYY') group by 1")
	List<StatisticsProjection> getMonthWiseCondomsDistributed(@Param("facilityId") Long facilityId);

	// is tbcd.created_time is correct ?
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',tbcd.created_time),'MONTH') AS name, \r\n"
			+ "		 coalesce (sum(tbcd.needles_distributed),0) as value \r\n"
			+ "			 from soch.ti_beneficiary_comm_dis tbcd inner join ti_beneficiary tb on tb.id = tbcd.beneficiary_id  where tbcd.facility_id =:facilityId \r\n"
			+ "			 and tb.is_active =true and tb.is_deleted =false\r\n"
			+ "			 and to_char(tbcd.created_time,'YYYY')=to_char(now(),'YYYY') group by 1")
	List<StatisticsProjection> getMonthWiseNeedlesDistributed(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name,\r\n"
			+ "		 COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id \r\n"
			+ "	   inner join master_client_status msc on msc.id = bn.client_status_id \r\n"
			+ "		 WHERE tib.facility_id=:facilityId and  msc.id =5 and  tib.is_active = true and tib.is_deleted  = false  and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDropoutCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, \r\n"
			+ "		COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "		 JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id\r\n"
			+ "		 JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id\r\n"
			+ "		JOIN soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "		WHERE tib.facility_id=:facilityId and sti.screening_status_syphilis_id IS NOT NULL \r\n"
			+ "		 AND mit.id = 2 and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY') and tib.is_active = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseTestingCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.follow_up_date),'MONTH') AS name, \r\n"
			+ "		 COUNT(sti.beneficiary_id) AS value FROM soch.ti_sti_treatment sti\r\n"
			+ "			 JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id\r\n"
			+ "			 JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id\r\n"
			+ "			WHERE tib.facility_id=:facilityId and sti.master_diagnosis_type_id IS NOT NULL  \r\n"
			+ "			and (to_char(sti.follow_up_date,'YYYY')=to_char(now(),'YYYY') ) and tib.is_active  = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDetectedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id"
			+ " JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id"
			+ " join soch.master_syphilis_status mss on mss.id = sti.screening_status_syphilis_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tib.facility_id=:facilityId and lower(mss.name) = 'reactive' "
			+ " and lower(mit.name)='syphilis' "
			+ " and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseSyphilisReactiveCount(@Param("facilityId") Long facilityId);

	// this month
	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc inner join ti_beneficiary tb  \r\n"
			+ "		on tbc.beneficiary_id  = tb.id \r\n"
			+ "		where to_char(counselling_date,'MM')=to_char(now(),'MM') \r\n"
			+ "		and tb.facility_id= :facilityId and  tbc.counselling_date is not null and tb.is_active  = true and tb.is_deleted  = false")
	List<StatisticsProjection> getHRGSCounselled(@Param("facilityId") Long facilityId);

	// current month
	@Query(nativeQuery = true, value = "select count( distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd inner join ti_beneficiary tb on tb.id = bcd.beneficiary_id\r\n"
			+ "				inner join master_contact_type mct on bcd.master_contact_type_id  = mct.id and tb.facility_id =:facilityId\r\n"
			+ "			and to_char(bcd.created_time,'MM')=to_char(now(),'MM') and tb.is_active  = true and tb.is_deleted  = false")
	List<StatisticsProjection> getTotalContact(@Param("facilityId") Long facilityId);

	// current month
	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd inner join ti_beneficiary tb on tb.id = bcd.beneficiary_id\r\n"
			+ "		inner join master_contact_type mct	on bcd.master_contact_type_id  = mct.id where mct.id = 1 and tb.facility_id =:facilityId and to_char(bcd.created_time,'MM')=to_char(now(),'MM')\r\n"
			+ "		and tb.is_active =true and tb.is_deleted = false")
	List<StatisticsProjection> getOneToOneContact(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (sum(tbra.condom_requirement_per_week),0) as value ,\r\n"
			+ "			 to_char(tbra.assessment_date,'month') as name from soch.ti_ben_rv_assessment tbra inner join ti_beneficiary tb on tb.id = tbra.beneficiary_id \r\n"
			+ "			 where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') group by 2 ")
	List<StatisticsProjection> getMonthwiseCondomDemand(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (sum(tbra.needles_syringes_requirement_per_week),0) as value ,\r\n"
			+ "			to_char(tbra.assessment_date,'month') as name from soch.ti_ben_rv_assessment tbra inner join ti_beneficiary tb on tb.id = tbra.beneficiary_id\r\n"
			+ "			 where tb.facility_id =:facilityId and tb.is_active and tb.is_deleted  = false and to_char(tbra.assessment_date,'YYYY')=to_char(now(),'YYYY') group by 2 ")
	List<StatisticsProjection> getMonthwiseNeedlesDemand(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (date_part ('year' ,  created_time),0) as year,coalesce (date_part ('month' ,  created_time),0) as month,coalesce (date_part ('year' ,  valid_till),0) as endYear,\r\n"
			+ "                    coalesce (date_part ('month' ,  valid_till ),0) as endMonth,coalesce (monthly_active_target,0) as targets from soch.facility where id=:facilityId")
	FacilityTargetProjection getMonthlyActiveTargetByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (date_part ('year' ,  f.created_time),0) as year,coalesce (date_part ('month' ,  f.created_time),0) as month,coalesce (date_part ('year' ,  valid_till),0) as endYear,coalesce (date_part ('month' ,  valid_till ),0) as endMonth,\r\n"
			+ "                   coalesce (SUM(tfm.typology_target),0) as targets from typology_facility_mapping tfm inner join facility f on f.id = tfm.facility_id \r\n"
			+ "where f.id = :facilityId and tfm.typology_id  IN :typology group by f.created_time,f.valid_till")
	FacilityTargetProjection getMonthlyActiveTargetByFacilityIdAndTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select monthly_syphilis_target from soch.facility where id =:facilityId")
	Integer getMonthlySyphilisTargetByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name,"
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id "
			+ "      inner join master_client_status msc on msc.id = bn.client_status_id "
			+ "      WHERE tib.facility_id= :facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and bn.client_status_id=1 and msc.id = 1  and tib.is_deleted = false and tib.is_active =true and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseActiveCountByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name,"
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id "
			+ "      inner join master_client_status msc on msc.id = bn.client_status_id "
			+ "      WHERE tib.facility_id= :facilityId and bn.gender_id IN :gender and bn.client_status_id=1 and msc.id = 1  and tib.is_deleted = false and tib.is_active =true and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseActiveCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name,"
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id "
			+ "      inner join master_client_status msc on msc.id = bn.client_status_id "
			+ "      WHERE tib.facility_id= :facilityId and tib.master_hrg_primary_id IN :typology and bn.client_status_id=1 and msc.id = 1  and tib.is_deleted = false and tib.is_active =true and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseActiveCountByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(tib.id) AS value FROM soch.ti_beneficiary tib"
			+ " JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id"
			+ " WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and tib.is_active = true and tib.is_deleted  = false and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCountByGenderAndTopology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(tib.id) AS value FROM soch.ti_beneficiary tib"
			+ " JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id"
			+ " WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender  and tib.is_active = true and tib.is_deleted  = false and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(tib.id) AS value FROM soch.ti_beneficiary tib"
			+ " JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id"
			+ " WHERE tib.facility_id=:facilityId and tib.master_hrg_primary_id IN :typology and tib.is_active = true and tib.is_deleted  = false and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCountByTopology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name,\r\n"
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id \r\n"
			+ "     inner join master_client_status msc on msc.id = bn.client_status_id \r\n"
			+ "     WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and  msc.id =5 and  tib.is_active = true and tib.is_deleted  = false  and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDropoutCountByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name,\r\n"
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id \r\n"
			+ "     inner join master_client_status msc on msc.id = bn.client_status_id \r\n"
			+ "     WHERE tib.facility_id=:facilityId and tib.master_hrg_primary_id IN :typology and  msc.id =5 and  tib.is_active = true and tib.is_deleted  = false  and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDropoutCountByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name,\r\n"
			+ "     COUNT(tib.id) AS value FROM soch.ti_beneficiary tib JOIN soch.beneficiary bn ON bn.id = tib.beneficiary_id \r\n"
			+ "     inner join master_client_status msc on msc.id = bn.client_status_id \r\n"
			+ "     WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and  msc.id =5 and  tib.is_active = true and tib.is_deleted  = false  and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDropoutCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = " select b.id as beneficiaryId, b.uid as beneficiaryUId, "
			+ "b.first_name as firstname, b.middle_name as middlename, b.last_name as lastname, "
			+ "b.gender_id as gender, b.pre_art_number as preArtNumber, "
			+ "b.art_number as artNumber  from soch.beneficiary as b "
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id= b.id "
			+ " join soch.beneficiary_transit_facility as btf on btf.beneficiary_id=b.id "
			+ " where ab.is_active=true and ab.is_delete=false and ab.facility_id =:facilityId "
			+ " and ab.is_transit = true and current_timestamp BETWEEN SYMMETRIC ab.transit_start_date AND ab.transit_end_date and btf.facility_id=:currentUserFacilityId "
			+ " and (lower(b.first_name) like %:searchText% or lower(b.middle_name) like %:searchText% "
			+ " or lower(b.last_name) like %:searchText%  or lower(b.art_number) like %:searchText% or lower(b.pre_art_number) like %:searchText% ); ")
	List<ArtTransitBeneficiaryProjection> findByFacilityIdAndSearchText(@Param("facilityId") Long facilityId,
			@Param("searchText") String searchText, @Param("currentUserFacilityId") Long currentUserFacilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, \r\n"
			+ "        COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "        JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id\r\n"
			+ "        JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id\r\n"
			+ "        JOIN soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "        WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and sti.screening_status_syphilis_id IS NOT NULL \r\n"
			+ "        AND mit.id = 2 and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY') and tib.is_active = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseTreatedCountByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, \r\n"
			+ "        COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "        JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id\r\n"
			+ "        JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id\r\n"
			+ "        JOIN soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "        WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and sti.screening_status_syphilis_id IS NOT NULL \r\n"
			+ "        AND mit.id = 2 and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY') and tib.is_active = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseTreatedCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, \r\n"
			+ "        COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "        JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id\r\n"
			+ "        JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id\r\n"
			+ "        JOIN soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "        WHERE tib.facility_id=:facilityId  and tib.master_hrg_primary_id IN :typology and sti.screening_status_syphilis_id IS NOT NULL \r\n"
			+ "        AND mit.id = 2 and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY') and tib.is_active = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseTreatedCountByTopology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.follow_up_date),'MONTH') AS name, \r\n"
			+ "         COUNT(sti.beneficiary_id) AS value FROM soch.ti_sti_treatment sti\r\n"
			+ "         JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id\r\n"
			+ "         JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id\r\n"
			+ "         WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and sti.master_diagnosis_type_id IS NOT NULL  \r\n"
			+ "         and (to_char(sti.follow_up_date,'YYYY')=to_char(now(),'YYYY') ) and tib.is_active  = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDetectedCountByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.follow_up_date),'MONTH') AS name, \r\n"
			+ "         COUNT(sti.beneficiary_id) AS value FROM soch.ti_sti_treatment sti\r\n"
			+ "         JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id\r\n"
			+ "         JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id\r\n"
			+ "         WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and sti.master_diagnosis_type_id IS NOT NULL  \r\n"
			+ "         and (to_char(sti.follow_up_date,'YYYY')=to_char(now(),'YYYY') ) and tib.is_active  = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDetectedCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.follow_up_date),'MONTH') AS name, \r\n"
			+ "         COUNT(sti.beneficiary_id) AS value FROM soch.ti_sti_treatment sti\r\n"
			+ "         JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id\r\n"
			+ "         JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id\r\n"
			+ "         WHERE tib.facility_id=:facilityId and tib.master_hrg_primary_id IN :typology and sti.master_diagnosis_type_id IS NOT NULL  \r\n"
			+ "         and (to_char(sti.follow_up_date,'YYYY')=to_char(now(),'YYYY') ) and tib.is_active  = true and tib.is_deleted  = false GROUP BY 1")
	List<StatisticsProjection> getMonthwiseDetectedCountByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id"
			+ " JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id"
			+ " join soch.master_syphilis_status mss on mss.id = sti.screening_status_syphilis_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and tib.master_hrg_primary_id IN :typology and lower(mss.name) = 'reactive' "
			+ " and lower(mit.name)='syphilis' "
			+ " and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseSyphilisReactiveCountByGenderAndTypology(
			@Param("facilityId") Long facilityId, @Param("gender") List<Integer> gender,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id"
			+ " JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id"
			+ " join soch.master_syphilis_status mss on mss.id = sti.screening_status_syphilis_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tib.facility_id=:facilityId and bn.gender_id IN :gender and lower(mss.name) = 'reactive' "
			+ " and lower(mit.name)='syphilis' "
			+ " and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseSyphilisReactiveCountByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " JOIN soch.ti_beneficiary tib ON sti.beneficiary_id = tib.id"
			+ " JOIN soch.beneficiary bn ON tib.beneficiary_id = bn.id"
			+ " join soch.master_syphilis_status mss on mss.id = sti.screening_status_syphilis_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " WHERE tib.facility_id=:facilityId  and tib.master_hrg_primary_id IN :typology and lower(mss.name) = 'reactive' "
			+ " and lower(mit.name)='syphilis' "
			+ " and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseSyphilisReactiveCountByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc  "
			+ " inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " where to_char(counselling_date,'MM')=to_char(now(),'MM') "
			+ " and tb.facility_id= :facilityId and  tbc.counselling_date is not null "
			+ " and tb.is_active  = true and tb.is_deleted  = false "
			+ " and tb.master_hrg_primary_id IN :typology and b.gender_id IN :gender ")
	List<StatisticsProjection> getHRGSCounselledByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc "
			+ " inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " where to_char(counselling_date,'MM')=to_char(now(),'MM') and tb.facility_id=:facilityId "
			+ " and  tbc.counselling_date is not null" + " and tb.is_active  = true and tb.is_deleted  = false "
			+ " and b.gender_id IN :gender ")
	List<StatisticsProjection> getHRGSCounselledByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_ben_counselling tbc "
			+ " inner join soch.ti_beneficiary tb on tbc.beneficiary_id  = tb.id "
			+ " where to_char(counselling_date,'MM')=to_char(now(),'MM') "
			+ " and tb.facility_id= :facilityId and  tbc.counselling_date is not null "
			+ " and tb.is_active  = true and tb.is_deleted  = false " + " and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getHRGSCounselledByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count( distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " and tb.facility_id =:facilityId and to_char(bcd.created_time,'MM')=to_char(now(),'MM')"
			+ " and tb.is_active  = true and tb.is_deleted  = false"
			+ " and tb.master_hrg_primary_id IN :typology and b.gender_id IN :gender ")
	List<StatisticsProjection> getTotalContactByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count( distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " and tb.facility_id =:facilityId and to_char(bcd.created_time,'MM')=to_char(now(),'MM') "
			+ " and tb.is_active  = true and tb.is_deleted  = false and b.gender_id IN :gender ")
	List<StatisticsProjection> getTotalContactByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select count( distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd  "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct on bcd.master_contact_type_id  = mct.id  "
			+ " and tb.facility_id = :facilityId and to_char(bcd.created_time,'MM')=to_char(now(),'MM') "
			+ " and tb.is_active  = true and tb.is_deleted  = false and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getTotalContactByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd  "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct	on bcd.master_contact_type_id  = mct.id"
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id"
			+ " where mct.id = 1 and tb.facility_id =:facilityId "
			+ " and to_char(bcd.created_time,'MM')=to_char(now(),'MM') and tb.is_active =true and tb.is_deleted = false"
			+ " and tb.master_hrg_primary_id IN :typology " + " and b.gender_id IN :gender ")
	List<StatisticsProjection> getOneToOneContactByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct	on bcd.master_contact_type_id  = mct.id "
			+ " inner join soch.beneficiary b on b.id = tb.beneficiary_id "
			+ " where mct.id = 1 and tb.facility_id = :facilityId "
			+ " and to_char(bcd.created_time,'MM')=to_char(now(),'MM') "
			+ " and tb.is_active =true and tb.is_deleted = false and b.gender_id IN :gender ")
	List<StatisticsProjection> getOneToOneContactByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select count(distinct tb.beneficiary_id) as value from soch.ti_beneficiary_comm_dis bcd "
			+ " inner join soch.ti_beneficiary tb on tb.id = bcd.beneficiary_id "
			+ " inner join soch.master_contact_type mct	on bcd.master_contact_type_id  = mct.id "
			+ " where mct.id = 1 and tb.facility_id =:facilityId "
			+ " and to_char(bcd.created_time,'MM')=to_char(now(),'MM') "
			+ " and tb.is_active =true and tb.is_deleted = false and tb.master_hrg_primary_id IN :typology ")
	List<StatisticsProjection> getOneToOneContactByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1 " + " and sti.screening_status_hiv_id IS NOT NULL "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and bn.gender_id IN :gender and tcb.master_hrg_primary_id IN :typology GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivTestedByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1 " + " and sti.screening_status_hiv_id IS NOT NULL "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and bn.gender_id IN :gender GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivTestedByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id  "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1 " + " and sti.screening_status_hiv_id IS NOT NULL "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and tcb.master_hrg_primary_id IN :typology GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivTestedByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1  and mhss.id=1 "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and tcb.master_hrg_primary_id IN :typology and bn.gender_id IN :gender GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivReactiveByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1  and mhss.id=1 "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and bn.gender_id IN :gender GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivReactiveByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, "
			+ " COUNT(sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti "
			+ " join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id  "
			+ " join soch.beneficiary bn on bn.id = tcb.beneficiary_id  "
			+ " join soch.master_infection_type mit on mit.id = sti.infection_id "
			+ " join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ " WHERE tcb.facility_id= :facilityId and mit.id =1  and mhss.id=1 "
			+ " and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY')  "
			+ " and tcb.master_hrg_primary_id IN :typology GROUP BY 1 ")
	List<StatisticsProjection> getMonthwiseHivReactiveByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select DISTINCT b.pre_art_number as preArtNumber, b.id as beneficiaryId from soch.beneficiary as b "
			+ "	join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "	where  ab.facility_id = :facilityId  and b.pre_art_number = :preArtNumber ")
	Optional<ArtBeneficiaryRegistrationProjection> findByPreArtNumber(@Param("preArtNumber") String preArtNumber,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select DISTINCT b.art_number as artNumber ,b.id as beneficiaryId from soch.beneficiary as b "
			+ "	join soch.art_beneficiary as ab on ab.beneficiary_id = b.id "
			+ "	where  ab.facility_id = :facilityId  and b.art_number  = :artNumber ")
	Optional<ArtBeneficiaryRegistrationProjection> findByArtNumber(@Param("artNumber") String artNumber,
			@Param("facilityId") Long facilityId);

	/*
	 * @Query(nativeQuery = true ,value =
	 * "select count(beneficiary_id) as value,TO_CHAR(date_of_reg,'MONTH') as name "
	 * +
	 * " from soch.ti_core_beneficiary tcb join soch.beneficiary b on b.id = tcb.beneficiary_id "
	 * +
	 * " where tcb.hiv_art_linked = true and tcb.facility_id =:facilityId and b.gender IN :gender "
	 * +
	 * " and tcb.typology IN :typology and to_char(tcb.date_of_reg,'YYYY')=to_char(now(),'YYYY') group by 2"
	 * ) List<StatisticsProjection>
	 * getHIVLinkedByGenderAndTopology(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender,
	 * 
	 * @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery = true ,value =
	 * "select count(beneficiary_id) as value,TO_CHAR(date_of_reg,'MONTH') as name "
	 * +
	 * " from soch.ti_core_beneficiary tcb join soch.beneficiary b on b.id = tcb.beneficiary_id "
	 * +
	 * " where tcb.hiv_art_linked = true and tcb.facility_id =:facilityId and b.gender IN :gender "
	 * + " and to_char(tcb.date_of_reg,'YYYY')=to_char(now(),'YYYY') group by 2 ")
	 * List<StatisticsProjection> getHIVLinkedByGender(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender);
	 */

	/*
	 * @Query(nativeQuery = true ,value =
	 * "select count(beneficiary_id) as value,TO_CHAR(date_of_reg,'MONTH') as name "
	 * +
	 * " from soch.ti_core_beneficiary tcb join soch.beneficiary b on b.id = tcb.beneficiary_id "
	 * +
	 * " where tcb.hiv_art_linked = true and tcb.facility_id =:facilityId and  tcb.typology IN :typology "
	 * + " and to_char(tcb.date_of_reg,'YYYY')=to_char(now(),'YYYY') group by 2 ")
	 * List<StatisticsProjection> getHIVLinkedByTypology(@Param("facilityId") Long
	 * facilityId, @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery = true , value =
	 * "select count(bast.beneficiary_id) as value , 'Preparedness' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'ART Preparedness Counselling' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY')"
	 * + " and bast.facility_id =:facilityId and b.gender IN :gender " +
	 * " and tb.typology IN :typology group by 2") List<StatisticsProjection>
	 * getArtPreparednessByGenderAndTypology(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender,
	 * 
	 * @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery = true , value =
	 * "select count(bast.beneficiary_id) as value , 'Preparedness' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'ART Preparedness Counselling' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY')"
	 * + " and bast.facility_id =:facilityId and b.gender IN :gender " +
	 * " group by 2") List<StatisticsProjection>
	 * getArtPreparednessByGender(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender);
	 */

	/*
	 * @Query(nativeQuery = true , value =
	 * "select count(bast.beneficiary_id) as value , 'Preparedness' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'ART Preparedness Counselling' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY')"
	 * + " and bast.facility_id =:facilityId and tb.typology IN :typology " +
	 * " group by 2") List<StatisticsProjection>
	 * getArtPreparednessByTypology(@Param("facilityId") Long
	 * facilityId, @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery=true , value
	 * =" select count(bast.beneficiary_id) as value , 'On-Art' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'On-ART' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * +
	 * " and bast.facility_id =:facilityId and tb.typology IN :typology and b.gender IN :gender group by 2 "
	 * ) List<StatisticsProjection> getOnArtByGenderAndTypology(@Param("facilityId")
	 * Long facilityId, @Param("gender") List<String> gender,
	 * 
	 * @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery=true , value
	 * =" select count(bast.beneficiary_id) as value , 'On-Art' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'On-ART' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * + " and bast.facility_id =:facilityId  and b.gender IN :gender group by 2 ")
	 * List<StatisticsProjection> getOnArtByGender(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender);
	 */

	/*
	 * @Query(nativeQuery=true , value
	 * =" select count(bast.beneficiary_id) as value , 'On-Art' as name " +
	 * " from soch.beneficiary_art_status_tracking bast " +
	 * " join soch.master_beneficiary_activity_status mbas on mbas.id = bast.art_beneficiary_status_id "
	 * + " join soch.beneficiary b on b.id = bast.beneficiary_id " +
	 * " join soch.ti_beneficiary tb on tb.beneficiary_id = b.id " +
	 * " where mbas.name = 'On-ART' and to_char(bast.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * +
	 * " and bast.facility_id =:facilityId  and tb.typology IN :typology  group by 2 "
	 * ) List<StatisticsProjection> getOnArtByTypology(@Param("facilityId") Long
	 * facilityId, @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery=true , value =
	 * "select count(tbed.beneficiary_id) as value, 'Not-linked' as name " +
	 * " from soch.ti_ben_ext_Details tbed join soch.ti_beneficiary tb on tb.id = tbed.beneficiary_id "
	 * +
	 * " join soch.beneficiary b on b.id = tb.beneficiary_id where tbed.facility_id =:facilityId "
	 * + " and b.gender IN :gender and tb.typology IN :typology " +
	 * " and tbed.hiv_art_linked=false and to_char(tbed.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * ) List<StatisticsProjection>
	 * getNotLinkedByGenderAndTypology(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender,
	 * 
	 * @Param("typology") List<String> typology);
	 */

	/*
	 * @Query(nativeQuery=true , value =
	 * "select count(tbed.beneficiary_id) as value, 'Not-linked' as name " +
	 * " from soch.ti_ben_ext_Details tbed join soch.ti_beneficiary tb on tb.id = tbed.beneficiary_id "
	 * +
	 * " join soch.beneficiary b on b.id = tb.beneficiary_id where tbed.facility_id =:facilityId "
	 * + " and b.gender IN :gender " +
	 * " and tbed.hiv_art_linked=false and to_char(tbed.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * ) List<StatisticsProjection> getNotLinkedByGender(@Param("facilityId") Long
	 * facilityId, @Param("gender") List<String> gender);
	 */

	/*
	 * @Query(nativeQuery=true , value =
	 * "select count(tbed.beneficiary_id) as value, 'Not-linked' as name " +
	 * " from soch.ti_ben_ext_Details tbed join soch.ti_beneficiary tb on tb.id = tbed.beneficiary_id "
	 * +
	 * " join soch.beneficiary b on b.id = tb.beneficiary_id where tbed.facility_id =:facilityId "
	 * + "  and tb.typology IN :typology " +
	 * " and tbed.hiv_art_linked=false and to_char(tbed.created_time,'YYYY')=to_char(now(),'YYYY') "
	 * ) List<StatisticsProjection> getNotLinkedByTypology(@Param("facilityId") Long
	 * facilityId, @Param("typology") List<String> typology);
	 */

	@Query(nativeQuery = true, value = " select  b.uid as uid, concat(b.first_name,' ', b.middle_name,' ', b.last_name) as benficiaryName, "
			+ " b.pre_art_number as preArtNumber, b.mobile_number as mobileNumber,"
			+ " b.art_number as artNumber, b.age as age, ab.beneficiary_id as beneficiaryId , ab.facility_id as facilityId ,"
			+ " mabs.id as artBeneficiaryStatusId , mabs.name as artBeneficiaryStatusName,"
			+ " mg.id as genderId , mg.name as genderName" + " from soch.beneficiary as b"
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id=b.id"
			+ " left join soch.master_art_beneficiary_status as mabs on mabs.id= ab.art_beneficiary_status_id"
			+ " left join soch.master_gender as mg on mg.id = b.gender_id"
			+ " where ab.art_beneficiary_status_id in (:artBeneficiaryStatusIds) and ab.facility_id = :facilityId and ab.is_active = true and ab.is_delete =false and b.is_active = true"
			+ " and b.is_delete = false and (lower(b.uid) like %:searchText%  or lower(b.first_name) like %:searchText% or lower(b.middle_name) like %:searchText% "
			+ " or lower(b.last_name) like %:searchText% or lower(b.mobile_number) like %:searchText% or lower(b.pre_art_number) like %:searchText% or lower(b.art_number) like %:searchText%) ")
	List<ArtFollowupListProjection> findAllFollowUpList(
			@Param("artBeneficiaryStatusIds") List<Long> artBeneficiaryStatusIds, @Param("facilityId") Long facilityId,
			@Param("searchText") String searchText);

	@Query(nativeQuery = true, value = " select  b.uid as uid, concat(b.first_name,' ', b.middle_name,' ', b.last_name) as benficiaryName, "
			+ " b.pre_art_number as preArtNumber, b.mobile_number as mobileNumber,"
			+ " b.art_number as artNumber, b.age as age, ab.beneficiary_id as beneficiaryId , ab.facility_id as facilityId ,"
			+ " mabs.id as artBeneficiaryStatusId , mabs.name as artBeneficiaryStatusName,"
			+ " mg.id as genderId , mg.name as genderName" + " from soch.beneficiary as b"
			+ " join soch.art_beneficiary as ab on ab.beneficiary_id=b.id"
			+ " left join soch.master_art_beneficiary_status as mabs on mabs.id= ab.art_beneficiary_status_id"
			+ " left join soch.master_gender as mg on mg.id = b.gender_id"
			+ " where  ab.facility_id = :facilityId and ab.is_active = true and ab.is_delete =false and b.is_active = true"
			+ " and b.is_delete = false and  b.id=:beneficiaryId")
	ArtFollowupListProjection findFollowUpLisByBeneficairyId(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId);

	/*
	 * List<Beneficiary> findAllFollowUpList(@Param("artBeneficiaryStatusIds")
	 * List<Long> artBeneficiaryStatusIds,
	 * 
	 * @Param("adherenceValue") Integer adherenceValue, @Param("cD4belowValue")
	 * Integer cD4belowValue,
	 * 
	 * @Param("vLaboveValue") Integer vLaboveValue);
	 */

	// Beneficairy linked - HIV
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, \r\n"
			+ "			 COUNT(distinct sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id \r\n"
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id \r\n"
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ "          inner join soch.beneficiary_referral br \r\n" + "			 on br.beneficiary_id  = bn.id \r\n"
			+ "			 inner join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "			 inner join soch.facility f on br.refered_to  = f.id \r\n"
			+ "		 	WHERE tcb.facility_id=:facilityId and mit.id =1  and mhss.id=1 and mrs.id = 3 and f.facility_type_id  = 11\r\n"
			+ "		 	and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') "
			+ "  and tcb.master_hrg_primary_id IN :typology and bn.gender_id IN :gender GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivLinkedByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	// Beneficairy linked - HIV
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, \r\n"
			+ "			 COUNT(distinct sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id \r\n"
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id \r\n"
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ "          inner join soch.beneficiary_referral br \r\n" + "			 on br.beneficiary_id  = bn.id \r\n"
			+ "			 inner join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "			 inner join soch.facility f on br.refered_to  = f.id \r\n"
			+ "		 	WHERE tcb.facility_id=:facilityId and mit.id =1  and mhss.id=1 and mrs.id = 3 and f.facility_type_id  = 11\r\n"
			+ "		 	and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') "
			+ "  and bn.gender_id IN :gender GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivLinkedByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	// Beneficairy linked - HIV
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',sti.date_of_screening),'MONTH') AS name, \r\n"
			+ "			 COUNT(distinct sti.beneficiary_id) AS value FROM soch.ti_ben_scr_details sti \r\n"
			+ "			 join soch.ti_beneficiary tcb on tcb.id = sti.beneficiary_id \r\n"
			+ "			 join soch.beneficiary bn on bn.id = tcb.beneficiary_id \r\n"
			+ "			 join soch.master_infection_type mit on mit.id = sti.infection_id \r\n"
			+ "			 join soch.master_hiv_screening_status mhss on mhss.id = sti.screening_status_hiv_id "
			+ "          inner join soch.beneficiary_referral br \r\n" + "			 on br.beneficiary_id  = bn.id \r\n"
			+ "			 inner join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "			 inner join soch.facility f on br.refered_to  = f.id \r\n"
			+ "		 	WHERE tcb.facility_id=:facilityId and mit.id =1  and mhss.id=1 and mrs.id = 3 and f.facility_type_id  = 11\r\n"
			+ "		 	and to_char(sti.date_of_screening,'YYYY')=to_char(now(),'YYYY') "
			+ "  and tcb.master_hrg_primary_id IN :typology GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivLinkedByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select mabs.name as name ,count(distinct tb.beneficiary_id) as value from ti_beneficiary tb inner join beneficiary b\r\n"
			+ "		 on b.id =tb.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = tb.beneficiary_id\r\n"
			+ "		 inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id and b.hiv_status_id = 2\r\n"
			+ "		 and tb.facility_id = :facilityId group by mabs.name\r\n" + "		 union\r\n"
			+ "		 select 'Not Linked' as name , count(distinct tb.beneficiary_id) from ti_beneficiary tb inner join beneficiary b\r\n"
			+ "		 on b.id =tb.beneficiary_id\r\n"
			+ "		 where b.id not in(select distinct beneficiary_id from art_beneficiary where is_active=true and is_delete=false)\r\n"
			+ "		 and b.hiv_status_id = 2 and tb.facility_id = :facilityId")
	List<StatisticsProjection> getArtBeneficiaryStatusFromTI(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select mabs.name as name ,count(distinct tb.beneficiary_id) as value from ti_beneficiary tb inner join beneficiary b\r\n"
			+ "		 on b.id =tb.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = tb.beneficiary_id\r\n"
			+ "		 inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id and b.hiv_status_id = 2\r\n"
			+ "		 and tb.facility_id = :facilityId and tb.master_hrg_primary_id IN :typology group by mabs.name\r\n"
			+ "		 union\r\n"
			+ "		 select 'Not Linked' as name , count(distinct tb.beneficiary_id) from ti_beneficiary tb inner join beneficiary b\r\n"
			+ "		 on b.id =tb.beneficiary_id\r\n"
			+ "		 where b.id not in(select distinct beneficiary_id from art_beneficiary where is_active=true and is_delete=false)\r\n"
			+ "		 and b.hiv_status_id = 2  and tb.master_hrg_primary_id IN :typology and tb.facility_id = :facilityId")
	List<StatisticsProjection> getArtBeneficiaryStatusFromTIByTypology(@Param("facilityId") Long facilityId,
			@Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select mabs.name as name ,count(distinct tb.beneficiary_id) as value from ti_beneficiary tb inner join beneficiary b\r\n"
			+ "		 on b.id =tb.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = tb.beneficiary_id\r\n"
			+ "		 inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id and b.hiv_status_id = 2\r\n"
			+ "		 and tb.facility_id = :facilityId and b.gender_id IN :gender group by mabs.name\r\n"
			+ "		 union\r\n"
			+ "		 select 'Not Linked' as name , count(distinct tb.beneficiary_id) from ti_beneficiary tb inner join beneficiary b\r\n"
			+ "		 on b.id =tb.beneficiary_id\r\n"
			+ "		 where b.id not in(select distinct beneficiary_id from art_beneficiary where is_active=true and is_delete=false)\r\n"
			+ "		 and b.hiv_status_id = 2 and b.gender_id IN :gender and tb.facility_id = :facilityId")
	List<StatisticsProjection> getArtBeneficiaryStatusFromTIByGender(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender);

	@Query(nativeQuery = true, value = "select mabs.name as name ,count(distinct tb.beneficiary_id) as value from ti_beneficiary tb inner join beneficiary b\r\n"
			+ "		 on b.id =tb.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = tb.beneficiary_id\r\n"
			+ "		 inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id and b.hiv_status_id = 2\r\n"
			+ "		 and tb.facility_id = :facilityId and tb.master_hrg_primary_id IN :typology and b.gender_id IN :gender group by mabs.name\r\n"
			+ "		 union\r\n"
			+ "		 select 'Not Linked' as name , count(distinct tb.beneficiary_id) from ti_beneficiary tb inner join beneficiary b\r\n"
			+ "		 on b.id =tb.beneficiary_id\r\n"
			+ "		 where b.id not in(select distinct beneficiary_id from art_beneficiary where is_active=true and is_delete=false)\r\n"
			+ "		 and b.hiv_status_id = 2 and tb.master_hrg_primary_id IN :typology and b.gender_id IN :gender and tb.facility_id = :facilityId")
	List<StatisticsProjection> getArtBeneficiaryStatusFromTIByGenderAndTypology(@Param("facilityId") Long facilityId,
			@Param("gender") List<Integer> gender, @Param("typology") List<Integer> typology);

	@Query(nativeQuery = true, value = "select (select coalesce (sum(sd.adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd "
			+ " inner join soch.facility f on f.id = sd.facility_id "
			+ " inner join soch.product p on p.id = sd.product_id "
			+ " where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' "
			+ " and sd.date_of_addition_or_consupmtion < date_trunc('month', now()) "
			+ " and f.id  =:facilityId and lower(p.product_name) like '%condom%') as AverageCount, "
			+ " (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda "
			+ " inner join soch.facility f on f.id = sda.facility_id "
			+ " inner join soch.product p on p.id = sda.product_id "
			+ " where f.id =:facilityId and lower(p.product_name) like '%condom%') as TotalQuantity ")
	InventoryProjection getCondomInventoryDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select coalesce (sum(sd.adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd "
			+ " inner join soch.facility f on f.id = sd.facility_id "
			+ " inner join soch.product p on p.id = sd.product_id "
			+ " where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' "
			+ " and sd.date_of_addition_or_consupmtion < date_trunc('month', now()) "
			+ " and f.id  =:facilityId and lower(p.product_name) like '%hiv%') as AverageCount, "
			+ " (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda "
			+ " inner join soch.facility f on f.id = sda.facility_id "
			+ " inner join soch.product p on p.id = sda.product_id "
			+ " where f.id =:facilityId and lower(p.product_name) like '%hiv%') as TotalQuantity ")
	InventoryProjection getHivInventoryDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select coalesce (sum(sd.adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd "
			+ " inner join soch.facility f on f.id = sd.facility_id "
			+ " inner join soch.product p on p.id = sd.product_id "
			+ " where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' "
			+ " and sd.date_of_addition_or_consupmtion < date_trunc('month', now()) "
			+ " and f.id  =:facilityId and lower(p.product_name) like '%needle%') as AverageCount, "
			+ " (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda "
			+ " inner join soch.facility f on f.id = sda.facility_id "
			+ " inner join soch.product p on p.id = sda.product_id "
			+ " where f.id =:facilityId and lower(p.product_name) like '%needle%') as TotalQuantity ")
	InventoryProjection getNeedleInventoryDetails(@Param("facilityId") Long facilityId);

	@Modifying
	@Transactional
	@Query("update Beneficiary b set b.isDelete = true , b.isActive = false where b.id = :beneficiaryId")
	void deleteBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
}
