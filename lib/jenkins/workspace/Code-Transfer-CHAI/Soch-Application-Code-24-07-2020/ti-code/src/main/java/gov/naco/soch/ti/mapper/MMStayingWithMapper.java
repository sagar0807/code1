package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterStayingWith;

@Mapper(componentModel = "spring")
@Named("stayingWith")
public interface MMStayingWithMapper {// extends EntityMapper<MiniMasterDto, MasterStayingWith> {

	MasterStayingWith toStayingWithEntity(MiniMasterDto masterStayingWith);
	
	MiniMasterDto toStayingWithDto(MasterStayingWith masterStayingWith);
}
