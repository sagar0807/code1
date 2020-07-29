package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the indent_request_status_master database table.
 * 
 */
@Entity
@Table(name="indent_request_status_master")
@NamedQuery(name="IndentRequestStatusMaster.findAll", query="SELECT i FROM IndentRequestStatusMaster i")
public class IndentRequestStatusMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="indent_request_status_name")
	private String indentRequestStatusName;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to GoodsRequest
	@OneToMany(mappedBy="indentRequestStatusMaster")
	private Set<GoodsRequest> goodsRequests;

	public IndentRequestStatusMaster() {
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

	public String getIndentRequestStatusName() {
		return this.indentRequestStatusName;
	}

	public void setIndentRequestStatusName(String indentRequestStatusName) {
		this.indentRequestStatusName = indentRequestStatusName;
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
		goodsRequest.setIndentRequestStatusMaster(this);

		return goodsRequest;
	}

	public GoodsRequest removeGoodsRequest(GoodsRequest goodsRequest) {
		getGoodsRequests().remove(goodsRequest);
		goodsRequest.setIndentRequestStatusMaster(null);

		return goodsRequest;
	}

}