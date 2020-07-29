/**
 * 
 */
package gov.naco.soch.cst.dto;

import gov.naco.soch.dto.BaseDto;

public class DnaPcrResultsDto extends BaseDto {
	
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private Long dnaPcrTestId;
	private String dnaPcrTestName;
	private Long dnaPcrResultId;
	private String dnaPcrResultName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDnaPcrTestId() {
		return dnaPcrTestId;
	}
	public void setDnaPcrTestId(Long dnaPcrTestId) {
		this.dnaPcrTestId = dnaPcrTestId;
	}
	public String getDnaPcrTestName() {
		return dnaPcrTestName;
	}
	public void setDnaPcrTestName(String dnaPcrTestName) {
		this.dnaPcrTestName = dnaPcrTestName;
	}
	public Long getDnaPcrResultId() {
		return dnaPcrResultId;
	}
	public void setDnaPcrResultId(Long dnaPcrResultId) {
		this.dnaPcrResultId = dnaPcrResultId;
	}
	public String getDnaPcrResultName() {
		return dnaPcrResultName;
	}
	public void setDnaPcrResultName(String dnaPcrResultName) {
		this.dnaPcrResultName = dnaPcrResultName;
	}
	
}