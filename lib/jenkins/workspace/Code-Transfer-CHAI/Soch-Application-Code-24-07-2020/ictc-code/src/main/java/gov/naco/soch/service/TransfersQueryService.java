package gov.naco.soch.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import gov.naco.soch.domain.Transfers;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.TransfersRepository;
import gov.naco.soch.service.dto.TransfersCriteria;
import gov.naco.soch.service.dto.TransfersDTO;
import gov.naco.soch.service.mapper.TransfersMapper;

/**
 * Service for executing complex queries for {@link Transfers} entities in the database.
 * The main input is a {@link TransfersCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TransfersDTO} or a {@link Page} of {@link TransfersDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TransfersQueryService extends QueryService<Transfers> {

    private final Logger log = LoggerFactory.getLogger(TransfersQueryService.class);

    private final TransfersRepository transfersRepository;

    private final TransfersMapper transfersMapper;

    public TransfersQueryService(TransfersRepository transfersRepository, TransfersMapper transfersMapper) {
        this.transfersRepository = transfersRepository;
        this.transfersMapper = transfersMapper;
    }

    /**
     * Return a {@link List} of {@link TransfersDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TransfersDTO> findByCriteria(TransfersCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Transfers> specification = createSpecification(criteria);
        return transfersMapper.toDto(transfersRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TransfersDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TransfersDTO> findByCriteria(TransfersCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Transfers> specification = createSpecification(criteria);
        return transfersRepository.findAll(specification, page)
            .map(transfersMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TransfersCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Transfers> specification = createSpecification(criteria);
        return transfersRepository.count(specification);
    }

    /**
     * Function to convert {@link TransfersCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Transfers> createSpecification(TransfersCriteria criteria) {
        Specification<Transfers> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Transfers_.id));
            }
            if (criteria.getSourceFacilityType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSourceFacilityType(), Transfers_.sourceFacilityType));
            }
            if (criteria.getTransferStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTransferStatus(), Transfers_.transferStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHivStatus(), Transfers_.hivStatus));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), Transfers_.category));
            }
            if (criteria.getRemarks() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRemarks(), Transfers_.remarks));
            }
            if (criteria.getInitiationDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInitiationDate(), Transfers_.initiationDate));
            }
            if (criteria.getDestinationFacilityType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDestinationFacilityType(), Transfers_.destinationFacilityType));
            }
            if (criteria.getDsrcCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDsrcCode(), Transfers_.dsrcCode));
            }
            if (criteria.getTiCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTiCode(), Transfers_.tiCode));
            }
            if (criteria.getArtCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getArtCode(), Transfers_.artCode));
            }
            if (criteria.getOstCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOstCode(), Transfers_.ostCode));
            }
            if (criteria.getPidCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPidCode(), Transfers_.pidCode));
            }
            if (criteria.getReportingDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportingDate(), Transfers_.reportingDate));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), Transfers_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), Transfers_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), Transfers_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), Transfers_.modifiedTime));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), Transfers_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), Transfers_.isDeleted));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(Transfers_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
            }
            if (criteria.getSourceFacilityId() != null) {
                specification = specification.and(buildSpecification(criteria.getSourceFacilityId(),
                    root -> root.join(Transfers_.sourceFacility, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getDestinationFacilityId() != null) {
                specification = specification.and(buildSpecification(criteria.getDestinationFacilityId(),
                    root -> root.join(Transfers_.destinationFacility, JoinType.LEFT).get(Facility_.id)));
            }
        }
        return specification;
    }
}
