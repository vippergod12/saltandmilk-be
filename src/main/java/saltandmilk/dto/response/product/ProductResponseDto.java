package saltandmilk.dto.response.product;

import lombok.*;
import lombok.experimental.FieldDefaults;
import saltandmilk.dto.response.category.CategoryResponse;
import saltandmilk.dto.response.tag.TagResponseDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {
    String name;
    String description;
    Double basePrice;
    Boolean isPublished;
    // Thay vì ID, chúng ta trả về cả object CategoryResponseDto
    private CategoryResponse category;

    // Thay vì list ID, chúng ta trả về list object TagResponseDto
    private List<TagResponseDto> tags;
}
