package saltandmilk.entities.product;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="sizes")
@Builder
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="size_id")
    int sizeId;
    String name;
}
