package gov.naco.soch.cst.scheduler;

import org.springframework.stereotype.Component;

import gov.naco.soch.cst.service.ArtFollowupListService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class ArtFollowupScheduler {

	private static final Logger logger = LoggerFactory.getLogger(ArtFollowupScheduler.class);
	
	@Autowired
	private ArtFollowupListService artFollowupListService;
	
	/* Job should run in every day midnight 12 AM */
    @Scheduled(cron = "0 0 0 * * ?")
    public void artFollowupListUpdate() {
    
    	artFollowupListService.findOnArtMisBeneficiaryList();
    	artFollowupListService.findOnArtLfuBeneficiaryList();
    }
}
