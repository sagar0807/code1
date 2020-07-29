package gov.naco.soch.inventory.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.IndentDto;
import gov.naco.soch.inventory.service.IndentService;

@RestController
@RequestMapping("/indent")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndentController {

	private static final Logger logger = LoggerFactory.getLogger(IndentController.class);

	@Autowired
	private IndentService indentService;

	@GetMapping("/list/{facilityId}")
	public List<IndentDto> getAllIndentDetails(@PathVariable("facilityId") Long facilityId) {
		logger.info("getAllIndentDetails method is invoked");
		return indentService.getAllIndentDetails(facilityId);
	}

	@GetMapping("/toBeCreatedContractIndents")
	public IndentDto getAllToBecreatedContractProducts(
			@RequestParam(value = "indentNumber", required = true) String indentNumber) {
		logger.info("getAllToBecreatedContractProducts method is invoked");
		return indentService.getAllToBecreatedContractProducts(indentNumber);
	}

	@PostMapping("/save")
	public IndentDto saveIndent(@RequestBody IndentDto indent) {
		logger.info("saveIndent method is invoked");
		return indentService.saveIndent(indent);
	}

	@PostMapping("/updatestatus/{indentId}")
	public Boolean updateIndentStatus(@PathVariable("indentId") Long indentId,
			@RequestParam(name = "status", required = true) String status) {
		logger.info("updateIndentStatus method is invoked");
		return indentService.updateIndentStatus(indentId, status);
	}

	@PostMapping("/delete/{indentId}")
	public Boolean deleteIndent(@PathVariable("indentId") Long indentId) {
		logger.info("deleteIndent method is invoked");
		return indentService.deleteIndent(indentId);
	}

	/**
	 * getAllIndentNumbers : Method to fetch all indent numbers
	 * 
	 * @return List<String>
	 */
	@GetMapping("/indentnumber/list")
	public List<IndentDto> getAllIndentNumbers() {
		logger.info("getAllIndentNumbers method is invoked");
		return indentService.getAllIndentNumbers();
	}

	/**
	 * getAllIndentNumbers : Method to fetch all indent numbers in approved status
	 * 
	 * @return List<String>
	 */
	@GetMapping("/indentnumber/approved/list")
	public List<IndentDto> getAllApprovedAndPushedIndentNumbers() {
		logger.info("getAllApprovedIndentNumbers method is invoked");
		return indentService.getAllApprovedAndPushedIndentNumbers();
	}

	/**
	 * getAllIndentNumbers : Method to fetch all indent numbers in pushed status
	 * 
	 * @return List<String>
	 */
	@GetMapping("/indentnumber/pushed/list")
	public List<IndentDto> getAllPushedIndentNumbers() {
		logger.info("getAllPushedIndentNumbers method is invoked");
		return indentService.getAllPushedIndentNumbers();
	}

	/**
	 * getAllIndentsByProductAndSacs : Method to fetch all indents by productId and
	 * sacsId
	 * 
	 * @return List<IndentDto>
	 */
	@GetMapping("/indentListSuitableForContract/{contractId}")
	public List<IndentDto> getAllIndentsByProductAndSacs(@Valid @PathVariable("contractId") Long contractId) {
		logger.info("getAllPushedIndentNumbers method is invoked");
		return indentService.getAllIndentsByProductAndSacs(contractId);
	}
	
	@GetMapping("/list/search/{facilityId}")
	public List<IndentDto> getAllIndentDetailsBysearch(@PathVariable("facilityId") Long facilityId,
			@RequestParam(value="indentNumber",required=false)String indentNumber,
			@RequestParam (value="indentDate",required=false)@DateTimeFormat(pattern="MM/dd/yyyy")LocalDate indentDate,
			@RequestParam(value="productName",required=false)String productName) {
		logger.info("getAllIndentDetails method is invoked");
		return indentService.getAllIndentDetailsBysearch(facilityId,indentNumber,indentDate,productName);
	}

}
