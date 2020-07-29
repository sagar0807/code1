package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.IndentDto;
import gov.naco.soch.dto.IndentProductDto;
import gov.naco.soch.dto.IndentProductScheduleDto;
import gov.naco.soch.dto.IndentProductScheduleSacsDto;
import gov.naco.soch.dto.IndentProductScheduleSacsLotDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.Indent;
import gov.naco.soch.entity.IndentProduct;
import gov.naco.soch.entity.IndentProductSchedule;
import gov.naco.soch.entity.IndentProductScheduleSac;
import gov.naco.soch.entity.IndentProductScheduleSacsLot;
import gov.naco.soch.entity.IndentStatusMaster;
import gov.naco.soch.entity.Product;
import gov.naco.soch.enums.FacilityTypeEnum;

public class IndentMapperUtil {

	public static List<IndentDto> mapIndentToIndentDto(List<Indent> indents) {
		List<IndentDto> indentDtos = new ArrayList<IndentDto>();
		if (indents != null) {
			indents.forEach(indent -> {
				IndentDto indentDto = new IndentDto();
				indentDto.setIndentId(indent.getIndentId());
				indentDto.setIndentNumber(indent.getIndentNumber());
				if (indent.getIndentStatusMaster() != null) {
					indentDto.setIndentStatusId(indent.getIndentStatusMaster().getId());
					indentDto.setIndentStatus(indent.getIndentStatusMaster().getStatus());
				}
				indentDto.setIndentDate(indent.getIndentDate());
				List<IndentProductDto> indentProductDtos = mapToIndentProductDto(indent.getIndentProducts());
				indentDto.setProducts(indentProductDtos);
				indentDtos.add(indentDto);
			});
		}
		return indentDtos;
	}

	public static List<IndentProductDto> mapToIndentProductDto(Set<IndentProduct> indentProducts) {
		List<IndentProductDto> indentProductDtos = new ArrayList<IndentProductDto>();
		if (indentProducts != null) {
			indentProducts.forEach(indentProduct -> {
				IndentProductDto indentProductDto = new IndentProductDto();
				indentProductDto.setIndentProductId(indentProduct.getId());
				indentProductDto.setIndentId(indentProduct.getIndent().getIndentId());
				if (indentProduct.getProduct() != null) {
					indentProductDto.setProductId(indentProduct.getProduct().getId());
					indentProductDto.setProductName(indentProduct.getProduct().getProductName());
					if (indentProduct.getProduct().getProductUomMaster() != null) {
						indentProductDto.setUom(indentProduct.getProduct().getProductUomMaster().getUomName());
					}
				}
				List<IndentProductScheduleDto> schedules = mapToIndentProductScheduleDto(
						indentProduct.getIndentProductSchedules());
				indentProductDto.setSchedules(schedules);
				indentProductDtos.add(indentProductDto);
			});
		}
		return indentProductDtos;
	}

	private static List<IndentProductScheduleDto> mapToIndentProductScheduleDto(
			Set<IndentProductSchedule> indentProductSchedules) {
		List<IndentProductScheduleDto> scheduleDtos = new ArrayList<IndentProductScheduleDto>();
		if (indentProductSchedules != null) {
			indentProductSchedules.forEach(schedule -> {
				IndentProductScheduleDto scheduleDto = new IndentProductScheduleDto();
				scheduleDto.setQuantity(schedule.getQuantity());
				scheduleDto.setScheduleId(schedule.getId());
				scheduleDto.setScheduleNumber(schedule.getScheduleNumber());
				scheduleDto.setUnitPrice(schedule.getUnitPrice());
				List<IndentProductScheduleSacsDto> sacsDtoList = mapToIndentProductScheduleSacsDto(
						schedule.getIndentProductScheduleSacs());
				scheduleDto.setSacsList(sacsDtoList);
				scheduleDtos.add(scheduleDto);

			});
		}
		return scheduleDtos;
	}

	private static List<IndentProductScheduleSacsDto> mapToIndentProductScheduleSacsDto(
			Set<IndentProductScheduleSac> indentProductScheduleSacsList) {
		List<IndentProductScheduleSacsDto> sacsDtoList = new ArrayList<IndentProductScheduleSacsDto>();
		if (indentProductScheduleSacsList != null) {
			indentProductScheduleSacsList.forEach(indentProductScheduleSacs -> {
				IndentProductScheduleSacsDto sacsDto = new IndentProductScheduleSacsDto();
				sacsDto.setFacilityId(indentProductScheduleSacs.getFacility().getId());
				sacsDto.setFacilityName(indentProductScheduleSacs.getFacility().getName());
				sacsDto.setScheduleSacsId(indentProductScheduleSacs.getId());
				List<IndentProductScheduleSacsLotDto> indentProductScheduleSacsLotDtos = mapToIndentProductScheduleSacsLotDto(
						indentProductScheduleSacs.getIndentProductSceduleSacsLots());
				sacsDto.setLots(indentProductScheduleSacsLotDtos);
				sacsDtoList.add(sacsDto);
			});
		}
		return sacsDtoList;
	}

	private static List<IndentProductScheduleSacsLotDto> mapToIndentProductScheduleSacsLotDto(
			Set<IndentProductScheduleSacsLot> indentProductSceduleSacsLots) {
		List<IndentProductScheduleSacsLotDto> lotDtos = new ArrayList<IndentProductScheduleSacsLotDto>();
		if (indentProductSceduleSacsLots != null) {
			indentProductSceduleSacsLots.forEach(lot -> {
				IndentProductScheduleSacsLotDto lotDto = new IndentProductScheduleSacsLotDto();
				lotDto.setScheduleId(lot.getIndentProductScheduleSac().getIndentProductSchedule().getId());
				lotDto.setScheduleNumber(
						lot.getIndentProductScheduleSac().getIndentProductSchedule().getScheduleNumber());
				lotDto.setEndDate(lot.getEndDate());
				lotDto.setLotId(lot.getId());
				lotDto.setLotNumber(lot.getLotNumber());
				lotDto.setQuantity(lot.getQuantity());
				lotDto.setStartDate(lot.getStartDate());
				lotDtos.add(lotDto);
			});
		}
		return lotDtos;
	}

	public static Indent mapIndentDtoToIndent(IndentDto indentDto, Indent indent) {

		indent.setIndentNumber(indentDto.getIndentNumber());
		indent.setIndentDate(indentDto.getIndentDate());
		indent.setIsDelete(false);
		indent.setIsActive(true);

		IndentStatusMaster status = new IndentStatusMaster();
		status.setId(1L);

		indent.setIndentStatusMaster(status);
		// Add product details
		Set<IndentProduct> indentProductDetails = mapIndentProductDtoToIndentProduct(indentDto.getProducts(), indent);
		indent.setIndentProducts(indentProductDetails);
		return indent;
	}

	private static Set<IndentProduct> mapIndentProductDtoToIndentProduct(List<IndentProductDto> products,
			Indent indent) {

		Set<IndentProduct> indentProductDetailsSet = new HashSet<>();

		if (!CollectionUtils.isEmpty(products)) {
			for (IndentProductDto indentproduct : products) {
				IndentProduct indentproductDetail = new IndentProduct();
				Product product = new Product();
				product.setId(indentproduct.getProductId());

				indentproductDetail.setProduct(product);
				indentproductDetail.setIsDelete(false);
				indentproductDetail.setIsActive(true);

				// Add Schedule details
				Set<IndentProductSchedule> indentProductScheduleDetails = mapIndentProductScheduleDtoToIndentProductSchedule(
						indentproduct.getSchedules(), indentproductDetail);
				indentproductDetail.setIndentProductSchedules(indentProductScheduleDetails);
				indentProductDetailsSet.add(indentproductDetail);
				indentproductDetail.setIndent(indent);
			}
		}
		return indentProductDetailsSet;
	}

	private static Set<IndentProductSchedule> mapIndentProductScheduleDtoToIndentProductSchedule(
			List<IndentProductScheduleDto> schedules, IndentProduct indentProduct) {
		Set<IndentProductSchedule> indentProductScheduleDetailsSet = new HashSet<>();

		if (!CollectionUtils.isEmpty(schedules)) {
			for (IndentProductScheduleDto productScheduleDto : schedules) {
				IndentProductSchedule indentProductScheduleDetail = new IndentProductSchedule();
				indentProductScheduleDetail.setQuantity(productScheduleDto.getQuantity());
				indentProductScheduleDetail.setUnitPrice(productScheduleDto.getUnitPrice());
				indentProductScheduleDetail.setScheduleNumber(productScheduleDto.getScheduleNumber());
				indentProductScheduleDetail.setIsDelete(false);
				indentProductScheduleDetail.setIsActive(true);
				indentProductScheduleDetail.setIndentProduct(indentProduct);

				// Add sacs to schedule
				Set<IndentProductScheduleSac> indentProductScheduleSacs = mapIndentProductScheduleSacDtoToIndentProductScheduleSac(
						productScheduleDto.getSacsList(), indentProductScheduleDetail);
				indentProductScheduleDetail.setIndentProductScheduleSacs(indentProductScheduleSacs);
				indentProductScheduleDetailsSet.add(indentProductScheduleDetail);
				indentProductScheduleDetail.setIndentProduct(indentProduct);
			}
		}
		return indentProductScheduleDetailsSet;
	}

	private static Set<IndentProductScheduleSac> mapIndentProductScheduleSacDtoToIndentProductScheduleSac(
			List<IndentProductScheduleSacsDto> indentProductScheduleSacs, IndentProductSchedule indentProductSchedule) {
		Set<IndentProductScheduleSac> indentProductScheduleSacsSet = new HashSet<>();
		for (IndentProductScheduleSacsDto indentSacsDto : indentProductScheduleSacs) {
			IndentProductScheduleSac indentProductScheduleSac = new IndentProductScheduleSac();
			Facility facility = new Facility();
			facility.setId(indentSacsDto.getFacilityId());
			indentProductScheduleSac.setFacility(facility);
			indentProductScheduleSac.setIsActive(true);
			indentProductScheduleSac.setIsDelete(false);
			indentProductScheduleSac.setIndentProductSchedule(indentProductSchedule);

			Set<IndentProductScheduleSacsLot> indentProductSceduleSacsLots = mapIndentProductScheduleSacsLotDtoToIndentProductScheduleSacsLot(
					indentSacsDto.getLots(), indentProductScheduleSac);
			indentProductScheduleSac.setIndentProductSceduleSacsLots(indentProductSceduleSacsLots);
			indentProductScheduleSacsSet.add(indentProductScheduleSac);
		}
		return indentProductScheduleSacsSet;
	}

	private static Set<IndentProductScheduleSacsLot> mapIndentProductScheduleSacsLotDtoToIndentProductScheduleSacsLot(
			List<IndentProductScheduleSacsLotDto> list, IndentProductScheduleSac indentProductScheduleSac) {
		Set<IndentProductScheduleSacsLot> indentProductSceduleSacsLotsSet = new HashSet<>();
		if (!CollectionUtils.isEmpty(list)) {
			for (IndentProductScheduleSacsLotDto indentLotsDto : list) {
				IndentProductScheduleSacsLot indentProductSceduleSacsLot = new IndentProductScheduleSacsLot();
				indentProductSceduleSacsLot.setStartDate(indentLotsDto.getStartDate());
				indentProductSceduleSacsLot.setEndDate(indentLotsDto.getEndDate());
				indentProductSceduleSacsLot.setQuantity(indentLotsDto.getQuantity());
				indentProductSceduleSacsLot.setLotNumber(indentLotsDto.getLotNumber());
				indentProductSceduleSacsLot.setIndentProductScheduleSac(indentProductScheduleSac);
				indentProductSceduleSacsLot.setIsActive(true);
				indentProductSceduleSacsLot.setIsDelete(false);
				indentProductSceduleSacsLotsSet.add(indentProductSceduleSacsLot);
			}
		}
		return indentProductSceduleSacsLotsSet;
	}

	public static IndentDto mapIndentDtoToIndent(Indent indent) {
		IndentDto indentDto = new IndentDto();
		indentDto.setIndentId(indent.getIndentId());
		indentDto.setIndentNumber(indent.getIndentNumber());
		if (indent.getIndentStatusMaster() != null) {
			indentDto.setIndentStatusId(indent.getIndentStatusMaster().getId());
			indentDto.setIndentStatus(indent.getIndentStatusMaster().getStatus());
		}
		indentDto.setIndentDate(indent.getIndentDate());
		List<IndentProductDto> indentProductDtos = mapToIndentProductDto(indent.getIndentProducts());
		indentDto.setProducts(indentProductDtos);
		return indentDto;
	}

	public static List<IndentDto> mapIndentNumber(List<Indent> indents) {
		List<IndentDto> indentDtoList = new ArrayList<>();
		if (indents != null) {
			indents.forEach(indent -> {
				IndentDto indentDto = new IndentDto();
				indentDto.setIndentId(indent.getIndentId());
				indentDto.setIndentNumber(indent.getIndentNumber());
				indentDtoList.add(indentDto);
			});
		}
		return indentDtoList;
	}

	public static String createSearchQuery(Facility facility, String indentNumber, LocalDate indentDate,
			String productName) {
		String searchQuery = "select * from soch.indent i join soch.indent_product ip on "
				+ "(i.indent_id=ip.indent_id) join soch.product p on(p.id=ip.product_id) where i.is_delete=false";
		if (indentNumber != null) {
			indentNumber=indentNumber.toLowerCase().trim();
			searchQuery =searchQuery+ " AND LOWER(i.indent_number) like '%" + indentNumber + "%'";
		}
		if (indentDate != null) {
			searchQuery =searchQuery+ " AND i.indent_date='" + indentDate + "'";
		}
		if (productName != null) {
			productName=productName.toLowerCase().trim();
			searchQuery =searchQuery+ " AND LOWER(p.product_name) like '%" + productName + "%'";
		}
		if (facility.getFacilityType().getId() == FacilityTypeEnum.NACO.getFacilityType()) {
			searchQuery =searchQuery+ " order by i.indent_id DESC ";
		} else if (facility.getFacilityType().getId() == FacilityTypeEnum.PROCUREMENT_AGENT.getFacilityType()) {
			searchQuery= searchQuery+ " AND i.indent_status_id=5 order by i.indent_id DESC ";
		}
		return searchQuery;
	}

}
