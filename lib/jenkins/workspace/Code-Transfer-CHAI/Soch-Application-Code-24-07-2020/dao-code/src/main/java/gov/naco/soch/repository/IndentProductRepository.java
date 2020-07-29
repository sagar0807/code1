package gov.naco.soch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IndentProduct;

@Repository
public interface IndentProductRepository extends JpaRepository<IndentProduct, Long> {

	Set<IndentProduct> findAllByIndent_IndentIdAndProduct_IdNotIn(Long indentId, List<Long> contractProductIds);

}
