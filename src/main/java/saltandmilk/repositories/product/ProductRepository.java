package saltandmilk.repositories.product;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import saltandmilk.entities.product.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> getProductsByName(String tagName);

//    @EntityGraph(attributePaths = {
//            "category",         // Tải category của sản phẩm
//            "tags",             // Tải tags của sản phẩm
//            "variants",         // Tải danh sách các biến thể
//            "variants.size",    // Tải 'Size' của từng biến thể
//            "variants.color",   // Tải 'Color' của từng biến thể
//            "variants.product"  // Tải tham chiếu 'Product' của từng biến thể
//    })
//    @Query("SELECT p FROM Product p WHERE p.product_id = :id")
//    Optional<Product> findWithDetailsByProductId(@Param("id") UUID id);
}
