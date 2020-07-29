package gov.naco.soch.ti.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gov.naco.soch.entity.TIHotspot;
import gov.naco.soch.repository.TIHotspotRepository;
import gov.naco.soch.ti.dto.TIHotspotDto;
import gov.naco.soch.ti.mapper.TiHotSpotsMapper;

@Service
@Transactional
public class TiHotSpotServiceImpl {

	private final Logger log = LoggerFactory.getLogger(TiHotSpotServiceImpl.class);

	private final TIHotspotRepository tiHotspotRepository;

	private final TiHotSpotsMapper tiHotSpotsMapper;

	public TiHotSpotServiceImpl(TIHotspotRepository tiHotspotRepository, TiHotSpotsMapper tiHotSpotsMapper) {
		this.tiHotspotRepository = tiHotspotRepository;
		this.tiHotSpotsMapper = tiHotSpotsMapper;
	}

	public TIHotspotDto save(TIHotspotDto tiHotspotDto) {
		log.debug(" request to save a  hotspot : {}", tiHotspotDto);
		TIHotspot tiHotspot = tiHotSpotsMapper.toEntity(tiHotspotDto);
		tiHotspot = tiHotspotRepository.save(tiHotspot);
		return tiHotSpotsMapper.toDto(tiHotspot);
	}

	public TIHotspotDto update(TIHotspotDto tiHotspotDto) {
		Optional<TIHotspot> hotspot = tiHotspotRepository.findById(tiHotspotDto.getId());
		if (hotspot.isPresent()) {
			TIHotspot tiHotspot = tiHotSpotsMapper.toEntity(tiHotspotDto);
			tiHotspot = tiHotspotRepository.save(tiHotspot);
			return tiHotSpotsMapper.toDto(tiHotspot);
		}
		return null;
	}

	public boolean delete(Long hotspotId) {
		Optional<TIHotspot> hotspot = tiHotspotRepository.findById(hotspotId);
		if (hotspot.isPresent()) {
			TIHotspot tiHotspot = hotspot.get();
			tiHotspot.setIsDelete(true);
			tiHotspotRepository.save(tiHotspot);
		}
		return true;
	}

	public boolean validateHotSpotName(String hotspotName, Long facilityId) {
		return tiHotspotRepository.existsByHotspotNameAndIsDeleteAndFacilityId(hotspotName, false, facilityId);

	}

	public boolean validateHotSpotCode(String hotspotCode, Long facilityId) {
		return tiHotspotRepository.existsByHotspotCodeAndIsDeleteAndFacilityId(hotspotCode, false, facilityId);

	}

	public boolean validateHotSpotNameForExisting(String hotspotName, Long hotspotId, Long facilityId) {
		return tiHotspotRepository.existsByHotspotNameAndIsDeleteAndFacilityIdAndIdNot(hotspotName, false, facilityId,
				hotspotId);

	}

	public boolean validateHotSpotCodeForExisting(String hotspotCode, Long hotspotId, Long facilityId) {
		return tiHotspotRepository.existsByHotspotCodeAndIsDeleteAndFacilityIdAndIdNot(hotspotCode, false, facilityId,
				hotspotId);

	}

}
