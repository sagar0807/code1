package gov.naco.soch.cst.aop;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import gov.naco.soch.cst.dto.ArtBeneficiaryDeleteDto;
import gov.naco.soch.cst.dto.ArtRegistrationDto;
import gov.naco.soch.entity.NotificationEvent;
import gov.naco.soch.enums.NotificationEventIdEnum;
import gov.naco.soch.repository.NotificationEventRepository;

/*
  Working : 1)give the full quality name of the method of the controller,after which a notification needs to be send.
            2) 1) should be given as a @Pointcut (refer the example @Pointcut saveUser(){})
            3) Advice given is @AfterReturning,which means only after successful execution of the method given in the 
            @Pointcut the method annotated with  @AfterReturning will be invoked
            4)give the arguments expected by the method as seen in the example method written here :sendNotification(JoinPoint joinPoint,Object body) 
 */

@Aspect
@Component
public class NotificationAspect {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private NotificationEventRepository notificationEventRepository;

	private static final Map<String, Object> placeholderMap = new HashMap<>();

	@Value("${notification.emailServiceUrl}")
	private String EMAIL_ENDPOINTURL;
	@Value("${notification.smsServiceUrl}")
	private String SMS_ENDPOINTURL;
	@Value("${notification.whatsappServiceUrl}")
	private String WHATSAPP_ENDPOINTURL;

	@Pointcut("execution(* gov.naco.soch.cst.controller.ArtBeneficiaryController.saveBeneficiary(..))")
	public void saveBeneficiary() {
	}

	@Pointcut("execution(* gov.naco.soch.cst.controller.ArtBeneficiaryController.deleteArtBeneficiary(..))")
	public void deleteBeneficiary() {
	}

	@Pointcut("execution(* gov.naco.soch.cst.controller.BeneficiaryReferralController.saveBeneficiaryFromIctcReferral(..))")
	public void saveReferral() {
	}

	@AfterReturning(pointcut = "saveBeneficiary()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForsaveBeneficiary(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		Optional<NotificationEvent> notificationEventOptional = notificationEventRepository.findByEventIdAndIsEnabled(
				Long.parseLong(NotificationEventIdEnum.ADD_BENEFICIARY_CST.getEventId()), true);
		if (notificationEventOptional.isPresent()) {
			if (requestBody instanceof ArtRegistrationDto && responseBody instanceof ArtRegistrationDto) {
				ArtRegistrationDto request = (ArtRegistrationDto) requestBody;
				ArtRegistrationDto response = (ArtRegistrationDto) responseBody;
				placeholderMap.put("beneficiaryname", request.getFirstName());
				placeholderMap.put("beneficiaryId", response.getBeneficiaryId());
				String eventId = NotificationEventIdEnum.ADD_BENEFICIARY_CST.getEventId();
				// sendNotfication(eventId);
				sendNotfication(eventId, true, false, false);
			}
		}
	}

	@AfterReturning(pointcut = "deleteBeneficiary()&& args(.., @RequestBody requestBody)")

	@Async
	public void sendNotificationFordeleteBeneficiary(JoinPoint joinPoint, Object requestBody) {
		Optional<NotificationEvent> notificationEventOptional = notificationEventRepository.findByEventIdAndIsEnabled(
				Long.parseLong(NotificationEventIdEnum.DELETE_BENEFICIARY_CST.getEventId()), true);
		if (notificationEventOptional.isPresent()) {
			if (requestBody instanceof ArtBeneficiaryDeleteDto) {
				ArtBeneficiaryDeleteDto request = (ArtBeneficiaryDeleteDto) requestBody;
				placeholderMap.put("beneficiaryname", request.getFirstName());
				String eventId = NotificationEventIdEnum.DELETE_BENEFICIARY_CST.getEventId();
				sendNotfication(eventId, true, false, false);
			}
		}
	}

	@AfterReturning(pointcut = "saveReferral()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForsaveReferral(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		Optional<NotificationEvent> notificationEventOptional = notificationEventRepository.findByEventIdAndIsEnabled(
				Long.parseLong(NotificationEventIdEnum.BENEFICIARY_REFERRAL_CST.getEventId()), true);
		if (notificationEventOptional.isPresent()) {
			if (requestBody instanceof ArtRegistrationDto && responseBody instanceof ArtRegistrationDto) {
				ArtRegistrationDto request = (ArtRegistrationDto) requestBody;
				ArtRegistrationDto response = (ArtRegistrationDto) responseBody;
				placeholderMap.put("beneficiaryname", request.getFirstName());
				placeholderMap.put("facilityname", response.getFacilityName());
				String eventId = NotificationEventIdEnum.BENEFICIARY_REFERRAL_CST.getEventId();
				sendNotfication(eventId, true, false, false);
			}
		}
	}

	private void sendNotfication(String eventId, boolean emailToBeSent, boolean smsToBeSent, boolean whatsAppToBeSent) {
		if (emailToBeSent) {
			restTemplate.postForEntity(EMAIL_ENDPOINTURL.concat(eventId), placeholderMap, Boolean.class);
		}
		if (smsToBeSent) {
			restTemplate.postForEntity(SMS_ENDPOINTURL.concat(eventId), placeholderMap, Boolean.class);
		}
		if (whatsAppToBeSent) {
			restTemplate.postForEntity(WHATSAPP_ENDPOINTURL.concat(eventId), placeholderMap, Boolean.class);
		}
	}

}
