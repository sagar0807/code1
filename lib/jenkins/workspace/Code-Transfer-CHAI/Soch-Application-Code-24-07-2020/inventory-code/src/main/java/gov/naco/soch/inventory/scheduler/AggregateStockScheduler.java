package gov.naco.soch.inventory.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import gov.naco.soch.inventory.service.CMSSService;
import gov.naco.soch.inventory.service.FacilityStockService;

@Component
public class AggregateStockScheduler {

	private static final Logger logger = LoggerFactory.getLogger(AggregateStockScheduler.class);

	@Autowired
	private FacilityStockService facilityStockService;

	@Autowired
	private CMSSService cmssService;

	/* Job should run in every day midnight 12 AM */
	@Scheduled(cron = "0 0 0 * * ?")
	public void inventoryStockUpdate() {
		/*
		 * logger.debug("updateExpiredQuantityInAggregateStock Started");
		 * facilityStockService.updateExpiredQuantityInAggregateStock();
		 * logger.debug("updateExpiredQuantityInAggregateStock Completed");
		 */

		logger.debug("saveFacilityStockDailyBalance Started");
		facilityStockService.saveFacilityStockDailyBalance();
		logger.debug("saveFacilityStockDailyBalance Started");

		logger.debug("CMSS Stock Updation Started");
		cmssService.fetchAndUpdateStockFromExternalService();
		logger.debug("CMSS Stock Updation Ended");
		
		logger.debug("CMSS RO Updation Started");
		cmssService.fetchExternalIndents();
		logger.debug("CMSS RO Updation Ended");
		
		logger.debug("CMSS Dispatches Updation Started");
		cmssService.fetchExternalIssues();
		logger.debug("CMSS Dispatches Updation Ended");
	}

}
