package saltandmilk.dto.request.product;

import lombok.*;
import lombok.experimental.FieldDefaults;
import saltandmilk.entities.category.Category;
import saltandmilk.entities.tag.Tag;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {
    String name;
    String description;
    Double basePrice;
    Boolean isPublished;
    int category;
    List<Integer> tags;
}
