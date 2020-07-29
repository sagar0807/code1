package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIBeneficiaryExtDetails;
import gov.naco.soch.ti.dto.TIBenTransitListDto;

@Mapper(componentModel = "spring")
public interface TIBenTransitListMapper extends EntityMapper<TIBenTransitListDto, TIBeneficiaryExtDetails>{
	
	 @Mapping(source = "beneficiary.id", target = "beneficiaryId")
	 @Mapping(source="facility.id",target="facilityId")
	 @Mapping(source = "beneficiary.beneficiary", target = "beneficiaryDto")
	 TIBenTransitListDto toDto(TIBeneficiaryExtDetails tIBenExtDetails);

	    @InheritInverseConfiguration
	    TIBeneficiaryExtDetails toEntity(TIBenTransitListDto tIBenExtDetailsDTO);

	    default TIBeneficiaryExtDetails fromId(Long id) {
	        if (id == null) {
	            return null;
	        }
	        TIBeneficiaryExtDetails tIBenExtDetails = new TIBeneficiaryExtDetails();
	        tIBenExtDetails.setId(id);
	        return tIBenExtDetails;
	    }

}
