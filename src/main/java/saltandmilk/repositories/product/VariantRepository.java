package saltandmilk.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import saltandmilk.entities.product.ProductVariant;

import java.util.List;
import java.util.UUID;

@Repository
public interface VariantRepository extends JpaRepository<ProductVariant, UUID> {
//    List<ProductVariant> findTop12ByOrderBySalesCountDesc();
@Query("""
    SELECT pv FROM ProductVariant pv
    JOIN pv.product p
    JOIN p.tags t
    WHERE t.tag_id = :tagId
""")
List<ProductVariant> findVariantsByTagId(@Param("tagId") int tagId);

@Query("""
    SELECT pv FROM ProductVariant pv
    JOIN pv.product p
    JOIN p.category c
    WHERE c.category_id = :category_id
""")
List<ProductVariant> findProductVariantByCategoryId(@Param("category_id") int category_id);
}
