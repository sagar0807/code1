package gov.naco.soch.constructordto;

import java.math.BigInteger;

public class SACSSummaryDto {
	private BigInteger incomingCount;
	private BigInteger daysInTransit;
	private BigInteger grnTwoPending;
	private BigInteger git;
	private BigInteger gitDays;
	private BigInteger batchCount;
	private BigInteger productCount;
	private BigInteger pendingReconsile;
	private BigInteger productReconsile;

	public BigInteger getIncomingCount() {
		return incomingCount;
	}

	public void setIncomingCount(BigInteger incomingCount) {
		this.incomingCount = incomingCount;
	}

	public BigInteger getDaysInTransit() {
		return daysInTransit;
	}

	public void setDaysInTransit(BigInteger daysInTransit) {
		this.daysInTransit = daysInTransit;
	}

	public BigInteger getGrnTwoPending() {
		return grnTwoPending;
	}

	public void setGrnTwoPending(BigInteger grnTwoPending) {
		this.grnTwoPending = grnTwoPending;
	}

	public BigInteger getGit() {
		return git;
	}

	public void setGit(BigInteger git) {
		this.git = git;
	}

	public BigInteger getGitDays() {
		return gitDays;
	}

	public void setGitDays(BigInteger gitDays) {
		this.gitDays = gitDays;
	}

	public BigInteger getBatchCount() {
		return batchCount;
	}

	public void setBatchCount(BigInteger batchCount) {
		this.batchCount = batchCount;
	}

	public BigInteger getProductCount() {
		return productCount;
	}

	public void setProductCount(BigInteger productCount) {
		this.productCount = productCount;
	}

	public BigInteger getPendingReconsile() {
		return pendingReconsile;
	}

	public void setPendingReconsile(BigInteger pendingReconsile) {
		this.pendingReconsile = pendingReconsile;
	}

	public BigInteger getProductReconsile() {
		return productReconsile;
	}

	public void setProductReconsile(BigInteger productReconsile) {
		this.productReconsile = productReconsile;
	}

}
