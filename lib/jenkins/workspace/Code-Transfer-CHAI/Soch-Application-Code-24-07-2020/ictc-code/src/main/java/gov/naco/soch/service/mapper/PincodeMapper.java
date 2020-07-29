package gov.naco.soch.service.mapper;

import org.mapstruct.Mapper;

import gov.naco.soch.domain.Pincode;
import gov.naco.soch.service.dto.PincodeDTO;

@Mapper(componentModel = "spring", uses = {})
public interface PincodeMapper extends EntityMapper<PincodeDTO, Pincode>{
	
	default Pincode fromId(Long pincodeId) {
        if (pincodeId == null) {
            return null;
        }
        Pincode pincode = new Pincode();
        pincode.setId(pincodeId);
        return pincode;
    }
	
}
