package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.naco.soch.constructordto.ArtDetailsDTO;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.Facility;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ArtBeneficiaryRepository extends JpaRepository<ArtBeneficiary, Long> {

	Optional<ArtBeneficiary> findByBeneficiaryId(Long beneficiaryId);

	List<ArtBeneficiary> findByFacilityId(Facility facilityId);

	@Modifying
	@Transactional
	@Query("update ArtBeneficiary ab set ab.isDelete = true , ab.isActive = false where ab.beneficiary.id = :beneficiaryId and ab.facility.id = :facilityId")
	int deleteArtBeneficiary(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(value = "select * from soch.art_beneficiary ab where ab.beneficiary_id=:beneficiaryId and ab.is_delete=:isDelete ", nativeQuery = true)
	ArtBeneficiary findByBeneficiaryIdAndAndIsDelete(@Param("beneficiaryId") Long beneficiaryId,
			@Param("isDelete") boolean isDelete);

	@Query("select new gov.naco.soch.constructordto.ArtDetailsDTO(masterArtBeneficiaryStatus.name as artStatus,facility.name as artCentre) from ArtBeneficiary ab where ab.beneficiary.id=:beneficiaryId"
			+ " and isDelete=:isDelete")
	ArtDetailsDTO getArtStatusAndArtCentre(@Param("beneficiaryId") Long beneficiaryId,
			@Param("isDelete") boolean isDelete);

	@Query(value = "select * from soch.art_beneficiary ab where ab.beneficiary_id=:id ", nativeQuery = true)
	Optional<ArtBeneficiary> findByBenId(@Param("id") Long id);

	@Query(value = "select * from soch.art_beneficiary ab where ab.beneficiary_id=:beneficiaryId and ab.facility_id=:facilityId", nativeQuery = true)
	Optional<ArtBeneficiary> findByBeneficiaryId(Long beneficiaryId, Long facilityId);

	@Query(value = "select mabs.name from  art_beneficiary ab inner join soch.beneficiary b on b.id = ab.beneficiary_id inner join \r\n"
			+ " soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\r\n"
			+ " inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id  where  ab.beneficiary_id  = :beneficiaryId and  bfm.facility_id  = :facilityId and "
			+ " ab.is_active  = true and ab.is_delete = false ", nativeQuery = true)
	String getBenficiaryStatus(Long beneficiaryId, Long facilityId);

	@Query(value = "select ab.* from soch.art_beneficiary ab where ab.beneficiary_id = :beneficiaryId", nativeQuery = true)
    Optional<ArtBeneficiary> findBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

}