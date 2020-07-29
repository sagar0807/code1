package gov.naco.soch.projection;

import java.math.BigDecimal;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = FacilityAggregateStockProjection.class, columns = {
		@ColumnResult(name = "productname"), @ColumnResult(name = "productcode"),
		@ColumnResult(name = "git", type = Double.class), @ColumnResult(name = "facilityid", type = Long.class),
		@ColumnResult(name = "productid", type = Integer.class),
		@ColumnResult(name = "availablequantity", type = BigDecimal.class),
		@ColumnResult(name = "damagedquantity", type = Double.class),
		@ColumnResult(name = "expiredquantity", type = BigDecimal.class), }))
public class FacilityAggregateStockProjection {

	private String productname;
	private String productcode;
	private Double git;
	private Double damagedquantity;
	private Integer facilityid;
	private Integer productid;
	private BigDecimal availablequantity;
	private BigDecimal expiredquantity;

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public Double getGit() {
		return git;
	}

	public void setGit(Double git) {
		this.git = git;
	}

	public Integer getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(Integer facilityid) {
		this.facilityid = facilityid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public BigDecimal getAvailablequantity() {
		return availablequantity;
	}

	public void setAvailablequantity(BigDecimal availablequantity) {
		this.availablequantity = availablequantity;
	}

	public BigDecimal getExpiredquantity() {
		return expiredquantity;
	}

	public void setExpiredquantity(BigDecimal expiredquantity) {
		this.expiredquantity = expiredquantity;
	}

	public Double getDamagedquantity() {
		return damagedquantity;
	}

	public void setDamagedquantity(Double damagedquantity) {
		this.damagedquantity = damagedquantity;
	}


}
