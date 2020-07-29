package gov.naco.soch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Address.
 */
@Entity
@Table(name = "address")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;
    
    @Column(name="address_line_one")
	private String addressLineOne;

	@Column(name="address_line_two")
	private String addressLineTwo;

    @Column(name = "block")
    private String block;

    @Column(name = "city")
    private String city;
    
    @Column(name = "country")
    private String country;

    @Column(name = "geo_latitude")
    private String geoLatitude;

    @Column(name = "geo_longitude")
    private String geoLongitude;

    @Column(name = "house_no")
    private Integer houseNo;
    
    @Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;
	
	@Column(name = "taluk")
	private String taluk;
	
	@ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("addresses")
    private District district;
	
    @Column(name = "pincode")
    private String pincode;
    
    @ManyToOne
	@JoinColumn(name="pincode_id")
	private Pincode pincodeEntity;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("addresses")
    private State state;
    
	@ManyToOne
	@JoinColumn(name="subdistrict_id")
	private Subdistrict subdistrict;
	
	@ManyToOne
	@JoinColumn(name="town_id")
	private Town town;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public Address address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlock() {
        return block;
    }

    public Address block(String block) {
        this.block = block;
        return this;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCity() {
        return city;
    }

    public Address city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGeoLatitude() {
        return geoLatitude;
    }

    public Address geoLatitude(String geoLatitude) {
        this.geoLatitude = geoLatitude;
        return this;
    }

    public void setGeoLatitude(String geoLatitude) {
        this.geoLatitude = geoLatitude;
    }

    public String getGeoLongitude() {
        return geoLongitude;
    }

    public Address geoLongitude(String geoLongitude) {
        this.geoLongitude = geoLongitude;
        return this;
    }

    public void setGeoLongitude(String geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public Address houseNo(Integer houseNo) {
        this.houseNo = houseNo;
        return this;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public String getPincode() {
        return pincode;
    }

    public Address pincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getTaluk() {
        return taluk;
    }

    public Address taluk(String taluk) {
        this.taluk = taluk;
        return this;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public State getState() {
        return state;
    }

    public Address state(State state) {
        this.state = state;
        return this;
    }

    public void setState(State state) {
        this.state = state;
    }

    public District getDistrict() {
        return district;
    }

    public Address district(District district) {
        this.district = district;
        return this;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Pincode getPincodeEntity() {
		return pincodeEntity;
	}

	public void setPincodeEntity(Pincode pincodeEntity) {
		this.pincodeEntity = pincodeEntity;
	}

	public Subdistrict getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(Subdistrict subdistrict) {
		this.subdistrict = subdistrict;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        return id != null && id.equals(((Address) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", block=" + block + ", city=" + city + ", country=" + country + ", geoLatitude="
				+ geoLatitude + ", geoLongitude=" + geoLongitude + ", houseNo=" + houseNo + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + ", taluk=" + taluk + ", district=" + district + ", pincode=" + pincode
				+ ", pincodeEntity=" + pincodeEntity + ", state=" + state + ", subdistrict=" + subdistrict + ", town="
				+ town + "]";
	}

    
   
}
