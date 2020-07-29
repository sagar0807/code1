package gov.naco.soch.dto;

import java.util.List;

public class ProductSacsDto {

	private Long productId;
	private List<Long> sacsId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<Long> getSacsId() {
		return sacsId;
	}

	public void setSacsId(List<Long> sacsId) {
		this.sacsId = sacsId;
	}

}
