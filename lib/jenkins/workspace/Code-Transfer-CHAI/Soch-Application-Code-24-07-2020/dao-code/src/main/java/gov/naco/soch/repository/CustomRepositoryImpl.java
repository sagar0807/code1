package gov.naco.soch.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
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

@SuppressWarnings("unchecked")
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Object[]> userAdvanceSearch(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	public int actualCount(String query) {
		Object count = entityManager.createNativeQuery(query).getSingleResult();
		String countString = String.valueOf(count);
		return Integer.valueOf(countString);
	}

	public List<TiOstBeneficiary> findBeneficiaryListForSearch(String searchQuery) {
		List<TiOstBeneficiary> list = entityManager.createNativeQuery(searchQuery, TiOstBeneficiary.class)
				.getResultList();
		return list;
	}

	public List<TIDispensationExpectedList> findBeneficiaryList(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<TIDispensationExpectedList> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(TIDispensationExpectedList.class)).getResultList();

		return list;
	}

	public List<Facility> facilitySearch(String searchQuery, Pageable pageable) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery, Facility.class);
		nativeQuery.setFirstResult((int) pageable.getOffset());
		nativeQuery.setMaxResults(pageable.getPageSize());
		List<Facility> list = nativeQuery.getResultList();
		return list;
	}

	@Override
	public List<Product> findProductsByAdvanceSearch(String searchQuery) {
		List<Product> list = entityManager.createNativeQuery(searchQuery, Product.class).getResultList();
		return list;
	}

	@Override
	public List<LinkedFacilityBeneficiary> findLacListByAdvanceSearch(String searchQuery) {
		List<LinkedFacilityBeneficiary> list = entityManager
				.createNativeQuery(searchQuery, LinkedFacilityBeneficiary.class).getResultList();
		return list;
	}

	@Override
	public List<Regimen> regimenAdvanceSearch(String searchQuery) {
		List<Regimen> list = entityManager.createNativeQuery(searchQuery, Regimen.class).getResultList();
		return list;
	}

	@Override
	public List<Division> divisionAdvanceSearch(String searchQuery) {
		List<Division> list = entityManager.createNativeQuery(searchQuery, Division.class).getResultList();
		return list;
	}

	@Override
	public List<Role> roleAdvanceSearch(String searchQuery) {
		List<Role> list = entityManager.createNativeQuery(searchQuery, Role.class).getResultList();
		return list;
	}

	@Override
	public List<Object[]> findIctcreferralsByAdvanceSearchs(String searchQuery) {
		List<Object[]> list = entityManager.createNativeQuery(searchQuery).getResultList();
		return list;
	}

	@Override
	public List<ArtDispensation> dispensationAdvanceSerach(String searchQuery) {
		List<ArtDispensation> list = entityManager.createNativeQuery(searchQuery, ArtDispensation.class)
				.getResultList();
		return list;
	}

	@Override
	public List<ArtPepDispensation> pepDispensationAdvanceSearch(String searchQuery) {
		List<ArtPepDispensation> list = entityManager.createNativeQuery(searchQuery, ArtPepDispensation.class)
				.getResultList();
		return list;
	}

	@Override
	public List<LabTestSampleBatch> getReceiveSamplesListByAdvanceSearch(String searchQuery) {
		List<LabTestSampleBatch> list = entityManager.createNativeQuery(searchQuery, LabTestSampleBatch.class)
				.getResultList();
		return list;
	}

	@Override
	public List<FacilityAggregateStockProjection> findUsingSearchValue(String searchQuery) {
		List<FacilityAggregateStockProjection> list = entityManager.createNativeQuery(searchQuery)
				.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(FacilityAggregateStockProjection.class)).getResultList();
		return list;
	}

	@Override
	public List<GoodsRequest> findGoodsRequestBySearchValue(String searchQuery) {
		List<GoodsRequest> list = entityManager.createNativeQuery(searchQuery, GoodsRequest.class).getResultList();
		return list;
	}

	@Override
	public List<FacilityDispatch> findBysearchValue(String searchQuery) {
		List<FacilityDispatch> list = entityManager.createNativeQuery(searchQuery, FacilityDispatch.class)
				.getResultList();
		return list;
	}

	@Override
	public long findCountBeneficiaryList(String query) {
		Object count = entityManager.createNativeQuery(query).getResultList().get(0);
		String countString = String.valueOf(count);
		return Long.parseLong(countString);
	}

	@Override
	public List<LabTestSample> getRecordResultsListByAdvanceSearch(String searchQuery) {
		List<LabTestSample> list = entityManager.createNativeQuery(searchQuery, LabTestSample.class).getResultList();
		return list;
	}

	@Override
	public List<ArtBeneficiaryDueList> artBeneficiaryDueListAdvanceSearch(String searchQuery) {
		List<ArtBeneficiaryDueList> list = entityManager.createNativeQuery(searchQuery, ArtBeneficiaryDueList.class)
				.getResultList();
		return list;
	}

	@Override
	public List<TIDispensationExpectedList> findBeneficiaryList(String searchQuery) {
		Query nativeQuery = entityManager.createNativeQuery(searchQuery);
		List<TIDispensationExpectedList> list = nativeQuery.unwrap(org.hibernate.query.NativeQuery.class)
				.setResultTransformer(Transformers.aliasToBean(TIDispensationExpectedList.class)).getResultList();
		return list;
	}

	public List<Indent> findIndentBySearchValue(String searchQuery) {
		List<Indent> list = entityManager.createNativeQuery(searchQuery, Indent.class).getResultList();
		return list;
	}

	@Override
	public List<ArtBeneficiaryQueue> artBeneficiaryQueueAdvanceSearch(String searchQuery) {
		List<ArtBeneficiaryQueue> list = entityManager.createNativeQuery(searchQuery, ArtBeneficiaryQueue.class)
				.getResultList();
		return list;
	}

	@Override
	public List<Contract> findContractBySearchValue(String searchQuery) {
		List<Contract> list = entityManager.createNativeQuery(searchQuery, Contract.class).getResultList();
		return list;
	}

	@Override
	public List<Object[]> findFacilityList(String listQuery) {
		List<Object[]> list = entityManager.createNativeQuery(listQuery).getResultList();
		return list;
	}

	@Override
	public List<FacilityDispatch> findFacilityDispatchBySearchValue(String searchQuery) {
		List<FacilityDispatch> list = entityManager.createNativeQuery(searchQuery, FacilityDispatch.class)
				.getResultList();
		return list;
	}

	@Override
	public List<Dispatch> findDispatchBySearchValue(String searchQuery) {
		List<Dispatch> list = entityManager.createNativeQuery(searchQuery, Dispatch.class).getResultList();
		return list;
	}

	@Override
	public List<FacilityReceipt> findReceiptHistoryBySearchValue(String searchQuery) {
		List<FacilityReceipt> list = entityManager.createNativeQuery(searchQuery, FacilityReceipt.class)
				.getResultList();
		return list;
	}

	@Override
	public List<FacilityReceipt> findFacilityReceiptBySearchValue(String searchQuery) {
		List<FacilityReceipt> list = entityManager.createNativeQuery(searchQuery, FacilityReceipt.class)
				.getResultList();
		return list;
	}

	public List<ProductDosage> findProductDosage(String searchQuery) {
		List<ProductDosage> list = entityManager.createNativeQuery(searchQuery, ProductDosage.class).getResultList();
		return list;
	}

	@Override
	public List<Receipt> findReceiptHistoryBySearchQuery(String searchQuery) {
		List<Receipt> list = entityManager.createNativeQuery(searchQuery, Receipt.class).getResultList();
		return list;
	}

	@Override
	public List<FacilityReceipt> findUnregisteredSourceHistoryBySearchQuery(String searchQuery) {
		List<FacilityReceipt> list = entityManager.createNativeQuery(searchQuery, FacilityReceipt.class)
				.getResultList();
		return list;
	}

	@Override
	public List<GoodsRequest> findGoodsRequestForSacsBySearchValue(String searchQuery) {
		List<GoodsRequest> list = entityManager.createNativeQuery(searchQuery, GoodsRequest.class).getResultList();
		return list;
	}
}
