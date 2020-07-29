package gov.naco.soch.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.domain.Subdistrict;
import gov.naco.soch.service.dto.SubdistrictDTO;

@Mapper(componentModel = "spring", uses = {DistrictMapper.class})
public interface SubdistrictMapper extends EntityMapper<SubdistrictDTO, Subdistrict>{

	@Mapping(source = "district.id", target = "districtId")
	SubdistrictDTO toDto(Subdistrict subdistrict);
	
	@Mapping(source = "districtId", target = "district")
    Subdistrict toEntity(SubdistrictDTO subdistrictDTO);
	
	default Subdistrict fromId(Long subdistrictId) {
        if (subdistrictId == null) {
            return null;
        }
        Subdistrict subdistrict = new Subdistrict();
        subdistrict.setSubdistrictId(subdistrictId);
        return subdistrict;
    }
}
