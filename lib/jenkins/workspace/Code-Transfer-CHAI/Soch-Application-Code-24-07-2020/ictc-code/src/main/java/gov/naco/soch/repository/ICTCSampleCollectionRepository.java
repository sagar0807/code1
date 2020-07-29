package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.ICTCSampleCollection;

/**
 * Spring Data  repository for the ICTCSampleCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCSampleCollectionRepository extends JpaRepository<ICTCSampleCollection, Long>, JpaSpecificationExecutor<ICTCSampleCollection> {
	Long countByBarcode(String barcode);
	
	@Modifying
	@Query("update ICTCSampleCollection isc set isc.isDeleted=true, isc.isActive=false where isc.id=:id")
	void markEntryAsDeletedAndInActive(@Param("id") Long id);
}
