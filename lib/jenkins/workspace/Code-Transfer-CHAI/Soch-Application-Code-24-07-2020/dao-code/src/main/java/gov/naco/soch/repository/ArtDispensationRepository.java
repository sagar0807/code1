package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtDispensation;

@Repository
public interface ArtDispensationRepository extends JpaRepository<ArtDispensation, Long> ,CustomRepository {

	@Query(nativeQuery = true, value = "select * from (SELECT * FROM soch.art_dispensation where beneficiary_id =:beneficiaryId"
			+ " ORDER BY created_time DESC LIMIT 3)sub ORDER BY created_time DESC")
	List<ArtDispensation> findByLastDispensationdetails(@Param("beneficiaryId") Long beneficiaryId);

	List<ArtDispensation> findAllByFacility_IdAndDispenseDate(Long facilityId, LocalDate now);

}
