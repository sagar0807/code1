package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ti_ben_scr_details database table.
 * 
 */
@Entity
@Table(name="ti_ben_scr_details")
@NamedQuery(name="TiBenScrDetail.findAll", query="SELECT t FROM TiBenScrDetail t")
public class TiBenScrDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="current_hiv_status")
	private String currentHivStatus;

	@Column(name="current_syphilis")
	private String currentSyphilis;

	@Column(name="date_of_screening")
	private Timestamp dateOfScreening;

	@Column(name="fever_greater_than_three_weeks")
	private Boolean feverGreaterThanThreeWeeks;

	private String infection;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="next_date_of_screening")
	private Date nextDateOfScreening;

	@Column(name="presence_of_sweat_greater_than_three_weeks")
	private Boolean presenceOfSweatGreaterThanThreeWeeks;

	@Column(name="prolonged_cough_greater_than_three_weeks")
	private Boolean prolongedCoughGreaterThanThreeWeeks;

	@Column(name="screening_status_hiv")
	private String screeningStatusHiv;

	@Column(name="screening_status_syphilis")
	private String screeningStatusSyphilis;

	private String status;

	@Column(name="tb_status")
	private String tbStatus;

	@Column(name="weightloss_greater_than_3_kg_in_last_four_weeks")
	private Boolean weightlossGreaterThan3KgInLastFourWeeks;

	//bi-directional many-to-one association to BeneficiaryReferral
	@OneToMany(mappedBy="tiBenScrDetail")
	private Set<BeneficiaryReferral> beneficiaryReferrals;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TiBeneficiary
	@ManyToOne
	@JoinColumn(name="beneficiary_id")
	private TiBeneficiary tiBeneficiary;

	public TiBenScrDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getCurrentHivStatus() {
		return this.currentHivStatus;
	}

	public void setCurrentHivStatus(String currentHivStatus) {
		this.currentHivStatus = currentHivStatus;
	}

	public String getCurrentSyphilis() {
		return this.currentSyphilis;
	}

	public void setCurrentSyphilis(String currentSyphilis) {
		this.currentSyphilis = currentSyphilis;
	}

	public Timestamp getDateOfScreening() {
		return this.dateOfScreening;
	}

	public void setDateOfScreening(Timestamp dateOfScreening) {
		this.dateOfScreening = dateOfScreening;
	}

	public Boolean getFeverGreaterThanThreeWeeks() {
		return this.feverGreaterThanThreeWeeks;
	}

	public void setFeverGreaterThanThreeWeeks(Boolean feverGreaterThanThreeWeeks) {
		this.feverGreaterThanThreeWeeks = feverGreaterThanThreeWeeks;
	}

	public String getInfection() {
		return this.infection;
	}

	public void setInfection(String infection) {
		this.infection = infection;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Date getNextDateOfScreening() {
		return this.nextDateOfScreening;
	}

	public void setNextDateOfScreening(Date nextDateOfScreening) {
		this.nextDateOfScreening = nextDateOfScreening;
	}

	public Boolean getPresenceOfSweatGreaterThanThreeWeeks() {
		return this.presenceOfSweatGreaterThanThreeWeeks;
	}

	public void setPresenceOfSweatGreaterThanThreeWeeks(Boolean presenceOfSweatGreaterThanThreeWeeks) {
		this.presenceOfSweatGreaterThanThreeWeeks = presenceOfSweatGreaterThanThreeWeeks;
	}

	public Boolean getProlongedCoughGreaterThanThreeWeeks() {
		return this.prolongedCoughGreaterThanThreeWeeks;
	}

	public void setProlongedCoughGreaterThanThreeWeeks(Boolean prolongedCoughGreaterThanThreeWeeks) {
		this.prolongedCoughGreaterThanThreeWeeks = prolongedCoughGreaterThanThreeWeeks;
	}

	public String getScreeningStatusHiv() {
		return this.screeningStatusHiv;
	}

	public void setScreeningStatusHiv(String screeningStatusHiv) {
		this.screeningStatusHiv = screeningStatusHiv;
	}

	public String getScreeningStatusSyphilis() {
		return this.screeningStatusSyphilis;
	}

	public void setScreeningStatusSyphilis(String screeningStatusSyphilis) {
		this.screeningStatusSyphilis = screeningStatusSyphilis;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTbStatus() {
		return this.tbStatus;
	}

	public void setTbStatus(String tbStatus) {
		this.tbStatus = tbStatus;
	}

	public Boolean getWeightlossGreaterThan3KgInLastFourWeeks() {
		return this.weightlossGreaterThan3KgInLastFourWeeks;
	}

	public void setWeightlossGreaterThan3KgInLastFourWeeks(Boolean weightlossGreaterThan3KgInLastFourWeeks) {
		this.weightlossGreaterThan3KgInLastFourWeeks = weightlossGreaterThan3KgInLastFourWeeks;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals() {
		return this.beneficiaryReferrals;
	}

	public void setBeneficiaryReferrals(Set<BeneficiaryReferral> beneficiaryReferrals) {
		this.beneficiaryReferrals = beneficiaryReferrals;
	}

	public BeneficiaryReferral addBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().add(beneficiaryReferral);
		beneficiaryReferral.setTiBenScrDetail(this);

		return beneficiaryReferral;
	}

	public BeneficiaryReferral removeBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().remove(beneficiaryReferral);
		beneficiaryReferral.setTiBenScrDetail(null);

		return beneficiaryReferral;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public TiBeneficiary getTiBeneficiary() {
		return this.tiBeneficiary;
	}

	public void setTiBeneficiary(TiBeneficiary tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

}