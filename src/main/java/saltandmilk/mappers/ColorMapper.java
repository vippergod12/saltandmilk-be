package saltandmilk.mappers;

import org.mapstruct.Mapper;
import saltandmilk.dto.request.product.ColorRequestDto;
import saltandmilk.dto.response.product.ColorResponseDto;
import saltandmilk.entities.product.Color;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    Color toColor(ColorRequestDto request);

    ColorResponseDto toColorResponseDto(Color color);

    List<ColorResponseDto> toListColorResponseDto(List<Color> colors);
}
