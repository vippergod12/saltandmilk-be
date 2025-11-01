package saltandmilk.entities.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Categories")
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    String name;
    String slug;
    @Column(name="img_url")
    String imgUrl;

    // Quan hệ với Category cha (nhiều category con có thể thuộc về 1 category cha)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id") // Tên cột khóa ngoại trong DB
    @JsonBackReference // Ngăn chặn đệ quy vô hạn khi serialize JSON
            Category parent;

    // Quan hệ với các Category con (1 category cha có thể có nhiều category con)
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Phía quản lý quan hệ, sẽ được serialize
            Set<Category> children = new HashSet<>();
}
