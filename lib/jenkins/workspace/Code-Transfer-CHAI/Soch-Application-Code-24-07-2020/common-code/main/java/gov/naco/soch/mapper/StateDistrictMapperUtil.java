package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import gov.naco.soch.dto.DistrictDto;
import gov.naco.soch.dto.StateDto;
import gov.naco.soch.dto.SubdistrictDto;
import gov.naco.soch.dto.TownDto;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.Subdistrict;

public class StateDistrictMapperUtil {

	public static List<StateDto> mapStateObjToStateDto(List<Object[]> stateObj) {
		List<StateDto> stateDtos = stateObj.stream().map(objects -> {
			StateDto stateDto = new StateDto();
			stateDto.setId((long) ((Integer) objects[0]).intValue());
			stateDto.setName(objects[1].toString());
			return stateDto;
		}).sorted(Comparator.comparing(StateDto::getName)).collect(Collectors.toList());
		return stateDtos;
	}

	public static List<DistrictDto> mapDistrictObjToDistrictDto(List<Object[]> districtObj) {
		List<DistrictDto> districtDtos = districtObj.stream().map(objects -> {
			DistrictDto districtDto = new DistrictDto();
			districtDto.setId((long) ((Integer) objects[0]).intValue());
			districtDto.setStateid((long) ((Integer) objects[1]).intValue());
			districtDto.setName(objects[2].toString());
			return districtDto;
		}).sorted(Comparator.comparing(DistrictDto::getName)).collect(Collectors.toList());
		return districtDtos;
	}

	// map stateId from addressDto to state
	public static State mapToState(Long stateId) {
		State state = new State();
		state.setId(stateId);
		return state;
	}

	// map districtId from addressDto to District
	public static District mapToDistrict(Long districtId) {
		District district = new District();
		district.setId(districtId);
		return district;
	}

	// map state details into stateDto
	public static StateDto mapToStateDto(State state) {
		StateDto stateDto = new StateDto();
		stateDto.setId(state.getId());
		stateDto.setName(state.getName());
		return stateDto;
	}

	// map district details into districtDto
	public static DistrictDto mapToDistrictDto(District district) {
		DistrictDto districtDto = new DistrictDto();
		districtDto.setId(district.getId());
		districtDto.setName(district.getName());
		return districtDto;
	}

	public static List<SubdistrictDto> mapSubdistrictListToSubdistrictDtoList(List<Subdistrict> subdistrictList) {
		List<SubdistrictDto> subdistrictDtoList = new ArrayList<>();
		subdistrictList.forEach(subdistrict -> {
			SubdistrictDto subdistrictDto = new SubdistrictDto();
			subdistrictDto.setDistrictId(subdistrict.getDistrict().getId());
			subdistrictDto.setDistrictName(subdistrict.getDistrict().getName());
			subdistrictDto.setSubdistrictId(subdistrict.getSubdistrictId());
			subdistrictDto.setSubDistrictName(subdistrict.getSubdistrictName());
			List<TownDto> townDtoList = new ArrayList<>();
			subdistrict.getTowns().forEach(town -> {
				TownDto townDto = new TownDto();
				townDto.setTownId(town.getTownId());
				townDto.setTownName(town.getTownName());
				townDtoList.add(townDto);
			});
			subdistrictDto.setTowns(townDtoList.stream().sorted(Comparator.comparing(TownDto::getTownName))
					.collect(Collectors.toList()));
			subdistrictDtoList.add(subdistrictDto);
		});

		return subdistrictDtoList.stream().sorted(Comparator.comparing(SubdistrictDto::getSubDistrictName))
				.collect(Collectors.toList());
	}

	public static StateDto mapStateToStateDto(State state) {
		StateDto stateDto = new StateDto();
		stateDto.setId(state.getId());
		stateDto.setName(state.getName());
		List<DistrictDto> districtDtos = new ArrayList<>();
		if (!state.getDistricts().isEmpty()) {		
			for (District district : state.getDistricts()) {
				DistrictDto districtDto = new DistrictDto();
				districtDto.setId(district.getId());
				districtDto.setName(district.getName());
				districtDto.setStateid(state.getId());
				districtDtos.add(districtDto);
			}
			Collections.sort(districtDtos);
			stateDto.setDistricts(districtDtos);
		}
		return stateDto;
	}
}
