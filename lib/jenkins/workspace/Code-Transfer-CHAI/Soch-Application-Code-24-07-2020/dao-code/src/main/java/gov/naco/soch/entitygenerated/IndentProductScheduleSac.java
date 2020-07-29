package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the indent_product_schedule_sacs database table.
 * 
 */
@Entity
@Table(name="indent_product_schedule_sacs")
@NamedQuery(name="IndentProductScheduleSac.findAll", query="SELECT i FROM IndentProductScheduleSac i")
public class IndentProductScheduleSac implements Serializable {
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

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="to_facility")
	private Facility facility;

	//bi-directional many-to-one association to IndentProductSchedule
	@ManyToOne
	@JoinColumn(name="indent_product_schedule_id")
	private IndentProductSchedule indentProductSchedule;

	//bi-directional many-to-one association to IndentProductScheduleSacsLot
	@OneToMany(mappedBy="indentProductScheduleSac")
	private Set<IndentProductScheduleSacsLot> indentProductScheduleSacsLots;

	public IndentProductScheduleSac() {
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

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public IndentProductSchedule getIndentProductSchedule() {
		return this.indentProductSchedule;
	}

	public void setIndentProductSchedule(IndentProductSchedule indentProductSchedule) {
		this.indentProductSchedule = indentProductSchedule;
	}

	public Set<IndentProductScheduleSacsLot> getIndentProductScheduleSacsLots() {
		return this.indentProductScheduleSacsLots;
	}

	public void setIndentProductScheduleSacsLots(Set<IndentProductScheduleSacsLot> indentProductScheduleSacsLots) {
		this.indentProductScheduleSacsLots = indentProductScheduleSacsLots;
	}

	public IndentProductScheduleSacsLot addIndentProductScheduleSacsLot(IndentProductScheduleSacsLot indentProductScheduleSacsLot) {
		getIndentProductScheduleSacsLots().add(indentProductScheduleSacsLot);
		indentProductScheduleSacsLot.setIndentProductScheduleSac(this);

		return indentProductScheduleSacsLot;
	}

	public IndentProductScheduleSacsLot removeIndentProductScheduleSacsLot(IndentProductScheduleSacsLot indentProductScheduleSacsLot) {
		getIndentProductScheduleSacsLots().remove(indentProductScheduleSacsLot);
		indentProductScheduleSacsLot.setIndentProductScheduleSac(null);

		return indentProductScheduleSacsLot;
	}

}