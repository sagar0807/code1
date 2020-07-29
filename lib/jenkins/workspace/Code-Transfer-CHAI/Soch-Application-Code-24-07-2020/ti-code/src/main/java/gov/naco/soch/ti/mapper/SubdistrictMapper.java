package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import gov.naco.soch.dto.SubdistrictDto;
import gov.naco.soch.entity.Subdistrict;

@Mapper(componentModel = "spring", uses = {})
public interface SubdistrictMapper  extends EntityMapper<SubdistrictDto,Subdistrict> {
	
	Subdistrict toEntity(SubdistrictDto subdistrictDto);
	
	@InheritInverseConfiguration
	SubdistrictDto toDto(Subdistrict subdistrict);

	default Subdistrict fromId(Long id) {
		if (id == null) {
			return null;
		}
		Subdistrict subdistrict = new Subdistrict();
		subdistrict.setSubdistrictId(id);
		return subdistrict;
	}
}
