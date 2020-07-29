//package gov.naco.soch.ti.controller;
//
//import java.net.URISyntaxException;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import gov.naco.soch.ti.dto.TIBenCounsellingListDTO;
//import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
//import gov.naco.soch.ti.dto.TIBeneficiaryFullDetailsDTO;
//import gov.naco.soch.ti.dto.TIDispensationExpectedListDTO;
//import gov.naco.soch.ti.service.TIBeneficiariesServiceImpl;
//import gov.naco.soch.ti.service.TIBeneficiaryQueryService;
//import gov.naco.soch.web.rest.errors.BadRequestAlertException;
//
//@RestController
//@RequestMapping("/api")
//public class TIBeneficiariesController {
//
//    private final Logger log = LoggerFactory.getLogger(TIBeneficiariesController.class);
//    
//    private static final String ENTITY_NAME = "tIBeneficiary";
//    
//    
//	@Autowired
//	TIBeneficiariesServiceImpl tIBeneficiaryService;
//	
//	@Autowired
//	TIBeneficiaryQueryService tIBeneficiaryQueryService;
//	
//
//	@PostMapping("/ti-beneficiary/delete") 
//	public boolean deleteTIBeneficiary(@Valid @RequestBody TIBeneficiaryDTO tiBeneficiaryDTO) {
//		log.debug("REST request to delete TIBeneficiary : {}", tiBeneficiaryDTO);	 
//		return  tIBeneficiaryService.deleteBeneficiary(tiBeneficiaryDTO);
//	}
//
//	@PostMapping("/ti-beneficiary/save")
//	public TIBeneficiaryFullDetailsDTO createTIBeneficiary(@Valid @RequestBody TIBeneficiaryFullDetailsDTO tiBeneficiaryFullDetailsDTO) throws URISyntaxException {
//		log.debug("REST request to save TIBeneficiary : {}", tiBeneficiaryFullDetailsDTO);
//		if (null!=tiBeneficiaryFullDetailsDTO.getBeneficiaryDTO().getId()) {
//			throw new BadRequestAlertException("A new tIBeneficiary cannot already have an ID", ENTITY_NAME, "idexists");
//		}
//		return tIBeneficiaryService.save(tiBeneficiaryFullDetailsDTO);
//	}
//
//	
//	 @PostMapping("/ti-beneficiary/update")
//	    public TIBeneficiaryFullDetailsDTO updateTIBeneficiary(@Valid @RequestBody TIBeneficiaryFullDetailsDTO tiBeneficiaryFullDetailsDTO) throws URISyntaxException {
//	        log.debug("REST request to update TIBeneficiary : {}", tiBeneficiaryFullDetailsDTO);
//	        if (tiBeneficiaryFullDetailsDTO.getBeneficiaryDTO().getId() == null) {
//	            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//	        }
//	        TIBeneficiaryFullDetailsDTO tiBeneficiaryFullDetailsDTOResp = tIBeneficiaryService.save(tiBeneficiaryFullDetailsDTO);
//	        return tiBeneficiaryFullDetailsDTOResp;
//	    }
//
//	 
//	 //
//	 
//	 @GetMapping("/ti-beneficiary/list/{facilityId}/{beneficiaryId}")
//	    public List<TIBeneficiaryFullDetailsDTO> getBeneficiaryFullList(@PathVariable (value = "facilityId", required = true) Long facilityId ,@PathVariable (value = "beneficiaryId", required = false)  Long beneficiaryId)  {
//	        log.debug("REST request to get BeneficiaryFullList : {}");	       
//	        List<TIBeneficiaryFullDetailsDTO> tiBeneficiaryFullDetailsDTOList = tIBeneficiaryService.getBeneficiaryFullList(facilityId,beneficiaryId);
//	        return tiBeneficiaryFullDetailsDTOList;
//	    }
//	 @GetMapping("/ti-beneficiary/dispensation/expectedbeneficiarylist")
//	    public List<TIDispensationExpectedListDTO> getExpectedBeneficiaryList()   {
//	        log.debug("REST request to get Dispensation Expectedbeneficiarylist : {}");	       
//	        List<TIDispensationExpectedListDTO> dispensationExpectedList=tIBeneficiaryService.getExpectedBeneficiaryList();
//	        return dispensationExpectedList;
//	    }
//	 
//	 @GetMapping("/ti-beneficiary/services/counsellinglist")
//	    public List<TIBenCounsellingListDTO> getBeneficiaryCouncellingList()   {
//	        log.debug("REST request to get Dispensation BeneficiaryCouncellingList : {}");	       
//	        List<TIBenCounsellingListDTO> councellingList=tIBeneficiaryService.getBeneficiaryCounsellingList();
//	        return councellingList;
//	    }
//}
