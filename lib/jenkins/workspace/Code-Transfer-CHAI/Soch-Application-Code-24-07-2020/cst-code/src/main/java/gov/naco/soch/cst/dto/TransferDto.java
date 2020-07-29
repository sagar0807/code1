package gov.naco.soch.cst.dto;

import gov.naco.soch.dto.BaseDto;

import java.time.LocalDate;


public class TransferDto  extends BaseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String preArtNumber;
    private String artNumber;
    private String transferStatus;
    private String sourceFacilityType;
    private String artCode;
    private String facilityTo;
    private String facilityFrom;
    private String uid;
    private String age;
    private String gender;
    private LocalDate transferDate;
    private Long beneficiaryId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPreArtNumber() {
        return preArtNumber;
    }

    public void setPreArtNumber(String preArtNumber) {
        this.preArtNumber = preArtNumber;
    }

    public String getArtNumber() {
        return artNumber;
    }

    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getSourceFacilityType() {
        return sourceFacilityType;
    }

    public void setSourceFacilityType(String sourceFacilityType) {
        this.sourceFacilityType = sourceFacilityType;
    }

    public String getArtCode() {
        return artCode;
    }

    public void setArtCode(String artCode) {
        this.artCode = artCode;
    }

    public String getFacilityTo() {
        return facilityTo;
    }

    public void setFacilityTo(String facilityTo) {
        this.facilityTo = facilityTo;
    }

    public String getFacilityFrom() {
        return facilityFrom;
    }

    public void setFacilityFrom(String facilityFrom) {
        this.facilityFrom = facilityFrom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    @Override
    public String toString() {
        return "TransferDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", preArtNumber='" + preArtNumber + '\'' +
                ", artNumber='" + artNumber + '\'' +
                ", transferStatus='" + transferStatus + '\'' +
                ", sourceFacilityType='" + sourceFacilityType + '\'' +
                ", artCode='" + artCode + '\'' +
                ", facilityTo='" + facilityTo + '\'' +
                ", facilityFrom='" + facilityFrom + '\'' +
                ", uid='" + uid + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", transferDate=" + transferDate +
                '}';
    }
}
