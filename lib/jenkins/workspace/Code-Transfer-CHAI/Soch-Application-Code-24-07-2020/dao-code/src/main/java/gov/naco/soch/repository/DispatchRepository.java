package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.Dispatch;

public interface DispatchRepository extends JpaRepository<Dispatch, Long>, CustomRepository {

	Dispatch findByDispatchId(Long dispatchId);

	@EntityGraph(value = "DispatchGraph")
	List<Dispatch> findAllByShipToConsignee_IdAndDispatchStatusMaster_IdAndConsignor_FacilityType_IdIn(Long facilityId,
			int i, List<Long> facilityTypeIds);

	List<Dispatch> findAllByConsignor_IdOrderByDispatchIdDesc(Long consignorId);

	List<Dispatch> findAllByContract_ContractId(Long contarctId);

	List<Dispatch> findAllByConsignor_Id(Long consignorId);

	List<Dispatch> findAllByContract_ContractIdAndContractProduct_Product_Id(Long contractId, Long productId);

	List<Dispatch> findAllByContract_ContractIdAndContractProduct_Product_IdAndContractProductSchedule_Id(
			Long contractId, Long id, Long scheduleId);

	@Query(nativeQuery=true,value="select count(d.invoice_number) from soch.dispatch d where LOWER(d.invoice_number)=LOWER(:invoiceNumber)")
	Long existsByInvoiceNumber(@Param("invoiceNumber")String invoiceNumber);

}
