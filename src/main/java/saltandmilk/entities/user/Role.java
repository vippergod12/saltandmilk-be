package saltandmilk.entities.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Roles")
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int role_id;
    String name;

    @OneToMany(mappedBy = "role")
    List<User> users;

    @ManyToMany(fetch = FetchType.EAGER) // EAGER để tải các quyền ngay khi tải Role
    @JoinTable(
            name = "role_permission", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    Set<Permission> permissions;
}
