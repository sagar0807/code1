package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IctcBeneficiary;
import gov.naco.soch.projection.ArtBeneficiaryRegistrationProjection;

@Repository
public interface IctcBeneficiaryRepository extends JpaRepository<IctcBeneficiary, Long> {

	@Query(nativeQuery = true, value = "select b.* from soch.ictc_beneficiary as b "
			+ "where b.beneficiary_id = :beneficiaryId and b.facility_id=:facilityId and b.is_deleted = :isDeleted order by b.id DESC LIMIT 1")
	Optional<IctcBeneficiary> findByBeneficiaryAndIsDeleted(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("isDeleted") boolean isDeleted);

	@Query(nativeQuery = true, value = "select b.pid as beneficiaryPid from soch.ictc_beneficiary as b "
			+ "	where b.pid =:beneficiaryPid and b.facility_id =:facilityId")
	Optional<ArtBeneficiaryRegistrationProjection> findByBeneficiaryPid(@Param("beneficiaryPid") String beneficiaryPid,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ibs.name from ictc_visit iv inner join ictc_beneficiary ib on ib.id  = iv.ictc_beneficiary_id inner join master_ictc_beneficiary_status ibs on ibs.id  = iv.beneficiary_status"
			+ " where ib.beneficiary_id  = :beneficiaryId and ib.facility_id  = :facilityId  order by iv.id desc limit 1")
	String getICTCBenStatus(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);
}
