package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCSampleCollectionView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ICTCSampleCollectionView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCSampleCollectionViewRepository extends JpaRepository<ICTCSampleCollectionView, Long>, JpaSpecificationExecutor<ICTCSampleCollectionView> {

}
