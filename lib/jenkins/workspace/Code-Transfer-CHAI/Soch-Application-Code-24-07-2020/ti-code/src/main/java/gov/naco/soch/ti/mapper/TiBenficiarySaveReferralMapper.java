package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;

/**
* Mapper for the entity {@link TIBeneficiary} and its DTO
* {@link TIBeneficiaryDTO}.
*/
@Mapper(componentModel = "spring", uses = { 
TIBenCounsellingMapper_Initial.class, TIBenChildDetailsMapper.class,MMTypologyMapper.class,MMHrgSecondaryMapper.class,MMSubCategoryMapper.class,
MMDestinationDurationMapper.class,MMMobilityTypeMapper.class,MMStayingWithMapper.class,MMRegistrationDoneAtMapper.class,
                                TIBenRVAssessmentMapper_Initial.class, TIStiTreatmentMapper_Initial.class, TIBenScrDetailsMapper_Initial.class})
public interface TiBenficiarySaveReferralMapper extends EntityMapper<TIBeneficiaryDTO,TIBeneficiary>{
             
                TIBeneficiary toEntity(TIBeneficiaryDTO tiBeneficiaryDTO);
 
                @InheritInverseConfiguration
                TIBeneficiaryDTO toDto(TIBeneficiary tiBeneficiary);
 
                default TIBeneficiary fromId(Long id) {
                                if (id == null) {
                                                return null;
                                }
                                TIBeneficiary tIBeneficiary = new TIBeneficiary();
                                tIBeneficiary.setId(id);
                                return tIBeneficiary;
                }
}
