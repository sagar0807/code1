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

import gov.naco.soch.domain.Address;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.AddressRepository;
import gov.naco.soch.service.dto.AddressCriteria;
import gov.naco.soch.service.dto.AddressDTO;
import gov.naco.soch.service.mapper.AddressMapper;

/**
 * Service for executing complex queries for {@link Address} entities in the database.
 * The main input is a {@link AddressCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AddressDTO} or a {@link Page} of {@link AddressDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AddressQueryService extends QueryService<Address> {

    private final Logger log = LoggerFactory.getLogger(AddressQueryService.class);

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public AddressQueryService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    /**
     * Return a {@link List} of {@link AddressDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<AddressDTO> findByCriteria(AddressCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Address> specification = createSpecification(criteria);
        return addressMapper.toDto(addressRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link AddressDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AddressDTO> findByCriteria(AddressCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Address> specification = createSpecification(criteria);
        return addressRepository.findAll(specification, page)
            .map(addressMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AddressCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Address> specification = createSpecification(criteria);
        return addressRepository.count(specification);
    }

    /**
     * Function to convert {@link AddressCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Address> createSpecification(AddressCriteria criteria) {
        Specification<Address> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Address_.id));
            }
            if (criteria.getAddress() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddress(), Address_.address));
            }
            if (criteria.getBlock() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBlock(), Address_.block));
            }
            if (criteria.getCity() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCity(), Address_.city));
            }
            if (criteria.getGeoLatitude() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGeoLatitude(), Address_.geoLatitude));
            }
            if (criteria.getGeoLongitude() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGeoLongitude(), Address_.geoLongitude));
            }
            if (criteria.getHouseNo() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHouseNo(), Address_.houseNo));
            }
            if (criteria.getPincode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPincode(), Address_.pincode));
            }
            if (criteria.getTaluk() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTaluk(), Address_.taluk));
            }
            if (criteria.getStateId() != null) {
                specification = specification.and(buildSpecification(criteria.getStateId(),
                    root -> root.join(Address_.state, JoinType.LEFT).get(State_.id)));
            }
            if (criteria.getDistrictId() != null) {
                specification = specification.and(buildSpecification(criteria.getDistrictId(),
                    root -> root.join(Address_.district, JoinType.LEFT).get(District_.id)));
            }
        }
        return specification;
    }
}
