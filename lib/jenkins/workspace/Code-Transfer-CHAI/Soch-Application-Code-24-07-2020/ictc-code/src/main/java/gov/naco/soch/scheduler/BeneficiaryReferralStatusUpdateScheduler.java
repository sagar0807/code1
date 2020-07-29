package gov.naco.soch.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import gov.naco.soch.service.ICTCBeneficiaryStatusUpdateService;

@EnableAsync
@Service
public class BeneficiaryReferralStatusUpdateScheduler {

	private final Logger log = LoggerFactory.getLogger(BeneficiaryReferralStatusUpdateScheduler.class);
	
	@Autowired
	private ICTCBeneficiaryStatusUpdateService statusUpdateService;
	
	@Scheduled(cron = "0 0 0 1/1 * ?")
	public void updateStatus() {
		log.info("Art Pending Linkage status update batch job started");
		statusUpdateService.updateStatus();
		log.info("Art Pending Linkage status update batch job started");
	}
	
}
