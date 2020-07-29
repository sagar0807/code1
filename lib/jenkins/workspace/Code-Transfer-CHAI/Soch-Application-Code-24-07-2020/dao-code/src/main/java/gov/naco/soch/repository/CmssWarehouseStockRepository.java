package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssWarehouseStock;

@Repository
public interface CmssWarehouseStockRepository extends JpaRepository<CmssWarehouseStock, Long> {

}
