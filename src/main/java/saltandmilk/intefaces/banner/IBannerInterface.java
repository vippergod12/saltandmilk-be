package saltandmilk.intefaces.banner;


import saltandmilk.dto.response.banners.BannerResponse;

import java.util.List;

public interface IBannerInterface {
    List<BannerResponse> getAllBanners();
    List<BannerResponse> getAllBannersIsActiveTrue();
}
