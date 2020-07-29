package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Regimen;

@Repository
public interface RegimenRepository extends JpaRepository<Regimen, Long>, CustomRepository {

	@Query(nativeQuery = true, value = "select count(id) from soch.regimen where is_delete = false and LOWER(regimen_name)=LOWER(:regimenName) and id!=:id ")
	int countRegimentInEdit(@Param("regimenName") String regimenName, @Param("id") Long id);

	@Query(nativeQuery = true, value = "select count(id) from soch.regimen where is_delete = false and LOWER(regimen_name)=LOWER(:regimenName) ")
	int countRegimentInAdd(@Param("regimenName") String regimenName);

}
