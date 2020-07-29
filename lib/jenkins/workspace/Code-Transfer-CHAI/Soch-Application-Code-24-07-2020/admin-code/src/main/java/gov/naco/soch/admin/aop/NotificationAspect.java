package gov.naco.soch.admin.aop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import gov.naco.soch.dto.DesignationDto;
import gov.naco.soch.dto.DivisionDto;
import gov.naco.soch.dto.FacilityDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.entity.Designation;
import gov.naco.soch.entity.Division;
import gov.naco.soch.entity.UserAuth;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.NotificationEventIdEnum;
import gov.naco.soch.mapper.UserMapperUtil;
import gov.naco.soch.repository.DesignationRepository;
import gov.naco.soch.repository.DivisionRepository;
import gov.naco.soch.repository.NotificationEventRepository;
import gov.naco.soch.repository.UserAuthRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.util.CommonConstants;
import gov.naco.soch.util.UserUtils;

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
	
	@Autowired
	private UserMasterRepository userMasterRepository;
	
	@Autowired
	private DivisionRepository divisionRepository;
	
	@Autowired
	private DesignationRepository designationRepository;
	
	@Autowired
	private UserAuthRepository userAuthRepository;
	

	private static final HashMap<String, Object> placeholderMap = new HashMap<>();

	@Value("${notification.emailServiceUrl}")
	private String EMAIL_ENDPOINTURL;
	@Value("${notification.smsServiceUrl}")
	private String SMS_ENDPOINTURL;
	@Value("${notification.whatsappServiceUrl}")
	private String WHATSAPP_ENDPOINTURL;

	@Pointcut("execution(* gov.naco.soch.admin.controller.UserController.saveUser(..))")
	public void saveUser() {
	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.UserController.deleteUser(..))")
	public void deleteUser() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.DivisionController.addDivision(..))")
	public void saveDivision() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.DivisionController.deleteDivision(..))")
	public void deleteDivision() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.RoleController.addRole(..))")
	public void saveRole() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.RoleController.deleteRole(..))")
	public void deleteRole() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.DesignationController.saveDesignation(..))")
	public void saveDesignation() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.DesignationController.deleteDesignation(..))")
	public void deleteDesignation() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.FacilityController.addFacility(..))")
	public void saveFacility() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.FacilityController.deleteFacility(..))")
	public void deleteFacility() {

	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.SacsController.addSacs(..))")
	public void addSacs() {
	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.LabsController.addLabs(..))")
	public void addLabs() {
	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.SupplierController.addSupplier(..))")
	public void addSupplier() {
	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.RegionalWarehouseController.addRegionalWarehouse(..))")
	public void addRegionalWarehouse() {
	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.FacilityController.addAnyFacility(..))")
	public void addAnyFacility() {
	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.LacController.addLacFacility(..))")
	public void saveLac() {
	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.LacController.deleteLacFacility(..))")
	public void deleteLac() {
	}

	@Pointcut("execution(* gov.naco.soch.admin.controller.UserController.resetPassword(..))")
	public void resetPassword() {
	}
	/*
	 * @Pointcut("execution(* gov.naco.soch.admin.controller.UserController.prepareRegistrationDetailsForSavedUser(..))"
	 * ) public void prepareRegistrationDetailsForSavedUser() {
	 * 
	 * }
	 */

	@AfterReturning(pointcut = "saveUser()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForsaveUser(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.ADD_USER.getEventId()), true)
				.ifPresent(x -> {
					if (requestBody instanceof UserMasterDto && responseBody instanceof UserMasterDto) {
						UserMasterDto request = (UserMasterDto) requestBody;
						//Change to avoid notification on updation. @Author : Rishad Basheer
						if(request.getId()==null || request.getId() == 0) {
						UserMasterDto response = (UserMasterDto) responseBody;
						placeholderMap.put("username", request.getFirstname());
						placeholderMap.put("userid", response.getId());
						String eventId = NotificationEventIdEnum.ADD_USER.getEventId();
						sendNotfication(eventId, true, true, true);

						/* Send registration details */
						if (!StringUtils.isBlank(response.getEmail())) {
							List<String> toEmailsList = new ArrayList<>();
							toEmailsList.add(response.getEmail());
							placeholderMap.put("username", response.getUserName());
							placeholderMap.put("password", response.getPassword());
							placeholderMap.put(CommonConstants.NOTIFICATION_SPECIFIC_RECIPIENT_NAME_PLACEHOLDER,
									response.getFirstname());
							placeholderMap.put(CommonConstants.NOTIFICATION_TO_SPECIFIC_EMAILS_PLACEHOLDER,
									toEmailsList);
							eventId = NotificationEventIdEnum.SEND_REGISTRATION_DETAILS_TO_USER.getEventId();
							sendNotfication(eventId, true, false, false);
							response.setPassword(null);
						 }
					}
					}
				});
	}

	@AfterReturning(pointcut = "deleteUser()&& args(.., @PathVariable userId)")
	@Async
	public void sendNotificationFordeleteUser(JoinPoint joinPoint, Long userId) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.DELETE_USER.getEventId()), true)
				.ifPresent(x -> {
					//placeholderMap.put("username", userName);
					//Code change (Bug-fix on 08/07/20)
					UserMaster userMaster = userMasterRepository.findById(userId).get();
					if(userMaster!=null) {
					String userName = userMaster.getFirstname()+" "+userMaster.getLastname();
					placeholderMap.put("username", userName);
					}
					else
						System.out.println("userMaster is null");
					placeholderMap.put("userid", userId);
					String eventId = NotificationEventIdEnum.DELETE_USER.getEventId();
					sendNotfication(eventId, true, true, true);
				});
	}

	@AfterReturning(pointcut = "saveDivision()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForsaveDivision(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.ADD_DIVISION.getEventId()), true)
				.ifPresent(x -> {
					if (requestBody instanceof DivisionDto && responseBody instanceof DivisionDto) {
						DivisionDto request = (DivisionDto) requestBody;
						//Change to avoid notification on updation. @Author : Rishad Basheer
						if(request.getId()==null || request.getId() == 0) {
						DivisionDto response = (DivisionDto) responseBody;
						placeholderMap.put("divisionname", request.getName());
						placeholderMap.put("divisionid", response.getId());
						String eventId = NotificationEventIdEnum.ADD_DIVISION.getEventId();
						sendNotfication(eventId, true, true, true);
						}
					 }
				});
	}

	@AfterReturning(pointcut = "deleteDivision()&& args(.., @PathVariable divisionId)")
	@Async
	public void sendNotificationFordeleteDivision(JoinPoint joinPoint, Long divisionId) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.DELETE_DIVISION.getEventId()), true)
				.ifPresent(x -> {
					//Code change (Bug-fix on 08/07/20)
					Division division = divisionRepository.findById(divisionId).get();
					String divisionName = division.getName();
					placeholderMap.put("divisionname", divisionName);
					placeholderMap.put("divisionid", divisionId);
					String eventId = NotificationEventIdEnum.DELETE_DIVISION.getEventId();
					sendNotfication(eventId, true, true, true);
				});
	}

	@AfterReturning(pointcut = "saveRole()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForsaveRole(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.ADD_ROLE.getEventId()), true)
				.ifPresent(x -> {
					if (requestBody instanceof RoleDto && responseBody instanceof RoleDto) {
						RoleDto request = (RoleDto) requestBody;
						//Change to avoid notification on updation. @Author : Rishad Basheer
						if(request.getId()==null || request.getId() == 0) {
						RoleDto response = (RoleDto) responseBody;
						placeholderMap.put("rolename", request.getName());
						placeholderMap.put("roleid", response.getId());
						String eventId = NotificationEventIdEnum.ADD_ROLE.getEventId();
						sendNotfication(eventId, true, true, true);
					  }
					}
				});
	}

	@AfterReturning(pointcut = "deleteRole()&& args(.., @PathVariable roleId)", returning = "roleName")
	@Async
	public void sendNotificationForDeleteRole(JoinPoint joinPoint, Long roleId, String roleName) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.DELETE_ROLE.getEventId()), true)
				.ifPresent(x -> {
					placeholderMap.put("rolename", roleName);
					placeholderMap.put("roleid", roleId);
					String eventId = NotificationEventIdEnum.DELETE_ROLE.getEventId();
					sendNotfication(eventId, true, true, true);
				});
	}

	@AfterReturning(pointcut = "saveDesignation()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForsaveDesignation(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.ADD_DESIGNATION.getEventId()), true)
				.ifPresent(x -> {
					if (requestBody instanceof DesignationDto && responseBody instanceof DesignationDto) {
						DesignationDto request = (DesignationDto) requestBody;
						//Change to avoid notification on updation. @Author : Rishad Basheer
						if(request.getId()==null || request.getId() == 0) {
						DesignationDto response = (DesignationDto) responseBody;
						placeholderMap.put("designationtitle", request.getTitle());
						placeholderMap.put("designationid", response.getId());
						String eventId = NotificationEventIdEnum.ADD_DESIGNATION.getEventId();
						sendNotfication(eventId, true, true, true);
						}
				 }
				});
	}

	@AfterReturning(pointcut = "deleteDesignation()&& args(.., @PathVariable designationId)")
	@Async
	public void sendNotificationForDeleteDesignation(JoinPoint joinPoint, Long designationId) {
		notificationEventRepository.findByEventIdAndIsEnabled(
				Long.parseLong(NotificationEventIdEnum.DELETE_DESIGNATION.getEventId()), true).ifPresent(x -> {
					//Code change (Bug-fix on 08/07/20)
					Designation designation = designationRepository.findById(designationId).get();
					String title = designation.getTitle();
					placeholderMap.put("designationtitle", title);
					placeholderMap.put("designationid", designationId);
					String eventId = NotificationEventIdEnum.DELETE_DESIGNATION.getEventId();
					sendNotfication(eventId, true, true, true);

				});
	}

	@AfterReturning(pointcut = "saveFacility()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForsaveFacility(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.ADD_FACILITY.getEventId()), true)
				.ifPresent(x -> {
					if (requestBody instanceof FacilityDto && responseBody instanceof FacilityDto) {
						FacilityDto request = (FacilityDto) requestBody;
						FacilityDto response = (FacilityDto) responseBody;
						placeholderMap.put("facilityname", request.getName());
						placeholderMap.put("facilityid", response.getId());
						String eventId = NotificationEventIdEnum.ADD_FACILITY.getEventId();
						sendNotfication(eventId, true, true, true);
				   }
				});
	}

	@AfterReturning(pointcut = "deleteFacility()&& args(.., @PathVariable facilityId)", returning = "responseBody")
	@Async
	public void sendNotificationForDeleteFacility(JoinPoint joinPoint, Long facilityId, Object responseBody) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.DELETE_FACILITY.getEventId()), true)
				.ifPresent(x -> {
					if (responseBody instanceof SacsFacilityDto) {
						SacsFacilityDto response = (SacsFacilityDto) responseBody;
						placeholderMap.put("facilityname", response.getName());
						placeholderMap.put("facilityid", facilityId);
						String eventId = NotificationEventIdEnum.DELETE_FACILITY.getEventId();
						sendNotfication(eventId, true, true, true);

					}
				});
	}

	@AfterReturning(pointcut = "addSacs()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForAddSacs(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		String eventId = NotificationEventIdEnum.ADD_SACS.getEventId();
		if (requestBody instanceof SacsFacilityDto) {
			SacsFacilityDto sacsFacilityDtoReq = (SacsFacilityDto) requestBody;
			placeholderMap.put("sacsname", sacsFacilityDtoReq.getName());
		}
		notificationEventRepository.findByEventIdAndIsEnabled(Long.parseLong(eventId), true).ifPresent(x -> {
			sendFacilityCreationNotification(requestBody, eventId);
		});
	}

	@AfterReturning(pointcut = "addLabs()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForAddLabs(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		String eventId = NotificationEventIdEnum.ADD_LABS.getEventId();
		if (requestBody instanceof SacsFacilityDto) {
			SacsFacilityDto sacsFacilityDtoReq = (SacsFacilityDto) requestBody;
			placeholderMap.put("labname", sacsFacilityDtoReq.getName());
		}
		notificationEventRepository.findByEventIdAndIsEnabled(Long.parseLong(eventId), true).ifPresent(x -> {
			sendFacilityCreationNotification(requestBody, eventId);
		});
	}

	@AfterReturning(pointcut = "addSupplier()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForAddSupplier(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		String eventId = NotificationEventIdEnum.ADD_SUPPLIER.getEventId();
		if (requestBody instanceof SacsFacilityDto) {
			SacsFacilityDto sacsFacilityDtoReq = (SacsFacilityDto) requestBody;
			placeholderMap.put("suppliername", sacsFacilityDtoReq.getName());
		}
		notificationEventRepository.findByEventIdAndIsEnabled(Long.parseLong(eventId), true).ifPresent(x -> {
			sendFacilityCreationNotification(requestBody, eventId);
		});
	}

	@AfterReturning(pointcut = "addRegionalWarehouse()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForAddRegionalWarehouse(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		String eventId = NotificationEventIdEnum.ADD_RWH.getEventId();
		if (requestBody instanceof SacsFacilityDto) {
			SacsFacilityDto sacsFacilityDtoReq = (SacsFacilityDto) requestBody;
			placeholderMap.put("rwhname", sacsFacilityDtoReq.getName());
		}
		notificationEventRepository.findByEventIdAndIsEnabled(Long.parseLong(eventId), true).ifPresent(x -> {
			sendFacilityCreationNotification(requestBody, eventId);
		});
	}

	@AfterReturning(pointcut = "addAnyFacility()&& args(.., @RequestBody requestBody)", returning = "responseBody")
	@Async
	public void sendNotificationForAddAnyFacility(JoinPoint joinPoint, Object requestBody, Object responseBody) {
		String eventId = NotificationEventIdEnum.ADD_SACS_FACILITY.getEventId();
		if (requestBody instanceof SacsFacilityDto) {
			SacsFacilityDto sacsFacilityDtoReq = (SacsFacilityDto) requestBody;
			placeholderMap.put("facilityname", sacsFacilityDtoReq.getName());
			placeholderMap.put("facilitytype", sacsFacilityDtoReq.getFacilityTypeName());
		}

		notificationEventRepository.findByEventIdAndIsEnabled(Long.parseLong(eventId), true).ifPresent(x -> {
			sendFacilityCreationNotification(requestBody, eventId);
		});
	}

	private void sendFacilityCreationNotification(Object requestBody, String eventId) {
		if (requestBody instanceof SacsFacilityDto) {
			SacsFacilityDto sacsFacilityDtoReq = (SacsFacilityDto) requestBody;
			sendNotfication(eventId, true, true, true);

			/* Send registration details for the created users with SACS */
			UserMasterDto primaryUser = sacsFacilityDtoReq.getPrimaryUser();
			sendFacilityUserRegistrationNotfication(primaryUser);

			UserMasterDto alternateUser = sacsFacilityDtoReq.getAlternateUser();
			sendFacilityUserRegistrationNotfication(alternateUser);

		}
	}

	private void sendFacilityUserRegistrationNotfication(UserMasterDto userMasterDto) {
		if (!StringUtils.isBlank(userMasterDto.getEmail())) {
			List<String> toEmailsList = new ArrayList<>();
			toEmailsList.add(userMasterDto.getEmail());
			placeholderMap.put("username", userMasterDto.getUserName());
			placeholderMap.put("password", userMasterDto.getPassword());
			placeholderMap.put(CommonConstants.NOTIFICATION_SPECIFIC_RECIPIENT_NAME_PLACEHOLDER,
					userMasterDto.getFirstname());
			placeholderMap.put(CommonConstants.NOTIFICATION_TO_SPECIFIC_EMAILS_PLACEHOLDER, toEmailsList);
			String eventId = NotificationEventIdEnum.SEND_REGISTRATION_DETAILS_TO_USER.getEventId();
			sendNotfication(eventId, true, false, false);
			// response.setPassword(null);
		}
	}

	@AfterReturning(pointcut = "saveLac()&& args(.., @RequestBody requestBody)")
	@Async
	public void sendNotificationForsaveLac(JoinPoint joinPoint, Object requestBody) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.ADD_LAC_CST.getEventId()), true)
				.ifPresent(x -> {
					if (requestBody instanceof SacsFacilityDto) {
						SacsFacilityDto request = (SacsFacilityDto) requestBody;
						placeholderMap.put("lacname", request.getName());
						String eventId = NotificationEventIdEnum.ADD_LAC_CST.getEventId();
						// sendNotfication(eventId);
						sendNotfication(eventId, true, false, false);
					 }
				});
	}

	@AfterReturning(pointcut = "deleteLac()&& args(.., @PathVariable facilityId)", returning = "responseBody")
	@Async
	public void sendNotificationForDeleteLac(JoinPoint joinPoint, Long facilityId, Object responseBody) {
		notificationEventRepository
				.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.DELETE_LAC_CST.getEventId()), true)
				.ifPresent(x -> {
					if (responseBody instanceof SacsFacilityDto) {
						SacsFacilityDto response = (SacsFacilityDto) responseBody;
						placeholderMap.put("lacname", response.getName());
						String eventId = NotificationEventIdEnum.DELETE_LAC_CST.getEventId();
						// sendNotfication(eventId);
						sendNotfication(eventId, true, false, false);

					}
				});
	}
	
	@AfterReturning(pointcut = "resetPassword()&& args(.., @PathVariable userName)")
	@Async
	public void sendNotificationForResetPassword(JoinPoint joinPoint, String userName) {
		notificationEventRepository
		.findByEventIdAndIsEnabled(Long.parseLong(NotificationEventIdEnum.RESET_PASSWORD.getEventId()), true)
		.ifPresent(x -> {
			UserAuth user = userAuthRepository.findByUserName(userName);
			String eventId = "";
			if(user!=null) {
			List<String> toEmailsList = new ArrayList<>();
			toEmailsList.add(user.getEmail());
			String userPassword = UserMapperUtil.generateUserPassword(userName);	
			placeholderMap.put("username", userName);
			placeholderMap.put("password", userPassword);
			placeholderMap.put(CommonConstants.NOTIFICATION_SPECIFIC_RECIPIENT_NAME_PLACEHOLDER,
             userName);
			placeholderMap.put(CommonConstants.NOTIFICATION_TO_SPECIFIC_EMAILS_PLACEHOLDER,
					toEmailsList);
			eventId = NotificationEventIdEnum.RESET_PASSWORD.getEventId();
			}
			else
			System.out.println("userAuth is null");
			sendNotfication(eventId, true, false, false);
		});
	}

	private void sendNotfication(String eventId, boolean emailToBeSent, boolean smsToBeSent, boolean whatsAppToBeSent) {
		
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(currentUser.getToken()); 
		
		HttpEntity<HashMap<String, Object>> request = new HttpEntity<HashMap<String, Object>>(placeholderMap, headers);
		
		if (emailToBeSent) {
			restTemplate.exchange(EMAIL_ENDPOINTURL.concat(eventId), HttpMethod.POST, request, Boolean.class);
		}
		if (smsToBeSent) {
			restTemplate.exchange(SMS_ENDPOINTURL.concat(eventId), HttpMethod.POST, request, Boolean.class);
		}
		if (whatsAppToBeSent) {
			restTemplate.exchange(WHATSAPP_ENDPOINTURL.concat(eventId), HttpMethod.POST, request, Boolean.class);
		}
	}
	

}
