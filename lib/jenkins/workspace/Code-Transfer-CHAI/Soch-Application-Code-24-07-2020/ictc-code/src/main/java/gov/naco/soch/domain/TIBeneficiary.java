package gov.naco.soch.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ti_beneficiary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TIBeneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benSequence")
	private Long id;

	@ManyToOne
	@JoinColumn(name="status_id")
	private MasterTiClientStatus status;

	@OneToOne(optional = false, fetch = FetchType.EAGER)
    @NotNull
    @JsonIgnore
    @JoinColumn(unique = true, name="beneficiary_id")
    private Beneficiary beneficiary;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterTiClientStatus getStatus() {
		return status;
	}

	public void setStatus(MasterTiClientStatus status) {
		this.status = status;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

}
