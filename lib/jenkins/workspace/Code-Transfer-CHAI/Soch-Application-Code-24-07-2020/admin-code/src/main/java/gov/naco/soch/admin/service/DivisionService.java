package gov.naco.soch.admin.service;

import java.text.DecimalFormat;
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

import gov.naco.soch.dto.DivisionDto;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.entity.Division;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.FacilityTypeDivisionMapping;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.mapper.DivisionMapperUtil;
import gov.naco.soch.repository.DivisionFacilitytypeMappingRepository;
import gov.naco.soch.repository.DivisionRepository;
import gov.naco.soch.repository.FacilityTypeRepository;

/**
 * Service class that handle division related methods
 *
 */
@Transactional
@Service
public class DivisionService {

	@Autowired
	private DivisionRepository divisionRepository;

	@Autowired
	private DivisionFacilitytypeMappingRepository divisionFacilityTypeRepository;

	@Autowired
	private FacilityTypeRepository facilityTypeRepo;

	private static final Logger logger = LoggerFactory.getLogger(DivisionService.class);

	/**
	 * Method to fetch all divisions
	 */
	public List<DivisionDto> getAllDivision() {
		// listing all values from division table
		logger.debug("In getAllDivision() of DivisionService");
		List<Division> divisionList = divisionRepository.findByIsDeleteOrderByIdAsc(false);
		List<DivisionDto> divisionDtoList = DivisionMapperUtil.mapToDivisionDtoList(divisionList);
		return divisionDtoList;
	}

	/**
	 * Method to delete a specific division based on its ID. Note: This is only a
	 * logical deletion
	 */
	public Boolean deleteDivision(Long divisionId) {
		logger.debug("In deleteDivision() of DivisionService");
		int count = divisionRepository.findDeleteUser(divisionId);
		if (count == 0 && divisionId > 10) {
			Division division = divisionRepository.findById(divisionId).get();
			division.setIsDelete(true);
			division.getFacilityTypeDivisionMappings().forEach(x -> {
				x.setIsDelete(true);
			});

			divisionRepository.save(division);
			return Boolean.TRUE;
		} else {

			return Boolean.FALSE;
		}
	}

	/**
	 * Method to Add/Edit a division
	 */
	public DivisionDto saveDivision(DivisionDto divisionDto) {
		logger.debug("In saveDivision() of DivisionService");
		int count = 0;
		boolean isEdit = false;
		Division division = new Division();

		if (divisionDto.getId() != null && divisionDto.getId() != 0) {
			count = divisionRepository.existsByNameInEdit(divisionDto.getName(), divisionDto.getId());
			isEdit = true;
		}

		else {
			count = divisionRepository.existsByOtherNameInEdit(divisionDto.getName());

		}

		if (count != 0) {
			logger.error(Constants.DUPLICATE_FOUND);
			String errorfield = "name";
			throwError(errorfield, divisionDto.getName());
		}

		if (isEdit) {
			division = divisionRepository.findById(divisionDto.getId()).get();
		}
		divisionDto.setIsDelete(false);
		division = DivisionMapperUtil.mapToDivision(divisionDto, division);

		Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappingList = new HashSet<>();
		for (Long facilityTypeDivisionMappingId : divisionDto.getFacilityTypeIds()) {
			FacilityTypeDivisionMapping facilityTypeDivisionMapping = new FacilityTypeDivisionMapping();
			FacilityType facilityType = facilityTypeRepo.findById(facilityTypeDivisionMappingId).get();
			facilityTypeDivisionMapping.setFacilityType(facilityType);
			facilityTypeDivisionMapping.setIsDelete(false);
			facilityTypeDivisionMapping.setDivision(division);
			facilityTypeDivisionMappingList.add(facilityTypeDivisionMapping);

		}
		if (isEdit) {
			divisionFacilityTypeRepository.deleteInBatch(division.getFacilityTypeDivisionMappings());
		}
		division.setFacilityTypeDivisionMappings(facilityTypeDivisionMappingList);
		divisionRepository.save(division);
		// auto generate DIVISION code after saving a division based on its primary key
		// https://www.java67.com/2014/10/how-to-pad-numbers-with-leading-zeroes-in-Java-example.html
		DecimalFormat df = new DecimalFormat("0000");
		String divisionCode = "DIV" + df.format(division.getId());
		division.setCode(divisionCode);
		divisionRepository.save(division);
		divisionDto.setCode(division.getCode());
		divisionRepository.save(division);

		divisionDto.setId(division.getId());
		if(!isEdit)
		divisionDto.setId(null);
		return divisionDto;

	}

	/**
	 * Division advance search with criteria: facilityType, name, code
	 * 
	 * @param searchValue
	 * @return
	 */
	public List<DivisionDto> divisonAdvanceSearch(Map<String, String> searchValue) {
		// listing all values from division table
		logger.debug("In divisonAdvanceSearch() of DivisionService");
		String searchQuery = DivisionMapperUtil.divisionAdvanceSearchQueryCreator(searchValue);
		List<Division> divisionList = divisionRepository.divisionAdvanceSearch(searchQuery);
		List<DivisionDto> divisionDtoList = DivisionMapperUtil.mapToDivisionDtoList(divisionList);
		return divisionDtoList;
	}

	/**
	 * Method to throw error in case of validation errors
	 * 
	 * @param errorfield
	 * @param errorFieldValue
	 */
	private void throwError(String errorfield, String errorFieldValue) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(Constants.DUPLICATE_FOUND + "'" + errorFieldValue + "'");
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
		throw new ServiceException(Constants.DUPLICATE_FOUND + " '" + errorFieldValue + "' ", errorResponse,
				HttpStatus.BAD_REQUEST);
	}

}
