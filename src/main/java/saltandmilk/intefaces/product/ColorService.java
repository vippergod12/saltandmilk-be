package saltandmilk.intefaces.product;

import saltandmilk.dto.response.product.ColorResponseDto;

import java.util.List;

public interface ColorService {
    List<ColorResponseDto> findAll();

}
