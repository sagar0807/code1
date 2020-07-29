package gov.naco.soch.ti.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import gov.naco.soch.repository.TiOstBeneficiaryRepository;

@Component
public class BeneficiaryClientStatusJob {

	private final Logger log = LoggerFactory.getLogger(BeneficiaryClientStatusJob.class);

	@Autowired
	private TiOstBeneficiaryRepository ostBeneficiaryRepository;

	@Scheduled(cron = "0 30 23 * * *")
	public void updateBeneficiaryClientStatus() {
		log.info("Cron Job Started");
		ostBeneficiaryRepository.updateBeneficiaryClientStatus();
		log.info("Cron Job Ended");

	}

}
