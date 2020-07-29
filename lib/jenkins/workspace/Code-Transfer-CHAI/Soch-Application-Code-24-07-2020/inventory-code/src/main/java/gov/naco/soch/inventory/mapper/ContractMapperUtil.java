package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gov.naco.soch.dto.ContractDetailsDto;
import gov.naco.soch.dto.ContractDto;
import gov.naco.soch.dto.ContractSacsDto;
import gov.naco.soch.dto.LotContractDto;
import gov.naco.soch.dto.ProductContractDto;
import gov.naco.soch.dto.ScheduleProductDto;
import gov.naco.soch.entity.Contract;
import gov.naco.soch.entity.ContractProduct;
import gov.naco.soch.entity.ContractProductSchedule;
import gov.naco.soch.entity.ContractProductScheduleSac;
import gov.naco.soch.entity.ContractProductScheduleSacsLot;
import gov.naco.soch.entity.ContractStatusMaster;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.Product;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.inventory.service.ContractService;

public class ContractMapperUtil {

	// methods 1&2 are to map List<Contract> to List<ContractDetailsDto>

	public static List<ContractDetailsDto> mapContractToContractDtoList(List<Contract> contractDetails) {
		List<ContractDetailsDto> contractDtos = new ArrayList<ContractDetailsDto>();
		if (contractDetails != null) {
			contractDetails.forEach(contract -> {
				Facility facilitySupplier = contract.getFacility();
				ContractDetailsDto contractDto = new ContractDetailsDto();
				contractDto.setId(contract.getContractId());
				contractDto.setNoaNumber(contract.getNoaNumber());
				contractDto.setAllotmentDate(contract.getAllotmentDate());
				contractDto.setIndentNumber(contract.getIndentNum());
				ContractStatusMaster contractStatusMaster = new ContractStatusMaster();
				contractStatusMaster = contract.getContractStatusMaster();
				if (contractStatusMaster != null) {
					contractDto.setContractStatus(contractStatusMaster.getStatus());
				}
				contractDto.setSupplierId(facilitySupplier.getId());
				contractDto.setSupplierName(facilitySupplier.getName());
				contractDto.setCreatedBy(contract.getCreatedBy());
				List<String> products = mapContractProductDetailToContractProductDto(contract.getContractProducts());
				contractDto.setProducts(products);
				contractDtos.add(contractDto);
			});
		}
		return contractDtos;
	}

	/*
	 * private static List<ContractProductDto>
	 * mapContractProductDetailToContractProductDto( Set<ContractProduct>
	 * contractProductDetails) { List<ContractProductDto> contractProductDtos = new
	 * ArrayList<>(); Integer authorizedQuantity = 0; for (ContractProduct
	 * contractProductDetail : contractProductDetails) { ContractProductDto
	 * contractProductDto = new ContractProductDto();
	 * 
	 * contractProductDto.setAuthorizedQuantity(null);
	 * contractProductDto.setProductName(contractProductDetail.getProduct().
	 * getProductName());
	 * contractProductDto.setUom(contractProductDetail.getProduct().
	 * getProductUomMaster().getUomName()); for (ContractProductSchedule
	 * ContractProductScheduleDetail : contractProductDetail
	 * .getContractProductSchedules()) { if
	 * (ContractProductScheduleDetail.getQuantity() != null) { authorizedQuantity =
	 * authorizedQuantity + ContractProductScheduleDetail.getQuantity(); } }
	 * contractProductDto.setAuthorizedQuantity(authorizedQuantity);
	 * contractProductDtos.add(contractProductDto); }
	 * 
	 * return contractProductDtos; }
	 */
	// New mapper method for fetching products name for replacing above commented
	// method : mapContractProductDetailToContractProductDto
	private static List<String> mapContractProductDetailToContractProductDto(
			Set<ContractProduct> contractProductDetails) {
		List<String> contractProducts = new ArrayList<String>();
		for (ContractProduct contractProductDetail : contractProductDetails) {
			String product = contractProductDetail.getProduct().getProductName();
			contractProducts.add(product);
		}

		return contractProducts;
	}

	// methods 3,4 are to map contract with contractDto

	public static ContractDto mapContractToContractDto(Contract contract) {
		ContractDto contractDto = new ContractDto();
		contractDto.setId(contract.getContractId());
		contractDto.setNoaNumber(contract.getNoaNumber());
		contractDto.setAllotmentDate(contract.getAllotmentDate());
		Facility facilitySupplier = new Facility();
		facilitySupplier = contract.getFacility();
		contractDto.setSupplierId(facilitySupplier.getId());
		contractDto.setSupplierName(facilitySupplier.getName());
		contractDto.setIndentNumber(contract.getIndentNum());
		// contractDto.setContractStatus(contract.getContractStatus());
		ContractStatusMaster contractStatusMaster = new ContractStatusMaster();
		contractStatusMaster = contract.getContractStatusMaster();
		contractDto.setContractStatus(contractStatusMaster.getStatus());
		List<ProductContractDto> product = mapContractProductDetailToProductContractDto(contract.getContractProducts());
		contractDto.setProduct(product);

		return contractDto;
	}

	private static List<ProductContractDto> mapContractProductDetailToProductContractDto(
			Set<ContractProduct> contractProductDetails) {

		List<ProductContractDto> productContractDtos = new ArrayList<>();
		if (contractProductDetails != null) {
			for (ContractProduct contractProductDetail : contractProductDetails) {
				ProductContractDto productContractDto = new ProductContractDto();
				productContractDto.setContarctProductId(contractProductDetail.getId());
				productContractDto.setContarctProductId(contractProductDetail.getId());

				if (contractProductDetail.getProduct() != null) {
					productContractDto.setProductId(contractProductDetail.getProduct().getId());
					productContractDto.setProductName(contractProductDetail.getProduct().getProductName());
					if (contractProductDetail.getProduct().getProductUomMaster() != null) {
						productContractDto
								.setUom(contractProductDetail.getProduct().getProductUomMaster().getUomName());
					}
				}

				List<ScheduleProductDto> scheduleProductDtos = ContractService.mapContractProductScheduleDetailToScheduleProductDto(
						contractProductDetail.getContractProductSchedules());

				productContractDto.setSchedule(scheduleProductDtos);
				Long authorizedQuantity = 0L;
				for (ContractProductSchedule ContractProductScheduleDetail : contractProductDetail
						.getContractProductSchedules()) {
					if (ContractProductScheduleDetail.getQuantity() != null) {
						authorizedQuantity = authorizedQuantity + ContractProductScheduleDetail.getQuantity();
					}
				}
				productContractDto.setAuthorizedQuantity(authorizedQuantity);
				productContractDtos.add(productContractDto);
			}

		}

		return productContractDtos;
	}

	public static List<ContractSacsDto> mapContractProductScheduleSacsToContractSacsDto(
			Set<ContractProductScheduleSac> contractProductScheduleSacs) {
		List<ContractSacsDto> contractSacsDtos = new ArrayList<>();
		if (contractProductScheduleSacs != null) {
			for (ContractProductScheduleSac contractProductScheduleSac : contractProductScheduleSacs) {
				ContractSacsDto contractSacsDto = new ContractSacsDto();
				contractSacsDto.setSacsId(contractProductScheduleSac.getId());
				if (contractProductScheduleSac.getFacility() != null) {
					contractSacsDto.setFacilityId(contractProductScheduleSac.getFacility().getId());
					contractSacsDto.setToFacility(contractProductScheduleSac.getFacility().getName());
					if (contractProductScheduleSac.getFacility().getAddress() != null
							&& contractProductScheduleSac.getFacility().getAddress().getState() != null) {
						contractSacsDto
								.setStateId(contractProductScheduleSac.getFacility().getAddress().getState().getId());

					}
				}
				List<LotContractDto> lots = mapContractProductSceduleSacsLotsToLotContractDto(
						contractProductScheduleSac.getContractProductSceduleSacsLots());
				contractSacsDto.setLots(lots);
				contractSacsDtos.add(contractSacsDto);
			}
		}

		return contractSacsDtos;
	}

	public static Contract mapContractDtoToContract(ContractDto contractDto, Contract contract, String action) {
		contract.setNoaNumber(contractDto.getNoaNumber());
		contract.setAllotmentDate(contractDto.getAllotmentDate());
		contract.setIsDelete(false);
		Facility facilitySupplier = new Facility();
		facilitySupplier.setId(contractDto.getSupplierId());
		contract.setFacility(facilitySupplier);
		ContractStatusMaster contractStatusMaster = new ContractStatusMaster();
		if (action.equalsIgnoreCase("save")) {
			contractStatusMaster.setId(1);
		} else if (action.equalsIgnoreCase("submit")) {
			contractStatusMaster.setId(2);
		} else if (action.equalsIgnoreCase("approve")) {
			contractStatusMaster.setId(3);
		}
		contract.setContractStatusMaster(contractStatusMaster);

		if (contractDto.getIndentNumber() != null) {
			contract.setIndentNum(contractDto.getIndentNumber());
		}
		contract.setIsActive(true);
		contract.setIsDelete(false);

		// Add product details
		Set<ContractProduct> contractProductDetails = mapContractProductDetailDtoToContractProductDetail(
				contractDto.getProduct(), contract);
		contract.setContractProducts(contractProductDetails);
		return contract;
	}

	private static Set<ContractProduct> mapContractProductDetailDtoToContractProductDetail(
			List<ProductContractDto> products, Contract contract) {
		Set<ContractProduct> contractProductDetails = new HashSet<ContractProduct>();
		if (products != null) {
			for (ProductContractDto productContract : products) {
				ContractProduct contractProductDetail = new ContractProduct();

				Product product = new Product();
				product.setProductName(product.getProductName());
				product.setId(productContract.getProductId());
				contractProductDetail.setProduct(product);
				contractProductDetail.setIsDelete(false);
				contractProductDetail.setIsActive(true);
				// Add Schedule details
				Set<ContractProductSchedule> contractProductScheduleDetails = mapContractScheduleDtoToContractProductScheduleDetail(
						productContract.getSchedule(), contractProductDetail);
				contractProductDetail.setContractProductSchedules(contractProductScheduleDetails);
				// contractProductDetail.getContractProductScheduleDetails().addAll(contractProductScheduleDetails);
				contractProductDetails.add(contractProductDetail);
				contractProductDetail.setContract(contract);

			}

		}
		return contractProductDetails;
	}

	private static Set<ContractProductSchedule> mapContractScheduleDtoToContractProductScheduleDetail(
			List<ScheduleProductDto> schedules, ContractProduct contractProduct) {
		Set<ContractProductSchedule> contractProductScheduleDetails = new HashSet<ContractProductSchedule>();

		if (schedules != null) {
			for (ScheduleProductDto scheduleProductDto : schedules) {
				ContractProductSchedule contractProductScheduleDetail = new ContractProductSchedule();

				contractProductScheduleDetail.setQuantity(scheduleProductDto.getQuantity());
				contractProductScheduleDetail.setUnitPrice(scheduleProductDto.getUnitPrice());
				contractProductScheduleDetail.setScheduleNumber(scheduleProductDto.getScheduleNumber());
				contractProductScheduleDetail.setIsDelete(false);
				contractProductScheduleDetail.setIsActive(true);
				contractProductScheduleDetail.setContractProduct(contractProduct);
				// Add sacs to schedule
				Set<ContractProductScheduleSac> contractProductScheduleSacs = mapContractProductScheduleToContractProductScheduleSac(
						scheduleProductDto.getSacs(), contractProductScheduleDetail);
				contractProductScheduleDetail.setContractProductScheduleSacs(contractProductScheduleSacs);
				contractProductScheduleDetails.add(contractProductScheduleDetail);
				contractProductScheduleDetail.setContractProduct(contractProduct);
			}
		}
		return contractProductScheduleDetails;
	}

	private static Set<ContractProductScheduleSac> mapContractProductScheduleToContractProductScheduleSac(
			List<ContractSacsDto> contractProductScheduleSacs, ContractProductSchedule contractProductSchedule) {
		Set<ContractProductScheduleSac> contractProductScheduleSacsSet = new HashSet<ContractProductScheduleSac>();
		for (ContractSacsDto contractSacsDto : contractProductScheduleSacs) {
			ContractProductScheduleSac contractProductScheduleSac = new ContractProductScheduleSac();

			Facility facility = new Facility();
			facility.setId(contractSacsDto.getFacilityId());
			facility.setName(contractSacsDto.getToFacility());
			contractProductScheduleSac.setFacility(facility);
			contractProductScheduleSac.setIsActive(true);
			contractProductScheduleSac.setIsDelete(false);
			contractProductScheduleSac.setContractProductSchedule(contractProductSchedule);
			Set<ContractProductScheduleSacsLot> contractProductSceduleSacsLots = mapContractProductScheduleSacToContractProductSacsLot(
					contractSacsDto.getLots(), contractProductScheduleSac);
			contractProductScheduleSac.setContractProductSceduleSacsLots(contractProductSceduleSacsLots);
			contractProductScheduleSacsSet.add(contractProductScheduleSac);
		}
		return contractProductScheduleSacsSet;
	}

	private static Set<ContractProductScheduleSacsLot> mapContractProductScheduleSacToContractProductSacsLot(
			List<LotContractDto> list, ContractProductScheduleSac contractProductScheduleSac) {
		Set<ContractProductScheduleSacsLot> contractProductSceduleSacsLots = new HashSet<ContractProductScheduleSacsLot>();
		if (list != null) {
			for (LotContractDto contractDto : list) {
				ContractProductScheduleSacsLot contractProductSceduleSacsLot = new ContractProductScheduleSacsLot();

				contractProductSceduleSacsLot.setStartDate(contractDto.getStartDate());
				contractProductSceduleSacsLot.setEndDate(contractDto.getEndDate());
				contractProductSceduleSacsLot.setQuantity(contractDto.getQuantity());
				contractProductSceduleSacsLot.setLotNumber(contractDto.getLotNumber());
				contractProductSceduleSacsLot.setIsActive(true);
				contractProductSceduleSacsLot.setIsDelete(false);
				contractProductSceduleSacsLot.setContractProductScheduleSac(contractProductScheduleSac);
				contractProductSceduleSacsLots.add(contractProductSceduleSacsLot);
			}
		}
		return contractProductSceduleSacsLots;
	}

	public static List<ProductContractDto> mapContractProductScheduleSacToProductContractDto(
			List<ContractProductScheduleSac> contractProductScheduleSacs) {
		List<ProductContractDto> productContractDtos = new ArrayList<>();
		if (contractProductScheduleSacs != null) {
			contractProductScheduleSacs.forEach(contractProductScheduleSac -> {
				ProductContractDto productContractDto = new ProductContractDto();
				Long productId = contractProductScheduleSac.getContractProductSchedule().getContractProduct()
						.getProduct().getId();
				productContractDto.setProductId(productId);
				productContractDto.setProductName(contractProductScheduleSac.getContractProductSchedule()
						.getContractProduct().getProduct().getProductName());
				productContractDto.setUom(contractProductScheduleSac.getContractProductSchedule().getContractProduct()
						.getProduct().getProductUomMaster().getUomName());

				productContractDtos.add(productContractDto);
			});
		}
		return productContractDtos;
	}

	public static List<LotContractDto> mapContractProductSceduleSacsLotsToLotContractDto(
			Set<ContractProductScheduleSacsLot> contractProductSceduleSacsLotDetails) {
		List<LotContractDto> lotDetails = new ArrayList<>();
		if (contractProductSceduleSacsLotDetails != null) {
			for (ContractProductScheduleSacsLot contractProductSceduleLotDetail : contractProductSceduleSacsLotDetails) {
				LotContractDto lotContractDto = new LotContractDto();
				lotContractDto.setLotId(contractProductSceduleLotDetail.getId());
				if (contractProductSceduleLotDetail.getStartDate() != null) {
					lotContractDto.setStartDate(contractProductSceduleLotDetail.getStartDate());
				}
				if (contractProductSceduleLotDetail.getEndDate() != null) {
					lotContractDto.setEndDate(contractProductSceduleLotDetail.getEndDate());
				}

				if (contractProductSceduleLotDetail.getQuantity() != null) {
					lotContractDto.setQuantity(contractProductSceduleLotDetail.getQuantity());
				}
				if (contractProductSceduleLotDetail.getLotNumber() != null) {
					lotContractDto.setLotNumber(contractProductSceduleLotDetail.getLotNumber());
				}
				lotDetails.add(lotContractDto);
			}
		}
		return lotDetails;
	}

	public static String createSearchQuery(Facility facility, Long userId, String indentNumber, String noaNumber,
			String supplier, String productName, LocalDate allotmentDate) {
		String searchQuery = "select  * from soch.contract c join soch.facility f on(c.supplier_id=f.id) "
				+ "join soch.contract_product cp on(c.contract_id=cp.contract_id) join soch.product p on "
				+ "(p.id=cp.product_id) where c.is_delete=false";

		if (indentNumber != null) {
			indentNumber=indentNumber.toLowerCase().trim();
			searchQuery = searchQuery + " AND LOWER(c.indent_num) like '%" + indentNumber + "%'";
		}
		if (noaNumber != null) {
			noaNumber=noaNumber.toLowerCase().trim();
			searchQuery = searchQuery + " AND LOWER(c.noa_number) like '%" + noaNumber + "%'";
		}
		if (supplier != null) {
			supplier=supplier.toLowerCase().trim();
			searchQuery = searchQuery + " AND LOWER(f.name) like '%" + supplier + "%'";
		}
		if (productName != null) {
			productName=productName.toLowerCase().trim();
			searchQuery = searchQuery + " AND LOWER(p.product_name) like '%" + productName + "%'";
		}
		if (allotmentDate != null) {
			searchQuery = searchQuery + " AND c.allotment_date='" + allotmentDate + "'";
		}

		if (facility.getFacilityType().getId() == FacilityTypeEnum.NACO.getFacilityType()) {
			List<Integer> contractStatusMasterIds = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5));
			String formattedString = contractStatusMasterIds.toString().replace("[", "") // remove the right bracket
					.replace("]", "") // remove the left bracket
					.trim();
			searchQuery = searchQuery + " AND (c.created_by=" + userId + " or " + "contract_status_id IN ("
					+ formattedString + ") )";
		} else if (facility.getFacilityType().getId() == FacilityTypeEnum.PROCUREMENT_AGENT.getFacilityType()) {
			searchQuery = searchQuery + " AND c.created_by=" + userId + " order by c.contract_id";
		} else if (facility.getFacilityType().getId() == FacilityTypeEnum.SUPPLIER.getFacilityType()) {
			searchQuery = searchQuery + " AND (c.created_by=" + userId + " or(c.supplier_id=" + facility.getId()
					+ "and c.created_by!=" + userId + " and c.contract_status_id in(3))) ORDER BY c.contract_id desc";
		}
		return searchQuery;
	}

}
