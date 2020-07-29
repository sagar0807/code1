package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtPepDispensation;

@Repository
public interface ArtPepDispensationRepository extends JpaRepository<ArtPepDispensation, Long>,CustomRepository {

	List<ArtPepDispensation> findAllByFacility_IdAndDispenseDate(Long facilityId, LocalDate now);


}
