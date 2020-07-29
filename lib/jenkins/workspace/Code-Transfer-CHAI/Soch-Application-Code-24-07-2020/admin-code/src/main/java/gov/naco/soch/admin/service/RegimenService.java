package gov.naco.soch.admin.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.RegimenConstituentDto;
import gov.naco.soch.dto.RegimenDto;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.Regimen;
import gov.naco.soch.entity.RegimenConstituent;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.mapper.RegimenMapper;
import gov.naco.soch.repository.ProductRepository;
import gov.naco.soch.repository.RegimenRepository;
import gov.naco.soch.util.CommonConstants;

@Service
@Transactional
public class RegimenService {

	@Autowired
	RegimenRepository regimenRepository;

	@Autowired
	ProductRepository productRepository;

	private static final Logger logger = LoggerFactory.getLogger(RegimenService.class);

	/*
	 * Save product
	 */
	public boolean saveRegimen(@RequestBody RegimenDto regimenDto) {
		regimenDto.setRegimenName(regimenDto.getRegimenName().trim());
		logger.debug("Entering into method saveRegimen with productDto->{}:", regimenDto);
		Regimen regimen = null;
		int count = 0;
		if (regimenDto.getId() != null && regimenDto.getId() > 0) {
			count = regimenRepository.countRegimentInEdit(regimenDto.getRegimenName(), regimenDto.getId());
			if (count != 0) {
				String errorfield = "Regimen Name";
				throwError(errorfield, regimenDto.getRegimenName());
			}
			regimen = regimenRepository.findById(regimenDto.getId()).get();
			if (regimen.getRegimenConstituents() != null && !regimen.getRegimenConstituents().isEmpty()) {
				regimen.getRegimenConstituents().clear();
			}
		} else {
			count = regimenRepository.countRegimentInAdd(regimenDto.getRegimenName());
			if (count != 0) {
				String errorfield = "Regimen Name";
				throwError(errorfield, regimenDto.getRegimenName());
			}
		}
		regimen = RegimenMapper.mapToRegimen(regimenDto, regimen);

		if (regimenDto.getRegimenConstituentList() != null && !regimenDto.getRegimenConstituentList().isEmpty()) {
			Set<RegimenConstituent> regimenConstituentSet = new HashSet<RegimenConstituent>();
			for (RegimenConstituentDto regimenConstituentDto : regimenDto.getRegimenConstituentList()) {
				RegimenConstituent regimenConstituent = new RegimenConstituent();
				Product product = productRepository.findById(regimenConstituentDto.getProductId()).get();
				regimenConstituent.setProduct(product);
				if (product.getProductUomMaster() != null) {
					regimenConstituent.setProductUomMaster(product.getProductUomMaster());
				}
				regimenConstituent.setQuantity(regimenConstituentDto.getQuantity());
				regimenConstituent.setIsActive(true);
				regimenConstituent.setIsDelete(false);
				regimenConstituent.setRegimen(regimen);
				regimenConstituentSet.add(regimenConstituent);
			}
			if (regimen.getRegimenConstituents() == null) {
				regimen.setRegimenConstituents(new HashSet<RegimenConstituent>());
			}
			regimen.getRegimenConstituents().addAll(regimenConstituentSet);
		}

		regimenRepository.save(regimen);
		logger.debug("Leaving from method saveRegimen with regimenDto->{}:", regimenDto);
		return true;
	}

	/*
	 * Get all regimens
	 */
	public List<RegimenDto> getRegimens() {

		List<Regimen> regimens = regimenRepository.findAll();
		List<RegimenDto> regimenDtoList = new ArrayList<>();
		RegimenDto regimenDto = null;
		if (regimens != null && !regimens.isEmpty()) {
			for (Regimen regimen : regimens) {
				regimenDto = RegimenMapper.mapToRegimenDto(regimen);
				regimenDtoList.add(regimenDto);
			}
		}
		return regimenDtoList;

	}

	/*
	 * Delete product.
	 */
	public boolean deleteRegimen(Long regimenId) {

		Regimen regimen = regimenRepository.findById(regimenId).get();
		regimen.setIsDelete(true);
		if (!regimen.getRegimenConstituents().isEmpty()) {
			regimen.getRegimenConstituents().forEach(action -> {
				action.setIsDelete(Boolean.TRUE);
				action.setRegimen(regimen);
			});
		}
		regimenRepository.save(regimen);
		return true;

	}

	public List<RegimenDto> regimenAdvanceSearch(Map<String, String> searchValue) {
		String searchQuery = RegimenMapper.advanceSearchQueryCreator(searchValue);
		List<Regimen> regimens = regimenRepository.regimenAdvanceSearch(searchQuery);
		List<RegimenDto> regimenDtoList = new ArrayList<>();
		RegimenDto regimenDto = null;
		if (regimens != null && !regimens.isEmpty()) {
			for (Regimen regimen : regimens) {
				regimenDto = RegimenMapper.mapToRegimenDto(regimen);
				regimenDtoList.add(regimenDto);
			}
		}
		return regimenDtoList;
	}

	// Method to throw error
	private void throwError(String errorfield, String errorFieldValue) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(Constants.DUPLICATE_FOUND + "'" + errorFieldValue + "'");
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(CommonConstants.VALIDATION_FAILED, errorDtoList,
				detailsSimplified);
		throw new ServiceException(Constants.DUPLICATE_FOUND + " '" + errorFieldValue + "' ", errorResponse,
				HttpStatus.BAD_REQUEST);
	}

}
