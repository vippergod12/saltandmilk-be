package saltandmilk.services.product;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        List<ProductVariant> list = variantRepository.findAll();
        return variantMapper.toListResponseDTO(list);
    }

    @Override
    public List<VariantResponseDto> getVariantsByTag(int tagId) {
        List<ProductVariant> list = variantRepository.findVariantsByTagId(tagId);
        return variantMapper.toListResponseDTO(list);
    }

    @Override
    public Page<VariantResponseDto> getVariantsByCategoryId(int category_id, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ProductVariant> pageResult = variantRepository.findProductVariantByCategoryId(category_id,pageable);
        return pageResult.map(variantMapper::toResponseDTO);
    }

    @Override
    public List<VariantResponseDto> findSuggestions(String query, int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        String likeQuery = "%" + query.toLowerCase() + "%";
        return variantRepository.searchProductSuggestions(likeQuery, pageable);
    }

    @Override
    public Page<VariantResponseDto> getVariantsByCategorySlug(String slug,int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ProductVariant> pageResult = variantRepository.findVariantsByCategorySlug(slug, pageable);
        return pageResult.map(variantMapper::toResponseDTO);
    }
}
