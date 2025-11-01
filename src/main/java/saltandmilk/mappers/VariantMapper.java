package saltandmilk.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import saltandmilk.dto.request.product.VariantRequestDto;
import saltandmilk.dto.response.product.VariantResponseDto;
import saltandmilk.entities.product.ProductVariant;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VariantMapper {

    ProductVariant toEntity(VariantRequestDto dto);

    @Mapping(source = "variantId", target = "variantId") // Tên trường đã giống nhau, MapStruct tự xử lý
    @Mapping(source = "product.product_id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "size.sizeId", target = "sizeId")
    @Mapping(source = "size.name", target = "sizeName")
    @Mapping(source = "color.colorId", target = "colorId")
    @Mapping(source="createdAt", target="createdAt")
    @Mapping(source="updatedAt",target="updatedAt")
    @Mapping(source = "color.name", target = "colorName")
    VariantResponseDto toResponseDTO(ProductVariant entity);

    List<VariantResponseDto> toListResponseDTO(List<ProductVariant> entity);
}
