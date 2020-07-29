package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.Address} entity. This class is used
 * in {@link gov.naco.soch.web.rest.AddressResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /addresses?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AddressCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter address;

    private StringFilter block;

    private StringFilter city;

    private StringFilter geoLatitude;

    private StringFilter geoLongitude;

    private IntegerFilter houseNo;

    private StringFilter pincode;

    private StringFilter taluk;

    private LongFilter stateId;

    private LongFilter districtId;

    public AddressCriteria() {
    }

    public AddressCriteria(AddressCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.address = other.address == null ? null : other.address.copy();
        this.block = other.block == null ? null : other.block.copy();
        this.city = other.city == null ? null : other.city.copy();
        this.geoLatitude = other.geoLatitude == null ? null : other.geoLatitude.copy();
        this.geoLongitude = other.geoLongitude == null ? null : other.geoLongitude.copy();
        this.houseNo = other.houseNo == null ? null : other.houseNo.copy();
        this.pincode = other.pincode == null ? null : other.pincode.copy();
        this.taluk = other.taluk == null ? null : other.taluk.copy();
        this.stateId = other.stateId == null ? null : other.stateId.copy();
        this.districtId = other.districtId == null ? null : other.districtId.copy();
    }

    @Override
    public AddressCriteria copy() {
        return new AddressCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAddress() {
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public StringFilter getBlock() {
        return block;
    }

    public void setBlock(StringFilter block) {
        this.block = block;
    }

    public StringFilter getCity() {
        return city;
    }

    public void setCity(StringFilter city) {
        this.city = city;
    }

    public StringFilter getGeoLatitude() {
        return geoLatitude;
    }

    public void setGeoLatitude(StringFilter geoLatitude) {
        this.geoLatitude = geoLatitude;
    }

    public StringFilter getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoLongitude(StringFilter geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    public IntegerFilter getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(IntegerFilter houseNo) {
        this.houseNo = houseNo;
    }

    public StringFilter getPincode() {
        return pincode;
    }

    public void setPincode(StringFilter pincode) {
        this.pincode = pincode;
    }

    public StringFilter getTaluk() {
        return taluk;
    }

    public void setTaluk(StringFilter taluk) {
        this.taluk = taluk;
    }

    public LongFilter getStateId() {
        return stateId;
    }

    public void setStateId(LongFilter stateId) {
        this.stateId = stateId;
    }

    public LongFilter getDistrictId() {
        return districtId;
    }

    public void setDistrictId(LongFilter districtId) {
        this.districtId = districtId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AddressCriteria that = (AddressCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(address, that.address) &&
            Objects.equals(block, that.block) &&
            Objects.equals(city, that.city) &&
            Objects.equals(geoLatitude, that.geoLatitude) &&
            Objects.equals(geoLongitude, that.geoLongitude) &&
            Objects.equals(houseNo, that.houseNo) &&
            Objects.equals(pincode, that.pincode) &&
            Objects.equals(taluk, that.taluk) &&
            Objects.equals(stateId, that.stateId) &&
            Objects.equals(districtId, that.districtId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        address,
        block,
        city,
        geoLatitude,
        geoLongitude,
        houseNo,
        pincode,
        taluk,
        stateId,
        districtId
        );
    }

    @Override
    public String toString() {
        return "AddressCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (address != null ? "address=" + address + ", " : "") +
                (block != null ? "block=" + block + ", " : "") +
                (city != null ? "city=" + city + ", " : "") +
                (geoLatitude != null ? "geoLatitude=" + geoLatitude + ", " : "") +
                (geoLongitude != null ? "geoLongitude=" + geoLongitude + ", " : "") +
                (houseNo != null ? "houseNo=" + houseNo + ", " : "") +
                (pincode != null ? "pincode=" + pincode + ", " : "") +
                (taluk != null ? "taluk=" + taluk + ", " : "") +
                (stateId != null ? "stateId=" + stateId + ", " : "") +
                (districtId != null ? "districtId=" + districtId + ", " : "") +
            "}";
    }

}
