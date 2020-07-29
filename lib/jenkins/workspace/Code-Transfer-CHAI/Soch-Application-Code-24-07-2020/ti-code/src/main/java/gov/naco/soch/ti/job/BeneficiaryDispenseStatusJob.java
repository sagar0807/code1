package gov.naco.soch.ti.job;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import gov.naco.soch.repository.TiOstBeneficiaryRepository;

@Component
public class BeneficiaryDispenseStatusJob {

	private final Logger log = LoggerFactory.getLogger(BeneficiaryDispenseStatusJob.class);

	@Autowired
	private TiOstBeneficiaryRepository ostBeneficiaryRepository;

	@Scheduled(cron = "0 0 23 28-31 * ?")
	//@Scheduled(cron = "0 0 19 * * *")
	public void updateBeneficiaryDispenseStatus() {
		final Calendar c = Calendar.getInstance();
		if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {

			log.info("Cron Job Started");
			ostBeneficiaryRepository.updateBeneficiaryDispensationStatus();
			log.info("Cron Job Ended");

		}
		
//		log.info("Cron Job Started");
//		ostBeneficiaryRepository.updateBeneficiaryDispensationStatus();
//		log.info("Cron Job Ended");

	}

}
