package saltandmilk.intefaces.product;

import saltandmilk.dto.response.product.VariantResponseDto;

import java.util.List;

public interface VariantService {
    List<VariantResponseDto> findAll();
    List<VariantResponseDto> getVariantsByTag(int tagId);
    List<VariantResponseDto> getVariantsByCategoryId(int category_id);
    List<VariantResponseDto> findSuggestions(String query, int limit);
}
