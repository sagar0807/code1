package gov.naco.soch.ti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.FacilitySettingDto;
import gov.naco.soch.entity.FacilitySetting;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.FacilitySettingRepository;
import gov.naco.soch.ti.mapper.FacilitySettingMapper;

//FacilitySettingService class interact data with database
@Transactional
@Service
public class FacilitySettingService {

	@Autowired
	private FacilitySettingRepository facilitySettingRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	// method to add facilitySetting details into facility_setting details table
	public void addFacilitySetting(FacilitySettingDto facilitySettingDto) {

		facilitySettingDto.setIsActive(true);

		FacilitySetting facilitySetting = new FacilitySetting();
		facilitySetting = FacilitySettingMapper.mapFacilitySettingDtoToFacilitySetting(facilitySettingDto);

		// if no record found, add as new record
		if (facilitySetting.getId() == null) {

			facilityRepository.findByDSRC();
			facilityRepository.findByRNTCP();
			facilityRepository.findByICTC();
			facilityRepository.findByTI();

			facilitySettingRepository.save(facilitySetting);

			facilitySettingDto.setId(facilitySetting.getId());
		}

		// if record is found update the record to new default values
		else {
			facilitySettingRepository.findById(facilitySettingDto.getId()).get();

			facilityRepository.findByDSRC();
			facilityRepository.findByRNTCP();
			facilityRepository.findByICTC();
			facilityRepository.findByTI();

			facilitySettingRepository.save(facilitySetting);

			facilitySettingDto.setId(facilitySetting.getId());
		}
	}

}
