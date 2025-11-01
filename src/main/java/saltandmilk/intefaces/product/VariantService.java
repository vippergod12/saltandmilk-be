package saltandmilk.intefaces.product;

import org.springframework.data.domain.Page;
import saltandmilk.dto.response.product.VariantResponseDto;

import java.util.List;

public interface VariantService {
    List<VariantResponseDto> findAll();
    List<VariantResponseDto> getVariantsByTag(int tagId);
    Page<VariantResponseDto> getVariantsByCategoryId(int category_id, int page, int size);
    List<VariantResponseDto> findSuggestions(String query, int limit);
    Page<VariantResponseDto> getVariantsByCategorySlug(String slug, int page, int size);

}
