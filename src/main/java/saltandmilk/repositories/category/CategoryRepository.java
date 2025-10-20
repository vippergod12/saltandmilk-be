package saltandmilk.repositories.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saltandmilk.entities.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
