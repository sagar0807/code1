package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Indent;

@Repository
public interface IndentRepository extends JpaRepository<Indent, Long>, CustomRepository {

	Indent findByIndentNumber(String indentNumber);

	Indent findByIndentNumberAndIndentProducts_Product_IdNotIn(String indentNumber, List<Long> contractProductIds);

	List<Indent> findAllByIsDeleteOrderByIndentIdDesc(boolean b);

	List<Indent> findAllByIndentStatusMaster_IdOrderByIndentIdDesc(long l);

	List<Indent> findAllByIsDelete(boolean b);

	@Query(value = "select i.* from soch.indent as i where i.indent_status_id in(2,5) and i.is_delete=false", nativeQuery = true)
	List<Indent> findAllApprovedIndents();

	@Query(value = "select i.* from soch.indent as i where i.indent_status_id = 5 and i.is_delete=false", nativeQuery = true)
	List<Indent> findAllPushedIndents();

	List<Indent> findAllByCreatedByAndIsDeleteOrderByIndentIdDesc(Long userId, boolean b);

	List<Indent> findAllByCreatedByOrIndentStatusMaster_IdInAndIsDeleteOrderByIndentIdDesc(Long userId,
			List<Long> indentStatusMasterIds, boolean b);

}
