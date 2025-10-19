package saltandmilk.services.banner;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import saltandmilk.dto.response.banners.BannerResponse;
import saltandmilk.entities.Banner;
import saltandmilk.intefaces.banner.IBannerInterface;
import saltandmilk.mappers.BannerMapper;
import saltandmilk.repositories.banner.BannerRepository;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BannerService implements IBannerInterface {
    BannerRepository _bannerRepository;
    BannerMapper _bannerMapper;

    @Override
    public List<BannerResponse> getAllBanners() {
        List<Banner> listBanner = _bannerRepository.findAll();
        return _bannerMapper.toBannerResponseList(listBanner);
    }

    @Override
    public List<BannerResponse> getAllBannersIsActiveTrue() {
        List<Banner> listBanner = _bannerRepository.findAllByIsActiveTrue();
        return _bannerMapper.toBannerResponseList(listBanner);
    }
}
