package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

public class TiBenTransferCriteria implements Serializable, Criteria {
	private static final long serialVersionUID = 1L;
	private LongFilter id;
private StringFilter name;
	
	private StringFilter uId;
	
	private StringFilter uid;
	
	private StringFilter mobileNumber;
	
	private LongFilter transferredFromFacility;//From
	
	private LongFilter transferredToFacility;//To
	
	private LongFilter beneficiaryId;
	
	private StringFilter status;
	
	private StringFilter gender;
	
	private LongFilter typology;
		
	private StringFilter param;
	
	private LongFilter genderId;
    
    private StringFilter ostNo;
    
    private StringFilter tiNo;
    
    private LocalDateFilter visitStdate;

    private LocalDateFilter visitENdate;
    
    private LongFilter facilityTypeId;
  
	@Override
	public Criteria copy() {
		// TODO Auto-generated method stub
		return null;
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
	
	
	public StringFilter getTiNo() {
		return tiNo;
	}
	public void setTiNo(StringFilter tiNo) {
		this.tiNo = tiNo;
	}
	public LongFilter getGenderId() {
		return genderId;
	}
	public void setGenderId(LongFilter genderId) {
		this.genderId = genderId;
	}
	public StringFilter getUid() {
		return uid;
	}
	public void setUid(StringFilter uid) {
		this.uid = uid;
	}
	public StringFilter getStatus() {
		return status;
	}
	public void setStatus(StringFilter status) {
		this.status = status;
	}
	public LongFilter getTransferredFromFacility() {
		return transferredFromFacility;
	}
	public void setTransferredFromFacility(LongFilter transferredFromFacility) {
		this.transferredFromFacility = transferredFromFacility;
	}
	public LongFilter getTransferredToFacility() {
		return transferredToFacility;
	}
	public void setTransferredToFacility(LongFilter transferredToFacility) {
		this.transferredToFacility = transferredToFacility;
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
	
	public LongFilter getTypology() {
		return typology;
	}
	public void setTypology(LongFilter typology) {
		this.typology = typology;
	}
	public StringFilter getParam() {
		return param;
	}
	public void setParam(StringFilter param) {
		this.param = param;
	}
	
	public StringFilter getOstNo() {
		return ostNo;
	}
	public void setOstNo(StringFilter ostNo) {
		this.ostNo = ostNo;
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
	
	public LongFilter getFacilityTypeId() {
		return facilityTypeId;
	}
	public void setFacilityTypeId(LongFilter facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}
	@Override
    public int hashCode() {
        return Objects.hash(
        id,
        name,
        uid,
        transferredFromFacility,
        transferredToFacility,
        mobileNumber,
        beneficiaryId,
        status,
        gender,
        typology,
        param,
        ostNo,
        tiNo,
        genderId,
        visitStdate,
        visitENdate,
       facilityTypeId
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
    final TiBenTransferCriteria that = (TiBenTransferCriteria) o;
    return
        Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(transferredFromFacility, that.transferredFromFacility) &&
        Objects.equals(transferredToFacility, that.transferredToFacility) &&
        Objects.equals(mobileNumber, that.mobileNumber)&&
        Objects.equals(beneficiaryId, that.beneficiaryId)&&
        Objects.equals(status, that.status)&&
        Objects.equals(gender, that.gender)&&
        Objects.equals(genderId, that.genderId)&&
    	Objects.equals(typology, that.typology)&&
    	Objects.equals(param, that.param)&&
    	Objects.equals(ostNo, that.ostNo)&&
    	Objects.equals(visitStdate, that.visitStdate)&&
    	Objects.equals(visitENdate, that.visitENdate)&&
    	Objects.equals(tiNo, that.tiNo)&&
    	Objects.equals(uid, that.uid)&&
    	Objects.equals(facilityTypeId, that.facilityTypeId);    	
 }
@Override
public String toString() {
    return "TiBenTransferCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (name != null ? "name=" + name + ", " : "") +
            (uid != null ? "uid=" + uid + ", " : "") +
            (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
            (transferredFromFacility != null ? "transferredFromFacility=" + transferredFromFacility + ", " : "") +
            (transferredToFacility != null ? "transferredToFacility=" + transferredToFacility + ", " : "") +
            (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
            (status != null ? "status=" + status + ", " : "") +
            (gender != null ? "gender=" + gender + ", " : "") +
            (genderId != null ? "genderId=" + genderId + ", " : "") +
            (typology != null ? "typology=" + typology + ", " : "") +
            (param != null ? "param=" + param + ", " : "") +
            (ostNo != null ? "ostNo=" + ostNo + ", " : "") +
            (visitStdate != null ? "visitStdate=" + visitStdate + ", " : "") +
            (visitENdate != null ? "visitENdate=" + visitENdate + ", " : "") +
            (tiNo != null ? "tiNo=" + tiNo + ", " : "") +
            (facilityTypeId != null ? "facilityTypeId=" + facilityTypeId + ", " : "") +
        "}";
}
	
}
