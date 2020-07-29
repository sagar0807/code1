package gov.naco.soch.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ICTCDashBoardConstant {

	public static final Map<Integer, String> CHART_COMPONENT_MAP;
	public static final Map<Integer, String> CHART_COMPONENT_FILTER_MAP;

	static {
		Map<Integer, String> componentMap = new HashMap<Integer, String>();
		componentMap.put(1, "{componentId:1,name:'registeredClients',title:'Registered Clients',isFilter:true}");
		componentMap.put(2, "{componentId:2,name:'testedPositiveclients',title:'Tested +ve Clients',isFilter:true}");
		componentMap.put(3, "{componentId:3,name:'artLinked',title:'ART LINKED',isFilter:true}");
		componentMap.put(4, "{componentId:4,name:'artLinkedPercentage',title:'ART LINKED PERCENTAGE',isFilter:false}");
		CHART_COMPONENT_MAP = Collections.unmodifiableMap(componentMap);
		Map<Integer, String> filterMap = new HashMap<Integer, String>();
		filterMap.put(0, "{chartId:1,name:'pw',title:'PW'}");
		filterMap.put(1, "{chartId:1,name:'gc',title:'GC'}");
		filterMap.put(2, "{chartId:1,name:'infant',title:'INFANT'}");
		filterMap.put(3, "{chartId:2,name:'pw',title:'PW'}");
		filterMap.put(4, "{chartId:2,name:'gc',title:'GC'}");
		filterMap.put(5, "{chartId:2,name:'infant',title:'INFANT'}");
		filterMap.put(6, "{chartId:3,name:'pw',title:'PW'}");
		filterMap.put(7, "{chartId:3,name:'gc',title:'GC'}");
		filterMap.put(8, "{chartId:3,name:'infant',title:'INFANT'}");
		filterMap.put(9, "{chartId:4,name:'',title:''}");
		CHART_COMPONENT_FILTER_MAP = Collections.unmodifiableMap(filterMap);
	}

	public static final String ICTC_SUMMARY_QUERY = " select (select\r\n" + "      count(ib.id)  \r\n" + "   from\r\n"
			+ "      soch.ictc_beneficiary ib inner join soch.beneficiary b on b.id  = ib.beneficiary_id left join \r\n"
			+ "      soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id \r\n" + "   where\r\n"
			+ "      ib.facility_id = :facilityId and iv.is_pregnant = true) as regclient_pw,\r\n"
			+ "        (select\r\n" + "      count(ib.id)  \r\n" + "   from\r\n"
			+ "      soch.ictc_beneficiary ib inner join soch.beneficiary b on b.id  = ib.beneficiary_id left join \r\n"
			+ "      soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id \r\n" + "   where\r\n"
			+ "      ib.facility_id = :facilityId and iv.is_pregnant = false) as regclient_gc,\r\n" + "    ( select\r\n"
			+ "      count(ib.id)  \r\n" + "   from\r\n"
			+ "      soch.ictc_beneficiary ib inner join soch.beneficiary b on b.id  = ib.beneficiary_id  \r\n"
			+ "   where\r\n" + "      ib.facility_id = :facilityId and b.category  = 'Infant')as regclient_infant,\r\n"
			+ "    ( select\r\n" + "      count(ib.id) \r\n" + "   from\r\n"
			+ "   		soch.ictc_beneficiary ib inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n"
			+ "      left join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id \r\n"
			+ "      left join soch.master_hiv_status mhs on b.hiv_status_id  = mhs.id \r\n" + "   where\r\n"
			+ "      ib.facility_id = :facilityId and mhs.id = 2 and iv.is_pregnant = true) as hiv_pw,\r\n"
			+ "     \r\n" + "          (select\r\n" + "      count(ib.id) \r\n" + "   from\r\n"
			+ "   		soch.ictc_beneficiary ib inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n"
			+ "      left join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id \r\n"
			+ "      left join soch.master_hiv_status mhs on b.hiv_status_id  = mhs.id \r\n" + "   where\r\n"
			+ "      ib.facility_id = :facilityId and mhs.id = 2 and iv.is_pregnant = false) as hiv_gc,\r\n"
			+ "     \r\n" + "          (select\r\n" + "      count(ib.id) \r\n" + "   from\r\n"
			+ "   		soch.ictc_beneficiary ib inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n"
			+ "      left join soch.master_hiv_status mhs on b.hiv_status_id  = mhs.id \r\n" + "   where\r\n"
			+ "      ib.facility_id = :facilityId and mhs.id = 2 and b.category  = 'Infant') as hiv_infant";
}
