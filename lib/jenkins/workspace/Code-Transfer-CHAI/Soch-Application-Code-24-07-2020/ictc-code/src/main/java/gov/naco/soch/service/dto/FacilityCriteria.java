package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.Facility} entity. This class is used
 * in {@link gov.naco.soch.web.rest.FacilityResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /facilities?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class FacilityCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter name;

    private StringFilter code;

    private LongFilter facilityTypeId;

    private LongFilter addressId;

    public FacilityCriteria() {
    }

    public FacilityCriteria(FacilityCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.code = other.code == null ? null : other.code.copy();
        this.facilityTypeId = other.facilityTypeId == null ? null : other.facilityTypeId.copy();
        this.addressId = other.addressId == null ? null : other.addressId.copy();
    }

    @Override
    public FacilityCriteria copy() {
        return new FacilityCriteria(this);
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

    public StringFilter getCode() {
        return code;
    }

    public void setCode(StringFilter code) {
        this.code = code;
    }

    public LongFilter getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(LongFilter facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public LongFilter getAddressId() {
        return addressId;
    }

    public void setAddressId(LongFilter addressId) {
        this.addressId = addressId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FacilityCriteria that = (FacilityCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(code, that.code) &&
            Objects.equals(facilityTypeId, that.facilityTypeId) &&
            Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        name,
        code,
        facilityTypeId,
        addressId
        );
    }

    @Override
    public String toString() {
        return "FacilityCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
                (code != null ? "code=" + code + ", " : "") +
                (facilityTypeId != null ? "facilityTypeId=" + facilityTypeId + ", " : "") +
                (addressId != null ? "addressId=" + addressId + ", " : "") +
            "}";
    }

}
