package saltandmilk.repositories.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saltandmilk.entities.tag.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {
}
