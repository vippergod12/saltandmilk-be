package saltandmilk.entities.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import saltandmilk.entities.category.Category;
import saltandmilk.entities.tag.Tag;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="products")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID product_id;
    String name;
    String description;
    Double basePrice;
    String slug;
    @Column(name="is_published")
    boolean isPublished;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    // --- PHẦN THÊM MỚI ---
    @ManyToOne(fetch = FetchType.LAZY) // (1)
    @JoinColumn(name = "category_id") // (2)
    Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_tags", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "product_id"), // Khóa ngoại trỏ về bảng products
            inverseJoinColumns = @JoinColumn(name = "tag_id") // Khóa ngoại trỏ về bảng tags
    )
    private Set<Tag> tags = new HashSet<>();

    // --- PHẦN SỬA LẠI & HOÀN THIỆN ---
    @OneToMany(
            mappedBy = "product", // (A)
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductVariant> variants = new ArrayList<>();
}
