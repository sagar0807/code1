package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TiOstBeneficiary;

@Repository
public interface TiOstBeneficiaryRepository
	extends JpaRepository<TiOstBeneficiary, Long>, JpaSpecificationExecutor<TiOstBeneficiary>, CustomRepository {

    @Override
    @EntityGraph(value = "tiOstBeneficiaryGraph")
    Page<TiOstBeneficiary> findAll(Specification<TiOstBeneficiary> spec, Pageable pageable);

    List<TiOstBeneficiary> findAllByOstStatus(int i);

    List<TiOstBeneficiary> findAllByOstStatusIn(List<Long> ostStatusIds);

    Optional<TiOstBeneficiary> findByOstCodeAndAndIsDeletedAndIdNot(String ostCode, boolean isDeleted,
	    Long beneficiaryId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "CALL soch.beneficiary_dispensestatus()")
    void updateBeneficiaryDispensationStatus();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "CALL soch.beneficiary_clientstatus()")
    void updateBeneficiaryClientStatus();

    boolean existsByOstCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeleted(String ostCode,
	    Long facilityId, boolean b);

    Optional<TiOstBeneficiary> findByOstCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(
	    String ostCode, Long facilityId, boolean b, Long beneficiaryId);

    Optional<TiOstBeneficiary> findByOstNumberAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(
	    String ostNumber, Long facilityId, boolean b, Long beneficiaryId);

    @Query("select case when tob.status.id in (1,7) then true else false end from "
    	+ " TiOstBeneficiary tob where id=:id")
	boolean checkActiveOrRelapseStatus(@Param("id")Long id);
}
