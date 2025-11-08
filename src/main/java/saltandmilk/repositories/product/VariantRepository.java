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
import java.util.Optional;
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

    String DTO_PROJECTION = """
new saltandmilk.dto.response.product.VariantResponseDto(
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
""";

    @Query("""
SELECT pv
        FROM ProductVariant pv
        JOIN pv.product p
        LEFT JOIN pv.size s
        LEFT JOIN pv.color c
        WHERE (LOWER(p.name) LIKE %:query% OR LOWER(pv.sku) LIKE %:query%)
    """)
    List<ProductVariant> searchProductSuggestions(@Param("query") String query, Pageable pageable);

    @Query("""
        SELECT pv FROM ProductVariant pv
        JOIN pv.product p
        WHERE p.category.slug = :slug
    """)
    Page<ProductVariant> findVariantsByCategorySlug(@Param("slug") String slug, Pageable pageable);

    // 1. Cho API fetchRelatedProducts
    // Tìm các variant CÓ product.categoryId khớp
    @Query("""
    SELECT v FROM ProductVariant v WHERE v.product.product_id = :productId
    """)
    List<ProductVariant> findByProductId(@Param("productId") UUID productId, Pageable pageable);


    // 2. Cho API fetchVariantSummaries (POST /by-ids)
    @Query("SELECT v FROM ProductVariant v WHERE v.variantId IN :variantIds")
    List<ProductVariant> findByVariantIdIn(@Param("variantIds") List<UUID> variantIds);

    @Query("SELECT pv FROM ProductVariant pv WHERE pv.variantId = :variantId")
    Optional<ProductVariant> findWithDetailsByVariantId(@Param("variantId") UUID variantId);
}
