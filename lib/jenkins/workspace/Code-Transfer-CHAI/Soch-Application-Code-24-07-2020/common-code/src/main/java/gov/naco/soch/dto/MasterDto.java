package gov.naco.soch.dto;

import java.io.Serializable;

/*This class is used for passing master objects which has only 'id/code' and 'name' as significant, especially for displaying dropdown values.*/
public class MasterDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String code;
	private String name;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MasterDto [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
