package saltandmilk.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saltandmilk.entities.product.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
}
