package gov.naco.soch.dto;

import java.lang.reflect.Field;

public class MiniMasterDto extends BaseDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiniMasterDto() {
	   
	}
	
	public MiniMasterDto(Long id, String name) {
	    this.id = id;
	    this.name = name;
	  
	}

	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean checkNull() throws IllegalAccessException {
	    for (Field f : getClass().getDeclaredFields())
	        if (f.get(this) != null)
	            return false;
	    return true;            
	}
	

}
