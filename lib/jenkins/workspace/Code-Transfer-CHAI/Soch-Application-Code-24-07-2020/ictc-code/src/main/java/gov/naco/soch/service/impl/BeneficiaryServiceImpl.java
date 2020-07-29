package gov.naco.soch.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.service.mapper.BeneficiaryMapper;

/**
 * Service Implementation for managing {@link Beneficiary}.
 */
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	private final Logger log = LoggerFactory.getLogger(BeneficiaryServiceImpl.class);

	private final BeneficiaryRepository beneficiaryRepository;

	private final BeneficiaryMapper beneficiaryMapper;

	public BeneficiaryServiceImpl(BeneficiaryRepository beneficiaryRepository, BeneficiaryMapper beneficiaryMapper) {
		this.beneficiaryRepository = beneficiaryRepository;
		this.beneficiaryMapper = beneficiaryMapper;
	}

	/**
	 * Save a beneficiary.
	 *
	 * @param beneficiaryDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public BeneficiaryDTO save(BeneficiaryDTO beneficiaryDTO) {
		log.debug("Request to save Beneficiary : {}", beneficiaryDTO);
		Beneficiary beneficiary = beneficiaryMapper.toEntity(beneficiaryDTO);
		beneficiary = beneficiaryRepository.save(beneficiary);
		return beneficiaryMapper.toDto(beneficiary);
	}
	
	/**
	 * Save a beneficiary.
	 *
	 * @param beneficiaryDTO the entity to save.
	 * @return the persisted entity.
	 */
	public Beneficiary saveBeneficiary(Beneficiary beneficiary) {
		log.debug("Request to save Beneficiary : {}", beneficiary);
		return beneficiaryRepository.save(beneficiary);
	}

	/**
	 * Get all the beneficiaries.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<BeneficiaryDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Beneficiaries");
		return beneficiaryRepository.findAll(pageable).map(beneficiaryMapper::toDto);
	}

	/**
	 * Get one beneficiary by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<BeneficiaryDTO> findOne(Long id) {
		log.debug("Request to get Beneficiary : {}", id);
		return beneficiaryRepository.findById(id).map(beneficiaryMapper::toDto);

	}
	
	/**
	 * Get one beneficiary by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Transactional(readOnly = true)
	public Optional<Beneficiary> find(Long id) {
		log.debug("Request to get Beneficiary : {}", id);
		return beneficiaryRepository.findById(id);

	}

	/**
	 * Get one beneficiary by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	public BeneficiaryDTO getOne(Long id) {
		log.debug("Request to get Beneficiary : {}", id);
		return beneficiaryMapper.toDto(beneficiaryRepository.getOne(id));

	}

	/**
	 * Delete the beneficiary by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Beneficiary : {}", id);
		beneficiaryRepository.deleteById(id);
	}
}
