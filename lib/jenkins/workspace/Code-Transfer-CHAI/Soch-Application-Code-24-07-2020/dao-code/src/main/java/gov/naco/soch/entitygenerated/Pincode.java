package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the pincode database table.
 * 
 */
@Entity
@NamedQuery(name="Pincode.findAll", query="SELECT p FROM Pincode p")
public class Pincode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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

	private String pincode;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="pincode1")
	private Set<Address> addresses1;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="pincode2")
	private Set<Address> addresses2;

	public Pincode() {
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

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Set<Address> getAddresses1() {
		return this.addresses1;
	}

	public void setAddresses1(Set<Address> addresses1) {
		this.addresses1 = addresses1;
	}

	public Address addAddresses1(Address addresses1) {
		getAddresses1().add(addresses1);
		addresses1.setPincode1(this);

		return addresses1;
	}

	public Address removeAddresses1(Address addresses1) {
		getAddresses1().remove(addresses1);
		addresses1.setPincode1(null);

		return addresses1;
	}

	public Set<Address> getAddresses2() {
		return this.addresses2;
	}

	public void setAddresses2(Set<Address> addresses2) {
		this.addresses2 = addresses2;
	}

	public Address addAddresses2(Address addresses2) {
		getAddresses2().add(addresses2);
		addresses2.setPincode2(this);

		return addresses2;
	}

	public Address removeAddresses2(Address addresses2) {
		getAddresses2().remove(addresses2);
		addresses2.setPincode2(null);

		return addresses2;
	}

}