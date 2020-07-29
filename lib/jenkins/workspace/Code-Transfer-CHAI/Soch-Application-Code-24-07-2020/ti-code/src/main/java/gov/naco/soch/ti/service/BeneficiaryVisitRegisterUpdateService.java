package gov.naco.soch.ti.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterBeneficiaryOstStatus;
import gov.naco.soch.entity.MasterOstClientStatus;
import gov.naco.soch.entity.MasterTiClientStatus;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.ti.dto.VisitRegisterDto;

@Service
@Transactional
public class BeneficiaryVisitRegisterUpdateService {

    private final BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

    public BeneficiaryVisitRegisterUpdateService(
	    BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository) {
	this.beneficiaryVisitRegisterRepository = beneficiaryVisitRegisterRepository;
    }

    public void save(VisitRegisterDto visitRegisterDto, String module) {
	BeneficiaryVisitRegister visitReg = new BeneficiaryVisitRegister();
	if (visitRegisterDto.getFacilityId() != null) {
	    Facility facility = new Facility();
	    facility.setId(visitRegisterDto.getFacilityId());
	    visitReg.setFacility(facility);
	}
	if (visitRegisterDto.getMasterBenId() != null) {
	    Beneficiary masterBen = new Beneficiary();
	    masterBen.setId(visitRegisterDto.getMasterBenId());
	    visitReg.setBeneficiary(masterBen);
	}
	if (module.equalsIgnoreCase("ti")) {
	    if (visitRegisterDto.getTiBeneficiaryId() != null) {
		TIBeneficiary tiBen = new TIBeneficiary();
		tiBen.setId(visitRegisterDto.getTiBeneficiaryId());
		visitReg.setTiBeneficiary(tiBen);
	    }
	    if (visitRegisterDto.getTiClientStatusId() != null) {
		MasterTiClientStatus tiStatus = new MasterTiClientStatus();
		tiStatus.setId(visitRegisterDto.getTiClientStatusId());
		visitReg.setTiClientStatus(tiStatus);
		visitReg.setTiClientStatusDate(visitRegisterDto.getTiClientStatusDate());
	    }
	    beneficiaryVisitRegisterRepository.save(visitReg);
	} else if (module.equalsIgnoreCase("ost")) {
	    if (visitRegisterDto.getOstBeneficiaryId() != null) {
		TiOstBeneficiary ostBen = new TiOstBeneficiary();
		ostBen.setId(visitRegisterDto.getOstBeneficiaryId());
		visitReg.setTiOstBeneficiary(ostBen);
	    }
	    if (visitRegisterDto.getOstClientStatusId() != null) {
		MasterOstClientStatus ostClientStatus = new MasterOstClientStatus();
		ostClientStatus.setId(visitRegisterDto.getOstClientStatusId());
		visitReg.setOstClientStatus(ostClientStatus);
		visitReg.setOstClientStatusDate(visitRegisterDto.getOstClientStatusDate());
	    }
	    if (visitRegisterDto.getOstStatusId() != null) {
		MasterBeneficiaryOstStatus ostStatus = new MasterBeneficiaryOstStatus();
		ostStatus.setId(visitRegisterDto.getOstStatusId());
		visitReg.setOstStatus(ostStatus);
		visitReg.setOstStatusDate(visitRegisterDto.getOstStatusDate());
	    }
	    beneficiaryVisitRegisterRepository.save(visitReg);
	}

    }

}
