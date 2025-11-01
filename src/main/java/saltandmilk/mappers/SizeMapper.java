package saltandmilk.mappers;

import org.mapstruct.Mapper;
import saltandmilk.dto.request.product.SizeRequestDto;
import saltandmilk.dto.response.product.SizeResponseDto;
import saltandmilk.entities.product.Size;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SizeMapper {
    Size toSize(SizeRequestDto request);

    SizeResponseDto toResponseDto(Size size);

    List<SizeResponseDto> toListResponseDto(List<Size> sizes);
}
