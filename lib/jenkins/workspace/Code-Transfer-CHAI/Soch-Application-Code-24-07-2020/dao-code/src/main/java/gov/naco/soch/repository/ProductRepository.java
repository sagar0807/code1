package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Product;
import gov.naco.soch.projection.ProductInventoryProjection;
import gov.naco.soch.projection.ProductListProjection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, CustomRepository {

	@Query(value = "select p from Product p where p.productName in ('Buprenorphine','Methadone') ")
	List<Product> findSubstituitionDrugs();

	Product findById(Integer product);

	@Query(nativeQuery = true, value = "select fac.name as PlCenName ,addr.address as PlAddr ,addr.city as PlCity,dis.name as PlDist,"
			+ "stat.name as PlState, addr.pincode as PlPin ,prod.product_name as PlProdName ,fstock.batch_number as PlBatchNum,"
			+ "fstock.manufacturing_date as PlManfDate,fstock.expired_date as PlExprDate,fstock.current_quantity as PlAvailStock,"
			+ "(Select COALESCE (SUM(quantity),0) " + "FROM soch.facility_stock_tracking Fstr "
			+ "WHERE Fstr.facility_id 		= fstock.facility_id " + "AND Fstr.product_id 		= fstock.product_id "
			+ "AND Fstr.is_active 			= true " + "AND Fstr.created_time\\:\\:date = current_date "
			+ "AND Fstr.stock_add_deduct	= 'deduct')	as PlStockConsumed, " + "pum.uom_code as PlUom "
			+ "from soch.facility fac " + "join soch.address addr on fac.address_id = addr.id "
			+ "join soch.district dis on addr.district_id = dis.id "
			+ "join soch.state stat on addr.state_id = stat.id "
			+ "join soch.facility_stock fstock on fac.id = fstock.facility_id "
			+ "join soch.product prod on fstock.product_id = prod.id "
			+ "join soch.facility_stock_tracking fst on fac.id = fst.facility_id "
			+ "join soch.product_uom_master pum on pum.id = prod.uom_id " + "where fac.id=?1 ")
	List<ProductListProjection> getProductsByFacility(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select count(id) from soch.product where lower(product_name)=lower(:productName) and is_delete=false")
	int isExistByProductNameInSave(@Param("productName") String productName);

	@Query(nativeQuery = true, value = "select count(id) from soch.product where LOWER(product_name)=LOWER(:productName) and is_delete=false and id !=:id")
	int isExistByProductNameInEdit(@Param("productName") String productName, @Param("id") Long id);

	@Query(value = "select p.* from soch.product as p where lower(p.product_name) LIKE %:productName%", nativeQuery = true)
	List<Product> findByProductNameLike(@Param("productName") String productName);

	@Query(nativeQuery = true, value = "select p.id from soch.product p where p.product_name=:productName")
	Long findProductIdByProductName(@Param("productName") String productNam);

	List<Product> findAllByIsDelete(Boolean false1);

	@Query(nativeQuery = true, value = "select p.* from soch.product p where (lower(p.product_name) Like lower(:searchValue) or lower(p.product_short_code) Like lower(:searchValue)) and p.is_delete=false and p.is_active=true order by p.product_name asc")
	List<Product> findProductsByNormalSearch(@Param("searchValue") String searchValue);

	List<Product> findAllByIsDeleteOrderByIdDesc(Boolean false1);

	@Query(nativeQuery = true, value = "select count(id) from soch.product where lower(product_short_code)=lower(:productShortCode) and is_delete=false and id !=:id")
	int isExistByProductShortCodeInEdit(@Param("productShortCode") String productShortCode, @Param("id") Long id);

	@Query(nativeQuery = true, value = "select count(id) from soch.product where lower(product_short_code)=lower(:productShortCode) and is_delete=false")
	int isExistByProductShortCodeInSave(@Param("productShortCode") String productShortCode);

	@Query(nativeQuery = true, value = "select p.id as productId,p.product_name as productName,p.product_short_code as productCode,"
			+ "p.uom_id as uomId,uom.uom_name as uomName from soch.product p "
			+ "join soch.product_uom_master uom on uom.id=p.uom_id "
			+ "where p.is_delete=false and p.is_active=true order by p.product_name asc")
	List<ProductInventoryProjection> findAllProductByIsActiveAndIsDelete();

}
