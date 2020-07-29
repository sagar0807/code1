package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "tiOstFollowUpSideEffectMapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_followup_side_effect_mapping_id_seq"),
		 @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_ost_followup_side_effect_mapping")
@NamedQuery(name = "TiOstFollowUpSideEffectMapping.findAll", query = "SELECT t FROM TiOstFollowUpSideEffectMapping t")
public class TiOstFollowUpSideEffectMapping extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tiOstFollowUpSideEffectMapping")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "followup_id")
	private TiOstFollowUp tiostFollowUp;

	@ManyToOne
	@JoinColumn(name = "side_effect_id")
	private MasterOstSideEffect sideEffect;

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

	public TiOstFollowUp getTiostFollowUp() {
		return tiostFollowUp;
	}

	public void setTiostFollowUp(TiOstFollowUp tiostFollowUp) {
		this.tiostFollowUp = tiostFollowUp;
	}

	public MasterOstSideEffect getSideEffect() {
		return sideEffect;
	}

	public void setSideEffect(MasterOstSideEffect sideEffect) {
		this.sideEffect = sideEffect;
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
