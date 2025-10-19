package saltandmilk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="promotional_banners")
@Builder
public class Banner {
    @Id
    int banner_id;

    String title;

    String image_url;

    String target_url;

    @Column(name="is_active")
    boolean isActive;

    int display_order;
}
