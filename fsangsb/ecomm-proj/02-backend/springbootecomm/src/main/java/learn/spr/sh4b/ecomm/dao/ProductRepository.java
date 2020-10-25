package learn.spr.sh4b.ecomm.dao;

import learn.spr.sh4b.ecomm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
