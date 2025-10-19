package saltandmilk.repositories.banner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saltandmilk.entities.Banner;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
    List<Banner> findAllByIsActiveTrue();
//    List<Banner> findAllByIsActiveFalse();
}
