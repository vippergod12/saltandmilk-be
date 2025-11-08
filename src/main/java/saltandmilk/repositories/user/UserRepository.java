package saltandmilk.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saltandmilk.entities.user.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
//    Optional<User> findByEmail(String user_id);

    Optional<User> findByEmail(String email);

//    List<User> findByNameContainingIgnoreCase(String name);

//    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);
}
