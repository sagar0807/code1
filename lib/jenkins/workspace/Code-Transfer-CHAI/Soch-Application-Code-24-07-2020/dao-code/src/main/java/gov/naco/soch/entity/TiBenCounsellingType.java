package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "benCounsellingTypeSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_counselling_type_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_ben_counselling_type")
@NamedQuery(name = "TiBenCounsellingType.findAll", query = "SELECT t FROM TiBenCounsellingType t")
public class TiBenCounsellingType extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benCounsellingTypeSequence")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "counselling_id")
	private TIBenCounselling tiBenCounselling;

	@ManyToOne
	@JoinColumn(name = "master_counselling_type_id")
	private MasterCounsellingType masterCounsellingType;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) { 
		this.id = id;
	}

	public TIBenCounselling getTiBenCounselling() {
		return tiBenCounselling;
	}

	public void setTiBenCounselling(TIBenCounselling tiBenCounselling) {
		this.tiBenCounselling = tiBenCounselling;
	}
	
	
	

	public MasterCounsellingType getMasterCounsellingType() {
		return masterCounsellingType;
	}

	public void setMasterCounsellingType(MasterCounsellingType masterCounsellingType) {
		this.masterCounsellingType = masterCounsellingType;
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

}
