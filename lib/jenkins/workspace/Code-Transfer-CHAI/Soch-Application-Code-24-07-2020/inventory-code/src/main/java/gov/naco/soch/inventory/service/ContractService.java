package gov.naco.soch.inventory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.ContractDetailsDto;
import gov.naco.soch.dto.ContractDto;
import gov.naco.soch.dto.ContractSacsDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.ScheduleProductDto;
import gov.naco.soch.dto.SupplierDto;
import gov.naco.soch.entity.Contract;
import gov.naco.soch.entity.ContractProduct;
import gov.naco.soch.entity.ContractProductSchedule;
import gov.naco.soch.entity.ContractProductScheduleSac;
import gov.naco.soch.entity.ContractProductScheduleSacsLot;
import gov.naco.soch.entity.ContractStatusMaster;
import gov.naco.soch.entity.Dispatch;
import gov.naco.soch.entity.DispatchBatch;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.inventory.mapper.ContractMapperUtil;
import gov.naco.soch.repository.ContractProductDetailRepository;
import gov.naco.soch.repository.ContractRepository;
import gov.naco.soch.repository.DispatchRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class ContractService {

	private static DispatchRepository dispatchRepository;

	@PostConstruct
	public void init() {
		ContractService.dispatchRepository = dispatchRepository1;
	}

	@Autowired
	DispatchRepository dispatchRepository1;

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private ContractProductDetailRepository contractProductDetailRepository;

	public List<ContractDetailsDto> getAllContractDetails() {

		LoginResponseDto userDetails = UserUtils.getLoggedInUserDetails();
		List<Contract> contractDetails = new ArrayList<Contract>();
		List<ContractDetailsDto> contractDtoDetails = new ArrayList<ContractDetailsDto>();
		Optional<Facility> facilityOptional = facilityRepository.findById(userDetails.getFacilityId());
		if (facilityOptional.isPresent()) {
			Facility facility = facilityOptional.get();
			if (facility.getFacilityType().getId() == FacilityTypeEnum.NACO.getFacilityType()) {
				List<Integer> contractStatusMasterIds = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5));
				contractDetails = contractRepository
						.findAllByCreatedByOrContractStatusMaster_IdInAndIsDeleteOrderByContractId(
								userDetails.getUserId(), contractStatusMasterIds, false);
			} else if (facility.getFacilityType().getId() == FacilityTypeEnum.PROCUREMENT_AGENT.getFacilityType()) {
				contractDetails = contractRepository
						.findAllByCreatedByAndIsDeleteOrderByContractIdDesc(userDetails.getUserId(), false);
			} else if (facility.getFacilityType().getId() == FacilityTypeEnum.SUPPLIER.getFacilityType()) {
				contractDetails = contractRepository.findAllSupplierContractList(userDetails.getFacilityId(),
						userDetails.getUserId(), false);
			}
			contractDtoDetails = ContractMapperUtil.mapContractToContractDtoList(contractDetails);
		} else {
			throw new ServiceException("Invalid facility Id", null, HttpStatus.BAD_REQUEST);
		}
		return contractDtoDetails;
	}

	public ContractDto getContractDetailsById(Long contractId) {
		Contract contract = contractRepository.findByContractId(contractId);
		ContractDto contractDto = ContractMapperUtil.mapContractToContractDto(contract);
		return contractDto;
	}

	public static List<ScheduleProductDto> mapContractProductScheduleDetailToScheduleProductDto(
			Set<ContractProductSchedule> contractProductScheduleDetails) {
		List<ScheduleProductDto> scheduleProductDtos = new ArrayList<>();
		if (contractProductScheduleDetails != null) {
			for (ContractProductSchedule contractProductScheduleDetail : contractProductScheduleDetails) {

				ScheduleProductDto scheduleProductDto = new ScheduleProductDto();
				scheduleProductDto.setScheduleId(contractProductScheduleDetail.getId());
				scheduleProductDto.setQuantity(contractProductScheduleDetail.getQuantity());
				scheduleProductDto.setScheduleNumber(contractProductScheduleDetail.getScheduleNumber());
				scheduleProductDto.setUnitPrice(contractProductScheduleDetail.getUnitPrice());
				List<Dispatch> disapatches = new ArrayList<>();
				disapatches = dispatchRepository
						.findAllByContract_ContractIdAndContractProduct_Product_IdAndContractProductSchedule_Id(
								contractProductScheduleDetail.getContractProduct().getContract().getContractId(),
								contractProductScheduleDetail.getContractProduct().getProduct().getId(),
								contractProductScheduleDetail.getId());
				if (disapatches != null) {
					Long dispatchedQuantity = 0L;
					for (Dispatch dispatch : disapatches) {
						for (DispatchBatch batch : dispatch.getDispatchBatches()) {
							dispatchedQuantity = dispatchedQuantity + batch.getQuantityNumber();
						}

					}
					scheduleProductDto.setDispatchedQuantity(dispatchedQuantity);
				}

				List<ContractSacsDto> sacsDetails = ContractMapperUtil.mapContractProductScheduleSacsToContractSacsDto(
						contractProductScheduleDetail.getContractProductScheduleSacs());
				scheduleProductDto.setSacs(sacsDetails);
				scheduleProductDtos.add(scheduleProductDto);
			}
		}
		return scheduleProductDtos;
	}

	public void deleteContract(Long contractId) {
		Contract contract = contractRepository.findByContractId(contractId);
		if (contract != null) {
			contract.setIsDelete(true);
			for (ContractProduct ContractProductDetail : contract.getContractProducts()) {
				ContractProductDetail.setIsDelete(true);
				for (ContractProductSchedule contractProductSchedule : ContractProductDetail
						.getContractProductSchedules()) {
					contractProductSchedule.setIsDelete(true);
					for (ContractProductScheduleSac contractProductScheduleSac : contractProductSchedule
							.getContractProductScheduleSacs()) {
						contractProductScheduleSac.setIsDelete(true);
						for (ContractProductScheduleSacsLot contractProductSceduleSacsLot : contractProductScheduleSac
								.getContractProductSceduleSacsLots()) {
							contractProductSceduleSacsLot.setIsDelete(true);
						}
					}
				}
			}
			contractRepository.save(contract);
		}
	}

	public void submitContract(Long contractId) {
		Contract contract = contractRepository.findByContractId(contractId);
		if (contract != null) {
			// contract.setContractStatus(ContractStatusEnum.AWAITING_APPROVAL.getStatus());
			contractRepository.save(contract);
		}
	}

	public ContractDto saveContract(ContractDto contractDto, String action) {

		Contract contract;
		if (contractDto.getId() == null) {
			Integer count = contractRepository.existByNoaNumber(contractDto.getNoaNumber());
			if (count > 0) {
				throw new ServiceException("Noa Number already exists", null, HttpStatus.BAD_REQUEST);
			}
			contract = new Contract();
		} else {
			Optional<Contract> contractOptional = contractRepository.findById(contractDto.getId());
			contract = contractOptional.get();
			if (!CollectionUtils.isEmpty(contract.getContractProducts())) {
				contractProductDetailRepository.deleteAll(contract.getContractProducts());
			}
		}
		contract = ContractMapperUtil.mapContractDtoToContract(contractDto, contract, action);
		contractRepository.save(contract);
		return contractDto;
	}

	public Boolean approveContract(Long contractId, String status) {
		Contract contract = contractRepository.findByContractId(contractId);
		ContractStatusMaster contractStatusMaster = new ContractStatusMaster();
		if (status.equalsIgnoreCase("approve")) {
			contractStatusMaster.setId(3);
		} else if (status.equalsIgnoreCase("rejected")) {
			contractStatusMaster.setId(4);
		} else if (status.equalsIgnoreCase("closed")) {
			contractStatusMaster.setId(5);
		}
		contract.setContractStatusMaster(contractStatusMaster);
		contractRepository.save(contract);
		return true;
	}

	public List<String> getAllNoa() {
		List<Contract> contracts = contractRepository.findAllByIsDelete(false);
		List<String> noaList = new ArrayList<>();
		for (Contract contract : contracts) {
			String noa = contract.getNoaNumber();
			noaList.add(noa);
		}
		return noaList;
	}

	public List<SupplierDto> listSuppliers() {
		List<Facility> suppliers = facilityRepository.findByfacilityTypeId(3);
		List<SupplierDto> supplierList = new ArrayList<SupplierDto>();
		if (suppliers != null) {
			for (Facility supplier : suppliers) {
				SupplierDto supplierDto = new SupplierDto();
				supplierDto.setSupplierId(supplier.getId());
				supplierDto.setSupplierName(supplier.getName());
				supplierList.add(supplierDto);
			}
		}
		return supplierList;
	}

	public List<ContractDetailsDto> getAllContractDetailsBySearch(Long facilityId, Long userId, String indentNumber,
			String noaNumber, String supplier, String productName, LocalDate allotmentDate) {
		List<Contract> contractDetails = new ArrayList<Contract>();
		List<ContractDetailsDto> contractDtoDetails = new ArrayList<ContractDetailsDto>();
		Optional<Facility> facilityOptional = facilityRepository.findById(facilityId);
		if (facilityOptional.isPresent()) {
			Facility facility = facilityOptional.get();
			String searchQuery = ContractMapperUtil.createSearchQuery(facility, userId, indentNumber, noaNumber,
					supplier, productName, allotmentDate);
			contractDetails = contractRepository.findContractBySearchValue(searchQuery);
			contractDtoDetails = ContractMapperUtil.mapContractToContractDtoList(contractDetails);
		} else {
			throw new ServiceException("Invalid facility Id", null, HttpStatus.BAD_REQUEST);
		}
		return contractDtoDetails;
	}

}
