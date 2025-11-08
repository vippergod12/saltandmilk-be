package saltandmilk.dto.response.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import saltandmilk.dto.response.category.CategoryResponse;
import saltandmilk.dto.response.tag.TagResponseDto;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {
    UUID product_id;
    String name;
    String description;
    Double basePrice;
    Boolean isPublished;
    // Thay vì ID, chúng ta trả về cả object CategoryResponseDto
    private CategoryResponse category;

    private List<VariantResponseDto> variants;

    // Thay vì list ID, chúng ta trả về list object TagResponseDto
    private List<TagResponseDto> tags;
}
