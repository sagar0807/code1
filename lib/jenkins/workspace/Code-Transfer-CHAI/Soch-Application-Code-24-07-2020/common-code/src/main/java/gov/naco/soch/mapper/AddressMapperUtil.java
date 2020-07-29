package gov.naco.soch.mapper;

import gov.naco.soch.dto.AddressDto;
import gov.naco.soch.dto.DistrictDto;
import gov.naco.soch.dto.FacilityDto;
import gov.naco.soch.dto.LacAddDto;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.dto.StateDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.Pincode;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.Subdistrict;
import gov.naco.soch.entity.Town;

public class AddressMapperUtil {

	// Function to map AddressDto(gov.naco.soch.dto.AddressDto) to
	// Address(gov.naco.soch.entity.Address)

	public static AddressDto mapToAddressDto(Address address) {
		AddressDto addressDto = new AddressDto();
		DistrictDto districtDto = new DistrictDto();
		StateDto stateDto = new StateDto();
		addressDto.setAddress(address.getAddress());
		addressDto.setDistrictId(address.getDistrict().getId());
		addressDto.setGeoLatitude(address.getGeoLatitude());
		addressDto.setGeoLongitude(address.getGeoLongitude());
		addressDto.setId(address.getId());
		addressDto.setIsActive(address.getIsActive());
		addressDto.setIsDelete(address.getIsDelete());
		addressDto.setPincode(address.getPincode());
		addressDto.setStateId(address.getState().getId());
		addressDto.setCity(address.getCity());
		districtDto = StateDistrictMapperUtil.mapToDistrictDto(address.getDistrict());
		addressDto.setDistrict(districtDto);
		stateDto = StateDistrictMapperUtil.mapToStateDto(address.getState());
		addressDto.setState(stateDto);

		return addressDto;
	}

	public static Address mapToAddress(FacilityDto facilityDto) {
		Address address = new Address();
		District district = new District();
		State state = new State();

		address.setAddress(facilityDto.getFacilityAddress());
		address.setCity(facilityDto.getCity());
		district = StateDistrictMapperUtil.mapToDistrict(facilityDto.getDistrictId());
		address.setDistrict(district);
		address.setId(facilityDto.getAddressId());
		address.setIsActive(facilityDto.getIsActive());
		address.setIsDelete(facilityDto.getIsDelete());
		address.setPincode(facilityDto.getPincode());
		state = StateDistrictMapperUtil.mapToState(facilityDto.getStateId());
		address.setState(state);
		return address;
	}

	
	public static Address mapToAddressFacility(FacilityDto facilityDto,State state,District district,Pincode pincode ) {
		Address address = new Address();
		address.setAddress(facilityDto.getFacilityAddress());
		address.setCity(facilityDto.getCity());
		address.setDistrict(district);
		address.setId(facilityDto.getAddressId());
		address.setIsActive(facilityDto.getIsActive());
		address.setIsDelete(facilityDto.getIsDelete());
		address.setPincodeEntity(pincode);
		address.setState(state);
		return address;
	}
	
	
	public static Address maptoAddressInDelete(FacilityDto facilityDto) {
		Address address = new Address();
		District district = new District();
		State state = new State();

		if (facilityDto != null) {
			address.setCity(facilityDto.getAddress().getCity());
			address.setId(facilityDto.getAddress().getId());
			address.setAddress(facilityDto.getAddress().getAddress());
			address.setGeoLatitude(facilityDto.getAddress().getGeoLatitude());
			address.setGeoLongitude(facilityDto.getAddress().getGeoLongitude());
			address.setIsActive(facilityDto.getIsActive());
			address.setIsDelete(facilityDto.getIsDelete());
			address.setPincode(facilityDto.getAddress().getPincode());
			district = StateDistrictMapperUtil.mapToDistrict(facilityDto.getDistrictId());
			address.setDistrict(district);
			state = StateDistrictMapperUtil.mapToState(facilityDto.getStateId());
			address.setState(state);
		}
		return address;
	}

	public static Address mapToAddressForLac(LacAddDto lacAddDto) {
		Address address = new Address();
		District district = new District();
		State state = new State();
		address.setAddress(lacAddDto.getAddress());
		address.setCity(lacAddDto.getCity());
		district = StateDistrictMapperUtil.mapToDistrict(lacAddDto.getDistrictId());
		address.setDistrict(district);
		address.setIsActive(true);
		address.setIsDelete(false);
		address.setPincode(lacAddDto.getPincode());
		state = StateDistrictMapperUtil.mapToState(lacAddDto.getStateId());
		address.setState(state);
		return address;
	}

	public static Address mapToAddressForLac(LacAddDto lacAddDto, Address address) {
		District district = address.getDistrict();
		State state = address.getState();
		address.setAddress(lacAddDto.getAddress());
		address.setCity(lacAddDto.getCity());
		district = StateDistrictMapperUtil.mapToDistrict(lacAddDto.getDistrictId());
		address.setDistrict(district);
		address.setIsActive(true);
		address.setIsDelete(false);
		address.setPincode(lacAddDto.getPincode());
		state = StateDistrictMapperUtil.mapToState(lacAddDto.getStateId());
		address.setState(state);
		return address;

	}

	public static Address mapSacsFacilityDtoToAddressFacility(SacsFacilityDto sacsFacilityDto, State state,
			District district, Town town, Subdistrict subdistrict, Pincode pincode) {
		Address address = new Address();
		address.setAddressLineOne(sacsFacilityDto.getAddressLineOne());
		address.setAddressLineTwo(sacsFacilityDto.getAddressLineTwo());
		address.setCity(sacsFacilityDto.getCity());
		address.setDistrict(district);
		address.setCountry(sacsFacilityDto.getCountry());
		address.setIsActive(true);
		address.setIsDelete(false);
		address.setPincodeEntity(pincode);
		address.setState(state);
		address.setSubdistrict(subdistrict);
		address.setTown(town);
		
		return address;
	}

	public static Address mapSacsFacilityDtoToAddressFacilityInEdit(SacsFacilityDto sacsFacilityDto, State state,
			District district, Town town, Subdistrict subdistrict, Pincode pincode, Address address) {
		
		address.setAddressLineOne(sacsFacilityDto.getAddressLineOne());
		address.setAddressLineTwo(sacsFacilityDto.getAddressLineTwo());
		address.setCity(sacsFacilityDto.getCity());
		address.setDistrict(district);
		address.setCountry("India");
		address.setPincodeEntity(pincode);
		address.setState(state);
		address.setSubdistrict(subdistrict);
		address.setTown(town);
		
		return address;
	}

}
