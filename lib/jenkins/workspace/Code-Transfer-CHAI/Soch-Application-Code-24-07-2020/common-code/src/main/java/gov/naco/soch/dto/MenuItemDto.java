package gov.naco.soch.dto;

import gov.naco.soch.dto.BaseDto;

public class MenuItemDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String menu;
	private String routerLink;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getRouterLink() {
		return routerLink;
	}
	public void setRouterLink(String routerLink) {
		this.routerLink = routerLink;
	}
	
	
	
}
