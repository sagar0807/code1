package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TypologyMaster;

@Repository
public interface TypologyRepository extends JpaRepository<TypologyMaster, Long> {

	@Query(nativeQuery = true, value = "select t.typology_id,t.typology_name,tfm.typology_target from soch.typology_master t "
			+ "join soch.typology_facility_mapping tfm on tfm.typology_id=t.typology_id "
			+ "where tfm.facility_id=:facilityId and t.is_delete=false and tfm.is_delete=false order by t.typology_name asc")
	List<Object[]> findAllByFacilityIdAndIsDelete(@Param("facilityId") Long facilityId);
}
