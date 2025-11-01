package saltandmilk.services.product;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import saltandmilk.dto.response.product.SizeResponseDto;
import saltandmilk.entities.product.Size;
import saltandmilk.intefaces.product.SizeService;
import saltandmilk.mappers.SizeMapper;
import saltandmilk.repositories.product.SizeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SizeServiceImpl implements SizeService {
    final SizeRepository sizeRepository;
    final SizeMapper sizeMapper;
    @Override
    public List<SizeResponseDto> findAll() {
        List<Size> list = sizeRepository.findAll();
        return sizeMapper.toListResponseDto(list);
    }
}
