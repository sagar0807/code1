package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstFollowUpBy;
import gov.naco.soch.ti.dto.TiOstFollowUpByDTO;

@Mapper(componentModel = "spring",uses=MMFollowUpByMapper.class)
public interface TiOstFollowUpByMapper extends EntityMapper<TiOstFollowUpByDTO, TiOstFollowUpBy> {
	
	@Mapping(source="tiostFollowUp.id",target="followUpId")
	@Mapping(target="followUpBy",qualifiedByName="followUpBy")
	TiOstFollowUpByDTO toDto(TiOstFollowUpBy tIOstFollowUpBy);
	
	@InheritInverseConfiguration
	TiOstFollowUpBy toEntity(TiOstFollowUpByDTO tIOstFollowUpByDTO);
	
	 default TiOstFollowUpBy fromId(Long id) {
	        if (id == null) {
	            return null;
	        }
	        TiOstFollowUpBy tiOstFollowUpBy = new TiOstFollowUpBy();
	        tiOstFollowUpBy.setId(id);
	        return tiOstFollowUpBy;
	    }

}
