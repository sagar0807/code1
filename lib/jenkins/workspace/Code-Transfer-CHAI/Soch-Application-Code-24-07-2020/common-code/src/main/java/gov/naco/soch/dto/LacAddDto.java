package gov.naco.soch.dto;

public class LacAddDto extends BaseDto {
	
	private static final long serialVersionUID = 1L;
	private Long lacId;
	private Long staffNurseId;
	private Long alternatePersonId;
	private Long facilityId;
	private Long divisionId;
	private String name;
	private String status;
	private String address;
	private Long stateId;
	private Long districtId;
	private String city;
	private String pincode;
	private String code;
	private LacUserDto lacStaffNurseDetails ;
	private LacUserDto lacAlternatePersonDetails;
	private Boolean enable;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public Long getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public LacUserDto getLacStaffNurseDetails() {
		return lacStaffNurseDetails;
	}
	public void setLacStaffNurseDetails(LacUserDto lacStaffNurseDetails) {
		this.lacStaffNurseDetails = lacStaffNurseDetails;
	}
	public LacUserDto getLacAlternatePersonDetails() {
		return lacAlternatePersonDetails;
	}
	public void setLacAlternatePersonDetails(LacUserDto lacAlternatePersonDetails) {
		this.lacAlternatePersonDetails = lacAlternatePersonDetails;
	}
	
	public Long getLacId() {
		return lacId;
	}
	public void setLacId(Long lacId) {
		this.lacId = lacId;
	}
	public Long getStaffNurseId() {
		return staffNurseId;
	}
	public void setStaffNurseId(Long staffNurseId) {
		this.staffNurseId = staffNurseId;
	}
	public Long getAlternatePersonId() {
		return alternatePersonId;
	}
	public void setAlternatePersonId(Long alternatePersonId) {
		this.alternatePersonId = alternatePersonId;
	}
	public String getPincode() {
		return pincode;
	}
	public String getCode() {
		return code;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "LacAddDto [lacId=" + lacId + ", staffNurseId=" + staffNurseId + ", alternatePersonId="
				+ alternatePersonId + ", facilityId=" + facilityId + ", divisionId=" + divisionId + ", name=" + name
				+ ", status=" + status + ", address=" + address + ", stateId=" + stateId + ", districtId=" + districtId
				+ ", city=" + city + ", pinCode=" + pincode + ", lacStaffNurseDetails=" + lacStaffNurseDetails
				+ ", lacAlternatePersonDetails=" + lacAlternatePersonDetails + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LacAddDto other = (LacAddDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (alternatePersonId == null) {
			if (other.alternatePersonId != null)
				return false;
		} else if (!alternatePersonId.equals(other.alternatePersonId))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (districtId == null) {
			if (other.districtId != null)
				return false;
		} else if (!districtId.equals(other.districtId))
			return false;
		if (divisionId == null) {
			if (other.divisionId != null)
				return false;
		} else if (!divisionId.equals(other.divisionId))
			return false;
		if (facilityId == null) {
			if (other.facilityId != null)
				return false;
		} else if (!facilityId.equals(other.facilityId))
			return false;
		if (lacAlternatePersonDetails == null) {
			if (other.lacAlternatePersonDetails != null)
				return false;
		} else if (!lacAlternatePersonDetails.equals(other.lacAlternatePersonDetails))
			return false;
		if (lacId == null) {
			if (other.lacId != null)
				return false;
		} else if (!lacId.equals(other.lacId))
			return false;
		if (lacStaffNurseDetails == null) {
			if (other.lacStaffNurseDetails != null)
				return false;
		} else if (!lacStaffNurseDetails.equals(other.lacStaffNurseDetails))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (staffNurseId == null) {
			if (other.staffNurseId != null)
				return false;
		} else if (!staffNurseId.equals(other.staffNurseId))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
	

}
