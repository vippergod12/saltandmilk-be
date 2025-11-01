package saltandmilk.repositories.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import saltandmilk.dto.response.product.VariantResponseDto;
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
Page<ProductVariant> findProductVariantByCategoryId(@Param("category_id") int category_id,  Pageable pageable);
    @Query("""
        SELECT new saltandmilk.dto.response.product.VariantResponseDto(
            pv.variantId,
            pv.sku,
            pv.stockQuantity,
            pv.price,
            pv.salePrice,
            pv.imageUrl,
            pv.createdAt,
            pv.updatedAt,
            p.product_id,
            p.name,
            s.sizeId,
            s.name,
            c.colorId,
            c.name
        )
        FROM ProductVariant pv
        JOIN pv.product p
        LEFT JOIN pv.size s
        LEFT JOIN pv.color c
        WHERE (LOWER(p.name) LIKE :query OR LOWER(pv.sku) LIKE :query)
    """)
    List<VariantResponseDto> searchProductSuggestions(@Param("query") String query, Pageable pageable);

    @Query("""
        SELECT pv FROM ProductVariant pv
        JOIN pv.product p
        WHERE p.category.slug = :slug
    """)
    Page<ProductVariant> findVariantsByCategorySlug(@Param("slug") String slug, Pageable pageable);
}
