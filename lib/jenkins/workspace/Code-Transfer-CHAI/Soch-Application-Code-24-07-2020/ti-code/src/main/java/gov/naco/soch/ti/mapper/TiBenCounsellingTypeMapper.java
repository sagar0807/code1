package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiBenCounsellingType;
import gov.naco.soch.ti.dto.TiBenCounsellingTypeDTO;

@Mapper(componentModel = "spring", uses = {MMCounsellingTypeMapper.class})
public interface TiBenCounsellingTypeMapper { // extends EntityMapper<TiBenCounsellingTypeDTO, TiBenCounsellingType> {
	
	@Mapping(target="masterCounsellingType",qualifiedByName="counsellingType")
	TiBenCounsellingTypeDTO toDto(TiBenCounsellingType tiBenCounsellingType);
    
	@InheritInverseConfiguration
	TiBenCounsellingType toEntity(TiBenCounsellingTypeDTO tiBenCounsellingTypeDTO);

	default TiBenCounsellingType fromId(Long id) {
		if (id == null) {
			return null;
		}
		TiBenCounsellingType tiBenCounsellingType = new TiBenCounsellingType();
		tiBenCounsellingType.setId(id);
		return tiBenCounsellingType;
	}

}
