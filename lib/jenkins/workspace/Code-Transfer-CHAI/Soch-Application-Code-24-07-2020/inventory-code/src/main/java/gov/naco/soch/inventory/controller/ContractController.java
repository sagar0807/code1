package gov.naco.soch.inventory.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.ContractDetailsDto;
import gov.naco.soch.dto.ContractDto;
import gov.naco.soch.dto.SupplierDto;
import gov.naco.soch.inventory.service.ContractService;

/**
 * Controller class for managing contract related APIs
 *
 */

@RestController
@RequestMapping("/contract")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContractController {

	private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private ContractService contractService;

	/**
	 * method to get all contract details
	 * 
	 * @return List<ContractDetailsDto>
	 */
	@GetMapping("/list")
	public List<ContractDetailsDto> getAllContractDetails() {
		logger.debug("getAllContractDetails method is invoked");
		return contractService.getAllContractDetails();
	}
	
	/**
	 * method to get contract details by search
	 * 
	 * @return List<ContractDetailsDto>
	 */
	@GetMapping("/list/search/{facilityId}/{userId}")
	public List<ContractDetailsDto> getAllContractDetailsBySearch(@PathVariable("facilityId")Long facilityId,@PathVariable("userId")Long userId,
			@RequestParam(value="indentNumber",required=false)String indentNumber,
			@RequestParam(value="noaNumber",required=false)String noaNumber,
			@RequestParam(value="supplier",required=false)String supplier,
			@RequestParam(value="productName",required=false)String productName,
			@RequestParam(value="allotmentDate",required=false)@DateTimeFormat(pattern="MM/dd/yyyy")LocalDate allotmentDate
			
			) {
		logger.debug("getAllContractDetails method is invoked");
		return contractService.getAllContractDetailsBySearch(facilityId, userId,indentNumber,noaNumber,supplier,productName,allotmentDate);
	}

	/**
	 * method to get contract details by contractId
	 * 
	 * @param contractId
	 * @return ContractDto
	 */
	@GetMapping("/list/{contractId}")
	public ContractDto getContractDetailsById(@PathVariable("contractId") Long contractId) {
		logger.debug("getContractDetailsById method is invoked");
		return contractService.getContractDetailsById(contractId);
	}

	/**
	 * method to delete contract details by contractId
	 * 
	 * @param contractId
	 * @return true
	 */
	@PostMapping("/delete/{contractId}")
	public Boolean deleteContract(@PathVariable("contractId") Long contractId) {
		logger.debug("deleteContract method called with parameter : ", contractId);
		contractService.deleteContract(contractId);
		return true;
	}

	/**
	 * method to submit a contract
	 * 
	 * @param contractId
	 * @return true
	 */
	@PostMapping("/submit/{contractId}")
	public Boolean submitContract(@PathVariable("contractId") Long contractId) {
		logger.debug("submitContract method called with parameter : ", contractId);
		contractService.submitContract(contractId);
		return true;
	}

	/**
	 * method to delete contract details by contractId
	 * 
	 * @param contractId
	 * @return ContractDto
	 */
	@PostMapping("/save")
	public ContractDto saveContract(@RequestBody ContractDto contract, @RequestParam String action) {
		logger.debug("addContract method is invoked");
		return contractService.saveContract(contract, action);
	}

	@PutMapping("{contractId}/approve")
	public Boolean approveContract(@PathVariable(value = "contractId") Long contractId,
			@RequestParam(value = "status") String status) {
		return contractService.approveContract(contractId, status);
	}

	/**
	 * listAllNoa : Method to fetch all Noa numbers
	 * 
	 * @return List<String>
	 * @author Rishad Basheer
	 */
	@GetMapping("noa/list")
	public List<String> listAllNoa() {
		return contractService.getAllNoa();
	}

	/**
	 * listSupplier : Method to get all suppliers for contract
	 * 
	 * @return
	 */
	@GetMapping("suppliers/list")
	public List<SupplierDto> listSupplier() {
		return contractService.listSuppliers();
	}
}
