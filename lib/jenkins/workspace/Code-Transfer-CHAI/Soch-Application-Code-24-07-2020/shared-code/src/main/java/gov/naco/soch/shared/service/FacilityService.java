package gov.naco.soch.shared.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.shared.dto.FacilityListResponseDTO;
import gov.naco.soch.shared.mapper.FacilityMapper;

@Service
@Transactional
public class FacilityService {

	private final Logger log = LoggerFactory.getLogger(FacilityService.class);

	private final FacilityRepository facilityRepository;
	
	private final FacilityMapper facilityMapper;

	public FacilityService(FacilityRepository facilityRepository,FacilityMapper facilityMapper) {
		this.facilityRepository = facilityRepository;
		this.facilityMapper = facilityMapper;
	}

	public List<FacilityListResponseDTO> getFacilitiesByFacilityType(Long facilityType) {
		List<Facility> facilities = facilityRepository.findByFacilityType_IdAndIsDelete(facilityType,false);
		return facilityMapper.toDto(facilities);
	}

}
