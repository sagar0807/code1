package gov.naco.soch.ti.dto;

import java.sql.Date;
import java.time.LocalDate;

import gov.naco.soch.dto.MiniMasterDto;

public class TiBenTransferDto extends BaseDto {
	private Long id;
	private String uId;
	private String firstName;
	private String lastName;
	private int age;
	private Long transferFromId;
	private String transferFrom;
	private Long transferToId;
	private String transferTo;
	private String status;
	private Long beneficiaryId;
	private LocalDate transferDate;
	private String sourceType;
	private String destinationType;
	private String transferStatus;
	private Long tiBeneficiaryId;
	private Long ostBeneficiaryId;
	private MiniMasterDto masterClientStatus;	
	private MiniMasterDto genderId;
	private long count;
	private String ostNumber;
	
	public String getTransferStatus() {
		return transferStatus;
	}
	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
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
	public String getTransferFrom() {
		return transferFrom;
	}
	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}
	public String getTransferTo() {
		return transferTo;
	}
	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getCount() {
	    return count;
	}
	public void setCount(long count) {
	    this.count = count;
	}
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	
	public LocalDate getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Long getTransferFromId() {
		return transferFromId;
	}
	public void setTransferFromId(Long transferFromId) {
		this.transferFromId = transferFromId;
	}
	public Long getTransferToId() {
		return transferToId;
	}
	public void setTransferToId(Long transferToId) {
		this.transferToId = transferToId;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getDestinationType() {
		return destinationType;
	}
	public void setDestinationType(String destinationType) {
		this.destinationType = destinationType;
	}
	public Long getTiBeneficiaryId() {
		return tiBeneficiaryId;
	}
	public void setTiBeneficiaryId(Long tiBeneficiaryId) {
		this.tiBeneficiaryId = tiBeneficiaryId;
	}
	public Long getOstBeneficiaryId() {
		return ostBeneficiaryId;
	}
	public void setOstBeneficiaryId(Long ostBeneficiaryId) {
		this.ostBeneficiaryId = ostBeneficiaryId;
	}
	
	public MiniMasterDto getMasterClientStatus() {
		return masterClientStatus;
	}
	public void setMasterClientStatus(MiniMasterDto masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}
	public MiniMasterDto getGenderId() {
		return genderId;
	}
	public void setGenderId(MiniMasterDto genderId) {
		this.genderId = genderId;
	}
	public String getOstNumber() {
		return ostNumber;
	}
	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}
	
	
	
	
	
	

}
