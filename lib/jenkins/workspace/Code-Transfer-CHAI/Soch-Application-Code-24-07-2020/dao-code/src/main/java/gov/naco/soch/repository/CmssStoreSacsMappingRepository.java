package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssStoreSacsMapping;

@Repository
public interface CmssStoreSacsMappingRepository extends JpaRepository<CmssStoreSacsMapping, Long> {

	List<CmssStoreSacsMapping> findByIsDelete(Boolean isDelete);
	
}
