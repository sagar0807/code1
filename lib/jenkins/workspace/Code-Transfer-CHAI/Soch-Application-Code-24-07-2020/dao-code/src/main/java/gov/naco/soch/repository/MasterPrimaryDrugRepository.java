package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterPrimaryDrug;

@Repository
public interface MasterPrimaryDrugRepository extends JpaRepository<MasterPrimaryDrug, Long> {

	
	 List<MasterPrimaryDrug> findByIsDelete(Boolean isDelete);
}
