package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryVisitRegister;

@Repository
public interface BeneficiaryVisitRegisterRepository extends JpaRepository<BeneficiaryVisitRegister, Long> {

	@Query(value = "select * from soch.beneficiary_visit_register bvr where bvr.visit_date=:localDate and bvr.beneficiary_id=:beneficiaryId and bvr.facility_id = :facilityId and is_delete=false and is_active=true order by bvr.id asc", nativeQuery = true)
	Optional<BeneficiaryVisitRegister> findByfacilityIdAndBeneficiaryId(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId, @Param("localDate") LocalDate localDate);

	List<BeneficiaryVisitRegister> findAllByIsDelete(boolean b);

	@Query(value = "select * from soch.beneficiary_visit_register bvr where bvr.beneficiary_id=:beneficiaryId and is_delete=false order by bvr.id desc LIMIT 1", nativeQuery = true)
	BeneficiaryVisitRegister findAllByBeneficiaryIdAndIsDelete(@Param("beneficiaryId") Long beneficiaryId,
			@Param("b") boolean b);

	BeneficiaryVisitRegister findByBeneficiaryId(Long beneficiaryId);

	List<BeneficiaryVisitRegister> findByBeneficiaryIdAndIsDelete(Long beneficiaryId, boolean b);

	@Query(value = "select * from soch.beneficiary_visit_register where beneficiary_id=:beneficiaryId "
			+ "and facility_id=:facilityId order by id DESC limit 4", nativeQuery = true)
	List<BeneficiaryVisitRegister> getVisitedId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

}
