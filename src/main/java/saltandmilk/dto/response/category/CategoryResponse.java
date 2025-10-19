package saltandmilk.dto.response.category;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRespone {
    int category_id;
    String name;
    String slug;
    String img_url;
    Integer parent_category_id;
    Set<CategoryRespone> children;
}
