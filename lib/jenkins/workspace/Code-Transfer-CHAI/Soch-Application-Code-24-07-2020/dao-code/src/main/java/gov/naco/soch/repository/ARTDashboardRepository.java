package gov.naco.soch.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.StatisticsProjection;

@Repository
public interface ARTDashboardRepository extends JpaRepository<Beneficiary, Long> {

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	inner join soch.art_beneficiary_due_list abd on b.id = abd.beneficiary_id "
			+ "	where abd.expected_visit_date >= now() and abd.is_visited =false and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBenificiaryDueForVisit(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_visit_register bvr on b.id = bvr.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBenificiaryForVisit(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id)   AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.master_four_s_screening mfs on mfs.id = ab.four_s_screening_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where mfs.id = 1 and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getFourPlusDetectedCountByCc(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.art_beneficiary_due_list abd on b.id = abd.beneficiary_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where abd.expected_visit_date < now() and is_visited =false and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1 ")
	List<StatisticsProjection> getBenificiaryMissedAppoinmentsCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where bfm.facility_id  =:facilityId and ab.is_active  = true and ab.is_delete =false"
			+ " and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewRegistrationsCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ab.art_start_date is not null and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewInitiationsCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.destination_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferOutCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.source_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferInCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name, "
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.destination_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and t.reporting_date is null and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryPendingTransferInCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.art_dispensation ad where ad.facility_id =:facilityId and ad.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getNumberOfDispensationCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getnumberOfTestsVlConductedCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name,p.product_name,count(adi.art_dispensation_id ) as value from soch.art_dispensation ad\n"
			+ "    inner join soch.art_dispensation_item adi on ad.id = adi.art_dispensation_id\n"
			+ "    inner join soch.product p on p.id = adi.product_id\n"
			+ "    where ad.facility_id = 3 and p.is_active = true  group by p.product_name, ad.created_time")
	List<StatisticsProjection> getNumberOfDispensationdrugCountAsPerDrugCountDetails(
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',abi.investigation_date),'MONTH') AS name,"
			+ " count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.art_beneficiary_investigation abi on abi.beneficiary_id = ab.id "
			+ " inner join soch.master_investigation mi on abi.investigation_id = mi.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ab.is_active = true and ab.is_delete=false "
			+ " and abi.investigation_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1 ")
	List<StatisticsProjection> getInvestigationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name, "
			+ " count(distinct ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id"
			+ " inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id"
			+ " inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id"
			+ " inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom"
			+ " inner join soch.role r on r.id = urm.role_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId "
			+ " and bvr.four_s_symptoms  = true and bvr.created_time >= date_trunc('month', now())- interval '11 month' "
			+ " and mfs.name ='Cough' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getCoughDetectedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name, "
			+ " count(distinct ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id"
			+ " inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id"
			+ " inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id"
			+ " inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom"
			+ " inner join soch.role r on r.id = urm.role_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId "
			+ " and bvr.four_s_symptoms  = true and bvr.created_time >= date_trunc('month', now())- interval '11 month' "
			+ " and mfs.name ='Fever' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getFeverDetectedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name, "
			+ " count(distinct ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id"
			+ " inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id"
			+ " inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id"
			+ " inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom"
			+ " inner join soch.role r on r.id = urm.role_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId "
			+ " and bvr.four_s_symptoms  = true and bvr.created_time >= date_trunc('month', now())- interval '11 month' "
			+ " and mfs.name ='Weight Loss' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getWeightLossDetectedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name, "
			+ " count(distinct ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id"
			+ " inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id"
			+ " inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id"
			+ " inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom"
			+ " inner join soch.role r on r.id = urm.role_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId "
			+ " and bvr.four_s_symptoms  = true and bvr.created_time >= date_trunc('month', now())- interval '11 month' "
			+ " and mfs.name ='Night Sweats' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getNightSweatDetectedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_received_date),'MONTH') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1 ")
	List<StatisticsProjection> getcd4TestConductedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.art_beneficiary_due_list abd on b.id = abd.beneficiary_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where abd.expected_visit_date >= now() and abd.is_visited =false and bfm.facility_id =:facilityId  AND  ab.created_time  between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBenificiaryDueForVisitMonthFilterList(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.art_beneficiary_due_list abd on b.id = abd.beneficiary_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where abd.expected_visit_date >= now() and abd.is_visited =false and bfm.facility_id =:facilityId   AND  ab.created_time  between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBenificiaryDueForVisitDaysFilterList(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select f.name as name , count(distinct ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id "
			+ " inner join soch.facility f on br.refered_from  = f.id "
			+ " inner join soch.facility_type ft on ft.id  = f.facility_type_id "
			+ " where ft.id =11 and ab.is_active = true and ab.is_delete=false " + " group by f.name ")
	List<StatisticsProjection> getAllFacilities();

	@Query(nativeQuery = true, value = "select rf.name as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner  join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_risk_factor rf on rf.id = ab.hiv_risk_factor_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false "
			+ " group by rf.name ")
	List<StatisticsProjection> getAllRiskFactorsByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ep.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_entry_point ep on ab.entry_point_id  = ep.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false "
			+ " group by ep.name ")
	List<StatisticsProjection> getAllEntryPointsByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select mo.name as name ,count(ab.beneficiary_id )as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_occupation mo on mo.id  = b.occupation_id  "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false "
			+ " group by mo.name ")
	List<StatisticsProjection> getAllOccupationByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select el.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_education_level el on el.id  = b.education_level_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ab.is_active = true and ab.is_delete=false " + " group by el.name ")
	List<StatisticsProjection> getAllEducationByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select mi.name as  name ,count(ab.beneficiary_id ) as value from soch.beneficiary b   "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_monthly_income mi on b.monthly_income   = mi.id  "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ab.is_active = true and ab.is_delete=false " + " group by mi.name ")
	List<StatisticsProjection> getAllSalaryByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_visit_register bvr on b.id = bvr.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where bfm.facility_id =:facilityId and  ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFilteredBenificiaryForVisit(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_visit_register bvr on b.id = bvr.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBenificiaryVisitDaysFilterList(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id)   AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.master_four_s_screening mfs on mfs.id = ab.four_s_screening_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where mfs.id = 1 and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFourPlusDetectedCountByCcFilteredByMonth(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id)   AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.master_four_s_screening mfs on mfs.id = ab.four_s_screening_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where mfs.id = 1 and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFourPlusDetectedCountByCcFilteredByDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.art_beneficiary_due_list abd on b.id = abd.beneficiary_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where abd.expected_visit_date < now() and is_visited =false and bfm.facility_id =:facilityId and ab.created_time between :dateFrom And :dateTo  GROUP BY 1 ")
	List<StatisticsProjection> getBenificiaryMissedAppoinmentsFilterCountDetails(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.art_beneficiary_due_list abd on b.id = abd.beneficiary_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where abd.expected_visit_date < now() and is_visited =false and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getBenificiaryMissedAppoinmentsFilterByDateCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where bfm.facility_id =:facilityId and ab.is_active  = true and ab.is_delete =false "
			+ " and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewRegistrationsCountDetailsForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where bfm.facility_id =:facilityId and ab.is_active  = true and ab.is_delete =false"
			+ " and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewRegistrationsCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ab.art_start_date is not null and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewInitiationsCountDetailsForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ab.art_start_date is not null and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewInitiationsCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select f.name as name , count(distinct ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id "
			+ " inner join soch.facility f on br.refered_from  = f.id "
			+ " inner join soch.facility_type ft on ft.id  = f.facility_type_id " 
			+ " where f.name IN :facilityNames "
			+ " and ft.id =11  and ab.is_active = true and ab.is_delete=false " + " group by f.name")
	List<StatisticsProjection> facilitywiseBreakupUsingFilters(@Param("facilityNames") List<String> facilityNames);

	@Query(nativeQuery = true, value = "select  'Others' as name , count(distinct ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id "
			+ " inner join soch.facility f on br.refered_from  = f.id "
			+ " inner join soch.facility_type ft on ft.id  = f.facility_type_id "
			+ " where f.name NOT IN :facilityNames " + " and ft.id =11 and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> facilitywiseBreakupOthersUsingFilters(
			@Param("facilityNames") List<String> facilityNames);

	@Query(nativeQuery = true, value = "select rf.name as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_risk_factor rf on rf.id = ab.hiv_risk_factor_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and rf.name IN :riskFactors "
			+ " and ab.is_active = true and ab.is_delete=false " + " group by rf.name ")
	List<StatisticsProjection> riskFactorBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("riskFactors") List<String> riskFactors);

	@Query(nativeQuery = true, value = "select 'Others' as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_risk_factor rf on rf.id = ab.hiv_risk_factor_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and rf.name NOT IN :riskFactors "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> riskFactorBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("riskFactors") List<String> riskFactors);

	@Query(nativeQuery = true, value = " select ep.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_entry_point ep on ab.entry_point_id  = ep.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ep.name IN :entryPoints  "
			+ " and ab.is_active = true and ab.is_delete=false " + " group by ep.name ")
	List<StatisticsProjection> entryPointBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("entryPoints") List<String> entryPoints);

	@Query(nativeQuery = true, value = " select 'Others' as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_entry_point ep on ab.entry_point_id  = ep.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ep.name NOT IN :entryPoints  "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> entryPointBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("entryPoints") List<String> entryPoints);

	@Query(nativeQuery = true, value = " select mo.name as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_occupation mo on mo.id  = b.occupation_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and mo.name IN :occupations  "
			+ " and ab.is_active = true and ab.is_delete=false  " + " group by mo.name ")
	List<StatisticsProjection> occupationBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("occupations") List<String> occupations);

	@Query(nativeQuery = true, value = " select 'Others' as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_occupation mo on mo.id  = b.occupation_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and mo.name NOT IN :occupations  "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> occupationBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("occupations") List<String> occupations);

	@Query(nativeQuery = true, value = " select el.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_education_level el on el.id  = b.education_level_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and el.name IN :educations "
			+ " and ab.is_active = true and ab.is_delete=false " + " group by el.name ")
	List<StatisticsProjection> educationBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("educations") List<String> educations);

	@Query(nativeQuery = true, value = " select 'Others' as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_education_level el on el.id  = b.education_level_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and el.name NOT IN :educations "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> educationBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("educations") List<String> educations);

	@Query(nativeQuery = true, value = "select mi.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_monthly_income mi on b.monthly_income   = mi.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and mi.name IN :salaries "
			+ " and ab.is_active = true and ab.is_delete=false " + " group by mi.name ")
	List<StatisticsProjection> salaryBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("salaries") List<String> salaries);

	@Query(nativeQuery = true, value = "select 'Others' as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_monthly_income mi on b.monthly_income   = mi.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and mi.name NOT IN :salaries "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> salaryBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("salaries") List<String> salaries);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts \n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.result_received_date is not null \n" + "and f.id = 1 GROUP BY 1")
	List<StatisticsProjection> getVlTestConducted(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(lts.id) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id\n"
			+ "where t.id = 1 and lts.result_received_date is not null\n"
			+ "group by lts.id, f.id having count(lts.id) < 350 \n" + "and f.id = 3")
	List<StatisticsProjection> getcd4TestLessThan350(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 1 and lts.sample_received_date is not null \n"
			+ "and lts.sample_dispatch_date is not null \n" + "and f.id = 1 GROUP BY 1;")
	List<StatisticsProjection> getcd4SamplesCollected(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.source_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo  GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferInFilterCount(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.destination_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferOutFilterCount(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.source_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo  GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferInFilterCountByDate(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.destination_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferOutFilterCountByDate(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name, "
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.destination_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and t.reporting_date is null and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryPendingTransferInFilterByMonthCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name, "
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.transfers t on b.id = t.beneficiary_id"
			+ "	inner join soch.facility_type ft on t.destination_facility_id = ft.id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ft.id = 15 and t.reporting_date is null and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryPendingTransferInFilterByDateCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.art_dispensation ad where ad.facility_id =:facilityId and ad.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getNumberOfDispensationCountFilterByMonthDetails(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ad.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(*) AS value from soch.art_dispensation ad where ad.facility_id =:facilityId and ad.created_time between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getNumberOfDispensationCountFilterByDateDetails(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time between :dateFrom and :dateTo GROUP BY 1")
	List<StatisticsProjection> getnumberOfTestsVlConductedCountDetailsFilteredByMonth(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time between :dateFrom and :dateTo GROUP BY 1")
	List<StatisticsProjection> getnumberOfTestsVlConductedCountDetailsFilteredByDate(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(ad.created_time,'MM/dd/yyyy') AS name,p.product_name,count(adi.art_dispensation_id ) as value from soch.art_dispensation ad\n"
			+ "    inner join soch.art_dispensation_item adi on ad.id = adi.art_dispensation_id\n"
			+ "    inner join soch.product p on p.id = adi.product_id\n"
			+ "    where ad.facility_id = :facilityId and p.is_active = true and ad.created_time between :dateFrom and :dateTo group by p.product_name, ad.created_time")
	List<StatisticsProjection> getNumberOfDispensationdrugCountAsPerDrugCountDetailsByDateFilter(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name,p.product_name,count(adi.art_dispensation_id ) as value from soch.art_dispensation ad\n"
			+ "    inner join soch.art_dispensation_item adi on ad.id = adi.art_dispensation_id\n"
			+ "    inner join soch.product p on p.id = adi.product_id\n"
			+ "    where ad.facility_id = :facilityId and p.is_active = true and ad.created_time between :dateFrom and :dateTo group by p.product_name, ad.created_time")
	List<StatisticsProjection> getNumberOfDispensationdrugCountAsPerDrugCountDetailsByMonthFilter(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name, count(*) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.sample_received_date is not null \n"
			+ "and lts.sample_dispatch_date is not null \n" + "and f.id = 3 GROUP BY 1")
	List<StatisticsProjection> getVlSamplesCollected(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			" where bfm.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1")
	List<StatisticsProjection> getreferredFromICTCCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id \n" +
			"where bfm.id = :facilityId and ab.created_time between :dateFrom and :dateTo group by 1")
	List<StatisticsProjection> getreferredFromICTCCountDetailsByMonthFilter(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id \n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time between :dateFrom and :dateTo group by 1")
	List<StatisticsProjection> getreferredFromICTCCountDetailsByDateFilter(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1")
	List<StatisticsProjection> getAttCompletionDetailsCountDetails(@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1")
	List<StatisticsProjection> getwidgetForAttStoppedOrOptedOutCountDetails(@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id \n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time between :dateFrom and :dateTo group by 1 ")
	List<StatisticsProjection> getwidgetForAttStoppedOrOptedOutFilterByMonthCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id \n" +
			"where bfm.id = :facilityId and ab.created_time between :dateFrom and :dateTo group by 1")
	List<StatisticsProjection> getwidgetForAttStoppedOrOptedOutFilterByDatesCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1 ")
	List<StatisticsProjection> getwidgetForbeneficiaryStatusBreakUpCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') as name , count(ab.beneficiary_id ) as value \r\n"
			+ "				from soch.art_beneficiary ab inner join soch.beneficiary b on b.id = ab.beneficiary_id \r\n"
			+ "				inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\r\n"
			+ "				inner join soch.master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id \r\n"
			+ "				where bfm.facility_id  =:facilityId and ab.is_active  = true and ab.is_delete =false and  mabs.id=:statusId \r\n"
			+ "				and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1")
	List<StatisticsProjection> getwidgetForbeneficiaryStatusBreakUpCountDetailsForStatus(
			@Param("facilityId") Long facilityId, @Param("statusId") int statusId);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time between :dateFrom and :dateTo group by 1 ")
	List<StatisticsProjection> getwidgetForAttCompletionFilterByMonthGraphCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time between :dateFrom AND :dateTo group by 1")
	List<StatisticsProjection> getwidgetForAttCompletionFilterByDateGraphCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',abi.investigation_date),'MONTH') AS name, count(ab.beneficiary_id) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.art_beneficiary_investigation abi on abi.beneficiary_id = ab.id\n" +
			"inner join soch.master_investigation mi on abi.investigation_id = mi.id\n" +
			"where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false\n" +
			"and abi.investigation_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getInvestigationCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(abi.investigation_date,'MM/dd/yyyy') AS name, count(ab.beneficiary_id) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.art_beneficiary_investigation abi on abi.beneficiary_id = ab.id\n" +
			"inner join soch.master_investigation mi on abi.investigation_id = mi.id\n" +
			"where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false\n" +
			"and abi.investigation_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getInvestigationCountDetailsForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id\n" +
			"inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id\n" +
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id\n" +
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom\n" +
			"inner join soch.role r on r.id = urm.role_id\n" +
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId \n" +
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo\n" +
			"and mfs.name ='Cough' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getCoughDetectedCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(bvr.created_time,'MM/dd/yyyy') AS name, count(distinct ab.beneficiary_id) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id\n" +
			"inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id\n" +
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id\n" +
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom\n" +
			"inner join soch.role r on r.id = urm.role_id\n" +
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId\n" +
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom and :dateTo\n" +
			"and mfs.name ='Cough' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getCoughDetectedCountDetailsForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id\n" +
			"inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id\n" +
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id\n" +
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom\n" +
			"inner join soch.role r on r.id = urm.role_id\n" +
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId\n" +
			" and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo\n" +
			"and mfs.name ='Fever' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getfeverDetectedCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(bvr.created_time,'MM/dd/yyyy') AS name,count(distinct ab.beneficiary_id) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id\n" +
			"inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id\n" +
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id\n" +
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom\n" +
			"inner join soch.role r on r.id = urm.role_id\n" +
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId\n" +
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo\n" +
			"and mfs.name ='Fever' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getFeverDetectedCountDetailsForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id\n" +
			"inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id\n" +
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id\n" +
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom\n" +
			"inner join soch.role r on r.id = urm.role_id\n" +
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId\n" +
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo\n" +
			"and mfs.name ='Weight Loss' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getWeightLossDetectedCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(bvr.created_time,'MM/dd/yyyy') AS name,count(distinct ab.beneficiary_id) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id\n" +
			"inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id\n" +
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id\n" +
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom\n" +
			"inner join soch.role r on r.id = urm.role_id\n" +
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId \n" +
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo\n" +
			"and mfs.name ='Weight Loss' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getWeightLossDetectedCountDetailsForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id\n" +
			"inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id\n" +
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id\n" +
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom\n" +
			"inner join soch.role r on r.id = urm.role_id\n" +
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId\n" +
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo\n" +
			"and mfs.name ='Night Sweats' and ab.is_active = true and ab.is_delete=false group by 1")
	List<StatisticsProjection> getNightSweatDetectedCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(bvr.created_time,'MM/dd/yyyy') AS name,count(distinct ab.beneficiary_id) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.user_role_mapping urm on ab.entry_user  = urm.user_id\n" +
			"inner join soch.beneficiary_visit_register bvr on ab.id  = bvr.beneficiary_id\n" +
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id\n" +
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom\n" +
			"inner join soch.role r on r.id = urm.role_id\n" +
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId\n" +
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo\n" +
			"and mfs.name ='Night Sweats' and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getNightSweatDetectedCountDetailsForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts \n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.result_received_date is not null \n"
			+ "and f.id = :facilityId and lts.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFilteredVlTestConductedForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.created_time,'MM/dd/yyyy') AS name,count(*) AS value from soch.lab_test_sample lts \n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.result_received_date is not null \n"
			+ "and f.id = :facilityId and lts.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFilteredVlTestConductedForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(lts.id) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id\n"
			+ "where t.id = 1 and lts.result_received_date is not null and lts.created_time between :dateFrom AND :dateTo \n"
			+ "group by lts.id, f.id having count(lts.id) < 350 \n" + "and f.id = :facilityId")
	List<StatisticsProjection> getFilteredCd4TestLessThan350ForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.created_time,'MM/dd/yyyy') AS name,count(lts.id) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id\n"
			+ "where t.id = 1 and lts.result_received_date is not null and lts.created_time between :dateFrom AND :dateTo \n"
			+ "group by lts.id, f.id having count(lts.id) < 350 \n" + "and f.id = :facilityId")
	List<StatisticsProjection> getFilteredCd4TestLessThan350ForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 1 and lts.sample_received_date is not null \n"
			+ "and lts.sample_dispatch_date is not null \n"
			+ "and f.id = :facilityId and lts.created_time between :dateFrom AND :dateTo\n" + "GROUP BY 1")
	List<StatisticsProjection> getFilteredCd4SamplesCollectedForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.created_time,'MM/dd/yyyy') AS name,count(*) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 1 and lts.sample_received_date is not null \n"
			+ "and lts.sample_dispatch_date is not null \n"
			+ "and f.id = :facilityId and lts.created_time between :dateFrom AND :dateTo\n" + "GROUP BY 1")
	List<StatisticsProjection> getFilteredCd4SamplesCollectedForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name, count(*) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.sample_received_date is not null \n"
			+ "and lts.sample_dispatch_date is not null \n"
			+ "and f.id = :facilityId and lts.created_time between :dateFrom AND :dateTo\n" + "GROUP BY 1")
	List<StatisticsProjection> getFilteredVlSamplesCollectedForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.created_time,'MM/dd/yyyy') AS name, count(*) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.sample_received_date is not null \n"
			+ "and lts.sample_dispatch_date is not null \n"
			+ "and f.id = :facilityId and lts.created_time between :dateFrom AND :dateTo\n" + "GROUP BY 1")
	List<StatisticsProjection> getFilteredVlSamplesCollectedForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select p.product_name as name, sum(fas.available_quantity) as value from soch.facility_aggregate_stock fas inner join soch.product p\n"
			+ "on p.id = fas.product_id where  fas.is_active =true and fas.is_delete =false and  fas.facility_id = :facilityId group by p.product_name")
	List<StatisticsProjection> getInventoryQuantityPerDrug(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select p.product_name as name, sum(fas.available_quantity) as value from soch.facility_aggregate_stock fas inner join soch.product p\n"
			+ "on p.id = fas.product_id where  fas.is_active =true and fas.is_delete =false and p.product_name in :drugs and fas.facility_id = :facilityId group by p.product_name;")
	List<StatisticsProjection> getInventoryQuantityPerDrugForFilters(@Param("facilityId") Long facilityId,
			@Param("drugs") List<String> drugs);

	// Dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts \ninner join soch.facility f on f.id = lts.sample_collected_facility_id\ninner join soch.test t on t.id = lts.test_id  \nwhere t.id = 2 and lts.result_received_date is not null \nand f.id = 1 GROUP BY 1")
	List<StatisticsProjection> getRegimenBreakup(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_received_date),'MONTH') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getcd4TestConductedCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.result_received_date,'MM/dd/yyyy') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getcd4TestConductedCountForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getPregnantDetectedCount(@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_received_date),'MONTH') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getPregnantDetectedCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(lts.result_received_date,'MM/dd/yyyy') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getPregnantWomenDetectedCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getPregnantReferredCount(@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_received_date),'MONTH') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getPregnantReferredCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(lts.result_received_date,'MM/dd/yyyy') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getPregnantWomenRefferedCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getNtepReferralCount(@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_received_date),'MONTH') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getNtepReferralCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select TO_CHAR(lts.result_received_date,'MM/dd/yyyy') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getNtepReferralCountDetailsForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_start_date ),'MONTH') as name ,count(distinct b.id ) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_start_date is not null\n" +
			"and iad.ipt_start_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getIptInitiationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_start_date ),'MONTH') as name ,count(distinct b.id ) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id \n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true and b.is_delete =false \n" +
			"and iad.ipt_start_date is not null\n" +
			"and iad.ipt_start_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getIptInitiationCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.ipt_start_date,'MM/dd/yyyy') AS name,count(distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id = :facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_start_date is not null\n" +
			"and iad.ipt_start_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptInitiationCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_end_date ),'MONTH') as name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_end_date is not null\n" +
			"and iad.ipt_end_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getIptCompletionCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_end_date ),'MONTH') as name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_end_date is not null and iad.ipt_end_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptCompletionCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.ipt_end_date,'MM/dd/yyyy') AS name,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_end_date is not null and iad.ipt_end_date between :dateFrom and :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptCompletionCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_stop_date ),'MONTH') as name ,count(distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.ipt_stop_date is not null and iad.ipt_stop_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getIptStoppedOrOptedOutCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_stop_date ),'MONTH') as name ,count(distinct b.id ) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.ipt_stop_date is not null and iad.ipt_stop_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptStoppedOrOptedOutCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.ipt_stop_date,'MM/dd/yyyy') AS name ,count(distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.ipt_stop_date is not null and iad.ipt_stop_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptStoppedOrOptedOutForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.att_start_date ),'MONTH') as name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.att_start_date is not null\n" +
			"and iad.att_start_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getAttInitiationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.att_start_date ),'MONTH') as name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.att_start_date is not null\n" +
			"and iad.att_start_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getAttInitiationCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.att_start_date,'MM/dd/yyyy') AS name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.att_start_date is not null\n" +
			"and iad.att_start_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getAttInitiationCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from beneficiary b \r\n"
			+ "	inner join art_beneficiary ab on b.id = ab.beneficiary_id \r\n"
			+ "	inner join beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id \r\n"
			+ "	inner join facility f on br.refered_from  = f.id \r\n"
			+ "	 where f.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1 ")
	List<StatisticsProjection> getBeneficiaryRegimenBreakupCountDetailsForRegimen1(
			@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from beneficiary b \r\n"
			+ "	inner join art_beneficiary ab on b.id = ab.beneficiary_id \r\n"
			+ "	inner join beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id \r\n"
			+ "	inner join facility f on br.refered_from  = f.id \r\n"
			+ "	 where f.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1 ")
	List<StatisticsProjection> getBeneficiaryRegimenBreakupCountDetailsForRegimen2(
			@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from beneficiary b \r\n"
			+ "	inner join art_beneficiary ab on b.id = ab.beneficiary_id \r\n"
			+ "	inner join beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id \r\n"
			+ "	inner join facility f on br.refered_from  = f.id \r\n"
			+ "	 where f.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1 ")
	List<StatisticsProjection> getBeneficiaryRegimenBreakupCountDetailsForRegimen3(
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select name from soch.master_art_beneficiary_status where id =:statusId")
	String getStatusName(@Param("statusId") int statusId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.tb_diagnosis),'MONTH') as name ,count(b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"inner join soch.master_tb_result tr on tr.id = iad.tb_diagnosis_id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and  tr.id =:tbType and iad.tb_diagnosis >= date_trunc('month', now())- interval '11 month'\n" +
			"group by iad.tb_diagnosis ,name")
	List<StatisticsProjection> getTBCount(@Param("facilityId") Long facilityId, @Param("tbType") int tbType);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.tb_diagnosis),'MONTH') as name ,count(b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"inner join soch.master_tb_result tr on tr.id = iad.tb_diagnosis_id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and  tr.id =:tbType and iad.tb_diagnosis between :dateFrom AND :dateTo\n" +
			"group by iad.tb_diagnosis ,name")
	List<StatisticsProjection> getTBCountForMonths(@Param("facilityId") Long facilityId, @Param("tbType") int tbType,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.tb_diagnosis,'MM/dd/yyyy') as name ,count(b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"inner join soch.master_tb_result tr on tr.id = iad.tb_diagnosis_id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and  tr.id =:tbType and iad.tb_diagnosis between :dateFrom AND :dateTo\n" +
			"group by iad.tb_diagnosis ,name")
	List<StatisticsProjection> getTBCountForDays(@Param("facilityId") Long facilityId, @Param("tbType") int tbType,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);
}
