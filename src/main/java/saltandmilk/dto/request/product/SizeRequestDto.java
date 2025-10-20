package saltandmilk.dto.request.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SizeRequestDto {
    int size_id;
    String name;
}
