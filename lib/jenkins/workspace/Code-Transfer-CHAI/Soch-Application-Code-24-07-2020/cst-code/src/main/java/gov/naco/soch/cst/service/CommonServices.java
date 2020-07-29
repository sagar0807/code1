package gov.naco.soch.cst.service;

import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.FacilityDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.mapper.FacilityMapperUtil;
import gov.naco.soch.repository.FacilityRepository;

@Transactional
@Service
public class CommonServices {
	@Autowired
	private FacilityRepository facilityRepository;

	private static final Logger logger = LoggerFactory.getLogger(CommonServices.class);

	public List<FacilityDto> getFacilityListByDistrictId(Long districtId) {
		logger.debug("getFacilityListByDistrictId method is invoked");
		List<Facility> facilityList = facilityRepository.findFacilitiesByDistrictId(districtId);
		List<FacilityDto> facilityDtoList = FacilityMapperUtil.mapToFacilityDtoList(facilityList);
		return facilityDtoList;
	}

}
