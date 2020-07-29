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
public class ProfileUpdateService  {

    private final TiProfileUpdateRepository profileUpdateRepo;
    private final ProfileUpdateMapper profileUpdateMapper;

    ProfileUpdateService(TiProfileUpdateRepository profileUpdateRepo, ProfileUpdateMapper profileUpdateMapper) {
	this.profileUpdateRepo = profileUpdateRepo;
	this.profileUpdateMapper = profileUpdateMapper;
    }

    public ProfileUpdateDto save(ProfileUpdateDto profileUpdateDto) {
	TiProfileUpdate profileUpdate = profileUpdateMapper.toEntity(profileUpdateDto);
	profileUpdate = profileUpdateRepo.save(profileUpdate);
	return profileUpdateMapper.toDto(profileUpdate);
    }

}
