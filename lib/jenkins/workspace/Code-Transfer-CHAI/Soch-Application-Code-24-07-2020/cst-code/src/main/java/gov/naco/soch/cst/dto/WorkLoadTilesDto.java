package gov.naco.soch.cst.dto;

import java.util.List;

import gov.naco.soch.projection.ArtBeneficiaryQueueProjection;

public class WorkLoadTilesDto {

	private Long id;
	private String roleName;
	private Integer queueCount;
	private Integer visitedQueueCount;
	private List<ArtBeneficiaryQueueProjection> countQueue;
	private List<ArtBeneficiaryQueueProjection> visitedCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public List<ArtBeneficiaryQueueProjection> getVisitedCount() {
		return visitedCount;
	}

	public void setVisitedCount(List<ArtBeneficiaryQueueProjection> visitedCount) {
		this.visitedCount = visitedCount;
	}
	
	public List<ArtBeneficiaryQueueProjection> getCountQueue() {
		return countQueue;
	}

	public void setCountQueue(List<ArtBeneficiaryQueueProjection> countQueue) {
		this.countQueue = countQueue;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public Integer getQueueCount() {
		return queueCount;
	}

	public void setQueueCount(Integer queueCount) {
		this.queueCount = queueCount;
	}

	public Integer getVisitedQueueCount() {
		return visitedQueueCount;
	}

	public void setVisitedQueueCount(Integer visitedQueueCount) {
		this.visitedQueueCount = visitedQueueCount;
	}

	

}
