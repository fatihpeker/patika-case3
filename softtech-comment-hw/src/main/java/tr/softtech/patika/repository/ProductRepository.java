package tr.softtech.patika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.softtech.patika.model.Product;

public interface ProductRepository extends JpaRepository<Product,String> {
}
