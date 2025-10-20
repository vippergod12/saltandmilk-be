package saltandmilk.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saltandmilk.entities.product.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
}
