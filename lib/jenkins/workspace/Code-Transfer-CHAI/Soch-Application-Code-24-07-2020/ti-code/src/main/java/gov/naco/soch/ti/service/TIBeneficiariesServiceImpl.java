//package gov.naco.soch.ti.service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.CollectionUtils;
//
//import gov.naco.soch.entity.TIBeneficiary;
//import gov.naco.soch.repository.TIBenChildrenRepository;
//import gov.naco.soch.repository.TIBenCounsellingRepository;
//import gov.naco.soch.repository.TIBenFollowUpRepository;
//import gov.naco.soch.repository.TIBenRVAssessmentRepository;
//import gov.naco.soch.repository.TIBenScrDetailsRepository;
//import gov.naco.soch.repository.TIOSTAssessmentRepository;
//import gov.naco.soch.repository.TIOstAssessRepository;
//import gov.naco.soch.repository.TIOstDetailsRepository;
//import gov.naco.soch.repository.TIStiTreatmentRepository;
//import gov.naco.soch.ti.dto.TIBenCounsellingListDTO;
//import gov.naco.soch.ti.dto.TIBeneficiaryCounsellingList;
//import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
//import gov.naco.soch.ti.mapper.TIBenChildDetailsMapper;
//import gov.naco.soch.ti.mapper.TIBenExtDetailsMapper;
//import gov.naco.soch.ti.mapper.TIBeneficiaryMapper;
//import gov.naco.soch.ti.mapper.TIDispensationListMapper;
//import gov.naco.soch.ti.mapper.TIOstDetailsMapper;
//
//
//@Service
//@Transactional
//public class TIBeneficiariesServiceImpl {
//
//	private static final Logger log = LoggerFactory.getLogger(TIBeneficiariesServiceImpl.class);	
//	@Autowired
//	TIBenRVAssessmentRepository tiBenRVAssessmentRepository;
//
//	@Autowired
//	TIBenCounsellingRepository tiBenCounsellingRepository;
//
//
//	@Autowired
//	TIStiTreatmentRepository tiStiTreatmentRepository;
//
//	@Autowired
//	TIBenScrDetailsRepository tiBenScrDetailsRepository;
//
//	@Autowired
//	TIOstAssessRepository tiOstAssessRepository;   
//
//	@Autowired
//	TIBenFollowUpRepository tiBenFollowUpRepository;
//
//	@Autowired
//	TIBenDetailsRepository tIBeneficiaryRepository;
//
//	@Autowired
//	TIBeneficiaryMapper tIBeneficiaryMapper;
//
//	@Autowired
//	TIBenExtDetailsMapper tIBenExtDetailsMapper;
//
//	@Autowired
//	TIBenChildDetailsMapper tIBenChildDetailsMapper;
//
//	@Autowired
//	TIBeneficiaryExtRepository tIBenExtDetailsRepository;
//
//	@Autowired
//	TIBenChildrenRepository tIBenChildDetailsRepository;
//	
//
//	@Autowired
//	TIOstDetailsMapper tiOstDetailsMapper;
//	
//	@Autowired
//	TIOstDetailsRepository tiOstDetailsRepository;
//	
//	
//	@Autowired
//	TIOSTAssessmentRepository tiOSTAssessmentRepository;
//	
//	
//	 @Autowired 	  
//	 TIBenCounsellRepository tiBenCounsellRepository; 	
//		
//	
//	TIDispensationListMapper tiDispensationListMapper;
//	
//	
//	TIBenCounsellMapper tiBenCounsellMapper;
//
//
//	public boolean deleteBeneficiary(TIBeneficiaryDTO tiBeneficiaryDTO) {
//		Optional<TIBeneficiary> tiBeneficiaryOpt=tIBeneficiaryRepository.findById(tiBeneficiaryDTO.getId());
//		if(tiBeneficiaryOpt.isPresent()) {
//			TIBeneficiary tiBeneficiary=tiBeneficiaryOpt.get();
//			if(null!=tiBeneficiaryDTO.getDeletedReason()) {
//				tiBeneficiary.setDeletedReason(tiBeneficiaryDTO.getDeletedReason());
//			}	       
//			tiBeneficiary.setIsDeleted(true);
//			tIBeneficiaryRepository.save(tiBeneficiary);
//			return true;
//		}
//		else {
//			//	 throw new BadRequestAlertException("BeneficiaryID does not exist", ""+id, "idexists");
//			throw new RuntimeException("BeneficiaryID does not exist");
//		}
//
//	}
//
//
//	public TIBeneficiaryFullDetailsDTO save(TIBeneficiaryFullDetailsDTO tiBeneficiaryFullDetailsDTO) {    	
//		//save tibeneficiary
//		TIBeneficiary tiBeneficiary= tIBeneficiaryMapper.toEntity(tiBeneficiaryFullDetailsDTO.getBeneficiaryDTO());	
//		TIBeneficiaryDTO tiBeneficiaryDTO =null;
//		TIBeneficiaryFullDetailsDTO tiBeneficiaryFullDetailsDTOResp=new TIBeneficiaryFullDetailsDTO();
//		if(null==tiBeneficiary.getId()) {
//			tiBeneficiary=tIBeneficiaryRepository.save(tiBeneficiary);	   	    	
//			Long tiBeneficiaryId=tiBeneficiary.getId();	 
//			log.debug("tiBeneficiaryId"+tiBeneficiaryId);
//			tiBeneficiaryDTO=tIBeneficiaryMapper.toDto(tiBeneficiary);	
//			tiBeneficiaryFullDetailsDTOResp.setBeneficiaryDTO(tiBeneficiaryDTO);
//			//Save tibeneficiaryextdetails
//			TIBenExtDetailsDTO tiBenExtDetailsDTO=tiBeneficiaryFullDetailsDTO.getBenExtDetailsDTO();
//			if(null!=tiBenExtDetailsDTO) {
//				tiBenExtDetailsDTO.setBeneficiaryId(tiBeneficiaryId);
//				TIBenExtDetails tIBenExtDetails = tIBenExtDetailsMapper.toEntity(tiBenExtDetailsDTO);
//				tIBenExtDetails=tIBenExtDetailsRepository.save(tIBenExtDetails);
//				tiBenExtDetailsDTO=tIBenExtDetailsMapper.toDto(tIBenExtDetails);
//				tiBeneficiaryFullDetailsDTOResp.setBenExtDetailsDTO(tiBenExtDetailsDTO);
//			}
//			//saving the children part
//			List<TIBenChildDetailsDTO> tiBenChildDetailsDTOList=tiBeneficiaryFullDetailsDTO.getBenChildDetailsDTO();
//			List<TIBenChildDetailsDTO> childrenList=new ArrayList<>();
//			if (!CollectionUtils.isEmpty(tiBenChildDetailsDTOList)) {
//				
//				for(TIBenChildDetailsDTO tiBenChildDetailsDTO:tiBenChildDetailsDTOList) {
//					TIBenChildDetails tIBenChildDetails = tIBenChildDetailsMapper.toEntity(tiBenChildDetailsDTO);
//					tIBenChildDetails.setBeneficiary(tiBeneficiary);
//					tIBenChildDetails=tIBenChildDetailsRepository.save(tIBenChildDetails);
//					childrenList.add(tIBenChildDetailsMapper.toDto(tIBenChildDetails));
//				}
//			}
//			tiBeneficiaryFullDetailsDTOResp.setBenChildDetailsDTO(childrenList);
//			/*
//			 * //save ost details TIOstDetailsDTO
//			 * tiOstDetailsDTO=tiBeneficiaryFullDetailsDTO.getTiOstDetailsDTO();
//			 * if(null!=tiOstDetailsDTO){ TIOstDetails
//			 * tiOstDetails=tiOstDetailsMapper.toEntity(tiOstDetailsDTO);
//			 * tiOstDetails.setBeneficiary(tiBeneficiary);
//			 * tiOstDetailsRepository.save(tiOstDetails); }
//			 */
//			//to enter entry in ti-ben-rv-assessments 
//			TIBenRVAssessment tiBenRVAssessment=new TIBenRVAssessment();
//			tiBenRVAssessment.setBeneficiary(tiBeneficiary);
//			tiBenRVAssessment.setDueDateOfAssessment(LocalDate.now().plusDays(1));
//			tiBenRVAssessment.setAssessmentPending(1);
//			tiBenRVAssessmentRepository.save(tiBenRVAssessment);
//
//
//			//to enter entry in ti-ben-counsellings
//			TIBenCounselling tiBenCounselling=new TIBenCounselling();
//			tiBenCounselling.setBeneficiary(tiBeneficiary);
//			tiBenCounselling.setNextCounsellingDate(LocalDate.now().plusDays(1));
//			tiBenCounsellingRepository.save(tiBenCounselling);
//
//			//to enter entry in ti-sti-treatments
//			TIStiTreatment tiStiTreatment=new TIStiTreatment();
//			tiStiTreatment.setBeneficiary(tiBeneficiary);
//			tiStiTreatment.setNextFollowUpDate(LocalDate.now().plusDays(1));//nextfollowup
//			tiStiTreatmentRepository.save(tiStiTreatment);
//
//			//to enter entry in ti-ben-scr-details
//			TIBenScrDetails tiBenScrDetails=new TIBenScrDetails();
//			tiBenScrDetails.setBeneficiary(tiBeneficiary);
//			tiBenScrDetails.setNextDateOfScreening(LocalDate.now().plusDays(1));
//			tiBenScrDetailsRepository.save(tiBenScrDetails);
//
//			//to enter entry in ti-ost-assesses
//			TIOstAssess tiOstAssess=new TIOstAssess();
//			tiOstAssess.setBeneficiary(tiBeneficiary);
//			tiOstAssess.setNextDateOfAssessment(LocalDate.now().plusDays(1));
//			tiOstAssessRepository.save(tiOstAssess);
//
//			//to enter entry in ti-ben-follow-ups
//
//			TIBenFollowUp tiBenFollowUp=new TIBenFollowUp();
//			tiBenFollowUp.setBeneficiary(tiBeneficiary);
//			tiBenFollowUp.setNextFollowupDate(LocalDate.now().plusDays(1));
//			tiBenFollowUpRepository.save(tiBenFollowUp);
//
//		}
//		else {
//			
//			Optional<TIBeneficiary> tiBeneficiaryOpt=tIBeneficiaryRepository.findById(tiBeneficiaryFullDetailsDTO.getBeneficiaryDTO().getId());			
//			
//			if(tiBeneficiaryOpt.isPresent()) {	
//			
//				tiBeneficiary=tIBeneficiaryRepository.save(tiBeneficiary);	   	    	
//				Long tiBeneficiaryId=tiBeneficiary.getId();	 
//				log.debug("tiBeneficiaryId"+tiBeneficiaryId);
//				tiBeneficiaryDTO =tIBeneficiaryMapper.toDto(tiBeneficiary);	
//				tiBeneficiaryFullDetailsDTOResp.setBeneficiaryDTO(tiBeneficiaryDTO);
//				//Save tibeneficiaryextdetails
//				TIBenExtDetailsDTO tiBenExtDetailsDTO=tiBeneficiaryFullDetailsDTO.getBenExtDetailsDTO();
//				if(null!=tiBenExtDetailsDTO) {
//					tiBenExtDetailsDTO.setBeneficiaryId(tiBeneficiaryId);
//					TIBenExtDetails tIBenExtDetails = tIBenExtDetailsMapper.toEntity(tiBenExtDetailsDTO);
//					tIBenExtDetails=tIBenExtDetailsRepository.save(tIBenExtDetails);
//					tiBenExtDetailsDTO=tIBenExtDetailsMapper.toDto(tIBenExtDetails);
//					tiBeneficiaryFullDetailsDTOResp.setBenExtDetailsDTO(tiBenExtDetailsDTO);
//				}
//				//saving the children part
//				List<TIBenChildDetailsDTO> tiBenChildDetailsDTOList=tiBeneficiaryFullDetailsDTO.getBenChildDetailsDTO();
//				List<TIBenChildDetailsDTO> childrenList=new ArrayList<>();
//				//first deleting the existing child list
//				List<TIBenChildDetails> tiIBenChildDetailsList=tIBenChildDetailsRepository.findAllByBeneficiaryId(tiBeneficiary.getId());
//				for(TIBenChildDetails tiBenChildDetails:tiIBenChildDetailsList) {
//					tIBenChildDetailsRepository.delete(tiBenChildDetails);
//				}
//				
//				if (!CollectionUtils.isEmpty(tiBenChildDetailsDTOList)) {
//					//logic to delete the old children from database and add the latest children which is coming
//					//
//					for(TIBenChildDetailsDTO tiBenChildDetailsDTO:tiBenChildDetailsDTOList) {
//						TIBenChildDetails tIBenChildDetails = tIBenChildDetailsMapper.toEntity(tiBenChildDetailsDTO);
//						tIBenChildDetails.setBeneficiary(tiBeneficiary);
//						tIBenChildDetails=tIBenChildDetailsRepository.save(tIBenChildDetails);
//						childrenList.add(tIBenChildDetailsMapper.toDto(tIBenChildDetails));
//						
//					}
//					tiBeneficiaryFullDetailsDTOResp.setBenChildDetailsDTO(childrenList);
//				}
//				//updatiing the ost details
//				
//				//save ost details
//				TIOstDetailsDTO tiOstDetailsDTO=tiBeneficiaryFullDetailsDTO.getTiOstDetailsDTO();
//				if(null!=tiOstDetailsDTO){
//					TIOstDetails tiOstDetails=tiOstDetailsMapper.toEntity(tiOstDetailsDTO);
//					tiOstDetails.setBeneficiary(tiBeneficiary);
//					tiOstDetails=tiOstDetailsRepository.save(tiOstDetails);
//					tiBeneficiaryFullDetailsDTOResp.setTiOstDetailsDTO(tiOstDetailsMapper.toDto(tiOstDetails));
//				}
//			}
//
//
//			else {			
//				throw new RuntimeException("BeneficiaryID does not exist");
//			}
//		}
//		return tiBeneficiaryFullDetailsDTOResp;
//	}
//	
//	
//	  public List<TIBeneficiaryFullDetailsDTO> getBeneficiaryFullList(Long facilityId,Long beneficiaryId){
//		  List<TIBeneficiaryFullDetailsDTO>  tiBeneficiaryFullDetailsDTOList=new ArrayList<>();
//		  if(0==beneficiaryId) {
//		  
//		
//		  List<TIBeneficiary> beneficiaryList=tIBeneficiaryRepository.findAllByFacilityId(String.valueOf(facilityId));
//		  
//		  for(TIBeneficiary tiBeneficiary:beneficiaryList) {
//			  TIBeneficiaryDTO tiBeneficiaryDTO= tIBeneficiaryMapper.toDto(tiBeneficiary);
//			  //getting the child details
//			  TIBeneficiaryFullDetailsDTO tiBeneficiaryFullDetailsDTO =new TIBeneficiaryFullDetailsDTO();
//			  List<TIBenChildDetails> tiBenChildDetailsList= tIBenChildDetailsRepository.findAllByBeneficiaryId(tiBeneficiary.getId());
//			  List<TIBenChildDetailsDTO> tiBenChildDetailsDTOList= tIBenChildDetailsMapper.toDto(tiBenChildDetailsList);
//			  List<TIBenExtDetails> tiBenExtDetails=tIBenExtDetailsRepository.findByBeneficiaryId(tiBeneficiary.getId());
//			  if(null!=tiBenExtDetails&&tiBenExtDetails.size()>0) {
//			  TIBenExtDetailsDTO tiBenExtDetailsDTO= tIBenExtDetailsMapper.toDto(tiBenExtDetails.get(0));
//			  tiBeneficiaryFullDetailsDTO.setBenExtDetailsDTO(tiBenExtDetailsDTO);
//			  }
//			  //getting the ost 
//			  List<TIOstDetails> tiOstDetails= tiOstDetailsRepository.findByBeneficiaryId(tiBeneficiary.getId());
//			  if(null!=tiOstDetails&&tiOstDetails.size()>0) {
//			  TIOstDetailsDTO tiOstDetailsDTO=tiOstDetailsMapper.toDto(tiOstDetails.get(0));
//			  tiBeneficiaryFullDetailsDTO.setTiOstDetailsDTO(tiOstDetailsDTO);
//			  }
//			  tiBeneficiaryFullDetailsDTO.setBenChildDetailsDTO(tiBenChildDetailsDTOList);
//			  tiBeneficiaryFullDetailsDTO.setBeneficiaryDTO(tiBeneficiaryDTO);
//			  
//			  
//			  tiBeneficiaryFullDetailsDTOList.add(tiBeneficiaryFullDetailsDTO);
//		  }
//		  
//		  }
//		  else {
//			  Optional<TIBeneficiary> tiBeneficiaryOpt=tIBeneficiaryRepository.findByFacilityIdAndId(String.valueOf(facilityId), beneficiaryId);
//			  if(tiBeneficiaryOpt.isPresent()) {
//			  TIBeneficiaryDTO tiBeneficiaryDTO= tIBeneficiaryMapper.toDto(tiBeneficiaryOpt.get());
//			  Long benId=tiBeneficiaryOpt.get().getId();
//			  //getting the child details
//			  TIBeneficiaryFullDetailsDTO tiBeneficiaryFullDetailsDTO =new TIBeneficiaryFullDetailsDTO();
//			  List<TIBenChildDetails> tiBenChildDetailsList= tIBenChildDetailsRepository.findAllByBeneficiaryId(benId);
//			  List<TIBenChildDetailsDTO> tiBenChildDetailsDTOList= tIBenChildDetailsMapper.toDto(tiBenChildDetailsList);
//			  List<TIBenExtDetails> tiBenExtDetails=tIBenExtDetailsRepository.findByBeneficiaryId(benId);
//			  if(null!=tiBenExtDetails&&tiBenExtDetails.size()>0) {
//			    TIBenExtDetailsDTO tiBenExtDetailsDTO= tIBenExtDetailsMapper.toDto(tiBenExtDetails.get(0));
//			    tiBeneficiaryFullDetailsDTO.setBenExtDetailsDTO(tiBenExtDetailsDTO);
//			  }
//			  tiBeneficiaryFullDetailsDTO.setBenChildDetailsDTO(tiBenChildDetailsDTOList);
//			  tiBeneficiaryFullDetailsDTO.setBeneficiaryDTO(tiBeneficiaryDTO);
//			 
//			  //getting the ost 
//			  List<TIOstDetails> tiOstDetails= tiOstDetailsRepository.findByBeneficiaryId(benId);
//			  //TIOstDetailsDTO tiOstDetailsDTO=tiOstDetailsMapper.toDto(tiOstDetails.get(0));			 
//			  if(null!=tiOstDetails&&tiOstDetails.size()>0) {
//			  TIOstDetailsDTO tiOstDetailsDTO=tiOstDetailsMapper.toDto(tiOstDetails.get(0));
//			  tiBeneficiaryFullDetailsDTO.setTiOstDetailsDTO(tiOstDetailsDTO);
//			  tiBeneficiaryFullDetailsDTO.setTiOstDetailsDTO(tiOstDetailsDTO);
//			  }
//			 
//			  tiBeneficiaryFullDetailsDTOList.add(tiBeneficiaryFullDetailsDTO);
//			  }
//			  else {
//				  throw new RuntimeException("The give beneficiaryId and facility does not exist in Beneficiary Table");
//			  }
//			  
//		  }
//		  return tiBeneficiaryFullDetailsDTOList;
//	  }
//	  
//	  public List<TIDispensationExpectedListDTO> getExpectedBeneficiaryList(){
//		  List<TIDispensationExpectedList> expectedBenDispensationList= tiOSTAssessmentRepository.findExpectedBeneficiaryList();
//		  tiDispensationListMapper=new TIDispensationListMapper();
//		  List<TIDispensationExpectedListDTO> dispensationExpectedList=tiDispensationListMapper.mapToArtPatientReferralDto(expectedBenDispensationList);
//		  return dispensationExpectedList;
//	  }
//	  
//	  public List<TIBenCounsellingListDTO> getBeneficiaryCounsellingList(){
//		  List<TIBeneficiaryCounsellingList> counsellingList= tiBenCounsellRepository.findBeneficiaryCounsellingList();
//		  tiBenCounsellMapper=new TIBenCounsellMapper();
//		  List<TIBenCounsellingListDTO> tiBenCounsellingListDTO=tiBenCounsellMapper.mapToArtPatientReferralDto(counsellingList);
//		  
//		  return tiBenCounsellingListDTO;
//	  }
//}
//
//
//
//
//
//
//		
