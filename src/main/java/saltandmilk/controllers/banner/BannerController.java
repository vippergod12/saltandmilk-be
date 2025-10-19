package saltandmilk.controllers.banner;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.banners.BannerResponse;
import saltandmilk.intefaces.banner.IBannerInterface;

import java.util.List;

@RestController
@RequestMapping("/api/banners")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BannerController {

    @Autowired
    IBannerInterface bannerInterface;

    @GetMapping
    ApiResp<List<BannerResponse>> getAllBannerIsActiveTrue() {
        var result = bannerInterface.getAllBannersIsActiveTrue();
        return ApiResp.<List<BannerResponse>>builder().result(result).build();
    }
}
