package gov.naco.soch.dto;

import java.time.LocalDateTime;

public class DispatchRemarkDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private String remarks;
	private LocalDateTime date;
	private Long userId;
	private String userName;
	private Long dispatchId;
	public String getRemarks() {
		return remarks;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(Long dispatchId) {
		this.dispatchId = dispatchId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "DispatchRemarkDto [remarks=" + remarks + ", date=" + date + ", userId=" + userId + ", userName="
				+ userName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DispatchRemarkDto other = (DispatchRemarkDto) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
