package saltandmilk.dto.response.banners;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BannerResponse {
    int banner_id;
    String title;
    String image_url;
    String target_url;
    boolean isActive;
    int display_order;

}
