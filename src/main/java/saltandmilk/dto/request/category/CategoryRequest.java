package saltandmilk.dto.request.category;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {
//    int category_id;
    String name;
    String slug;
    String imgUrl;
    Integer parent_category_id;
//    Set<CategoryRequest> children;

}
