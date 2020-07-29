package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIBenCounselling;
import gov.naco.soch.ti.dto.TIBenCounsellingDTO;

/**
 * Mapper for the entity {@link TIBenCounselling} and its DTO
 * {@link TIBenCounsellingDTO}.
 */
@Mapper(componentModel = "spring",uses={TiBenCounsellingTypeMapper.class,TIBeneficiaryMapper.class,BeneficiaryMapper.class,
		MMTypologyMapper.class,BeneficiaryFacilityMapper.class})
public interface TIBenCounsellingMapper extends EntityMapper<TIBenCounsellingDTO, TIBenCounselling> {

	@Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
	@Mapping(source="facility.id",target="facilityId")
	@Mapping(source="beneficiary.beneficiary.address.state.id",target="beneficiary.masterBeneficiary.address.stateId")
	@Mapping(source="beneficiary.beneficiary.address.district.id",target="beneficiary.masterBeneficiary.address.districtId")
	@Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
	@Mapping(source="beneficiary.tiCounselling",target="beneficiary.tiCounselling",ignore=true)
	@Mapping(source="beneficiary.tiAssessment",target="beneficiary.tiAssessment",ignore=true)
	@Mapping(source="beneficiary.tiStiTreatment",target="beneficiary.tiStiTreatment",ignore=true)
	@Mapping(source="beneficiary.tiScreening",target="beneficiary.tiScreening",ignore=true)
	TIBenCounsellingDTO toDto(TIBenCounselling tIBenCounselling);
	
    @InheritInverseConfiguration
	TIBenCounselling toEntity(TIBenCounsellingDTO tIBenCounsellingDTO);
 

	default TIBenCounselling fromId(Long id) {
		if (id == null) {
			return null;
		}
		TIBenCounselling tIBenCounselling = new TIBenCounselling();
		tIBenCounselling.setId(id);
		return tIBenCounselling;
	}

}
