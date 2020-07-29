package gov.naco.soch.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SacsFacilityDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Integer actualRecordCount;
	private Long id;
	private String name;
	private String code;
	private Long facilityTypeId;
	private Long divisionId;
	private String facilityTypeName;
	private String divisionName;
	private Long sacsId;
	private Boolean isActive;

	private Long facilityAddressId;
	private Long townId;
	private Long subDistrictId;
	private String addressLineOne;
	private String addressLineTwo;
	private String country;
	private String stateName;
	private Long stateId;
	private Long districtId;
	private String city;
	private String pincode;
	private LocalDateTime createdTime;

	private Boolean isLab;
	private String artcode;
	private String nodalCentre;
	private String facilityNo;

	private List<TypologyDto> typology;
	private String tiType;
	private Integer monthlyOstTarget;
	private Integer monthlyActiveTarget;
	private String cbStatus;

	private Long machineId;
	private String machineName;
	private String nationalId;

	private Integer noa;
	private String products;

	private Long parentFacilityId;

	private UserMasterDto primaryUser;
	private UserMasterDto alternateUser;

	private String tiOstTypeName;
	private Long tiOstTypeId;
	private String tiCenterName;
	private Long tiCenterId;
	private Long parentOstId;
	private String parentOstName;

	private Boolean clinicPresent;
	private LocalDate validTill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Long getSacsId() {
		return sacsId;
	}

	public void setSacsId(Long sacsId) {
		this.sacsId = sacsId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsLab() {
		return isLab;
	}

	public void setIsLab(Boolean isLab) {
		this.isLab = isLab;
	}

	public String getArtcode() {
		return artcode;
	}

	public void setArtcode(String artcode) {
		this.artcode = artcode;
	}

	public String getNodalCentre() {
		return nodalCentre;
	}

	public void setNodalCentre(String nodalCentre) {
		this.nodalCentre = nodalCentre;
	}

	public String getFacilityNo() {
		return facilityNo;
	}

	public void setFacilityNo(String facilityNo) {
		this.facilityNo = facilityNo;
	}

	public UserMasterDto getPrimaryUser() {
		return primaryUser;
	}

	public void setPrimaryUser(UserMasterDto primaryUser) {
		this.primaryUser = primaryUser;
	}

	public UserMasterDto getAlternateUser() {
		return alternateUser;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setAlternateUser(UserMasterDto alternateUser) {
		this.alternateUser = alternateUser;
	}

	public Long getFacilityAddressId() {
		return facilityAddressId;
	}

	public void setFacilityAddressId(Long facilityAddressId) {
		this.facilityAddressId = facilityAddressId;
	}

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public Long getSubDistrictId() {
		return subDistrictId;
	}

	public void setSubDistrictId(Long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public List<TypologyDto> getTypology() {
		return typology;
	}

	public void setTypology(List<TypologyDto> typology) {
		this.typology = typology;
	}

	public String getFacilityTypeName() {
		return facilityTypeName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setFacilityTypeName(String facilityTypeName) {
		this.facilityTypeName = facilityTypeName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getTiType() {
		return tiType;
	}

	public void setTiType(String tiType) {
		this.tiType = tiType;
	}

	public Integer getMonthlyOstTarget() {
		return monthlyOstTarget;
	}

	public void setMonthlyOstTarget(Integer monthlyOstTarget) {
		this.monthlyOstTarget = monthlyOstTarget;
	}

	public Integer getMonthlyActiveTarget() {
		return monthlyActiveTarget;
	}

	public void setMonthlyActiveTarget(Integer monthlyActiveTarget) {
		this.monthlyActiveTarget = monthlyActiveTarget;
	}

	public String getCbStatus() {
		return cbStatus;
	}

	public void setCbStatus(String cbStatus) {
		this.cbStatus = cbStatus;
	}

	public void setLab(boolean isLab) {
		this.isLab = isLab;
	}

	public Long getMachineId() {
		return machineId;
	}

	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public Long getParentFacilityId() {
		return parentFacilityId;
	}

	public void setParentFacilityId(Long parentFacilityId) {
		this.parentFacilityId = parentFacilityId;
	}

	public Integer getNoa() {
		return noa;
	}

	public void setNoa(Integer noa) {
		this.noa = noa;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getTiOstTypeName() {
		return tiOstTypeName;
	}

	public void setTiOstTypeName(String tiOstTypeName) {
		this.tiOstTypeName = tiOstTypeName;
	}

	public Long getTiOstTypeId() {
		return tiOstTypeId;
	}

	public void setTiOstTypeId(Long tiOstTypeId) {
		this.tiOstTypeId = tiOstTypeId;
	}

	public String getTiCenterName() {
		return tiCenterName;
	}

	public void setTiCenterName(String tiCenterName) {
		this.tiCenterName = tiCenterName;
	}

	public Long getTiCenterId() {
		return tiCenterId;
	}

	public void setTiCenterId(Long tiCenterId) {
		this.tiCenterId = tiCenterId;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime localDateTime) {
		this.createdTime = localDateTime;
	}

	public Long getParentOstId() {
		return parentOstId;
	}

	public void setParentOstId(Long parentOstId) {
		this.parentOstId = parentOstId;
	}

	public String getParentOstName() {
		return parentOstName;
	}

	public void setParentOstName(String parentOstName) {
		this.parentOstName = parentOstName;
	}

	public Boolean getClinicPresent() {
		return clinicPresent;
	}

	public void setClinicPresent(Boolean clinicPresent) {
		this.clinicPresent = clinicPresent;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	public Integer getActualRecordCount() {
		return actualRecordCount;
	}

	public void setActualRecordCount(Integer actualRecordCount) {
		this.actualRecordCount = actualRecordCount;
	}

	@Override
	public String toString() {
		return "SacsFacilityDto [actualRecordCount=" + actualRecordCount + ", id=" + id + ", name=" + name + ", code="
				+ code + ", facilityTypeId=" + facilityTypeId + ", divisionId=" + divisionId + ", facilityTypeName="
				+ facilityTypeName + ", divisionName=" + divisionName + ", sacsId=" + sacsId + ", isActive=" + isActive
				+ ", facilityAddressId=" + facilityAddressId + ", townId=" + townId + ", subDistrictId=" + subDistrictId
				+ ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", country=" + country
				+ ", stateName=" + stateName + ", stateId=" + stateId + ", districtId=" + districtId + ", city=" + city
				+ ", pincode=" + pincode + ", createdTime=" + createdTime + ", isLab=" + isLab + ", artcode=" + artcode
				+ ", nodalCentre=" + nodalCentre + ", facilityNo=" + facilityNo + ", typology=" + typology + ", tiType="
				+ tiType + ", monthlyOstTarget=" + monthlyOstTarget + ", monthlyActiveTarget=" + monthlyActiveTarget
				+ ", cbStatus=" + cbStatus + ", machineId=" + machineId + ", machineName=" + machineName
				+ ", nationalId=" + nationalId + ", noa=" + noa + ", products=" + products + ", parentFacilityId="
				+ parentFacilityId + ", primaryUser=" + primaryUser + ", alternateUser=" + alternateUser
				+ ", tiOstTypeName=" + tiOstTypeName + ", tiOstTypeId=" + tiOstTypeId + ", tiCenterName=" + tiCenterName
				+ ", tiCenterId=" + tiCenterId + ", parentOstId=" + parentOstId + ", parentOstName=" + parentOstName
				+ ", clinicPresent=" + clinicPresent + ", validTill=" + validTill + "]";
	}

}
