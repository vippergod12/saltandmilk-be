package saltandmilk.dto.request.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VariantRequestDto {
    String sku;
    int stockQuantity;
    Double price;
    Double salePrice;
    String imageUrl;
    private LocalDateTime createdAt;
    LocalDateTime updatedAt;
    UUID productId;  // tham chiếu đến Product cha
    int sizeId;     // optional
    int colorId;    // optional
}
