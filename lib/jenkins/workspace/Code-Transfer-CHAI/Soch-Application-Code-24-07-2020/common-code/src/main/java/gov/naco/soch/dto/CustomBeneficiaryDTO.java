package gov.naco.soch.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



public class CustomBeneficiaryDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private String aadharNumber;

    private String age;

    private String barcode;

    private String beneficiaryActivityStatus;

    private String beneficiaryType;

    private String category;

    private LocalDate dateOfBirth;

    private String educationLevel;

    private String employmentStatus;

    private String otherEmploymentStatus;

    private String firstName;

    private String gender;

    private Boolean isPlhiv;

    private String lastName;

    private String maritalStatus;

    private String middleName;

    private String mobileNumber;

    private String occupation;

    private String status;

    private String uid;

    private String ostCode;
	private String tiCode;

    private TiBeneficiaryAddressDto address;

    public TiBeneficiaryAddressDto getAddress() {
		return address;
	}

	public void setAddress(TiBeneficiaryAddressDto address) {
		this.address = address;
	}

	public Boolean getIsPlhiv() {
		return isPlhiv;
	}


    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBeneficiaryActivityStatus() {
        return beneficiaryActivityStatus;
    }

    public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
        this.beneficiaryActivityStatus = beneficiaryActivityStatus;
    }

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getOtherEmploymentStatus() {
        return otherEmploymentStatus;
    }

    public void setOtherEmploymentStatus(String otherEmploymentStatus) {
        this.otherEmploymentStatus = otherEmploymentStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean isIsPlhiv() {
        return isPlhiv;
    }

    public void setIsPlhiv(Boolean isPlhiv) {
        this.isPlhiv = isPlhiv;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOstCode() {
        return ostCode;
    }

    public void setOstCode(String ostCode) {
        this.ostCode = ostCode;
    }

    public String getTiCode() {
        return tiCode;
    }

    public void setTiCode(String tiCode) {
        this.tiCode = tiCode;
    }

 

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomBeneficiaryDTO beneficiaryDTO = (CustomBeneficiaryDTO) o;
        if (beneficiaryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beneficiaryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "CustomBeneficiaryDTO [id=" + id + ", aadharNumber=" + aadharNumber + ", age=" + age + ", barcode="
				+ barcode + ", beneficiaryActivityStatus=" + beneficiaryActivityStatus + ", beneficiaryType="
				+ beneficiaryType + ", category=" + category + ", dateOfBirth=" + dateOfBirth + ", educationLevel="
				+ educationLevel + ", employmentStatus=" + employmentStatus + ", otherEmploymentStatus="
				+ otherEmploymentStatus + ", firstName=" + firstName + ", gender=" + gender + ", isPlhiv=" + isPlhiv
				+ ", lastName=" + lastName + ", maritalStatus=" + maritalStatus + ", middleName=" + middleName
				+ ", mobileNumber=" + mobileNumber + ", occupation=" + occupation + ", status=" + status + ", uid="
				+ uid + ", ostCode=" + ostCode + ", tiCode=" + tiCode + ", addressDetails=" + address + "]";
	}

}
