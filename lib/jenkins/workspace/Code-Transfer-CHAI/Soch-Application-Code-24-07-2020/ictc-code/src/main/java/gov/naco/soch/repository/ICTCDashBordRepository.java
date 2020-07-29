package gov.naco.soch.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.projection.InventoryProjection;
import gov.naco.soch.projection.StatisticsProjection;

@Repository
public interface ICTCDashBordRepository extends JpaRepository<Beneficiary, Long> {

	@Query(value = "select regclient_pw,regclient_gc,regclient_infant,hiv_pw,hiv_gc,hiv_infant,artlinked_pw,artlinked_gc,artlinked_infant, \r\n"
			+ "			(case when (artlinked_count = 0 or  artreferred_count = 0) then 0 when (artreferred_count>0) then cast((cast(artlinked_count as float)/cast(artlinked_count+artreferred_count as float))*100 as int8) end) as link_percentage\r\n"
			+ "			 from soch.summarydataictc(:facilityId)", nativeQuery = true)
	Object getSummaryData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn "
			+ "	JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id	"
			+ "   WHERE ibn.facility_id =:facilityId and ibn.referred_by=1 and bn.hiv_status_id = 2 and ibn.is_active = true and ibn.is_deleted = false"
			+ "   and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth ")
	List<BigInteger> getSelfInitiatedCountForPositive(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn "
			+ "	JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id	"
			+ "   WHERE ibn.facility_id =:facilityId and ibn.referred_by=1 and bn.hiv_status_id = 1 and ibn.is_active = true and ibn.is_deleted = false"
			+ "   and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth ")
	List<BigInteger> getSelfInitiatedCountForNegative(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn "
			+ "	JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id	"
			+ "   WHERE ibn.facility_id =:facilityId and ibn.referred_by=1 and bn.hiv_status_id = 3 and ibn.is_active = true and ibn.is_deleted = false"
			+ "   and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth ")
	List<BigInteger> getSelfInitiatedCountForIntermediate(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn "
			+ "   JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id"
			+ "   WHERE ibn.facility_id=:facilityId and ibn.referred_by<>1 and bn.hiv_status_id = 1 and ibn.is_active = true AND ibn.is_deleted = false"
			+ "    and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth ")
	List<BigInteger> getProviderInitiatedCountForNegative(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn "
			+ "   JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id"
			+ "   WHERE ibn.facility_id=:facilityId and ibn.referred_by<>1 and bn.hiv_status_id = 2 and ibn.is_active = true AND ibn.is_deleted = false"
			+ "   and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth ")
	List<BigInteger> getProviderInitiatedCountForPositive(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn "
			+ "   JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id"
			+ "   WHERE ibn.facility_id=:facilityId and ibn.referred_by<>1 and bn.hiv_status_id = 3 and ibn.is_active = true AND ibn.is_deleted = false"
			+ "    and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth ")
	List<BigInteger> getProviderInitiatedCountForIntermediate(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.beneficiary bn \r\n"
			+ "			    JOIN soch.ictc_beneficiary ibn on bn.id = ibn.beneficiary_id \r\n"
			+ "			    JOIN soch.ictc_visit ivs ON ibn.id = ivs.ictc_beneficiary_id\r\n"
			+ "			    JOIN soch.ictc_follow_up ifp  ON ifp.ictc_beneficiary_id = ivs.ictc_beneficiary_id\r\n"
			+ "			    WHERE ibn.facility_id=:facilityId and ifp.follow_up_date IS NOT null and ibn.is_active = true AND ibn.is_deleted = false\r\n"
			+ "			    and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth")
	List<BigInteger> getFollowupCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.beneficiary bn \r\n"
			+ "			    JOIN soch.ictc_beneficiary ibn on bn.id = ibn.beneficiary_id \r\n"
			+ "			    JOIN soch.ictc_visit ivs ON ibn.id = ivs.ictc_beneficiary_id\r\n"
			+ "			    JOIN soch.ictc_follow_up ifp  ON ifp.ictc_beneficiary_id = ivs.ictc_beneficiary_id\r\n"
			+ "			    WHERE ibn.facility_id=:facilityId and ifp.follow_up_date IS NOT null  and ifp.is_completed =true and ibn.is_active = true AND ibn.is_deleted = false\r\n"
			+ "			    and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth")
	List<BigInteger> getRepeatTestCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = " select count(ifw.ictc_beneficiary_id) from soch.ictc_follow_up ifw "
			+ " join soch.ictc_beneficiary ib on ib.id = ifw.ictc_beneficiary_id "
			+ " join soch.ictc_visit iv on iv.ictc_beneficiary_id = ib.id "
			+ " join soch.beneficiary b on b.id  = ib.beneficiary_id "
			+ " where ifw.follow_up_type=2  and ib.facility_id =:facilityId "
			+ " and iv.is_pregnant = false and b.category_id<> 1"
			+ " and ib.is_active = true AND ib.is_deleted = false "
			+ " and extract(YEAR FROM ifw.follow_up_date) =:filterYear "
			+ " and extract(MONTH FROM ifw.follow_up_date) =:filterMonth ", nativeQuery = true)
	int getPartnersFollowedUpGC(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = " select count(ifw.ictc_beneficiary_id) from soch.ictc_follow_up ifw "
			+ " join soch.ictc_beneficiary ib on ib.id = ifw.ictc_beneficiary_id "
			+ " join soch.ictc_visit iv on iv.ictc_beneficiary_id = ib.id "
			+ " join soch.beneficiary b on b.id  = ib.beneficiary_id "
			+ " where ifw.follow_up_type=2  and ib.facility_id =:facilityId"
			+ " and iv.is_pregnant = true and b.category_id<> 1 "
			+ " and ib.is_active = true AND ib.is_deleted = false "
			+ " and extract(YEAR FROM ifw.follow_up_date) = :filterYear "
			+ " and extract(MONTH FROM ifw.follow_up_date) = :filterMonth ", nativeQuery = true)
	int getPartnersFollowedUpPW(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = " 	 select count(distinct ibt.beneficiary_id ) from soch.ictc_follow_up ifw \r\n"
			+ "			 join soch.ictc_beneficiary ib on ib.id = ifw.ictc_beneficiary_id \r\n"
			+ "			 join soch.ictc_visit iv on iv.ictc_beneficiary_id = ib.id \r\n"
			+ "			 inner join beneficiary_family_details bfd on bfd.beneficiary_id  = ib.beneficiary_id \r\n"
			+ "			 inner join soch.ictc_beneficiary ibt  on ibt.beneficiary_id  = bfd.member_beneficiary_id inner join\r\n"
			+ "			 soch.ictc_test_result itrt on itrt.ictc_beneficiary_id  = ibt.id \r\n"
			+ "			 join soch.beneficiary b on b.id  = ib.beneficiary_id \r\n"
			+ "			 where ifw.follow_up_type=2 and ifw.is_active = false and ib.facility_id =:facilityId \r\n"
			+ "			 and iv.is_pregnant = false and b.category_id<>1 and itrt.tested_date is not null\r\n"
			+ "			 and ib.is_active = true AND ib.is_deleted = false \r\n"
			+ "			 and extract(YEAR FROM ifw.follow_up_date) =:filterYear \r\n"
			+ "			 and extract(MONTH FROM ifw.follow_up_date) =:filterMonth", nativeQuery = true)
	int getPartnersTestedGC(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	// ifw.created_time is considered for tested_date
	@Query(value = " 	 select count(distinct ibt.beneficiary_id ) from soch.ictc_follow_up ifw \r\n"
			+ "			 join soch.ictc_beneficiary ib on ib.id = ifw.ictc_beneficiary_id \r\n"
			+ "			 join soch.ictc_visit iv on iv.ictc_beneficiary_id = ib.id \r\n"
			+ "			 inner join beneficiary_family_details bfd on bfd.beneficiary_id  = ib.beneficiary_id \r\n"
			+ "			 inner join soch.ictc_beneficiary ibt  on ibt.beneficiary_id  = bfd.member_beneficiary_id inner join\r\n"
			+ "			 soch.ictc_test_result itrt on itrt.ictc_beneficiary_id  = ibt.id \r\n"
			+ "			 join soch.beneficiary b on b.id  = ib.beneficiary_id \r\n"
			+ "			 where ifw.follow_up_type=2 and ifw.is_active = false and ib.facility_id =:facilityId \r\n"
			+ "			 and iv.is_pregnant = true and b.category_id<>1 and itrt.tested_date is not null\r\n"
			+ "			 and ib.is_active = true AND ib.is_deleted = false \r\n"
			+ "			 and extract(YEAR FROM ifw.follow_up_date) =:filterYear \r\n"
			+ "			 and extract(MONTH FROM ifw.follow_up_date) =:filterMonth", nativeQuery = true)
	int getPartnersTestedPW(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT COUNT(distinct ibn.beneficiary_id) from soch.ictc_beneficiary ibn "
			+ "   JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id "
			+ "   WHERE ibn.facility_id=:facilityId and bn.category_id = 1 and bn.hiv_status_id = 2 and "
			+ "	  ibn.is_active = true and ibn.is_deleted = false"
			+ "   and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and  EXTRACT(MONTH FROM ibn.created_time) =:filterMonth  ")
	List<BigInteger> getConfirmedPositiveCount(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT COUNT(distinct ibn.beneficiary_id) from soch.ictc_beneficiary ibn "
			+ "   JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id"
			+ "   JOIN soch.ictc_test_result itr ON itr.ictc_beneficiary_id = ibn.id "
			+ "   WHERE ibn.facility_id=:facilityId and bn.category_id = 1 and  ibn.is_active = true and ibn.is_deleted = false"
			+ "   and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and  EXTRACT(MONTH FROM ibn.created_time) =:filterMonth")
	List<BigInteger> getTestedCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = " select count(distinct ib.beneficiary_id) from soch.ictc_test_result itr "
			+ " join soch.ictc_beneficiary ib on ib.id = itr.ictc_beneficiary_id "
			+ " join soch.beneficiary b on b.id  = ib.beneficiary_id "
			+ " join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id "
			+ " where itr.is_tested_for_syphilis = true "
			+ " and iv.is_pregnant = true and ib.is_active = true and ib.is_deleted = false and ib.facility_id = :facilityId "
			+ " and extract(YEAR FROM itr.tested_date) = :filterYear "
			+ " and extract(MONTH FROM itr.tested_date) = :filterMonth ", nativeQuery = true)
	List<BigInteger> getPWTestedForSyphilis(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = " select count(distinct ib.beneficiary_id) from soch.ictc_test_result itr "
			+ " join soch.ictc_beneficiary ib on ib.id = itr.ictc_beneficiary_id "
			+ " join soch.beneficiary b on b.id  = ib.beneficiary_id "
			+ " join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id "
			+ " where itr.is_tested_for_syphilis = true "
			+ " and iv.is_pregnant = false and ib.facility_id = :facilityId and ib.is_active = true and ib.is_deleted = false "
			+ " and extract(YEAR FROM itr.tested_date) = :filterYear "
			+ " and extract(MONTH FROM itr.tested_date) = :filterMonth ", nativeQuery = true)
	List<BigInteger> getGCTestedForSyphilis(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(distinct ib.beneficiary_id) from soch.ictc_beneficiary ib \r\n"
			+ "			 join soch.beneficiary b on b.id  = ib.beneficiary_id \r\n"
			+ "			 join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id \r\n"
			+ "			 join soch.ictc_test_result itr on ib.id  = itr.ictc_beneficiary_id \r\n"
			+ "			 where ib.on_syphilis_treatment = true and iv.is_pregnant = true  and ib.is_active = true and ib.is_deleted = false \r\n"
			+ "			 and ib.facility_id =:facilityId and extract(YEAR FROM itr.report_received_date) =:filterYear \r\n"
			+ "			 and extract(MONTH FROM itr.report_received_date ) =:filterMonth", nativeQuery = true)
	List<BigInteger> getPWTreatedForSyphilis(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(distinct ib.beneficiary_id) from soch.ictc_beneficiary ib \r\n"
			+ "			 join soch.beneficiary b on b.id  = ib.beneficiary_id \r\n"
			+ "			 join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id \r\n"
			+ "			 join soch.ictc_test_result itr on ib.id  = itr.ictc_beneficiary_id \r\n"
			+ "			 where ib.on_syphilis_treatment = true and iv.is_pregnant = false  and ib.is_active = true and ib.is_deleted = false \r\n"
			+ "			 and ib.facility_id =:facilityId and extract(YEAR FROM itr.report_received_date) =:filterYear \r\n"
			+ "			 and extract(MONTH FROM itr.report_received_date ) =:filterMonth", nativeQuery = true)
	List<BigInteger> getGCTreatedForSyphilis(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select COUNT(distinct ib.beneficiary_id )  from beneficiary b  inner join ictc_beneficiary ib on b.id = ib.beneficiary_id \r\n"
			+ "			  	inner join ictc_visit iv on iv.ictc_beneficiary_id  = ib.id where iv.is_pregnant = true and iv.delivery_outcome in (1,2,3) and ib.facility_id =:facilityId\r\n"
			+ "			 	and ib.is_active = true and b.hiv_status_id = 2 and ib.is_deleted = false AND EXTRACT(YEAR FROM iv.delivery_date) =:filterYear \r\n"
			+ "			    and EXTRACT(MONTH FROM iv.delivery_date) =:filterMonth")
	List<BigInteger> getPositiveMotherCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select  count(distinct ibi.beneficiary_id ) from beneficiary b  inner join ictc_beneficiary ib on b.id = ib.beneficiary_id \r\n"
			+ "			  	inner join ictc_visit iv on iv.ictc_beneficiary_id  = ib.id inner join beneficiary_family_details bfd on bfd.beneficiary_id  = b.id\r\n"
			+ "			  	inner join beneficiary bi on bi.id = bfd.member_beneficiary_id inner join ictc_beneficiary ibi on ibi.beneficiary_id  = bi.id \r\n"
			+ "			  	inner join ictc_visit ivi on ivi.ictc_beneficiary_id  = ibi.id \r\n"
			+ "			  	where iv.is_pregnant = true and b.hiv_status_id  = 2 and iv.delivery_outcome in (1,2,3) and ib.facility_id =:facilityId and bi.category_id =1 and EXTRACT(YEAR FROM ivi.visit_date ) =  extract(YEAR FROM(iv.delivery_date + interval '6 week'))\r\n"
			+ "			    and EXTRACT(MONTH FROM ivi.visit_date) = extract(MONTH FROM(iv.delivery_date + interval '6 week'))\r\n"
			+ "			    and EXTRACT(WEEK FROM ivi.visit_date) = extract(WEEK FROM(iv.delivery_date + interval '6 week'))\r\n"
			+ "			    and ib.is_active = true and ib.is_deleted = false AND EXTRACT(YEAR FROM iv.delivery_date ) =:filterYear \r\n"
			+ "			    and EXTRACT(MONTH FROM iv.delivery_date) =:filterMonth and ib.is_deleted =false and ibi.is_deleted =false")
	List<BigInteger> getSixWeekInfantCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b "
			+ "		inner join soch.ictc_beneficiary ib on b.id = ib.beneficiary_id"
			+ "       inner join soch.facility f on ib.facility_id  = f.id "
			+ "       inner join soch.ictc_test_result ts on ts.ictc_beneficiary_id  = ib.id"
			+ "       inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id"
			+ "       inner join soch.master_tb_result tr on tr.id = ts.tb_test_result "
			+ "       where ib.facility_id=:facilityId and  ts.is_tested_for_tb  = true and iv.is_pregnant = false and tr.id = 1 and tr.id in(select tb_test_result from ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 ) and ib.is_active = true and ib.is_deleted = false"
			+ "       and EXTRACT(YEAR FROM ts.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM ts.report_delivery_date) =:filterMonth  ")
	List<BigInteger> getpulmonaryMicroTBCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b "
			+ "	inner join soch.ictc_beneficiary ib on b.id = ib.beneficiary_id "
			+ "   inner join soch.facility f on ib.facility_id  = f.id "
			+ "   inner join soch.ictc_test_result ts on ts.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.master_tb_result tr on tr.id = ts.tb_test_result "
			+ "   where  ib.facility_id=:facilityId and ts.is_tested_for_tb  = true and iv.is_pregnant = false and tr.id = 2 and ib.is_active = true and ib.is_deleted = false"
			+ " and tr.id in(select tb_test_result from ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 )"
			+ "   and EXTRACT(YEAR FROM ts.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM ts.report_delivery_date) =:filterMonth ")
	List<BigInteger> getpulmonaryClinicalTBCount(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b "
			+ "	inner join soch.ictc_beneficiary ib  on b.id = ib.beneficiary_id"
			+ "	inner join soch.facility f on ib.facility_id  = f.id "
			+ "   inner join soch.ictc_test_result ts on ts.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.master_tb_result tr on tr.id = ts.tb_test_result "
			+ "   where ib.facility_id=:facilityId and  ts.is_tested_for_tb  = true and iv.is_pregnant = false and tr.id = 3 and ib.is_active = true and ib.is_deleted = false "
			+ " and tr.id in(select tb_test_result from ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 )"
			+ "   and EXTRACT(YEAR FROM ts.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM ts.report_delivery_date) =:filterMonth")
	List<BigInteger> getextraPulmonaryMicroCount(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b "
			+ "	inner join soch.ictc_beneficiary ib  on b.id = ib.beneficiary_id"
			+ "	inner join soch.facility f on ib.facility_id  = f.id "
			+ "   inner join soch.ictc_test_result ts on ts.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.master_tb_result tr on tr.id = ts.tb_test_result "
			+ "   where ib.facility_id=:facilityId and  ts.is_tested_for_tb  = true and iv.is_pregnant = false and tr.id = 4 and ib.is_active = true and ib.is_deleted = false "
			+ " and tr.id in(select tb_test_result from ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 )"
			+ "   and EXTRACT(YEAR FROM ts.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM ts.report_delivery_date) =:filterMonth")
	List<BigInteger> getextraPulmonaryClinicalCount(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b "
			+ "   inner join soch.ictc_beneficiary ib on b.id = ib.beneficiary_id "
			+ "	inner join soch.facility f on ib.facility_id  = f.id \r\n"
			+ "   inner join soch.ictc_test_result ts on ts.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.master_tb_result tr on tr.id = ts.tb_test_result"
			+ "   where ib.facility_id=:facilityId and ts.is_tested_for_tb  = true and iv.is_pregnant = true and tr.id = 1 and ib.is_active = true and ib.is_deleted = false"
			+ " and tr.id in(select tb_test_result from ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 )"
			+ "   and EXTRACT(YEAR FROM ts.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM ts.report_delivery_date) =:filterMonth")
	List<BigInteger> getpulmonaryMicroTBCountForPW(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b inner join soch.ictc_beneficiary ib "
			+ "	on b.id = ib.beneficiary_id inner join soch.facility f on ib.facility_id  = f.id "
			+ "   inner join soch.ictc_test_result ts on ts.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id"
			+ "   inner join soch.master_tb_result tr on tr.id = ts.tb_test_result "
			+ "   where ib.facility_id=:facilityId and ts.is_tested_for_tb  = true and iv.is_pregnant = true and tr.id = 2"
			+ " and tr.id in(select tb_test_result from ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 )"
			+ "   and EXTRACT(YEAR FROM ts.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM ts.report_delivery_date) =:filterMonth and ib.is_active = true and ib.is_deleted = false")
	List<BigInteger> getpulmonaryClinicalTBCountForPW(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b "
			+ "	inner join soch.ictc_beneficiary ib on b.id = ib.beneficiary_id"
			+ "	inner join soch.facility f on ib.facility_id  = f.id \r\n"
			+ "   inner join soch.ictc_test_result ts on ts.ictc_beneficiary_id  = ib.id\r\n"
			+ "   inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id\r\n"
			+ "   inner join soch.master_tb_result tr on tr.id = ts.tb_test_result \r\n"
			+ "   where ib.facility_id=:facilityId and ts.is_tested_for_tb  = true and iv.is_pregnant = true and tr.id =3 and ib.is_active = true and ib.is_deleted = false \r\n"
			+ " and tr.id in(select tb_test_result from ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 )"
			+ "   and EXTRACT(YEAR FROM ts.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM ts.report_delivery_date) =:filterMonth")
	List<BigInteger> getextraPulmonaryMicroCountForPW(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b "
			+ "	inner join soch.ictc_beneficiary ib on b.id = ib.beneficiary_id"
			+ "	inner join soch.facility f on ib.facility_id  = f.id \r\n"
			+ "   inner join soch.ictc_test_result ts on ts.ictc_beneficiary_id  = ib.id\r\n"
			+ "   inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id\r\n"
			+ "   inner join soch.master_tb_result tr on tr.id = ts.tb_test_result \r\n"
			+ "   where ib.facility_id=:facilityId and ts.is_tested_for_tb  = true and iv.is_pregnant = true and tr.id =4 and ib.is_active = true and ib.is_deleted = false \r\n"
			+ " and tr.id in(select tb_test_result from ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 )"
			+ "   and EXTRACT(YEAR FROM ts.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM ts.report_delivery_date) =:filterMonth")
	List<BigInteger> getextraPulmonaryClinicCountForPW(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',fsa.date_of_addition_or_consupmtion),'MONTH') AS name,\r\n"
			+ "		 sum(fsa.testing_quantity) AS value  from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "					 inner join product p on p.id = fsa.product_id \r\n"
			+ "					 where  f.id =:facilityId and p.id = 1 GROUP BY 1")
	List<StatisticsProjection> getHIVFirstKITConsumptionData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',fsa.date_of_addition_or_consupmtion),'MONTH') AS name,\r\n"
			+ "		 sum(fsa.testing_quantity) AS value  from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "					 inner join product p on p.id = fsa.product_id \r\n"
			+ "					 where  f.id =:facilityId and p.id = 2 GROUP BY 1")
	List<StatisticsProjection> getHIVSecondKITConsumptionData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',fsa.date_of_addition_or_consupmtion),'MONTH') AS name,\r\n"
			+ "		 sum(fsa.testing_quantity) AS value  from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "					 inner join product p on p.id = fsa.product_id \r\n"
			+ "					 where  f.id =:facilityId and p.id = 3 GROUP BY 1")
	List<StatisticsProjection> getHIVThirdKITConsumptionData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',fsa.date_of_addition_or_consupmtion),'MONTH') AS name,\r\n"
			+ "		 sum(fsa.testing_quantity) AS value  from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "					 inner join product p on p.id = fsa.product_id \r\n"
			+ "					 where  f.id =:facilityId and p.id = 11 GROUP BY 1")
	List<StatisticsProjection> getSyphilisFirstKITConsumptionData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select coalesce (sum(adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd  \r\n"
			+ "			 inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sd.product_id  \r\n"
			+ "			where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' and \r\n"
			+ "			 sd.date_of_addition_or_consupmtion < date_trunc('month', now()) and f.id  =:facilityId and p.id = 1) as AverageCount , \r\n"
			+ "			 (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda \r\n"
			+ "		 inner join soch.facility f on f.id = sda.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sda.product_id  where f.id =:facilityId and p.id = 1) as TotalQuantity")
	InventoryProjection getHIVFirstKITdata(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select  coalesce (sum(adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd  \r\n"
			+ "			 inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sd.product_id  \r\n"
			+ "			where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' and \r\n"
			+ "			 sd.date_of_addition_or_consupmtion < date_trunc('month', now()) and f.id  = :facilityId and p.id = 2) as AverageCount , \r\n"
			+ "			 (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda \r\n"
			+ "		 inner join soch.facility f on f.id = sda.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sda.product_id  where f.id =:facilityId and p.id = 2) as TotalQuantity ")
	InventoryProjection getHIVSecondKITdata(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select  coalesce (sum(adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd  \r\n"
			+ "			 inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sd.product_id  \r\n"
			+ "			where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' and \r\n"
			+ "			 sd.date_of_addition_or_consupmtion < date_trunc('month', now()) and f.id  =:facilityId and p.id = 3) as AverageCount , \r\n"
			+ "			 (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda \r\n"
			+ "		 inner join soch.facility f on f.id = sda.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sda.product_id  where f.id =:facilityId and p.id =3) as TotalQuantity ")
	InventoryProjection getHIVThirdKITdata(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select coalesce (sum(adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd  \r\n"
			+ "			 inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sd.product_id  \r\n"
			+ "			where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' and \r\n"
			+ "			 sd.date_of_addition_or_consupmtion < date_trunc('month', now()) and f.id  =:facilityId and p.id = 11) as AverageCount , \r\n"
			+ "			 (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda \r\n"
			+ "		 inner join soch.facility f on f.id = sda.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sda.product_id  where f.id =:facilityId and p.id = 11) as TotalQuantity ")
	InventoryProjection getSyphilisFirstKITdata(@Param("facilityId") Long facilityId);

}
