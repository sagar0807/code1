package gov.naco.soch.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.ICTCBeneficiaryQueryService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCBeneficiaryVisitService;
import gov.naco.soch.service.ICTCGeneralService;
import gov.naco.soch.service.ICTCSampleBatchService;
import gov.naco.soch.service.ICTCSampleCollectionService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.IctcLinkedFacilityService;
import gov.naco.soch.service.LabTestSampleBatchService;
import gov.naco.soch.service.LabTestSampleService;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCBatchDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryCriteria;
import gov.naco.soch.service.dto.ICTCBeneficiaryDO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitDTO;
import gov.naco.soch.service.dto.ICTCPregancyFollowUpDTO;
import gov.naco.soch.service.dto.ICTCSampleBatchDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.dto.IctcBeneficiaryDeleteDTO;
import gov.naco.soch.service.dto.IctcLinkedFacilityDTO;
import gov.naco.soch.service.dto.LabTestSampleBatchDTO;
import gov.naco.soch.service.dto.LabTestSampleDTO;
import gov.naco.soch.service.dto.UpdateRelationshipDTO;
import gov.naco.soch.service.dto.UpdateTestResultDTO;
import io.github.jhipster.web.util.HeaderUtil;


/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCVisit}.
 */
@RestController
@RequestMapping("/api")
public class ICTCGeneralController {

    private final Logger log = LoggerFactory.getLogger(ICTCGeneralController.class);

    private static final String ENTITY_NAME = "sochictcIctcVisit";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ICTCVisitService ictcVisitService;
    private final ICTCSampleCollectionService iCTCSampleCollectionService;
    private final ICTCBeneficiaryService iCTCBeneficiaryService;
    private final ICTCBeneficiaryVisitService ictcBeneficiaryVisitService;
    private final ICTCSampleBatchService ictcSampleBatchService;
    private final IctcLinkedFacilityService ictcLinkedFacilityService;
    private final BeneficiaryService beneficiaryService;
    private final LabTestSampleService labTestSampleService;
    private final LabTestSampleBatchService labTestSampleBatchService;
    private final ICTCBeneficiaryQueryService ictcBeneficiaryQueryService;
    private final ICTCGeneralService ictcGeneralService;

    public ICTCGeneralController(
    		ICTCVisitService ictcVisitService, 
    		ICTCSampleCollectionService iCTCSampleCollectionService,
    		ICTCBeneficiaryService iCTCBeneficiaryService,
    		ICTCBeneficiaryVisitService ictcBeneficiaryVisitService,
    		ICTCSampleBatchService ictcSampleBatchService,
    		IctcLinkedFacilityService ictcLinkedFacilityService,
    		BeneficiaryService beneficiaryService,
    		LabTestSampleService labTestSampleService,
    		LabTestSampleBatchService labTestSampleBatchService,
    		ICTCBeneficiaryQueryService ictcBeneficiaryQueryService,
    		ICTCGeneralService ictcGeneralService) {
    	
        this.ictcVisitService = ictcVisitService;
        this.iCTCSampleCollectionService = iCTCSampleCollectionService;
        this.iCTCBeneficiaryService = iCTCBeneficiaryService;
        this.ictcBeneficiaryVisitService = ictcBeneficiaryVisitService;
        this.ictcSampleBatchService = ictcSampleBatchService;
        this.ictcLinkedFacilityService = ictcLinkedFacilityService;
        this.beneficiaryService = beneficiaryService;
        this.labTestSampleService = labTestSampleService;
        this.labTestSampleBatchService = labTestSampleBatchService;
        this.ictcBeneficiaryQueryService = ictcBeneficiaryQueryService;
        this.ictcGeneralService = ictcGeneralService;
    }
    
    /**
     *	POST /ictc-beneficiary-details : to create beneficiary
     * 
     * @param beneficiaryDO beneficiaryDO
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/ictc-beneficiary")
    public ResponseEntity<ICTCBeneficiaryDTO> createICTCBeneficiary(@Valid @RequestBody ICTCBeneficiaryDO beneficiaryDO) throws URISyntaxException {
    	ICTCBeneficiaryDTO result = ictcGeneralService.createICTCBeneficiary(beneficiaryDO);
        return ResponseEntity.created(new URI("/api/ictc-beneficiary" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * GET /ictc-beneficiary-details : to get beneficiary details using id
     * 
     * @param id id
     * @return
     */
    @GetMapping("/ictc-beneficiary-details/{id}")
    public ResponseEntity<ICTCBeneficiaryDO> getBeneficiaryDetails(@PathVariable Long id){
    	return ResponseEntity.ok().body(ictcGeneralService.getICTCBeneficiaryDetails(id));
    }
    
    /**
     * PUT /ictc-beneficiary-results update beneficiary details
     * 
     * @param details details
     * @return
     */
    @PutMapping("/ictc-beneficiary-details")
    public ResponseEntity<ICTCBeneficiaryDO> updateBeneficiaryDetails(@RequestBody ICTCBeneficiaryDO details){
    	return ResponseEntity.ok().body(ictcGeneralService.updateICTCBeneficiaryDetails(details));
    }
    
    /**
     * DELETE /ictc-beneficiary-details : To delete an entity
     * 
     * @param id id
     * @return
     */
    @DeleteMapping("/ictc-beneficiary-details/{id}")
    public ResponseEntity<Void> deleteICTCBeneficiaryDetails(@PathVariable Long id){
    	ictcGeneralService.deleteICTCBeneficiary(id);
    	return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
    
    /**
     * PUT /ictc-sample/result : Update beneficiary test result status
     * 
     * @param updateTestResultDTO updateTestResultDTO
     * @return
     */
    @PutMapping("/ictc-sample/result")
    public ResponseEntity<UpdateTestResultDTO> updateICTCSampleCollection(@Valid @RequestBody UpdateTestResultDTO updateTestResultDTO) {
    	return ResponseEntity.ok().body(ictcGeneralService.updateTestResult(updateTestResultDTO));
    }
    
    /**
     * PUT /ictc-sample/result/revoke : Revoke beneficiary test result status
     * 
     * @param resultId resultId
     * @return
     */
    @PutMapping("/ictc-sample/result/revoke/{resultId}")
    public ResponseEntity<Void> updateICTCSampleCollection(@PathVariable Long resultId) {
    	ictcGeneralService.revokeTestResult(resultId);
    	return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, resultId.toString())).build();
    }
    
    
    /**
     * PUT /ictc-post-counselling : Update post test counselling
     * 
     * @param beneficiaryDO beneficiaryDO
     * @return
     * @throws URISyntaxException
     */
    @PutMapping("/ictc-post-counselling")
    public ResponseEntity<ICTCBeneficiaryDO> updatePostCounselling(@RequestBody ICTCBeneficiaryDO beneficiaryDO) throws URISyntaxException {
        log.debug("REST request to update updatePostCounselling : {}", beneficiaryDO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ""))
            .body(ictcGeneralService.updatePostCounselling(beneficiaryDO));
    }
    
    /**
     * PUT /ictc-beneficiary-update-relation: Update relation ship
     * 
     * @param relationship relationship
     * @return
     */
    @PutMapping("/ictc-beneficiary-update-relation")
    public ResponseEntity<ICTCBeneficiaryDTO> updateRelationship(@RequestBody UpdateRelationshipDTO relationship) {
        log.debug("REST request to update updatePostCounselling : {}", relationship);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ""))
            .body(ictcGeneralService.updateInfantRelationship(relationship));
    }
    
    
    /**
     * POST /ictc-initiate-follow-up-visit : To initiate visit after on follow up
     * 
     * @param followUpId followUpId
     * @return
     */
    @PostMapping("/ictc-initiate-follow-up-visit")
    public ResponseEntity<ICTCBeneficiaryDTO> intiateFollowUp(@RequestParam Long followUpId, @RequestParam(required = false) Long facilityId) {
        log.debug("REST request to initiate follow up : {}", followUpId);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ""))
            .body(ictcGeneralService.initiateIctcFollowUpVisit(followUpId, facilityId));
    }
    
    /**
     * PUT /ictc-pregnancy-follow-up : To update pregnancy details at the time of pregnancy followup
     * 
     * @param details details
     * @return
     * @throws URISyntaxException
     */
    @PutMapping("/ictc-pregnancy-follow-up")
    public ResponseEntity<ICTCPregancyFollowUpDTO> ictcPregnancyFollowUp(@RequestBody ICTCPregancyFollowUpDTO details) {
        log.debug("REST request to update ictcVisitDTO : {}", details);
        return ResponseEntity.ok().body(ictcGeneralService.updatePregrancyFollowUpDetails(details));
    }
    
    
    /**
     * PUT /ictc-beneficiary-details/reason : To delete an entity with reason
     * 
     * @param ictcBeneficiaryDeleteDTO ictcBeneficiaryDeleteDTO
     * @return
     */
    @PutMapping("/ictc-beneficiary-details/reason")
    public ResponseEntity<Void> deleteICTCBeneficiaryDetailsWithReason(@RequestBody IctcBeneficiaryDeleteDTO ictcBeneficiaryDeleteDTO){
    	ictcGeneralService.deleteIctcBeneficiaryWithReason(ictcBeneficiaryDeleteDTO);
    	return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, ictcBeneficiaryDeleteDTO.getIctcBeneficiaryId().toString())).build();
    }
    
    
//    /// old code starts
//    
//    @PutMapping("/ictc-beneficiary")
//    public ResponseEntity<ICTCBeneficiaryDO> updateICTCBeneficiary(@RequestBody ICTCBeneficiaryDO beneficiaryDO) throws URISyntaxException {
//        log.debug("REST request to update updateICTCBeneficiary : {}", beneficiaryDO);
//
//        ICTCBeneficiaryDO resultDO = new ICTCBeneficiaryDO();
//        if(beneficiaryDO.getIctcBeneficiary().getId() != null) {
//        	 ICTCBeneficiaryDTO benResult = iCTCBeneficiaryService.save(beneficiaryDO.getIctcBeneficiary());
//        	 resultDO.setIctcBeneficiary(benResult);
//        }
//         
//        if(beneficiaryDO.getVisit().getId() != null) {
//        	ICTCVisitDTO ivResult = ictcVisitService.save(beneficiaryDO.getVisit());
//        	resultDO.setVisit(ivResult);
//        }
//         
//        if(beneficiaryDO.getSample().getId() != null) {
//        	iCTCSampleCollectionService.save(beneficiaryDO.getSample());
//        }
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ""))
//            .body(resultDO);
//    }
    
    
    
    @GetMapping("/ictc-visit/{id}")
	 @ResponseBody ResponseEntity<ICTCBeneficiaryDO> getICTCVisit(@PathVariable Long id) {
	        log.debug("REST request to get getICTCVisit beneficiaryId visit : {}", id);
	        ICTCBeneficiaryVisitDTO benVisit=ictcBeneficiaryVisitService.findOne(id).get();
	        ICTCVisitDTO visit=ictcVisitService.findOne(benVisit.getVisitId()).get();
//	        ICTCSampleCollectionDTO sample = iCTCSampleCollectionService.findOne(benVisit.getSampleCollectionId()).get();
	        ICTCBeneficiaryDTO ictcBeneficiary = iCTCBeneficiaryService.findOne(benVisit.getId()).get();
	        BeneficiaryDTO beneficiary = beneficiaryService.findOne(benVisit.getBeneficiaryId()).get();
	        ICTCBeneficiaryDO beneficiaryDO = new ICTCBeneficiaryDO();
	        beneficiaryDO.setIctcBeneficiary(ictcBeneficiary);
//	        beneficiaryDO.setSample(sample);
	        beneficiaryDO.setVisit(visit);
	        beneficiaryDO.setBeneficiary(beneficiary);
	        return ResponseEntity.ok()
	                .body(beneficiaryDO);
	 }
    
	 @PostMapping("/ictc-batch")
	    public ResponseEntity<ICTCSampleBatchDTO> createICTCBeneficiary(@Valid @RequestBody ICTCBatchDTO batchDTO) throws URISyntaxException {
	        log.debug("REST request to save batchDTO : {}", batchDTO);
	
	        ICTCSampleBatchDTO ictcSampleBatch = new ICTCSampleBatchDTO();
	        LabTestSampleBatchDTO sampleBatchDTO = new LabTestSampleBatchDTO();

//	        ictcSampleBatch.setLabId(batchDTO.getLabId());
//	        ictcSampleBatch.setConsignmentId(batchDTO.getConsignmentId());
//	        ictcSampleBatch.setDispatchDate(LocalDate.now());
////	        ictcSampleBatch.setBatchStatus("DISPATCHED");
//	        ictcSampleBatch = ictcSampleBatchService.save(ictcSampleBatch);
	        
//	        sampleBatchDTO.setLabId(batchDTO.getLabId());
//	        sampleBatchDTO.setNumOfSamples(batchDTO.getSamples().size());
//	        sampleBatchDTO.setBdnSerialNumber(batchDTO.getConsignmentId());
//	        sampleBatchDTO.setDispatchDate(LocalDate.now());
//	        sampleBatchDTO.setBatchStatusId(1);
//	        sampleBatchDTO.setIsDelete(false);
//	        sampleBatchDTO = labTestSampleBatchService.save(sampleBatchDTO);
	        
	        for (Long sampleId : batchDTO.getSamples()) {
				ICTCSampleCollectionDTO sampleCollectionDTO = iCTCSampleCollectionService.findOne(sampleId).get();
				sampleCollectionDTO.setBatchId(ictcSampleBatch.getId());
//				sampleCollectionDTO.setSampleStatus("DISPATCHED");
//				sampleCollectionDTO.setDispatchDate(ictcSampleBatch.getDispatchDate());
				iCTCSampleCollectionService.save(sampleCollectionDTO);
				
				LabTestSampleDTO labTestSampleDTO = new LabTestSampleDTO();
//				labTestSampleDTO.setBeneficiaryId(sampleCollectionDTO.getBeneficiaryId());
				labTestSampleDTO.setBarcodeNumber(sampleCollectionDTO.getBarcode());
				labTestSampleDTO.setSampleStatusId(3);
				labTestSampleDTO.setTestBatchId(sampleBatchDTO.getId());
//				String testType = sampleCollectionDTO.getTestType();
				int testTypeId;
//				testTypeId =  "Routine" == testType ? 1 : 1;
//				testTypeId =  "Targeted" == testType ? 2 : 1;
//				testTypeId =  "Repeat" == testType ? 3 : 1;
//				testTypeId =  "Adherence" == testType ? 4 : 1;
//				testTypeId =  "S-DBS-I" == testType ? 5 : 1;
//				testTypeId =  "S-DBS-II" == testType ? 6 : 1;
//				testTypeId =  "S-DBS-III" == testType ? 7 : 1;
//				testTypeId =  "C-DBS-I" == testType ? 8 : 1;
//				testTypeId =  "C-DBS-II" == testType ? 9 : 1;
//				testTypeId =  "C-DBS-III" == testType ? 10 : 1;
//				testTypeId =  "Antibody-I" == testType ? 11 : 1;
//				testTypeId =  "Antibody-II" == testType ? 12 : 1;
//				testTypeId =  "Antibody-III" == testType ? 13 : 1;
//				labTestSampleDTO.setTestTypeId(testTypeId);
				labTestSampleDTO.setIsDelete(false);
				labTestSampleService.save(labTestSampleDTO);
			}

	        return ResponseEntity.created(new URI("/api/ictc-batch" + ictcSampleBatch.getId()))
	            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, ictcSampleBatch.getId().toString()))
	            .body(ictcSampleBatch);
	}
	 
	 @PostMapping("/ictc-linked-facility")
	    public ResponseEntity<String> saveLinkedFacility(@Valid @RequestBody List<IctcLinkedFacilityDTO> linkedFacilityDTOs) throws URISyntaxException {
	        log.debug("REST request to save linkedFacilityDTOs : {}", linkedFacilityDTOs);
	
	        
	        for (IctcLinkedFacilityDTO facilityDTO : linkedFacilityDTOs) {
	        	ictcLinkedFacilityService.save(facilityDTO);
			}

	        return ResponseEntity.created(new URI("/api/ictc-batch" + linkedFacilityDTOs.size()))
	            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, linkedFacilityDTOs.size() + "SAVED"))
	            .body(linkedFacilityDTOs.size() + "SAVED");
	}
	 
	 @DeleteMapping("/ictc-beneficiary/{id}")
	 public ResponseEntity<Void> deleteICTCBeneficiary(@PathVariable Long id) {
		 log.debug("REST request to delete ICTCBeneficiary : {}", id);
		 ICTCBeneficiaryDTO beneficiary = iCTCBeneficiaryService.findOne(id).get();
		 beneficiary.setIsActive(false);
		 beneficiary.setIsDeleted(true);
		 iCTCBeneficiaryService.save(beneficiary);
		 return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
	 }
	 
   @GetMapping("/ictc-beneficiaries-list")
   public ResponseEntity<List<ICTCBeneficiary>> getAllICTCBeneficiaries(ICTCBeneficiaryCriteria criteria, Pageable pageable) {
       log.debug("REST request to get ICTCBeneficiaries by criteria: {}", criteria);
       List<ICTCBeneficiary> page = ictcBeneficiaryQueryService.findList(criteria);
      // HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
       return ResponseEntity.ok().body(page);
   }


}
