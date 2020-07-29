package gov.naco.soch.ti.dto;

import java.io.Serializable;

import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

public class TiOstBeneficiaryDispensationCriteria implements Serializable, Criteria {

	private static final long serialVersionUID = 1L;

	private LongFilter facilityId;

	private StringFilter drugType;

	private StringFilter name;

	private LocalDateFilter date;
	
	private StringFilter param;
	
	private StringFilter uid;
	
	
	private StringFilter ostNo;
	
	private StringFilter mobile;
	
    private BooleanFilter isTransit;
    
    private StringFilter sortParam;
	
	
	public TiOstBeneficiaryDispensationCriteria() {

	}

	public TiOstBeneficiaryDispensationCriteria(TiOstBeneficiaryDispensationCriteria other) {
		this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
		this.drugType = other.drugType == null ? null : other.drugType.copy();
		this.name = other.name == null ? null : other.name.copy();
		this.date = other.date == null ? null : other.date.copy();
		this.param = other.param == null ? null : other.param.copy();
		this.uid = other.uid == null ? null : other.uid.copy();
		this.ostNo = other.ostNo == null ? null : other.ostNo.copy();
		this.mobile = other.mobile == null ? null : other.mobile.copy();
		this.isTransit = other.isTransit == null ? null : other.isTransit.copy();
		this.sortParam=other.sortParam==null?null:other.sortParam.copy();
	}

	@Override
	public TiOstBeneficiaryDispensationCriteria copy() {
		return new TiOstBeneficiaryDispensationCriteria(this);
	}

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}

	public StringFilter getDrugType() {
		return drugType;
	}

	public void setDrugType(StringFilter drugType) {
		this.drugType = drugType;
	}

	public StringFilter getSortParam() {
	    return sortParam;
	}

	public void setSortParam(StringFilter sortParam) {
	    this.sortParam = sortParam;
	}

	public StringFilter getName() {
		return name;
	}

	public void setName(StringFilter name) {
		this.name = name;
	}

	public LocalDateFilter getDate() {
		return date;
	}

	public void setDate(LocalDateFilter date) {
		this.date = date;
	}
	
	public StringFilter getParam() {
		return param;
	}

	public void setParam(StringFilter param) {
		this.param = param;
	}
	

	public StringFilter getUid() {
		return uid;
	}

	public void setUid(StringFilter uid) {
		this.uid = uid;
	}

	public StringFilter getOstNo() {
		return ostNo;
	}

	public void setOstNo(StringFilter ostNo) {
		this.ostNo = ostNo;
	}

	public StringFilter getMobile() {
		return mobile;
	}

	public void setMobile(StringFilter mobile) {
		this.mobile = mobile;
	}
	
	public BooleanFilter getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(BooleanFilter isTransit) {
		this.isTransit = isTransit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final TiOstBeneficiaryDispensationCriteria that = (TiOstBeneficiaryDispensationCriteria) o;
		return Objects.equals(facilityId, that.facilityId) && Objects.equals(drugType, that.drugType)
				&& Objects.equals(name, that.name) && Objects.equals(date, that.date)
				&& Objects.equals(param, that.param)&& Objects.equals(uid, that.uid)
				&& Objects.equals(ostNo, that.ostNo)&& Objects.equals(mobile, that.mobile)
				&& Objects.equals(sortParam, that.sortParam)
				&& Objects.equals(isTransit, that.isTransit);
	}

	@Override
	public int hashCode() {
		return Objects.hash(facilityId, drugType, name, date,param,uid,ostNo,mobile,isTransit,sortParam);
	}

	@Override
	public String toString() {
		return "TIBeneficiaryCriteria{" + (facilityId != null ? "facilityId=" + facilityId + ", " : "")
				+ (drugType != null ? "drugType=" + drugType + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (date != null ? "date=" + date + ", " : "") + (param != null ? "param=" + param + ", " : "") 
				+ (uid != null ? "uid=" + uid + ", " : "") + (ostNo != null ? "ostNo=" + ostNo + ", " : "") 
				+ (mobile != null ? "mobile=" + mobile + ", " : "") + (isTransit != null ? "isTransit=" + isTransit + ", " : "")
				+"}";
	}

}
