package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Division;

/**
 * Repository class that deals with Division Entity
 *
 */
@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>, CustomRepository {
	boolean existsByNameIgnoreCase(String name);

	List<Division> findByIsDeleteOrderByIdAsc(Boolean isDelete);

	@Query(nativeQuery = true, value = "select count(id) from soch.division where LOWER(name) = LOWER(?1) and id!=?2")
	int existsByNameInEdit(String name, Long id);

	@Query(nativeQuery = true, value = "select count(id) from soch.division where is_delete = false and LOWER(name) = LOWER(?1)")
	int existsByOtherNameInEdit(String name);

	@Query(nativeQuery = true, value = "select count(division_id) from soch.user_master where division_id =?1 and is_delete=false")
	int findDeleteUser(Long divisionId);

}
