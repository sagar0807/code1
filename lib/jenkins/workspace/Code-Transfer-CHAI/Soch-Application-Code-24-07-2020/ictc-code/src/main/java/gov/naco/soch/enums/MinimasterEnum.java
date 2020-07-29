package gov.naco.soch.enums;

import java.util.HashMap;
import java.util.Map;

public enum MinimasterEnum {

    GENDER("soch.master_gender"),
    HRG_SECONDARY("soch.master_hrg_secondary"),
    MARITAL_STATUS("soch.master_marital_status"), 
    MIGRANT_OCCUPATION("soch.master_migrant_occupation"),
    MASTER_EDUCATION_LEVEL("soch.master_education_level"), 
    MASTER_OCCUPATION("soch.master_occupation"),
    MASTER_REG_DONE_AT("soch.master_registration_done_at"),
    MASTER_DESTINATION_DURATION("soch.master_destination_duration"), 
    MASTER_STAYING_WITH("soch.master_staying_with"),
    MOBILITY_TYPE("soch.master_mobility_type"), 
    TI_BEN_STATUS("soch.master_client_status_ticore"),
    OST_BEN_STATUS("soch.master_client_status_ost"),
    ARV_PROPHYLAXIS("soch.master_arv_prophylaxis"),
    INFANT_BREAST_FED("soch.master_infant_breast_feed"), 
    REFERRED_BY("soch.master_referredby"),
    PREG_TYPE_OF_CASE("soch.master_pregnancy_type_case"),
    ROUTE_OF_TRANS("soch.master_route_of_transmission"),
    NOT_TESTING_REASON("soch.master_not_testing_reason"),
    TB_RESULT("soch.master_tb_result"), 
    SYPHILIS_STATUS("soch.master_syphilis_status"),
    HIV_STATUS("soch.master_hiv_status"),
    HIV_TYPE("soch.master_hiv_type"),
    FOLLOW_UP_TYPE("soch.master_ictc_follow_up_type"),
    ICTC_BENEFICIARY_STATUS("soch.master_ictc_beneficiary_status"), 
    PARTNER_STATUS("soch.master_partner_status"),
    DELIVERY_OUTCOME("soch.master_delivery_outcome"),
    SAMPLE_COLLECTION_STATUS("soch.master_sample_collection_status"),
    REFERRAL_STATUS("soch.master_referral_status"),
    BENEFICIARY_CATEGORY("soch.master_beneficiary_category"),
//    TEST_TYPE("soch.master_test_type"),
//    BATCH_STATUS("soch.master_batch_status"),
//    DBS_RESULT_STATUS("soch.master_result_status"),
	RELATION_TYPE("soch.master_relationship"),
	DELETE_REASON("soch.master_delete_reason");
    private final String table;
    
    private static final Map<String, MinimasterEnum> lookup = new HashMap<String, MinimasterEnum>();

    MinimasterEnum(String table) {
	this.table = table;
    }

    public String getTable() {
	return this.table;
    }

  

    static {
	for (MinimasterEnum d : MinimasterEnum.values()) {
	    lookup.put(d.getTable(), d);
	}
    }

    public static MinimasterEnum get(String table) {
	return lookup.get(table);
    }

}
