package gov.naco.soch.cst.mapper;

import java.util.*;


import gov.naco.soch.cst.dto.ArtBeneficiaryListDto;
import gov.naco.soch.cst.dto.ArtRegistrationDto;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.MasterArtBeneficiaryStatus;

public class ArtBeneficiaryListMapper {

    public static ArtBeneficiaryListDto mapArtBeneficiaryDueDto(ArtBeneficiaryDueList artBeneficiary) {
        ArtBeneficiaryListDto artBeneficiaryDueDto = new ArtBeneficiaryListDto();
        Beneficiary beneficiary = artBeneficiary.getBeneficiary();
        if (beneficiary != null) {
            artBeneficiaryDueDto.setFirstName(Objects.toString(beneficiary.getFirstName(), "") + " "
                    + Objects.toString(beneficiary.getMiddleName(), "") + " "
                    + Objects.toString(beneficiary.getLastName(), ""));
            artBeneficiaryDueDto.setArtNumber(Objects.toString(beneficiary.getArtNumber(), ""));
            artBeneficiaryDueDto.setPreArtNumber(Objects.toString(beneficiary.getPreArtNumber(), ""));
            artBeneficiaryDueDto.setAge(beneficiary.getAge());
            artBeneficiaryDueDto.setGender(Objects.toString(beneficiary.getGender(), ""));
            artBeneficiaryDueDto.setStatus(Objects.toString(beneficiary.getStatus(), ""));
            artBeneficiaryDueDto.setUid(beneficiary.getUid());
        }
        return artBeneficiaryDueDto;

    }

}
