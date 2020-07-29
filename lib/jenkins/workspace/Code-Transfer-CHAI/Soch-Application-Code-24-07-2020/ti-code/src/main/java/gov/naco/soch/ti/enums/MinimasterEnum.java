package gov.naco.soch.ti.enums;

import java.util.HashMap;
import java.util.Map;

public enum MinimasterEnum {

    GENDER("soch.master_gender"), HRG_SECONDARY("soch.master_hrg_secondary"),
    MARITAL_STATUS("soch.master_marital_status"), MIGRANT_OCCUPATION("soch.master_migrant_occupation"),
    MASTER_EDUCATION_LEVEL("soch.master_education_level"), MASTER_OCCUPATION("soch.master_occupation"),
    MASTER_REG_DONE_AT("soch.master_registration_done_at"),
    MASTER_DESTINATION_DURATION("soch.master_destination_duration"), MASTER_STAYING_WITH("soch.master_staying_with"),
    MOBILITY_TYPE("soch.master_mobility_type"), TI_BEN_STATUS("soch.master_client_status_ticore"),
    OST_BEN_STATUS("soch.master_client_status_ost");

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
