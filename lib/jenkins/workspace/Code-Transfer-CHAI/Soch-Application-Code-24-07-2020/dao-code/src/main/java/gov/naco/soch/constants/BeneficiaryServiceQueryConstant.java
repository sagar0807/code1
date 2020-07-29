package gov.naco.soch.constants;

public final class BeneficiaryServiceQueryConstant {

	public static final String SERVICE_ASSESSMENT_QUERY = "select '1' as serviceTypeId , ta.assessment_date  as dateone, ta.due_date_of_assessment as datetwo,\r\n"
			+ "	case when ta.due_date_of_assessment = (select max(due_date_of_assessment) from ti_ben_rv_assessment ta inner join ti_beneficiary tb on tb.id  = ta.beneficiary_id  where tb.beneficiary_id = :beneficiaryId )\r\n"
			+ "	then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent, ta.condom_requirement_per_week as eventdataone,ta.needles_syringes_requirement_per_week as eventdatatwo,\r\n"
			+ "	ta.needles_syringes_requirement_per_week as eventdatathree,null  as eventdatafour,null as eventdatafive from ti_ben_rv_assessment ta inner join ti_beneficiary tb on tb.id  = ta.beneficiary_id  where tb.beneficiary_id = :beneficiaryId \r\n"
			+ "	group by serviceTypeId,ta.assessment_date,ta.due_date_of_assessment,ta.condom_requirement_per_week,ta.needles_syringes_requirement_per_week";

	public static final String SERVICE_COMMODITY_DISTRIBUTE_QUERY = "select '2' as serviceTypeId, (case when tbc.condoms_distributed >0 then tbc.created_time else null end ) as dateone,null as datetwo ,false as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent ,\r\n"
			+ "					coalesce(condoms_distributed,0)  as eventdataone,\r\n"
			+ "					 coalesce(syringes_distributed,0) as eventdatatwo, coalesce(needles_distributed,0) eventdatathree , mct.name  as eventdatafour,tm.typology_name as eventdatafive\r\n"
			+ "					from ti_beneficiary_comm_dis tbc inner join ti_beneficiary tb on tb.id  = tbc.beneficiary_id left join typology_master tm on tm.typology_id  = tb.master_hrg_primary_id\r\n"
			+ "					left join master_contact_type mct on mct.id = tbc.master_contact_type_id\r\n"
			+ "					where tb.beneficiary_id =  :beneficiaryId";

	public static final String SERVICE_COUNSELLING_QUERY = "select '3' as serviceTypeId , tc.counselling_date as dateone, tc.next_counselling_date as datetwo,\r\n"
			+ "				case when tc.next_counselling_date = (select max(tbc.next_counselling_date) from ti_ben_counselling tbc inner join ti_beneficiary tob on tob.id  = tbc.beneficiary_id where tob.beneficiary_id = :beneficiaryId )\r\n"
			+ "				then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent , string_agg(mct.name , '; ')   as eventdataone , tc.no_of_condoms_distributed as  eventdatatwo,\r\n"
			+ "			null as eventdatathree,null as eventdatafour,null as eventdatafive from ti_ben_counselling tc inner join ti_beneficiary tob on tob.id  = tc.beneficiary_id\r\n"
			+ "			left join ti_ben_counselling_type ct on tc.id = ct.counselling_id left join master_counselling_type mct on ct.master_counselling_type_id  = mct.id \r\n"
			+ "			where tob.beneficiary_id = :beneficiaryId group by serviceTypeId,tc.counselling_date,tc.next_counselling_date,tc.no_of_condoms_distributed";

	public static final String SERVICE_CLINICAL_TREAT_QUERY = "select '4' as serviceTypeId , tt.follow_up_date  as dateone, tt.next_follow_up_date as datetwo,\r\n"
			+ "			case when next_follow_up_date = (select max(next_follow_up_date) from ti_sti_treatment tt inner join ti_beneficiary tb on tb.id  = tt.beneficiary_id  where tb.beneficiary_id = :beneficiaryId )\r\n"
			+ "			then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,null as eventdataone, mdt.\"name\" as eventdatatwo,mkt.\"name\" as eventdatathree,null as eventdatafour,null as eventdatafive\r\n"
			+ "			from ti_sti_treatment tt inner join ti_beneficiary tb on tb.id  = tt.beneficiary_id\r\n"
			+ "			left join master_diagnosis_type mdt on mdt.id = tt.master_diagnosis_type_id left join master_kit_type mkt on mkt.id  = tt.master_kit_type_id \r\n"
			+ "			where tb.beneficiary_id = :beneficiaryId group by serviceTypeId,tt.follow_up_date,tt.next_follow_up_date,mdt.\"name\",mkt.\"name\"";

	public static final String SERVICE_SCREENING = "select '5' as serviceTypeId , tbs.date_of_screening  as dateone, tbs.next_date_of_screening as datetwo,case when next_date_of_screening = (select max(tbs.next_date_of_screening) from ti_ben_scr_details tbs\r\n"
			+ "							inner join ti_beneficiary tb on tb.id  = tbs.beneficiary_id  where tb.beneficiary_id = :beneficiaryId )\r\n"
			+ "							then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent , it.name as eventdataone,(case when tbs.screening_status_hiv_id is not null then hss.name\r\n"
			+ "							when tbs.screening_status_syphilis_id is not null then ss.name when tbs.tb_status_id 	is not null then tbss.name end)as eventdatatwo ,\r\n"
			+ "							null as eventdatathree,null as eventdatafour, null as eventdatafive from ti_ben_scr_details tbs inner join ti_beneficiary tb on tb.id  = tbs.beneficiary_id \r\n"
			+ "							left join master_infection_type it on it.id = tbs.infection_id left join master_hiv_screening_status hss on tbs.screening_status_hiv_id  = hss.id left join \r\n"
			+ "							master_syphilis_status ss on ss.id = tbs.screening_status_syphilis_id left join master_tb_screening_status tbss on tbss.id = tbs.tb_status_id \r\n"
			+ "						 	where tb.beneficiary_id = :beneficiaryId group by serviceTypeId,tbs.date_of_screening,tbs.next_date_of_screening,it.name\r\n"
			+ "							,tbs.screening_status_hiv_id,hss.name,tbs.screening_status_syphilis_id ,ss.name,tbs.tb_status_id,tbss.name";

	public static final String SERVICE_OST_ASSESSMENT_QUERY = "select '6' as serviceTypeId , tio.date_of_assessment  as dateone, tio.next_date_of_assessment as datetwo,\r\n"
			+ "				case when tio.next_date_of_assessment = (select max(next_date_of_assessment) from ti_ost_assessment o inner join ti_ost_beneficiary tob on o.ti_ost_beneficiary_id  = tob.id  where tob.beneficiary_id  = :beneficiaryId)\r\n"
			+ "				then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,tio.diagnosis as eventdataone,tio.advice as eventdatatwo,null as eventdatathree,null as eventdatafour,\r\n"
			+ "				null as eventdatafive from ti_ost_assessment tio inner join ti_ost_beneficiary tob on tio.ti_ost_beneficiary_id  = tob.id  where tob.beneficiary_id  = :beneficiaryId\r\n"
			+ "				group by serviceTypeId,tio.date_of_assessment,tio.next_date_of_assessment,tio.diagnosis,tio.advice";

	public static final String SERVICE_OST_FOLLOW_QUERY = "select '7' as serviceTypeId , tof.follow_up_date  as dateone, tof.next_followup_date as datetwo,\r\n"
			+ "			case when tof.next_followup_date = (select max(next_followup_date)  from ti_ost_follow_up o inner join ti_ost_beneficiary tob  on o.ti_ost_beneficiary_id  = tob.id where tob.beneficiary_id  = :beneficiaryId)\r\n"
			+ "			then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,null as eventdataone,null as eventdatatwo,null as eventdatathree,null as eventdatafour,\r\n"
			+ "			null as eventdatafive 	from ti_ost_follow_up tof inner join ti_ost_beneficiary tob  on tof.ti_ost_beneficiary_id  = tob.id where\r\n"
			+ "			tob.beneficiary_id  = :beneficiaryId group by serviceTypeId,tof.follow_up_date,tof.next_followup_date";

	public static final String SERVICE_OST_DISPENSE_QUERY = "select tod.actual_dispensation_date  as dateone,'8' as serviceTypeId  , null as datetwo,\r\n"
			+ "							false as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,p.product_name as eventdataone,\r\n"
			+ "							tod.dispensed_qty as eventdatatwo,null as eventdatathree,null as eventdatafour,\r\n"
			+ "							null as eventdatafive from ti_ost_dispensation_item tod\r\n"
			+ "							left join product p on p.id = tod.substitution_drug inner join ti_ost_beneficiary tob on tob.id = tod.ti_ost_beneficiary_id \r\n"
			+ "							where tob.beneficiary_id  = :beneficiaryId and tob.is_active  = true";

	public static final String TI_REFERRAL = "select '9' as serviceTypeId,br.refer_date as dateone ,null as datetwo ,false as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,\r\n"
			+ "						ft.facility_type_name  as eventdataone ,f.\"name\" as eventdatatwo,null as eventdatathree, null as eventdatafour, null as eventdatafive\r\n"
			+ "						from beneficiary b inner join ti_beneficiary tb on b.id = tb.beneficiary_id	inner join beneficiary_referral br on b.id = br.beneficiary_id \r\n"
			+ "						inner join facility f on f.id = br.refered_to inner join facility_type ft on ft.id = f.facility_type_id \r\n"
			+ "						where br.refered_from = :facilityId and tb.beneficiary_id  = :beneficiaryId";

	public static final String OST_REFERRAL = "select '10' as serviceTypeId,br.refer_date as dateone ,null as datetwo ,false as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,\r\n"
			+ "						ft.facility_type_name  as eventdataone ,f.\"name\" as eventdatatwo,null as eventdatathree, null as eventdatafour, null as eventdatafive\r\n"
			+ "						from beneficiary b inner join ti_ost_beneficiary tob on b.id = tob.beneficiary_id	inner join beneficiary_referral br on b.id = br.beneficiary_id \r\n"
			+ "						inner join facility f on f.id = br.refered_to inner join facility_type ft on ft.id = f.facility_type_id \r\n"
			+ "						where br.refered_from = :facilityId and tob.beneficiary_id  = :beneficiaryId";

}
