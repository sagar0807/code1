package gov.naco.soch.cst.controller;

import gov.naco.soch.cst.dto.ArtBeneficiaryDeleteDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryListDto;
import gov.naco.soch.cst.dto.ArtRegistrationDto;
import gov.naco.soch.cst.dto.ArtSearchResultDto;
import gov.naco.soch.cst.service.ArtBeneficiaryService;
import gov.naco.soch.dto.BeneficiaryWorkloadDto;
import gov.naco.soch.enums.BeneficiaryCategoryEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/beneficiary")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryController {

    private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryController.class);

    @Autowired
    private ArtBeneficiaryService artBeneficiaryService;

    @PostMapping("/save")
    public ArtRegistrationDto saveBeneficiary(@RequestBody ArtRegistrationDto artRegistrationDto) {
        logger.debug("saveBeneficiary method is invoked");
        artBeneficiaryService.saveBeneficiary(artRegistrationDto);
        logger.debug("saveBeneficiary method returns with parameters->{}", artRegistrationDto);
        return artRegistrationDto;

    }
    @GetMapping("/lookup")
    public ArtSearchResultDto getArtBeneficiaryList(@RequestParam(required = false) String searchParameters,
                                                    @RequestParam(required = true) Integer pageNumber, @RequestParam(required = true) Integer pageSize, @RequestParam(required = false) String fieldName, @RequestParam(required = false) String sortOrder) {

        logger.info("getArtBeneficiaryList method is invoked");
        ArtSearchResultDto artBeneficiarySearchResult = artBeneficiaryService.getArtBeneficiaryList(searchParameters, BeneficiaryCategoryEnum.ADULT.getCategoryType(),pageNumber, pageSize, fieldName, sortOrder);
        logger.info("getArtBeneficiaryList method returns with parameters->{}", artBeneficiarySearchResult.toString());

        return artBeneficiarySearchResult;
    }

    @GetMapping("/listPaediatric")
    public ArtSearchResultDto getArtBeneficiaryPaediatricList(@RequestParam(required = false) String searchParameters,
                                                              @RequestParam(required = true) Integer pageNumber, @RequestParam(required = true) Integer pageSize, @RequestParam(required = false) String fieldName, @RequestParam(required = false) String sortOrder) {

        logger.info("getArtBeneficiaryPaediatricList method is invoked");
        ArtSearchResultDto artBeneficiarySearchResult = artBeneficiaryService.getArtBeneficiaryList(searchParameters,BeneficiaryCategoryEnum.PAEDIATRIC.getCategoryType(), pageNumber, pageSize, fieldName, sortOrder);
        logger.info("getArtBeneficiaryPaediatricList method returns with parameters->{}", artBeneficiarySearchResult.toString());

        return artBeneficiarySearchResult;
    }
    @GetMapping("/listInPresentFacility")
    public ArtSearchResultDto getArtBeneficiariesInPresentFacility(@RequestParam(required = false) String searchParameters,
                                                                   @RequestParam(required = true) Integer pageNumber, @RequestParam(required = true) Integer pageSize ,@RequestParam(required = false) String fieldName, @RequestParam(required = false) String sortOrder) {

        logger.info("getArtBeneficiariesInPresentFacility method is invoked");
        ArtSearchResultDto artBeneficiarySearchResult = artBeneficiaryService.getArtBeneficiaryList(searchParameters,BeneficiaryCategoryEnum.BENEFICIARY_IN_PRESENT_FACILITY.getCategoryType(), pageNumber, pageSize, fieldName, sortOrder);
        logger.info("getArtBeneficiariesInPresentFacility method returns with parameters->{}", artBeneficiarySearchResult.toString());

        return artBeneficiarySearchResult;
    }

    @GetMapping("/listByDispensation")
    public ArtSearchResultDto getArtBeneficiaryByDispensationHistory(@RequestParam(required = false) String searchParameters,
                                                                     @RequestParam(required = true) Integer pageNumber, @RequestParam(required = true) Integer pageSize,  @RequestParam(required = false) String fieldName, @RequestParam(required = false) String sortOrder) {

        logger.info("getArtBeneficiaryByDispensationHistory method is invoked");
        ArtSearchResultDto artBeneficiarySearchResult = artBeneficiaryService.getArtBeneficiaryList(searchParameters,BeneficiaryCategoryEnum.BENEFICIARY_WITH_DISPENSATION_HISTORY.getCategoryType(), pageNumber, pageSize, fieldName, sortOrder);
        logger.info("getArtBeneficiaryByDispensationHistory method returns with parameters->{}", artBeneficiarySearchResult.toString());

        return artBeneficiarySearchResult;
    }

    @GetMapping("/listById")
    public ArtRegistrationDto getArtBeneficiaryById(Long beneficiaryId) {

        logger.info("getArtBeneficiaryById method is invoked");
        ArtRegistrationDto artRegistrationDto = artBeneficiaryService.getArtBeneficiaryById(beneficiaryId);
        logger.info("getArtBeneficiaryById method returns with parameters->{}", artRegistrationDto.toString());

        return artRegistrationDto;
    }

    @PostMapping("/delete")
    public ArtBeneficiaryDeleteDto deleteArtBeneficiary(@RequestBody ArtBeneficiaryDeleteDto artBeneficiaryDeleteDto){
        logger.info("deleteArtBeneficiary method is invoked");
        ArtBeneficiaryDeleteDto artDeleteDto =  artBeneficiaryService.deleteArtBeneficiary(artBeneficiaryDeleteDto);
        return artDeleteDto;

    }

    @GetMapping("basicInfo/{beneficiaryId}")
    public ArtRegistrationDto getArtBeneficiaryBasicData(@PathVariable Long beneficiaryId) {
        logger.info("getArtBeneficiaryBasicData method is invoked");
        ArtRegistrationDto ArtBeneficiaryBasicDataDto = artBeneficiaryService.getArtBeneficiaryBasicData(beneficiaryId);
        logger.info("getArtBeneficiaryBasicData for  beneficiaryId, {}", ArtBeneficiaryBasicDataDto.toString());
        return ArtBeneficiaryBasicDataDto;
    }


}
