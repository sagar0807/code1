package gov.naco.soch.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.shared.dto.ti.TIOstBeneficiaryDTO;


@Mapper(componentModel = "spring", uses = {
		MMTypologyMapper.class,MMRelationshipMapper.class,MMOstStatusMapper.class,MMOstBenStatusMapper.class})
public interface TiOstBeneficiaryMapper extends EntityMapper<TIOstBeneficiaryDTO, TiOstBeneficiary> {

	
	
	@Mapping(target="hrgPrimary",qualifiedByName="typology")
	@Mapping(target="guardianRelationshipType",qualifiedByName="relationship")
	@Mapping(target="ostStatus",qualifiedByName="ostStatus")
	@Mapping(target = "status", qualifiedByName = "tiBenStatus")
	TIOstBeneficiaryDTO toDto(TiOstBeneficiary tiBeneficiary);

	default TiOstBeneficiary fromId(Long id) {
		if (id == null) {
			return null;
		}
		TiOstBeneficiary tIBeneficiary = new TiOstBeneficiary();
		tIBeneficiary.setId(id);
		return tIBeneficiary;
	}
}