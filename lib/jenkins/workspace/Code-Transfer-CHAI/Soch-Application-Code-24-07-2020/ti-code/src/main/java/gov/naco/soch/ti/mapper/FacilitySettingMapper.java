package gov.naco.soch.ti.mapper;

import gov.naco.soch.dto.FacilitySettingDto;
import gov.naco.soch.entity.FacilitySetting;
import gov.naco.soch.util.DateUtil;

public class FacilitySettingMapper {

	// Mapper class to map DTO (FacilitySettingDto) class to entity
	// (FacilitySetting)
	public static FacilitySetting mapFacilitySettingDtoToFacilitySetting(FacilitySettingDto facilitySettingDto) {
		FacilitySetting facilitySetting = new FacilitySetting();

		facilitySetting.setCreatedTime(DateUtil.getCurrentUTCDateTime());
		facilitySetting.setIsActive(facilitySettingDto.getIsActive());
		facilitySetting.setIsDelete(false);
		facilitySetting.setModifiedTime(DateUtil.getCurrentUTCDateTime());

		facilitySetting.setDsrcDefault(facilitySettingDto.getDsrcDefault());
		facilitySetting.setRntcpDefault(facilitySettingDto.getRntcpDefault());
		facilitySetting.setIctcDefault(facilitySettingDto.getIctcDefault());
		facilitySetting.setTiDefault(facilitySettingDto.getTiDefault());
		facilitySetting.setId(facilitySettingDto.getId());

		return facilitySetting;
	}

}
