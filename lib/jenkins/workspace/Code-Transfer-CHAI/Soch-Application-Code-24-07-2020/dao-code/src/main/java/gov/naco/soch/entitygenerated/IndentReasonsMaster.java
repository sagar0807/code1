package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the indent_reasons_master database table.
 * 
 */
@Entity
@Table(name="indent_reasons_master")
@NamedQuery(name="IndentReasonsMaster.findAll", query="SELECT i FROM IndentReasonsMaster i")
public class IndentReasonsMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="indent_reasons_name")
	private String indentReasonsName;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to GoodsRequest
	@OneToMany(mappedBy="indentReasonsMaster")
	private Set<GoodsRequest> goodsRequests;

	public IndentReasonsMaster() {
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

	public String getIndentReasonsName() {
		return this.indentReasonsName;
	}

	public void setIndentReasonsName(String indentReasonsName) {
		this.indentReasonsName = indentReasonsName;
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

	public Set<GoodsRequest> getGoodsRequests() {
		return this.goodsRequests;
	}

	public void setGoodsRequests(Set<GoodsRequest> goodsRequests) {
		this.goodsRequests = goodsRequests;
	}

	public GoodsRequest addGoodsRequest(GoodsRequest goodsRequest) {
		getGoodsRequests().add(goodsRequest);
		goodsRequest.setIndentReasonsMaster(this);

		return goodsRequest;
	}

	public GoodsRequest removeGoodsRequest(GoodsRequest goodsRequest) {
		getGoodsRequests().remove(goodsRequest);
		goodsRequest.setIndentReasonsMaster(null);

		return goodsRequest;
	}

}