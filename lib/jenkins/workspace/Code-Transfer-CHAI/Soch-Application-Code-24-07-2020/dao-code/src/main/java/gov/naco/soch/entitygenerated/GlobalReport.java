package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the global_reports database table.
 * 
 */
@Entity
@Table(name="global_reports")
@NamedQuery(name="GlobalReport.findAll", query="SELECT g FROM GlobalReport g")
public class GlobalReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="module_name")
	private String moduleName;

	@Column(name="module_order")
	private Integer moduleOrder;

	@Column(name="report_id")
	private Integer reportId;

	@Column(name="report_name")
	private String reportName;

	@Column(name="report_order")
	private Integer reportOrder;

	@Column(name="role_id")
	private Integer roleId;

	@Column(name="sub_module_name")
	private String subModuleName;

	@Column(name="sub_module_order")
	private Integer subModuleOrder;

	private String url;

	public GlobalReport() {
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getModuleOrder() {
		return this.moduleOrder;
	}

	public void setModuleOrder(Integer moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	public Integer getReportId() {
		return this.reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Integer getReportOrder() {
		return this.reportOrder;
	}

	public void setReportOrder(Integer reportOrder) {
		this.reportOrder = reportOrder;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getSubModuleName() {
		return this.subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public Integer getSubModuleOrder() {
		return this.subModuleOrder;
	}

	public void setSubModuleOrder(Integer subModuleOrder) {
		this.subModuleOrder = subModuleOrder;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}