package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;

public class ProfileUpdateCriteria implements Serializable, Criteria {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private LongFilter facilityId;
    private BooleanFilter isDelete;
    private IntegerFilter month;
    private IntegerFilter year;

    public LongFilter getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
	this.facilityId = facilityId;
    }

    public BooleanFilter getIsDelete() {
	return isDelete;
    }

    public void setIsDelete(BooleanFilter isDelete) {
	this.isDelete = isDelete;
    }
    
    public IntegerFilter getMonth() {
        return month;
    }

    public void setMonth(IntegerFilter month) {
        this.month = month;
    }

    public IntegerFilter getYear() {
        return year;
    }

    public void setYear(IntegerFilter year) {
        this.year = year;
    }

    public ProfileUpdateCriteria() {

    }

    public ProfileUpdateCriteria(ProfileUpdateCriteria other) {
	this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
	this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
	this.month = other.month == null ? null : other.month.copy();
	this.year = other.year == null ? null : other.year.copy();
    }

    @Override
    public Criteria copy() {
	return new ProfileUpdateCriteria(this);
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	final ProfileUpdateCriteria that = (ProfileUpdateCriteria) o;
	return Objects.equals(facilityId, that.facilityId) && Objects.equals(month, that.month)
	     && Objects.equals(year, that.year)
		&& Objects.equals(isDelete, that.isDelete);

    }

    @Override
    public int hashCode() {
	return Objects.hash(month, year,facilityId, isDelete);
    }

}
