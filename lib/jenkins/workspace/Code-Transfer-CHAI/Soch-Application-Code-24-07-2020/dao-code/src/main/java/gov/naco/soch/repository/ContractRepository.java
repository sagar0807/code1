package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>, CustomRepository {
	@Query(nativeQuery = true, value = "select c.*,cp.*,cs.*,cps.*,cpsl.* from soch.contract c, soch.contract_product cp, soch.contract_product_schedule cs,soch.contract_product_schedule_sacs cps, soch.contract_product_schedule_sacs_lot cpsl where c.contract_id = :contractId and c.contract_id=cp.contract_id and cp.id = cs.contract_product_id and cs.id = cps.contract_product_schedule_id and cps.id = cpsl.contract_product_scedule_sacs_id  group by c.contract_id,cp.id,cs.id,cps.id,cpsl.id order by cpsl.start_date ASC")
	Contract findByContractId(@Param("contractId") Long contractId);

	@Query(nativeQuery = true, value = "select * from soch.contract where is_delete = :isDelete order by contract_id desc")
	List<Contract> findByIsDelete(@Param("isDelete") Boolean isDelete);

	@Query(nativeQuery = true, value = "select * from soch.contract where created_by = :userId and is_delete = :isDelete")
	List<Contract> findAllByFacilityId(@Param("userId") Long userId, @Param("isDelete") Boolean isDelete);

	List<Contract> findAllByContractProducts_Product_IdAndFacility_IdAndIsDeleteAndContractStatusMaster_Id(
			Long productId, Long facilityId, boolean b, int i);

	@Query(nativeQuery = true, value = "select COUNT(*) from soch.contract c where c.noa_number = :noaNumber and c.is_delete=false")
	Integer existByNoaNumber(@Param("noaNumber") String noaNumber);

	List<Contract> findAllByIsDelete(boolean b);

	List<Contract> findAllByCreatedByAndIsDeleteOrderByContractIdDesc(Long userId, boolean b);

	@Query(nativeQuery = true, value = "select * from soch.contract where (created_by=:userId or(supplier_id=:facilityId and created_by!=:userId and contract_status_id in(3))) and is_delete=:b ORDER BY contract_id desc")
	List<Contract> findAllSupplierContractList(@Param("facilityId") Long facilityId, @Param("userId") Long userId,
			@Param("b") boolean b);

	@Query(nativeQuery = true, value = "select  * from soch.contract where (created_by=:userId or contract_status_id IN :contractStatusMasterIds) AND is_delete=:b ORDER BY contract_id desc")
	List<Contract> findAllByCreatedByOrContractStatusMaster_IdInAndIsDeleteOrderByContractId(
			@Param("userId") Long userId, @Param("contractStatusMasterIds") List<Integer> contractStatusMasterIds,
			@Param("b") boolean b);

	@Query(nativeQuery = true, value = "select p.id from soch.contract c join soch.contract_product cp on "
			+ "(c.contract_id=cp.contract_id) join soch.product p on (cp.product_id=p.id) where c.indent_num=:indentNumber")
	List<Long> findAllIndentProductsPendingForContractCreation(@Param("indentNumber") String indentNumber);

}
