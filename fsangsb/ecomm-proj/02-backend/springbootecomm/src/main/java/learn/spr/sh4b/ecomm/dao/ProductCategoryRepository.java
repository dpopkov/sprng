package learn.spr.sh4b.ecomm.dao;

import learn.spr.sh4b.ecomm.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
productCategory - name of JSON entry
product-category - path for the "/product-category"
 */
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
