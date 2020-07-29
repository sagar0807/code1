
package gov.naco.soch.dto;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @date 2020-Jan-03 1:02:08 PM
 */

// DTO class used for transfer data between front end and back end.
public class MasterNameListDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String masterName;
	private String masterDescription;
	private boolean isActive;
	private boolean isDelete;
	private Integer masterType;
	private String fetchEndpoint;
	private String saveEndpoint;

	// define getter and setter for the above properties
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the masterName
	 */
	public String getMasterName() {
		return masterName;
	}

	/**
	 * @param masterName
	 *            the masterName to set
	 */
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	/**
	 * @return the masterDescription
	 */
	public String getMasterDescription() {
		return masterDescription;
	}

	/**
	 * @param masterDescription
	 *            the masterDescription to set
	 */
	public void setMasterDescription(String masterDescription) {
		this.masterDescription = masterDescription;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getMasterType() {
		return masterType;
	}

	public void setMasterType(Integer masterType) {
		this.masterType = masterType;
	}

	public String getFetchEndpoint() {
		return fetchEndpoint;
	}

	public void setFetchEndpoint(String fetchEndpoint) {
		this.fetchEndpoint = fetchEndpoint;
	}

	public String getSaveEndpoint() {
		return saveEndpoint;
	}

	public void setSaveEndpoint(String saveEndpoint) {
		this.saveEndpoint = saveEndpoint;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}


	
}
