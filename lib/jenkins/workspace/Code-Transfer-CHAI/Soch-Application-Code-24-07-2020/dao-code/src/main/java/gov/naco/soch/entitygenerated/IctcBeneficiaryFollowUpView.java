package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ictc_beneficiary_follow_up_view database table.
 * 
 */
@Entity
@Table(name="ictc_beneficiary_follow_up_view")
@NamedQuery(name="IctcBeneficiaryFollowUpView.findAll", query="SELECT i FROM IctcBeneficiaryFollowUpView i")
public class IctcBeneficiaryFollowUpView implements Serializable {
	private static final long serialVersionUID = 1L;

	private String age;

	@Column(name="beneficiary_id")
	private Integer beneficiaryId;

	@Column(name="beneficiary_status")
	private Integer beneficiaryStatus;

	private String category;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Temporal(TemporalType.DATE)
	@Column(name="delivery_date")
	private Date deliveryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="expected_delivery_date")
	private Date expectedDeliveryDate;

	@Column(name="facility_id")
	private Long facilityId;

	@Column(name="first_name")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name="follow_up_date")
	private Date followUpDate;

	@Column(name="follow_up_type")
	private Integer followUpType;

	private String gender;

	@Column(name="ictc_beneficiary_id")
	private Long ictcBeneficiaryId;

	private Integer id;

	@Column(name="is_completed")
	private Boolean isCompleted;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="mobile_number")
	private String mobileNumber;

	private String pid;

	@Temporal(TemporalType.DATE)
	@Column(name="pregnancy_lmp_date")
	private Date pregnancyLmpDate;

//	private String remarks;

	@Column(name="test_result_id")
	private Long testResultId;

	private String uid;

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	private Date visitDate;

	@Column(name="visit_id")
	private Long visitId;

	public IctcBeneficiaryFollowUpView() {
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getBeneficiaryId() {
		return this.beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Integer getBeneficiaryStatus() {
		return this.beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getExpectedDeliveryDate() {
		return this.expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Long getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Integer getFollowUpType() {
		return this.followUpType;
	}

	public void setFollowUpType(Integer followUpType) {
		this.followUpType = followUpType;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getIctcBeneficiaryId() {
		return this.ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsCompleted() {
		return this.isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Date getPregnancyLmpDate() {
		return this.pregnancyLmpDate;
	}

	public void setPregnancyLmpDate(Date pregnancyLmpDate) {
		this.pregnancyLmpDate = pregnancyLmpDate;
	}

//	public String getRemarks() {
//		return this.remarks;
//	}
//
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}

	public Long getTestResultId() {
		return this.testResultId;
	}

	public void setTestResultId(Long testResultId) {
		this.testResultId = testResultId;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Long getVisitId() {
		return this.visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

}