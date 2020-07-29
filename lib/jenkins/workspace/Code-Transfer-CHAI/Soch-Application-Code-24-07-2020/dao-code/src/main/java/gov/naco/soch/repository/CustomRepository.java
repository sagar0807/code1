package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.entity.ArtPepDispensation;
import gov.naco.soch.entity.Contract;
import gov.naco.soch.entity.Dispatch;
import gov.naco.soch.entity.Division;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.GoodsRequest;
import gov.naco.soch.entity.Indent;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.entity.LabTestSampleBatch;
import gov.naco.soch.entity.LinkedFacilityBeneficiary;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ProductDosage;
import gov.naco.soch.entity.Receipt;
import gov.naco.soch.entity.Regimen;
import gov.naco.soch.entity.Role;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.projection.FacilityAggregateStockProjection;
import gov.naco.soch.projection.TIDispensationExpectedList;

public interface CustomRepository {

	List<Object[]> userAdvanceSearch(String searchQuery, Pageable pageable);

	int actualCount(String actualCountQuery);

	List<TIDispensationExpectedList> findBeneficiaryList(String searchQuery, Pageable page);

	List<TIDispensationExpectedList> findBeneficiaryList(String searchQuery);

	long findCountBeneficiaryList(String searchQuery);

	List<TiOstBeneficiary> findBeneficiaryListForSearch(String searchQuery);

	List<Facility> facilitySearch(String searchQuery, Pageable pageable);

	List<Product> findProductsByAdvanceSearch(String searchQuery);

	List<LinkedFacilityBeneficiary> findLacListByAdvanceSearch(String searchQuery);

	List<Regimen> regimenAdvanceSearch(String searchQuery);

	List<Division> divisionAdvanceSearch(String searchQuery);

	List<Role> roleAdvanceSearch(String searchQuery);

	List<Object[]> findIctcreferralsByAdvanceSearchs(String searchQuery);

	List<ArtDispensation> dispensationAdvanceSerach(String searchQuery);

	List<ArtPepDispensation> pepDispensationAdvanceSearch(String searchQuery);

	List<LabTestSampleBatch> getReceiveSamplesListByAdvanceSearch(String searchQuery);

	List<FacilityAggregateStockProjection> findUsingSearchValue(String searchQuery);

	List<GoodsRequest> findGoodsRequestBySearchValue(String searchQuery);

	List<FacilityDispatch> findBysearchValue(String searchQuery);

	List<LabTestSample> getRecordResultsListByAdvanceSearch(String searchQuery);

	List<ArtBeneficiaryDueList> artBeneficiaryDueListAdvanceSearch(String searchQuery);

	List<ArtBeneficiaryQueue> artBeneficiaryQueueAdvanceSearch(String searchQuery);

	List<Indent> findIndentBySearchValue(String searchQuery);

	List<Contract> findContractBySearchValue(String searchQuery);

	List<FacilityReceipt> findFacilityReceiptBySearchValue(String searchQuery);

	List<Object[]> findFacilityList(String listQuery);

	List<FacilityDispatch> findFacilityDispatchBySearchValue(String searchQuery);

	List<Dispatch> findDispatchBySearchValue(String searchQuery);

	List<FacilityReceipt> findReceiptHistoryBySearchValue(String searchQuery);

	List<ProductDosage> findProductDosage(String searchQuery);

	List<Receipt> findReceiptHistoryBySearchQuery(String searchQuery);

	List<FacilityReceipt> findUnregisteredSourceHistoryBySearchQuery(String searchQuery);
	
	List<GoodsRequest> findGoodsRequestForSacsBySearchValue(String searchQuery);

}
