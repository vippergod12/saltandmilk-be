package saltandmilk.intefaces.product;

import saltandmilk.dto.response.product.SizeResponseDto;
import saltandmilk.entities.product.Size;

import java.util.List;

public interface SizeService {
    List<SizeResponseDto> findAll();
}
