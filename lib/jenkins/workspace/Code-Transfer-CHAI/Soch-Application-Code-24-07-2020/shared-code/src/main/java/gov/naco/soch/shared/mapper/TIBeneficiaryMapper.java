package gov.naco.soch.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.shared.dto.ti.TIBeneficiaryDTO;


/**
 * Mapper for the entity {@link TIBeneficiary} and its DTO
 * {@link TIBeneficiaryDTO}.
 */

@Mapper(componentModel = "spring", uses = {MMTypologyMapper.class,MMTiStatusMapper.class})
public interface TIBeneficiaryMapper extends EntityMapper<TIBeneficiaryDTO, TIBeneficiary> {

	@Mapping(target="hrgPrimary",qualifiedByName="typology")
	@Mapping(target = "status", qualifiedByName = "tiBenStatus")
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