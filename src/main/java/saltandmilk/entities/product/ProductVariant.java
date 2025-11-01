package saltandmilk.entities.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Product_variants")
@Builder
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
            @Column(name="variant_id")
    UUID variantId;

    String sku;

    @Column(name="created_at")
    LocalDateTime createdAt;
    @Column(name="updated_at")
    LocalDateTime updatedAt;

    @Column(name="stock_quantity")
    int stockQuantity;
    Double price;
    Double salePrice;
    @Column(name="image_url")
    String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY) // (B)
    @JoinColumn(name = "product_id", nullable = false) // (C)
    private Product product;

    // --- Các khóa ngoại khác ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;
}
