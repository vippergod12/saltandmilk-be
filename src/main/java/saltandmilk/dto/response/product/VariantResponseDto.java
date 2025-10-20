package saltandmilk.dto.response.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VariantResponseDto {
    UUID variantId;
    String sku;
    int stockQuantity;
    Double price;
    Double salePrice;
    String imageUrl;

    UUID productId;
    String productName;

    int sizeId;
    String sizeName;

    int colorId;
    String colorName;
}
