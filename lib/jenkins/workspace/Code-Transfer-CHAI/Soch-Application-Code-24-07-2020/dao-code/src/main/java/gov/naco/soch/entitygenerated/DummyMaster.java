package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the dummy_master database table.
 * 
 */
@Entity
@Table(name="dummy_master")
@NamedQuery(name="DummyMaster.findAll", query="SELECT d FROM DummyMaster d")
public class DummyMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	private String email;

	private String name;

	@Column(name="submitted_time")
	private Timestamp submittedTime;

	//bi-directional many-to-one association to DummyDetail
	@OneToMany(mappedBy="dummyMaster")
	private Set<DummyDetail> dummyDetails;

	public DummyMaster() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getSubmittedTime() {
		return this.submittedTime;
	}

	public void setSubmittedTime(Timestamp submittedTime) {
		this.submittedTime = submittedTime;
	}

	public Set<DummyDetail> getDummyDetails() {
		return this.dummyDetails;
	}

	public void setDummyDetails(Set<DummyDetail> dummyDetails) {
		this.dummyDetails = dummyDetails;
	}

	public DummyDetail addDummyDetail(DummyDetail dummyDetail) {
		getDummyDetails().add(dummyDetail);
		dummyDetail.setDummyMaster(this);

		return dummyDetail;
	}

	public DummyDetail removeDummyDetail(DummyDetail dummyDetail) {
		getDummyDetails().remove(dummyDetail);
		dummyDetail.setDummyMaster(null);

		return dummyDetail;
	}

}