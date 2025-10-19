package saltandmilk.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import saltandmilk.dto.request.banners.BannerCreate;
import saltandmilk.dto.response.banners.BannerResponse;
import saltandmilk.entities.Banner;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BannerMapper {
    Banner toBanner(BannerCreate bannerRequest);

    @Mapping(source = "active", target = "isActive")
    BannerResponse toBannerResponse(Banner banner);


    List<BannerResponse> toBannerResponseList(List<Banner> banners);

}
