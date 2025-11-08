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
    @Mapping(source = "product", target = "product")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "color", target = "color")
    @Mapping(source="createdAt", target="createdAt")
    @Mapping(source="updatedAt",target="updatedAt")
    VariantResponseDto toResponseDTO(ProductVariant entity);

    List<VariantResponseDto> toListResponseDTO(List<ProductVariant> entity);
}
