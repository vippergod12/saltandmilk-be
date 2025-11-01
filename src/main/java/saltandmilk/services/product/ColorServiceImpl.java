package saltandmilk.services.product;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import saltandmilk.dto.response.product.ColorResponseDto;
import saltandmilk.entities.product.Color;
import saltandmilk.intefaces.product.ColorService;
import saltandmilk.mappers.ColorMapper;
import saltandmilk.repositories.product.ColorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ColorServiceImpl implements ColorService {
    final ColorRepository colorRepository;
    final ColorMapper colorMapper;
    @Override
    public List<ColorResponseDto> findAll() {
        List<Color> list = colorRepository.findAll();
        return colorMapper.toListColorResponseDto(list);
    }
}
