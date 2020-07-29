package gov.naco.soch.cst.controller;

import gov.naco.soch.cst.dto.TransferDto;
import gov.naco.soch.cst.service.ArtBeneficiaryTransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiaryTransfer")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ArtBeneficiaryTransferController {
    private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryController.class);

    @Autowired
    private ArtBeneficiaryTransferService artBeneficiaryTransferService;

    @GetMapping("/transfer")
    public List<TransferDto> getArtTransfers(@RequestParam(required = true) String transferType , @RequestParam(required = false) String searchType, @RequestParam(required = false) MultiValueMap<String, String> queryMap)  {
       logger.info("getArtTransfers method is invoked");
        return artBeneficiaryTransferService.getTransferList(transferType ,searchType,queryMap);

    }

    @GetMapping("/accept")
    public boolean acceptTransfer(@RequestParam(required = true) Long transferId,@RequestParam(required = true)String preArtNumber,@RequestParam(required = true)String artNumber){
        logger.info("accept method is invoked");
        return artBeneficiaryTransferService.acceptTransfer(transferId,preArtNumber,artNumber);
    }


    @GetMapping("/cancel")
    public Long cancelTransfer(@RequestParam(required = true) Long transferId){
        logger.info("cancel Transfer method is invoked");
        return artBeneficiaryTransferService.cancelTransfer(transferId);

    }


}
