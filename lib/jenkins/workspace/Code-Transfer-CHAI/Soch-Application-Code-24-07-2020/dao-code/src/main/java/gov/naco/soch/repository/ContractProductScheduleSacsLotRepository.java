package gov.naco.soch.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ContractProductScheduleSacsLot;

@Repository
public interface ContractProductScheduleSacsLotRepository extends JpaRepository<ContractProductScheduleSacsLot, Long> {

	@Query(nativeQuery = true, value = "select * from soch.contract_product_schedule_sacs_lot cpssl join "
			+ "soch.contract_product_schedule_sacs cpss on (cpssl.contract_product_scedule_sacs_id=cpss.id) join "
			+ "soch.contract_product_schedule cps on(cpss.contract_product_schedule_id=cps.id) "
			+ "where cps.schedule_number=(:scheduleNumber) ")
	Set<ContractProductScheduleSacsLot> findLotsByScheduleNumber(@Param("scheduleNumber") String scheduleNumber);

	Set<ContractProductScheduleSacsLot> findAllByContractProductScheduleSac_ContractProductSchedule_ContractProduct_Contract_ContractId(
			Integer contractId);

	Set<ContractProductScheduleSacsLot> findAllByContractProductScheduleSac_ContractProductSchedule_ContractProduct_Contract_ContractIdAndContractProductScheduleSac_ContractProductSchedule_ContractProduct_Product_Id(
			Long contractId, Long productId);

	Set<ContractProductScheduleSacsLot> findAllByContractProductScheduleSac_ContractProductSchedule_ContractProduct_Contract_ContractIdAndContractProductScheduleSac_ContractProductSchedule_ContractProduct_Product_IdAndContractProductScheduleSac_Facility_IdOrderByStartDateAsc(
			Long contractId, Long productId, Long sacsId);

}
