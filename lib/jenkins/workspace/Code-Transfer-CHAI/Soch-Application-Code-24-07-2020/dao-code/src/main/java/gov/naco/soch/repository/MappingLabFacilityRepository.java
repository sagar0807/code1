package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.MappingLabFacility;

public interface MappingLabFacilityRepository extends JpaRepository<MappingLabFacility, Long> {

	@Query(nativeQuery = true, value = "select * from soch.mapping_lab_facility where lab_id = :labId")
	List<MappingLabFacility> findByLabId(@Param("labId") Long labId);
}
