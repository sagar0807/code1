package gov.naco.soch.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.inventory.dto.CMSSIndentDto;
import gov.naco.soch.inventory.dto.CMSSIssueDto;
import gov.naco.soch.inventory.dto.CMSSPOWiseStockDto;
import gov.naco.soch.inventory.dto.CMSSSacsWarehouseMappingDto;
import gov.naco.soch.inventory.dto.CMSSStockDto;
import gov.naco.soch.inventory.dto.CMSSStoreWiseStockDto;
import gov.naco.soch.inventory.dto.CMSSWarehouseDto;
import gov.naco.soch.inventory.service.CMSSService;

@RestController
@RequestMapping("/cmss")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CMSSController {

	private static final Logger logger = LoggerFactory.getLogger(CMSSController.class);

	@Autowired
	private CMSSService cmssService;

	@GetMapping("/stock/update")
	public Boolean fetchAndUpdateStockFromExternalService() {
		logger.info("fetchAndUpdateStockFromExternalService method is invoked");
		return cmssService.fetchAndUpdateStockFromExternalService();
	}

	@GetMapping("/stock/list")
	public List<CMSSStockDto> fetchStockList() {
		logger.info("fetchStockList method is invoked");
		return cmssService.fetchStockList();
	}

	@GetMapping("/stock/storewise/list")
	public List<CMSSStoreWiseStockDto> fetchStockStorewiseList() {
		logger.info("fetchStockStorewiseList method is invoked");
		return cmssService.fetchStockStorewiseList();
	}

	@GetMapping("/stock/powise/list")
	public List<CMSSPOWiseStockDto> fetchStockPOwiseList() {
		logger.info("fetchStockPOwiseList method is invoked");
		return cmssService.fetchStockPOwiseList();
	}

	@GetMapping("/stock/products/list")
	public List<String> fetchProductsList() {
		logger.info("fetchProductsList method is invoked");
		return cmssService.fetchProductsList();
	}

	@GetMapping("/warehouses/list")
	public List<CMSSWarehouseDto> fetchWarehousesList() {
		logger.info("fetchWarehousesList method is invoked");
		return cmssService.fetchWarehousesList();
	}

	@PostMapping("/warehouses/save")
	public Boolean saveWarehouses(@Valid @RequestBody List<CMSSWarehouseDto> warehouseList) {
		logger.info("saveWarehouses method is invoked");
		return cmssService.saveWarehouses(warehouseList);
	}

	@PostMapping("/warehouses/delete/{warehouseId}")
	public Boolean deleteWarehouse(@Valid @PathVariable("warehouseId") Long warehouseId) {
		logger.info("deleteWarehouse method is invoked");
		return cmssService.deleteWarehouse(warehouseId);
	}

	@GetMapping("/warehouses/sacs/mapping/list")
	public List<CMSSSacsWarehouseMappingDto> fetchWarehousesSacsMappingList() {
		logger.info("fetchWarehousesSacsMappingList method is invoked");
		return cmssService.fetchWarehousesSacsMappingList();
	}

	@PostMapping("/warehouses/sacs/mapping/save")
	public CMSSSacsWarehouseMappingDto saveWarehousesSacsMapping(
			@Valid @RequestBody CMSSSacsWarehouseMappingDto warehouse) {
		logger.info("saveWarehousesSacsMapping method is invoked");
		return cmssService.saveWarehousesSacsMapping(warehouse);
	}

	@GetMapping("/stores/list")
	public List<CMSSWarehouseDto> fetchStoreList() {
		logger.info("fetchWarehousesList method is invoked");
		return cmssService.fetchStoreList();
	}

	@GetMapping("/indent/update")
	public Boolean fetchExternalIndents() {
		logger.info("fetchExternalIndents method is invoked");
		return cmssService.fetchExternalIndents();
	}

	@GetMapping("/ro/update")
	public Boolean fetchExternalIssues() {
		logger.info("fetchExternalIssues method is invoked");
		return cmssService.fetchExternalIssues();
	}

	@GetMapping("/indent/list")
	public List<CMSSIndentDto> fetchIndentList() {
		logger.info("fetchIndentList method is invoked");
		return cmssService.fetchIndentList();
	}

	@GetMapping("/ro/list")
	public List<CMSSIssueDto> fetchIssueList() {
		logger.info("fetchIssueList method is invoked");
		return cmssService.fetchIssueList();
	}

	@GetMapping("/ro/history/list")
	public List<CMSSIssueDto> fetchIssuesHistoryList() {
		logger.info("fetchIssuesHistoryList method is invoked");
		return cmssService.fetchIssuesHistoryList();
	}

	@PostMapping("/ro/receive/{roId}")
	public CMSSIssueDto receiveIssuedIndents(@PathVariable("roId") Long roId,@RequestBody CMSSIssueDto dto) {
		logger.info("receiveIssuedIndents method is invoked");
		return cmssService.receiveIssuedIndents(roId, dto);
	}

}
