package saltandmilk.entities.user;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID user_id;
    String username;
    String email;
    String password;
    String full_name;
    LocalDateTime created_at;
    LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name="role_id")
    Role role;
}
