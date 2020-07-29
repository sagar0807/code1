package gov.naco.soch.inventory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.IndentDto;
import gov.naco.soch.dto.IndentProductDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.Contract;
import gov.naco.soch.entity.ContractProduct;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.Indent;
import gov.naco.soch.entity.IndentProduct;
import gov.naco.soch.entity.IndentProductSchedule;
import gov.naco.soch.entity.IndentProductScheduleSac;
import gov.naco.soch.entity.IndentProductScheduleSacsLot;
import gov.naco.soch.entity.IndentStatusMaster;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.inventory.mapper.IndentMapperUtil;
import gov.naco.soch.repository.ContractRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.IndentProductRepository;
import gov.naco.soch.repository.IndentRepository;
import gov.naco.soch.util.UserUtils;

@Service
public class IndentService {

	@Autowired
	private IndentRepository indentRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private IndentProductRepository indentProductRepository;

	private static final Logger logger = LoggerFactory.getLogger(IndentService.class);

	public List<IndentDto> getAllIndentDetails(Long facilityId) {
		logger.debug("In getAllIndentDetails() of IndentService");
		List<Indent> indents = new ArrayList<Indent>();
		List<IndentDto> indentDtos = new ArrayList<>();
		Optional<Facility> facilityOptional = facilityRepository.findById(facilityId);
		LoginResponseDto userDetails = UserUtils.getLoggedInUserDetails();
		if (facilityOptional.isPresent()) {
			Facility facility = facilityOptional.get();
			if (facility.getFacilityType().getId() == FacilityTypeEnum.NACO.getFacilityType()) {
				if(userDetails.getAccessCodes().contains("DIVISION-ADMIN-INDENT")) {
					indents = indentRepository
							.findAllByCreatedByAndIsDeleteOrderByIndentIdDesc(userDetails.getUserId(), false);
				}else {
					List<Long> indentStatusMasterIds = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L, 5L,6L));
					indents = indentRepository
							.findAllByCreatedByOrIndentStatusMaster_IdInAndIsDeleteOrderByIndentIdDesc(
									userDetails.getUserId(), indentStatusMasterIds, false);
				}
			} else if (facility.getFacilityType().getId() == FacilityTypeEnum.PROCUREMENT_AGENT.getFacilityType()) {
				indents = indentRepository.findAllByIndentStatusMaster_IdOrderByIndentIdDesc(5L);
			}
			indentDtos = IndentMapperUtil.mapIndentToIndentDto(indents);
			// indentDtos = findisAllContractCreated(indentDtos);
		} else {
			throw new ServiceException("Invalid facility Id", null, HttpStatus.BAD_REQUEST);
		}

		return indentDtos;
	}

	public IndentDto saveIndent(IndentDto indentDto) {
		logger.debug("In saveIndent() of IndentService");
		Indent indent;
		if (indentDto.getIndentId() == null) {
			Indent existingIndent = indentRepository.findByIndentNumber(indentDto.getIndentNumber());
			if (existingIndent != null) {
				throw new ServiceException("Indent Number already exists", null, HttpStatus.BAD_REQUEST);
			}
			indent = new Indent();
		} else {
			Indent existingIndent = indentRepository.findByIndentNumber(indentDto.getIndentNumber());
			if (existingIndent != null && existingIndent.getIndentId() != indentDto.getIndentId()) {
				throw new ServiceException("Indent Number already exists", null, HttpStatus.BAD_REQUEST);
			}
			Optional<Indent> indentOptional = indentRepository.findById(indentDto.getIndentId());
			indent = indentOptional.get();
			if (!CollectionUtils.isEmpty(indent.getIndentProducts())) {
				indent.getIndentProducts().clear();
			}
		}
		indent = IndentMapperUtil.mapIndentDtoToIndent(indentDto, indent);
		indentRepository.save(indent);
		return indentDto;
	}

	public Boolean updateIndentStatus(Long indentId, String status) {
		logger.debug("In updateIndentStatus() of IndentService");
		IndentStatusMaster indentStatusMaster = new IndentStatusMaster();

		if (status.equalsIgnoreCase("approve")) {
			indentStatusMaster.setId(2L);
		} else if (status.equalsIgnoreCase("reject")) {
			indentStatusMaster.setId(3L);
		} else if (status.equalsIgnoreCase("close")) {
			indentStatusMaster.setId(4L);
		} else if (status.equalsIgnoreCase("push")) {
			indentStatusMaster.setId(5L);
		}else if (status.equalsIgnoreCase("submit")) {
			indentStatusMaster.setId(6L);
		}
		Optional<Indent> indentOptional = indentRepository.findById(indentId);
		if (indentOptional.isPresent() && indentStatusMaster.getId() != null) {
			Indent indent = indentOptional.get();
			indent.setIndentStatusMaster(indentStatusMaster);
			indentRepository.save(indent);
			return true;
		}

		return false;
	}

	public List<IndentDto> getAllIndentNumbers() {
		List<Indent> indents = indentRepository.findAllByIsDelete(false);
		List<IndentDto> indentDtoList = new ArrayList<IndentDto>();
		indents.forEach(indent -> {
			IndentDto indentDto = new IndentDto();
			indentDto.setIndentId(indent.getIndentId());
			indentDto.setIndentNumber(indent.getIndentNumber());
			indentDtoList.add(indentDto);
		});
		return indentDtoList;
	}

	public Boolean deleteIndent(Long indentId) {
		Optional<Indent> indentOptional = indentRepository.findById(indentId);
		if (indentOptional.isPresent()) {
			Indent indent = indentOptional.get();
			indent.setIsDelete(true);
			for (IndentProduct indentProduct : indent.getIndentProducts()) {
				indentProduct.setIsDelete(true);
				for (IndentProductSchedule indentProductSchedule : indentProduct.getIndentProductSchedules()) {
					indentProductSchedule.setIsDelete(true);
					for (IndentProductScheduleSac indentProductScheduleSac : indentProductSchedule
							.getIndentProductScheduleSacs()) {
						indentProductScheduleSac.setIsDelete(true);
						for (IndentProductScheduleSacsLot indentProductScheduleSacsLot : indentProductScheduleSac
								.getIndentProductSceduleSacsLots()) {
							indentProductScheduleSacsLot.setIsDelete(true);
						}
					}
				}
			}
			indentRepository.save(indent);
			return true;
		}
		return false;
	}

	public IndentDto getAllToBecreatedContractProducts(String indentNumber) {
		Indent indent = new Indent();
		IndentDto indents = new IndentDto();
		Set<IndentProduct> indentProducts = new HashSet<IndentProduct>();
		List<Long> contractProductIds = contractRepository
				.findAllIndentProductsPendingForContractCreation(indentNumber);
		if (!contractProductIds.isEmpty()) {
			indent = indentRepository.findByIndentNumber(indentNumber);
			indentProducts = indentProductRepository.findAllByIndent_IndentIdAndProduct_IdNotIn(indent.getIndentId(),
					contractProductIds);
			indents = IndentMapperUtil.mapIndentDtoToIndent(indent);
			List<IndentProductDto> products = IndentMapperUtil.mapToIndentProductDto(indentProducts);
			indents.setProducts(products);
		} else {
			indent = indentRepository.findByIndentNumber(indentNumber);
			indents = IndentMapperUtil.mapIndentDtoToIndent(indent);

		}
		if (indent == null) {
			throw new ServiceException("Contract already created for all indent products or Invalid Indent Number ",
					null, HttpStatus.BAD_REQUEST);

		}
		return indents;
	}

	public List<IndentDto> getAllApprovedAndPushedIndentNumbers() {
		List<Indent> indents = indentRepository.findAllApprovedIndents();
		List<IndentDto> indentDtos = IndentMapperUtil.mapIndentNumber(indents);
		indentDtos = IndentMapperUtil.mapIndentToIndentDto(indents);
		// indentDtos = findisAllContractCreated(indentDtos);
		return indentDtos;
	}

	public List<IndentDto> findisAllContractCreated(List<IndentDto> indentDtos) {
		indentDtos.forEach(indentDto -> {
			Indent indent = new Indent();
			List<Long> contractProductIds = contractRepository
					.findAllIndentProductsPendingForContractCreation(indentDto.getIndentNumber());
			if (!contractProductIds.isEmpty()) {
				indent = indentRepository.findByIndentNumberAndIndentProducts_Product_IdNotIn(
						indentDto.getIndentNumber(), contractProductIds);
			}
			if (indent == null) {
				indentDto.setIsAllContractCreated(true);
			} else {
				indentDto.setIsAllContractCreated(false);
			}

		});
		return indentDtos;

	}

	public List<IndentDto> getAllPushedIndentNumbers() {
		List<Indent> indents = indentRepository.findAllPushedIndents();
		List<IndentDto> indentDtoList = IndentMapperUtil.mapIndentNumber(indents);
		return indentDtoList;
	}

	public List<IndentDto> getAllIndentsByProductAndSacs(@Valid Long contractId) {
		Contract contract = new Contract();
		Optional<Contract> contractOptional = contractRepository.findById(contractId);
		if (contractOptional.isPresent()) {
			contract = contractOptional.get();
		}
		List<Long> contractProductIds = contract.getContractProducts().stream().map(p -> p.getProduct().getId())
				.collect(Collectors.toList());

		List<IndentDto> indentDtoList = new ArrayList<>();
		List<Indent> indentList = new ArrayList<>();

		List<Indent> indents = indentRepository.findAllApprovedIndents();
		List<Indent> indentProductIds = indents.stream().filter(i -> i.getIndentProducts().stream()
				.map(p -> p.getProduct().getId()).collect(Collectors.toList()).containsAll(contractProductIds))
				.collect(Collectors.toList());

		for (Indent indent : indentProductIds) {
			Boolean indentfound = Boolean.TRUE;

			for (ContractProduct contractProduct : contract.getContractProducts()) {
				if (!indentfound) {
					break;
				}
				for (IndentProduct indentProduct : indent.getIndentProducts()) {
					if (contractProduct.getProduct().getId() == indentProduct.getProduct().getId()) {

						List<Long> sacsIds = indentProduct.getIndentProductSchedules().stream()
								.flatMap(s -> s.getIndentProductScheduleSacs().stream())
								.map(s -> s.getFacility().getId()).distinct().collect(Collectors.toList());
						List<Long> contractSacsIds = contractProduct.getContractProductSchedules().stream()
								.flatMap(s -> s.getContractProductScheduleSacs().stream())
								.map(s -> s.getFacility().getId()).distinct().collect(Collectors.toList());

						if (sacsIds.containsAll(contractSacsIds)) {
							indentfound = Boolean.TRUE;
						} else {
							indentfound = Boolean.FALSE;
							break;
						}
					}
				}
			}
			if (indentfound) {
				indentList.add(indent);
			}
		}

		List<Indent> distinctIndentList = indentList.stream().distinct().collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(distinctIndentList)) {
			indentDtoList = IndentMapperUtil.mapIndentNumber(distinctIndentList);
		}
		return indentDtoList;
	}

	public List<IndentDto> getAllIndentDetailsBysearch(Long facilityId, String indentNumber, LocalDate indentDate,
			String productName) {
		logger.debug("In getAllIndentDetailsBysearch() of IndentService");
		List<Indent> indents = new ArrayList<Indent>();
		List<IndentDto> indentDtos = new ArrayList<>();
		Optional<Facility> facilityOptional = facilityRepository.findById(facilityId);
		if (facilityOptional.isPresent()) {
			Facility facility = facilityOptional.get();
			String searchQuery = IndentMapperUtil.createSearchQuery(facility, indentNumber, indentDate, productName);
			indents = indentRepository.findIndentBySearchValue(searchQuery);
			indentDtos = IndentMapperUtil.mapIndentToIndentDto(indents);
			// indentDtos = findisAllContractCreated(indentDtos);
		} else {
			throw new ServiceException("Invalid facility Id", null, HttpStatus.BAD_REQUEST);
		}

		return indentDtos;
	}
}
