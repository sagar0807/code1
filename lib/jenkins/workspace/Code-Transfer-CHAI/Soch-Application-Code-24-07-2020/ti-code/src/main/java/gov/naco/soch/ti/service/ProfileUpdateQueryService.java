package gov.naco.soch.ti.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.naco.soch.entity.TiProfileUpdate;
import gov.naco.soch.entity.TiProfileUpdate_;
import gov.naco.soch.repository.TiProfileUpdateRepository;
import gov.naco.soch.ti.dto.ProfileUpdateCriteria;
import gov.naco.soch.ti.dto.ProfileUpdateDto;
import gov.naco.soch.ti.mapper.ProfileUpdateMapper;
import io.github.jhipster.service.QueryService;
@Service
@Transactional
public class ProfileUpdateQueryService extends QueryService<TiProfileUpdate>  {
    
    private final TiProfileUpdateRepository profileUpdateRepo;
    private final ProfileUpdateMapper profileUpdateMapper;

    ProfileUpdateQueryService(TiProfileUpdateRepository profileUpdateRepo, ProfileUpdateMapper profileUpdateMapper) {
	this.profileUpdateRepo = profileUpdateRepo;
	this.profileUpdateMapper = profileUpdateMapper;
    }
    
    public Page<ProfileUpdateDto> findByCriteria(ProfileUpdateCriteria criteria, Pageable pageable) {
   	final Specification<TiProfileUpdate> specification = createSpecification(criteria);
   	return profileUpdateRepo.findAll(specification, pageable).map(profileUpdateMapper::toDto);
       }

       private Specification<TiProfileUpdate> createSpecification(ProfileUpdateCriteria criteria) {
   	Specification<TiProfileUpdate> specification = Specification.where(null);
   	if (criteria != null) {
   	    if (criteria.getIsDelete() != null) {
   		specification = specification.and(buildSpecification(criteria.getIsDelete(), TiProfileUpdate_.isDelete));
   	    }
   	    if (criteria.getFacilityId() != null) {
   	  		specification = specification.and(buildSpecification(criteria.getFacilityId(), TiProfileUpdate_.facilityId));
   	  	    }
   	    if (criteria.getMonth() != null) {
   	  		specification = specification.and(buildSpecification(criteria.getMonth(), TiProfileUpdate_.month));
   	  	    }
   	  if (criteria.getYear() != null) {
	  		specification = specification.and(buildSpecification(criteria.getYear(), TiProfileUpdate_.year));
	  	    }
   	}
   	return specification;
       }


}
