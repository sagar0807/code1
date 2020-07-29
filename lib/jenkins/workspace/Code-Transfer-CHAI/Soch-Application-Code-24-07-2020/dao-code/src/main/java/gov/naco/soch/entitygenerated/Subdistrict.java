package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the subdistrict database table.
 * 
 */
@Entity
@NamedQuery(name="Subdistrict.findAll", query="SELECT s FROM Subdistrict s")
public class Subdistrict implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subdistrict_id")
	private Integer subdistrictId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="subdistrict_name")
	private String subdistrictName;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="subdistrict")
	private Set<Address> addresses;

	//bi-directional many-to-one association to District
	@ManyToOne
	private District district;

	//bi-directional many-to-one association to Town
	@OneToMany(mappedBy="subdistrict")
	private Set<Town> towns;

	public Subdistrict() {
	}

	public Integer getSubdistrictId() {
		return this.subdistrictId;
	}

	public void setSubdistrictId(Integer subdistrictId) {
		this.subdistrictId = subdistrictId;
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

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
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

	public String getSubdistrictName() {
		return this.subdistrictName;
	}

	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}

	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setSubdistrict(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setSubdistrict(null);

		return address;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Set<Town> getTowns() {
		return this.towns;
	}

	public void setTowns(Set<Town> towns) {
		this.towns = towns;
	}

	public Town addTown(Town town) {
		getTowns().add(town);
		town.setSubdistrict(this);

		return town;
	}

	public Town removeTown(Town town) {
		getTowns().remove(town);
		town.setSubdistrict(null);

		return town;
	}

}