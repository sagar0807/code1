package gov.naco.soch.ti.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.ti.dto.VisitRegisterDto;
import gov.naco.soch.ti.service.BeneficiaryVisitRegisterUpdateService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VisitRegisterResource {
    
    private final BeneficiaryVisitRegisterUpdateService visitRegisterService;

    public VisitRegisterResource (BeneficiaryVisitRegisterUpdateService visitRegisterService) {
        this.visitRegisterService=visitRegisterService;
    }
    
    @PostMapping("/visit")
    public boolean save(@Valid @RequestBody VisitRegisterDto visitRegDto)
    {
	visitRegisterService.save(visitRegDto, visitRegDto.getModule());
	return true;
    }
    
    

}
