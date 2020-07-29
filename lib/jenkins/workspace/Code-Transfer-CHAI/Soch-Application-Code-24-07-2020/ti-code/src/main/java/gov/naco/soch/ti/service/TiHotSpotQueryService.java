package gov.naco.soch.ti.service;

import java.util.Optional;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.entity.TIHotspot;
import gov.naco.soch.entity.TIHotspot_;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.TIHotspotRepository;
import gov.naco.soch.ti.dto.TIHotspotDto;
import gov.naco.soch.ti.dto.TiHotspotCriteria;
import gov.naco.soch.ti.mapper.TiHotSpotsMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.LongFilter;

@Service
@Transactional(readOnly = true)
public class TiHotSpotQueryService extends QueryService<TIHotspot> {

	private final Logger log = LoggerFactory.getLogger(TiHotSpotQueryService.class);

	private final TIHotspotRepository tiHotspotRepository;

	private final TiHotSpotsMapper tiHotSpotsMapper;

	private final FacilityRepository facilityRepository;

	public TiHotSpotQueryService(TIHotspotRepository tiHotspotRepository, FacilityRepository facilityRepository,
			TiHotSpotsMapper tiHotSpotsMapper) {
		this.tiHotspotRepository = tiHotspotRepository;
		this.facilityRepository = facilityRepository;
		this.tiHotSpotsMapper = tiHotSpotsMapper;
	}

	public Page<TIHotspotDto> findByCriteria(TiHotspotCriteria criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<TIHotspot> specification = createSpecification(criteria);
		return tiHotspotRepository.findAll(specification, pageable).map(tiHotSpotsMapper::toDto);

	}

	private Specification<TIHotspot> createSpecification(TiHotspotCriteria criteria) {
		Specification<TIHotspot> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), TIHotspot_.id));
			}
			if (criteria.getIsActive() != null) {
				specification = specification.and(buildSpecification(criteria.getIsActive(), TIHotspot_.isActive));
			}
			if (criteria.getIsDelete() != null) {
				specification = specification.and(buildSpecification(criteria.getIsDelete(), TIHotspot_.isDelete));
			}
			if (criteria.getHotspotCode() != null) {
				specification = specification
						.and(buildStringSpecification(criteria.getHotspotCode(), TIHotspot_.hotspotCode));
			}
			if (criteria.getHotspotName() != null) {
				specification = specification
						.and(buildStringSpecification(criteria.getHotspotName(), TIHotspot_.hotspotName));
			}
			if (criteria.getHotspotStatus() != null) {
				specification = specification
						.and(buildStringSpecification(criteria.getHotspotStatus(), TIHotspot_.hotspotStatus));
			}
			if (criteria.getFacilityId() != null) {
				specification = specification.and(buildSpecification(criteria.getFacilityId(),
						root -> root.join(TIHotspot_.facility, JoinType.LEFT).get(Facility_.id)));
			}
			if (criteria.getOstFacilityId() != null) {

				Optional<Facility> facility = facilityRepository.findById(criteria.getOstFacilityId().getEquals());
				if (facility.isPresent()) {
					if (facility.get().getTiCenter() != null) {
						Long tiCentreId = facility.get().getTiCenter().getId();
						LongFilter tiCentre = new LongFilter();
						tiCentre.setEquals(tiCentreId);
						specification = specification.and(buildSpecification(tiCentre,
								root -> root.join(TIHotspot_.facility, JoinType.LEFT).get(Facility_.id)));
					}
				}
			}

			if (criteria.getTypologyId() != null) {
				specification = specification.and(buildSpecification(criteria.getTypologyId(),
						root -> root.join(TIHotspot_.typology, JoinType.LEFT).get(TypologyMaster_.typologyId)));

			}

		}
		return specification;

	}
}
