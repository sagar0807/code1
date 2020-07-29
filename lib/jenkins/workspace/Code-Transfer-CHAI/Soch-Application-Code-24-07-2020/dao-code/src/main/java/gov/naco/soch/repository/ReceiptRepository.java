package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer>,CustomRepository {

	Receipt findByDispatch_DispatchId(Long dispatchId);

	List<Receipt> findAllByDispatch_ShipToConsignee_IdIn(List<Long> consigneeIdList);

	Optional<Receipt> findById(Long receiptId);

	@Query(nativeQuery=true,value="select * from soch.receipt r where r.dispatch_id=:dispatchId order by r.created_time DESC LIMIT 1")
	Receipt findByLatestByDispatchId(@Param("dispatchId")Long dispatchId);


}
