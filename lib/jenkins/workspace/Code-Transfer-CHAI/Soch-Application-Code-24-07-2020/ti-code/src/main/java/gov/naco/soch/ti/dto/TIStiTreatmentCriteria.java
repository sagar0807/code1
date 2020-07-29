package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIStiTreatment} entity.
 * This class is used in {@link gov.naco.soch.web.rest.TIStiTreatmentResource}
 * to receive all the possible filtering options from the Http GET request
 * parameters. For example the following could be a valid request:
 * {@code /ti-sti-treatments?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific
 * {@link Filter} class are used, we need to use fix type specific filters.
 */
public class TIStiTreatmentCriteria implements Serializable, Criteria {

	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private LongFilter facilityId;

	private LongFilter stiRtiDiagnosis;

	private LongFilter kitPrescribed;

	private BooleanFilter partnerNotified;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter followUpDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter nextFollowUpDate;

	private StringFilter clinicalDetails;

	private StringFilter treatmentProvided;

	private BooleanFilter isActive;

	private BooleanFilter isDelete;

	private IntegerFilter createdBy;

	private ZonedDateTimeFilter createdTime;

	private IntegerFilter modifiedBy;

	private ZonedDateTimeFilter modifiedTime;

	private LongFilter beneficiaryId;
	// New
	private StringFilter beneficiaryActiveStatus;
	
    private StringFilter clientStatus;
    
    private StringFilter gender;
	
	private StringFilter typology;
	
	private StringFilter param; 
	
	private LongFilter hrgPrimaryCategory;
	
	private BooleanFilter isActiveFacility;
	
	private BooleanFilter isEarly;
	
	  private LongFilter status;


	public TIStiTreatmentCriteria() {
	}

	public TIStiTreatmentCriteria(TIStiTreatmentCriteria other) {
		this.id = other.id == null ? null : other.id.copy();
		this.stiRtiDiagnosis = other.stiRtiDiagnosis == null ? null : other.stiRtiDiagnosis.copy();
		this.kitPrescribed = other.kitPrescribed == null ? null : other.kitPrescribed.copy();
		this.partnerNotified = other.partnerNotified == null ? null : other.partnerNotified.copy();
		this.followUpDate = other.followUpDate == null ? null : other.followUpDate.copy();
		this.nextFollowUpDate = other.nextFollowUpDate == null ? null : other.nextFollowUpDate.copy();
		this.clinicalDetails = other.clinicalDetails == null ? null : other.clinicalDetails.copy();
		this.treatmentProvided = other.treatmentProvided == null ? null : other.treatmentProvided.copy();
		this.isActive = other.isActive == null ? null : other.isActive.copy();
		this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
		this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
		this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
		this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
		this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
		this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
		this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
		this.beneficiaryActiveStatus = other.beneficiaryActiveStatus == null ? null
				: other.beneficiaryActiveStatus.copy();
		this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
		this.gender = other.gender == null ? null : other.gender.copy();
		this.typology = other.typology == null ? null : other.typology.copy();
		this.param = other.param == null ? null : other.param.copy();
		this.hrgPrimaryCategory=other.hrgPrimaryCategory==null?null:other.hrgPrimaryCategory.copy();
                 this.isActiveFacility=other.isActiveFacility==null?null:other.isActiveFacility.copy();
                 this.isEarly=other.isEarly==null?null:other.isEarly.copy();
                 this.status=other.status==null?null:other.status.copy();
	}

	@Override
	public TIStiTreatmentCriteria copy() {
		return new TIStiTreatmentCriteria(this);
	}

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}


	public LongFilter getStiRtiDiagnosis() {
		return stiRtiDiagnosis;
	}

	public void setStiRtiDiagnosis(LongFilter stiRtiDiagnosis) {
		this.stiRtiDiagnosis = stiRtiDiagnosis;
	}

	public LongFilter getHrgPrimaryCategory() {
		return hrgPrimaryCategory;
	}

	public void setHrgPrimaryCategory(LongFilter hrgPrimaryCategory) {
		this.hrgPrimaryCategory = hrgPrimaryCategory;
	}

	

	public LongFilter getKitPrescribed() {
		return kitPrescribed;
	}

	public void setKitPrescribed(LongFilter kitPrescribed) {
		this.kitPrescribed = kitPrescribed;
	}

	public BooleanFilter getPartnerNotified() {
		return partnerNotified;
	}

	public void setPartnerNotified(BooleanFilter partnerNotified) {
		this.partnerNotified = partnerNotified;
	}

	public LocalDateFilter getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDateFilter followUpDate) {
		this.followUpDate = followUpDate;
	}

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}

	public LocalDateFilter getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(LocalDateFilter nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public StringFilter getClinicalDetails() {
		return clinicalDetails;
	}

	public void setClinicalDetails(StringFilter clinicalDetails) {
		this.clinicalDetails = clinicalDetails;
	}

	public StringFilter getTreatmentProvided() {
		return treatmentProvided;
	}

	public void setTreatmentProvided(StringFilter treatmentProvided) {
		this.treatmentProvided = treatmentProvided;
	}

	public BooleanFilter getIsActive() {
		return isActive;
	}

	public void setIsActive(BooleanFilter isActive) {
		this.isActive = isActive;
	}

	public StringFilter getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(StringFilter clientStatus) {
		this.clientStatus = clientStatus;
	}

	public BooleanFilter getIsActiveFacility() {
		return isActiveFacility;
	}

	public void setIsActiveFacility(BooleanFilter isActiveFacility) {
		this.isActiveFacility = isActiveFacility;
	}

	public BooleanFilter getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(BooleanFilter isEarly) {
	    this.isEarly = isEarly;
	}

	public LongFilter getStatus() {
	    return status;
	}

	public void setStatus(LongFilter status) {
	    this.status = status;
	}

	public BooleanFilter getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(BooleanFilter isDelete) {
		this.isDelete = isDelete;
	}

	public IntegerFilter getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(IntegerFilter createdBy) {
		this.createdBy = createdBy;
	}

	public ZonedDateTimeFilter getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(ZonedDateTimeFilter createdTime) {
		this.createdTime = createdTime;
	}

	public IntegerFilter getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(IntegerFilter modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public ZonedDateTimeFilter getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(ZonedDateTimeFilter modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public LongFilter getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(LongFilter beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public StringFilter getBeneficiaryActiveStatus() {
		return beneficiaryActiveStatus;
	}

	public void setBeneficiaryActiveStatus(StringFilter beneficiaryActiveStatus) {
		this.beneficiaryActiveStatus = beneficiaryActiveStatus;
	}

	public StringFilter getGender() {
		return gender;
	}

	public void setGender(StringFilter gender) {
		this.gender = gender;
	}

	

	public StringFilter getTypology() {
		return typology;
	}

	public void setTypology(StringFilter typology) {
		this.typology = typology;
	}

	public StringFilter getParam() {
		return param;
	}

	public void setParam(StringFilter param) {
		this.param = param;
	}

	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final TIStiTreatmentCriteria that = (TIStiTreatmentCriteria) o;
		return Objects.equals(id, that.id) && Objects.equals(stiRtiDiagnosis, that.stiRtiDiagnosis)
				&& Objects.equals(kitPrescribed, that.kitPrescribed)
				&& Objects.equals(partnerNotified, that.partnerNotified)
				&& Objects.equals(followUpDate, that.followUpDate)
				&& Objects.equals(nextFollowUpDate, that.nextFollowUpDate)
				&& Objects.equals(clinicalDetails, that.clinicalDetails)
				&& Objects.equals(treatmentProvided, that.treatmentProvided) && Objects.equals(isActive, that.isActive)
				&& Objects.equals(isDelete, that.isDelete) && Objects.equals(createdBy, that.createdBy)
				&& Objects.equals(createdTime, that.createdTime) && Objects.equals(modifiedBy, that.modifiedBy)
				&& Objects.equals(modifiedTime, that.modifiedTime) && Objects.equals(beneficiaryId, that.beneficiaryId)
				&& Objects.equals(facilityId, that.facilityId)&&
				Objects.equals(clientStatus, that.clientStatus)&&
				Objects.equals(beneficiaryActiveStatus, that.beneficiaryActiveStatus)
				&& Objects.equals(gender, that.gender)
				&& Objects.equals(typology, that.typology)
				&& Objects.equals(hrgPrimaryCategory, that.hrgPrimaryCategory)
				&& Objects.equals(isActiveFacility, that.isActiveFacility)
				&& Objects.equals(isEarly, that.isEarly)
				&& Objects.equals(status, that.status)
				&& Objects.equals(param, that.param);


	}

	@Override
	public int hashCode() {
		return Objects.hash(id, stiRtiDiagnosis, kitPrescribed, partnerNotified, followUpDate, nextFollowUpDate,
				clinicalDetails, treatmentProvided, isActive, isDelete, createdBy, createdTime, modifiedBy,
				modifiedTime, beneficiaryId, facilityId, clientStatus, beneficiaryActiveStatus,gender, typology, param,hrgPrimaryCategory,isActiveFacility,isEarly,status);
	}

	@Override
	public String toString() {
		return "TIStiTreatmentCriteria [id=" + id + ", facilityId=" + facilityId + ", stiRtiDiagnosis="
				+ stiRtiDiagnosis + ", kitPrescribed=" + kitPrescribed + ", partnerNotified=" + partnerNotified
				+ ", followUpDate=" + followUpDate + ", nextFollowUpDate=" + nextFollowUpDate + ", clinicalDetails="
				+ clinicalDetails + ", treatmentProvided=" + treatmentProvided + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", beneficiaryId=" + beneficiaryId
				+ ", beneficiaryActiveStatus=" + beneficiaryActiveStatus
				+ ", gender=" + gender 
				+ ", typology=" + typology 
				+ ", param=" + param +"]";
	}

}
