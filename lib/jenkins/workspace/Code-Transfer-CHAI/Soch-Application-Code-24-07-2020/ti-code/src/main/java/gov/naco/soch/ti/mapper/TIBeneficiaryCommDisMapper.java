package gov.naco.soch.ti.mapper;



import org.mapstruct.*;

import gov.naco.soch.entity.TIBeneficiaryCommDis;
import gov.naco.soch.ti.dto.TIBeneficiaryCommDisDTO;

/**
 * Mapper for the entity {@link TIBeneficiaryCommDis} and its DTO {@link TIBeneficiaryCommDisDTO}.
 */
@Mapper(componentModel = "spring",uses={BeneficiaryMapper.class,BeneficiaryFacilityMapper.class,MMTypologyMapper.class,MMContactTypeMapper.class})
public interface TIBeneficiaryCommDisMapper extends EntityMapper<TIBeneficiaryCommDisDTO, TIBeneficiaryCommDis> {

	@Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
	@Mapping(source="beneficiary.beneficiary.address.state.id",target="beneficiary.masterBeneficiary.address.stateId")
	@Mapping(source="beneficiary.beneficiary.address.district.id",target="beneficiary.masterBeneficiary.address.districtId")
	@Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
	@Mapping(source="beneficiary.tiCounselling",target="beneficiary.tiCounselling",ignore=true)
	@Mapping(source="beneficiary.tiAssessment",target="beneficiary.tiAssessment",ignore=true)
	@Mapping(source="beneficiary.tiStiTreatment",target="beneficiary.tiStiTreatment",ignore=true)
	@Mapping(source="beneficiary.tiScreening",target="beneficiary.tiScreening",ignore=true)
    TIBeneficiaryCommDisDTO toDto(TIBeneficiaryCommDis tIBeneficiaryCommDis);

	@InheritInverseConfiguration
    TIBeneficiaryCommDis toEntity(TIBeneficiaryCommDisDTO tIBeneficiaryCommDisDTO);

    default TIBeneficiaryCommDis fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBeneficiaryCommDis tIBeneficiaryCommDis = new TIBeneficiaryCommDis();
        tIBeneficiaryCommDis.setId(id);
        return tIBeneficiaryCommDis;
    }
}
