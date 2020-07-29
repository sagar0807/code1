package gov.naco.soch.dto;

public class BeneficiaryWorkloadDto extends BaseDto {
	
	private static final long serialVersionUID = 1L;
	private String user;
	private Integer workload;
	private Integer userId;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Integer getWorkload() {
		return workload;
	}
	public void setWorkload(Integer workload) {
		this.workload = workload;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BeneficiaryWorkloadDto [user=" + user + ", workload=" + workload + ", userId=" + userId + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiaryWorkloadDto other = (BeneficiaryWorkloadDto) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (workload == null) {
			if (other.workload != null)
				return false;
		} else if (!workload.equals(other.workload))
			return false;
		return true;
	}

	

}
