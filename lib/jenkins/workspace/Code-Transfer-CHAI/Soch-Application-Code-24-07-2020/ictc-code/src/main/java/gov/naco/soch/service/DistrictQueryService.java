package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// for static metamodels
import gov.naco.soch.domain.District;
import gov.naco.soch.domain.District_;
import gov.naco.soch.repository.DistrictRepository;
import gov.naco.soch.service.dto.DistrictCriteria;
import gov.naco.soch.service.dto.DistrictDTO;
import gov.naco.soch.service.mapper.DistrictMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link District} entities in the database.
 * The main input is a {@link DistrictCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link DistrictDTO} or a {@link Page} of {@link DistrictDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class DistrictQueryService extends QueryService<District> {

    private final Logger log = LoggerFactory.getLogger(DistrictQueryService.class);

    private final DistrictRepository districtRepository;

    private final DistrictMapper districtMapper;

    public DistrictQueryService(DistrictRepository districtRepository, DistrictMapper districtMapper) {
        this.districtRepository = districtRepository;
        this.districtMapper = districtMapper;
    }

    /**
     * Return a {@link List} of {@link DistrictDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<DistrictDTO> findByCriteria(DistrictCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<District> specification = createSpecification(criteria);
        return districtMapper.toDto(districtRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link DistrictDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<DistrictDTO> findByCriteria(DistrictCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<District> specification = createSpecification(criteria);
        return districtRepository.findAll(specification, page)
            .map(districtMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(DistrictCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<District> specification = createSpecification(criteria);
        return districtRepository.count(specification);
    }

    /**
     * Function to convert {@link DistrictCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<District> createSpecification(DistrictCriteria criteria) {
        Specification<District> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), District_.id));
            }
            if (criteria.getAlternateName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAlternateName(), District_.alternateName));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), District_.name));
            }
        }
        return specification;
    }
}
