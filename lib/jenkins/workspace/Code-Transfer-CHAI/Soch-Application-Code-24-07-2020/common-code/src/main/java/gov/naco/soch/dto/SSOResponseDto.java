package gov.naco.soch.dto;

import java.math.BigInteger;

public class SSOResponseDto {
	private String createdBy;
	private String createdTimestamp;
	private boolean expired;
	private String id;
	private BigInteger sessionDuration;
	private String sessionExpiryTime;
	private String updatedBy;
	private String updatedTimestamp;
	private String username;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getSessionDuration() {
		return sessionDuration;
	}

	public void setSessionDuration(BigInteger sessionDuration) {
		this.sessionDuration = sessionDuration;
	}

	public String getSessionExpiryTime() {
		return sessionExpiryTime;
	}

	public void setSessionExpiryTime(String sessionExpiryTime) {
		this.sessionExpiryTime = sessionExpiryTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(String updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
