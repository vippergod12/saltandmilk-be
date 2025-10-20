package saltandmilk.services.product;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import saltandmilk.dto.response.product.VariantResponseDto;
import saltandmilk.entities.product.ProductVariant;
import saltandmilk.intefaces.product.VariantService;
import saltandmilk.mappers.VariantMapper;
import saltandmilk.repositories.product.VariantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VariantServiceImp implements VariantService {

    final VariantRepository variantRepository;
    final VariantMapper variantMapper;

    @Override
    public List<VariantResponseDto> findAll() {
        return List.of();
    }

    @Override
    public List<VariantResponseDto> getVariantsByTag(int tagId) {
        List<ProductVariant> list = variantRepository.findVariantsByTagId(tagId);
        return variantMapper.toListResponseDTO(list);
    }
}
