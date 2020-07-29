package gov.naco.soch.inventory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.entity.FacilityAggregateStock;
import gov.naco.soch.entity.FacilityStockDailyBalance;
import gov.naco.soch.repository.FacilityAggregateStockRepository;
import gov.naco.soch.repository.FacilityStocklDailyBalanceRepository;

@Service
@Transactional
public class FacilityStockService {

	@Autowired
	private FacilityAggregateStockRepository facilityAggregateStockRepository;

	@Autowired
	private FacilityStocklDailyBalanceRepository facilityStocklDailyBalanceRepository;

	private static final Logger logger = LoggerFactory.getLogger(FacilityStockService.class);

	/*
	 * public int updateExpiredQuantityInAggregateStock() { logger.
	 * debug("Going to update expired quantity in facility_aggregate_stock table");
	 * 
	 * int updatedCount =
	 * facilityAggregateStockRepository.updateExpiredQuantityInAggregateStock();
	 * logger.
	 * debug("Completed updating expired quantity in facility_aggregate_stock table"
	 * ); return updatedCount; }
	 */

	public Boolean saveFacilityStockDailyBalance() {
		logger.debug("Going to select all details from facility aggregate stock table");
		List<FacilityAggregateStock> aggregateStocks = facilityAggregateStockRepository.findAll();

		List<FacilityStockDailyBalance> facilityStockDailyBalances = new ArrayList<FacilityStockDailyBalance>();
		aggregateStocks.forEach(aggregateStock -> {
			FacilityStockDailyBalance facilityStockDailyBalance = new FacilityStockDailyBalance();
			facilityStockDailyBalance.setAvailableQuantity(aggregateStock.getAvailableQuantity());
			facilityStockDailyBalance.setBalanceDate(LocalDate.now());
			facilityStockDailyBalance.setBatchExpiryDate(aggregateStock.getBatchExpiryDate());
			facilityStockDailyBalance.setBatchManufactureDate(aggregateStock.getBatchManufactureDate());
			facilityStockDailyBalance.setBatchNumber(aggregateStock.getBatchNumber());
			//facilityStockDailyBalance.setExpiredQuantity(aggregateStock.getExpiredQuantity());
			facilityStockDailyBalance.setFacility(aggregateStock.getFacility());
			facilityStockDailyBalance.setGit(aggregateStock.getGit());
			facilityStockDailyBalance.setIsActive(Boolean.TRUE);
			facilityStockDailyBalance.setIsDelete(Boolean.FALSE);
			facilityStockDailyBalance.setCreatedTime(LocalDate.now());
			facilityStockDailyBalance.setModifiedTime(LocalDate.now());
			facilityStockDailyBalance.setProduct(aggregateStock.getProduct());
			facilityStockDailyBalances.add(facilityStockDailyBalance);
		});

		facilityStocklDailyBalanceRepository.saveAll(facilityStockDailyBalances);
		logger.debug("inserted all details into facility_stock_daily_balance table");
		return true;

	}

}
