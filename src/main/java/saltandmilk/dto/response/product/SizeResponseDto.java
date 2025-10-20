package saltandmilk.dto.response.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SizeResponseDto {
    int size_id;
    String name;
}
