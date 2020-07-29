package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
/**
 * Criteria class for benefeciary referral service in Soch-TI
 * @author Rishad Basheer
 *
 */
public class TiBenReferralCriteriaNew implements Serializable, Criteria{
	
	private static final long serialVersionUID = 1L;
	
	private LongFilter id;
	
	private StringFilter name;
	
	private StringFilter uId;
	
	private StringFilter mobileNumber;
	
	private LongFilter referredFacility;//From
	
	private LongFilter referralFacility;//To
	
	private LongFilter registeredFacility;
	
	private LongFilter beneficiaryId;
	
	private StringFilter referralType;
	
	private StringFilter gender;
	
	private StringFilter typology;
	
	private StringFilter infectionType;
	
	private StringFilter status;
	
	private StringFilter param;
	
	private BooleanFilter isDelete;
	
	private StringFilter uid;
	
	private StringFilter pid;
	
	private StringFilter tiNo;
	
	private StringFilter ostNo;
	
	private StringFilter artNo;
	
	private LocalDateFilter visitStDt;
	
	private LocalDateFilter visitEnDt;
	
	private LongFilter genderId;
	
	private LongFilter facilityTypeId;
	
	private LocalDateFilter visitStdate;

    private LocalDateFilter visitENdate;
    
    private LocalDateFilter dateofReferral;
    
    private LongFilter referredfromfacilitytype;

	
	
	public TiBenReferralCriteriaNew(TiBenReferralCriteriaNew tiBenReferralCriteriaNew) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Criteria copy() {
		return new TiBenReferralCriteriaNew(this);
	}
	public LongFilter getId() {
		return id;
	}
	public void setId(LongFilter id) {
		this.id = id;
	}
	public StringFilter getName() {
		return name;
	}
	public void setName(StringFilter name) {
		this.name = name;
	}
	public StringFilter getuId() {
		return uId;
	}
	public void setuId(StringFilter uId) {
		this.uId = uId;
	}
	public StringFilter getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(StringFilter mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public LongFilter getReferredFacility() {
		return referredFacility;
	}
	public void setReferredFacility(LongFilter referredFacility) {
		this.referredFacility = referredFacility;
	}
	public BooleanFilter getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(BooleanFilter isDelete) {
		this.isDelete = isDelete;
	}
	public LongFilter getReferralFacility() {
		return referralFacility;
	}
	public void setReferralFacility(LongFilter referralFacility) {
		this.referralFacility = referralFacility;
	}
	
	public StringFilter getReferralType() {
		return referralType;
	}
	public void setReferralType(StringFilter referralType) {
		this.referralType = referralType;
	}
	public LongFilter getRegisteredFacility() {
		return registeredFacility;
	}
	public void setRegisteredFacility(LongFilter registeredFacility) {
		this.registeredFacility = registeredFacility;
	}
	public LongFilter getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(LongFilter beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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
	public StringFilter getInfectionType() {
		return infectionType;
	}
	public void setInfectionType(StringFilter infectionType) {
		this.infectionType = infectionType;
	}
	public StringFilter getParam() {
		return param;
	}
	public void setParam(StringFilter param) {
		this.param = param;
	}
	
	
	public StringFilter getStatus() {
		return status;
	}
	public void setStatus(StringFilter status) {
		this.status = status;
	}
	
	public StringFilter getUid() {
		return uid;
	}
	public void setUid(StringFilter uid) {
		this.uid = uid;
	}
	public StringFilter getPid() {
		return pid;
	}
	public void setPid(StringFilter pid) {
		this.pid = pid;
	}
	public StringFilter getTiNo() {
		return tiNo;
	}
	public void setTiNo(StringFilter tiNo) {
		this.tiNo = tiNo;
	}
	public StringFilter getOstNo() {
		return ostNo;
	}
	public void setOstNo(StringFilter ostNo) {
		this.ostNo = ostNo;
	}
	public StringFilter getArtNo() {
		return artNo;
	}
	public void setArtNo(StringFilter artNo) {
		this.artNo = artNo;
	}
	public LocalDateFilter getVisitStDt() {
		return visitStDt;
	}
	public void setVisitStDt(LocalDateFilter visitStDt) {
		this.visitStDt = visitStDt;
	}
	public LocalDateFilter getVisitEnDt() {
		return visitEnDt;
	}
	public void setVisitEnDt(LocalDateFilter visitEnDt) {
		this.visitEnDt = visitEnDt;
	}
	public LongFilter getGenderId() {
		return genderId;
	}
	public void setGenderId(LongFilter genderId) {
		this.genderId = genderId;
	}
	
	public LongFilter getFacilityTypeId() {
		return facilityTypeId;
	}
	public void setFacilityTypeId(LongFilter facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}
	public LocalDateFilter getVisitStdate() {
		return visitStdate;
	}
	public void setVisitStdate(LocalDateFilter visitStdate) {
		this.visitStdate = visitStdate;
	}
	public LocalDateFilter getVisitENdate() {
		return visitENdate;
	}
	public void setVisitENdate(LocalDateFilter visitENdate) {
		this.visitENdate = visitENdate;
	}
	
	public LocalDateFilter getDateofReferral() {
		return dateofReferral;
	}
	public void setDateofReferral(LocalDateFilter dateofReferral) {
		this.dateofReferral = dateofReferral;
	}
	public LongFilter getReferredfromfacilitytype() {
		return referredfromfacilitytype;
	}
	public void setReferredfromfacilitytype(LongFilter referredfromfacilitytype) {
		this.referredfromfacilitytype = referredfromfacilitytype;
	}
	@Override
	    public int hashCode() {
	        return Objects.hash(
	        id,
	        name,
	        uId,
	        referralFacility,
	        referredFacility,
	        registeredFacility,
	        mobileNumber,
	        beneficiaryId,
	        referralType,
	        gender,
	        typology,
	        infectionType,
	        isDelete,
	        param,
	        uid,
	        pid,
	        tiNo,
	        ostNo,
	        artNo,
	        visitStDt,
	        visitEnDt,
	        genderId,
	        facilityTypeId,
	        dateofReferral,
	        referredfromfacilitytype
	        );
	    }
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TiBenReferralCriteriaNew that = (TiBenReferralCriteriaNew) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(uId, that.uId) &&
            Objects.equals(referredFacility, that.referredFacility) &&
            Objects.equals(referralFacility, that.referralFacility) &&
            Objects.equals(registeredFacility, that.registeredFacility) &&
            Objects.equals(mobileNumber, that.mobileNumber)&&
            Objects.equals(beneficiaryId, that.beneficiaryId)&&
            Objects.equals(referralType, that.referralType)&&
            Objects.equals(gender, that.gender)&&
            Objects.equals(typology, that.typology)&&
            Objects.equals(infectionType, that.infectionType)&&
            Objects.equals(isDelete, that.isDelete)&&
            Objects.equals(param, that.param)&&
            Objects.equals(uid, that.uid)&&
	        Objects.equals(pid, that.pid)&&
	        Objects.equals(tiNo, that.tiNo)&&
	        Objects.equals(ostNo, that.ostNo)&&
	        Objects.equals(artNo, that.artNo)&&
	        Objects.equals(visitStDt, that.visitStDt)&&
	        Objects.equals(visitEnDt, that.visitEnDt)&&
	        Objects.equals(genderId, that.genderId)&&
	        Objects.equals(facilityTypeId, that.facilityTypeId)&&
	        Objects.equals(dateofReferral, that.dateofReferral)&&
	        Objects.equals(referredfromfacilitytype, that.referredfromfacilitytype);
        
        
        
	        
    }
	 @Override
	    public String toString() {
	        return "TIBenReferralCriteriaNew{" +
	                (id != null ? "id=" + id + ", " : "") +
	                (name != null ? "name=" + name + ", " : "") +
	                (uId != null ? "uId=" + uId + ", " : "") +
	                (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
	                (referralFacility != null ? "referralFacility=" + referralFacility + ", " : "") +
	                (referredFacility != null ? "referredFacility=" + referredFacility + ", " : "") +
	                (registeredFacility != null ? "registeredFacility=" + registeredFacility + ", " : "") +
	                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
	                (referralType != null ? "referralType=" + referralType + ", " : "") +
	                (gender != null ? "gender=" + gender + ", " : "") +
	                (typology != null ? "typology=" + typology + ", " : "") +
	                (infectionType != null ? "infectionType=" + infectionType + ", " : "") +
	                (param != null ? "param=" + param + ", " : "") +
	                (uid != null ? "uid=" + uid + ", " : "") +
	                (pid != null ? "pid=" + pid + ", " : "") +
	                (tiNo != null ? "tiNo=" + tiNo + ", " : "") +
	                (ostNo != null ? "ostNo=" + ostNo + ", " : "") +
	                (artNo != null ? "artNo=" + artNo + ", " : "") +
	                (visitStDt != null ? "visitStDt=" + visitStDt + ", " : "") +
	                (visitEnDt != null ? "visitEnDt=" + visitEnDt + ", " : "") +
	                (genderId != null ? "genderId=" + genderId + ", " : "") +
	                (facilityTypeId != null ? "facilityTypeId=" + facilityTypeId + ", " : "") +
	                (dateofReferral != null ? "dateofReferral=" + dateofReferral + ", " : "") +
	                (referredfromfacilitytype != null ? "referredfromfacilitytype=" + referredfromfacilitytype + ", " : "") +
	            "}";
	    }
	
}
