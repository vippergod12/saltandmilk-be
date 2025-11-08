package saltandmilk.controllers.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.product.VariantResponseDto;
import saltandmilk.intefaces.product.ProductDetailService;
import saltandmilk.intefaces.product.VariantService;
import saltandmilk.mappers.VariantMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/variants")
@RequiredArgsConstructor
public class VariantController {
    final VariantService variantService;
    final ProductDetailService productDetailService;
    final VariantMapper variantMapper;

    @GetMapping
    ApiResp<List<VariantResponseDto>> getAllVariants(@RequestParam(name = "tagId") int tagId) {
        var variants = variantService.getVariantsByTag(tagId);
        return ApiResp.<List<VariantResponseDto>>builder().result(variants).build();
    }

    @GetMapping("/all")
    ApiResp<List<VariantResponseDto>>getAll(){
        var result = variantService.findAll();
        return ApiResp.<List<VariantResponseDto>>builder().result(result).build();
    }

    @GetMapping("/get-by-cate")
    ApiResp<Page<VariantResponseDto>> getVariantsByCategoryId(@RequestParam(name = "category_id") int category_id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size) {
        Page<VariantResponseDto> variantPage = variantService.getVariantsByCategoryId(category_id,page,size);
        return ApiResp.<Page<VariantResponseDto>>builder().result(variantPage).build();
    }

    @GetMapping("/search")
    ApiResp<List<VariantResponseDto>> search(@RequestParam("q") String query,
                                             @RequestParam(value = "limit", defaultValue = "5") int limit){
        List<VariantResponseDto> suggestions = variantService.findSuggestions(query,limit);
        return ApiResp.<List<VariantResponseDto>>builder().result(suggestions).build();
    }

    @GetMapping("/by-category-slug/{slug}")
    ApiResp<Page<VariantResponseDto>> getVariantsByCategorySlug(@PathVariable String slug,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "12") int size){
        Page<VariantResponseDto> variantPage = variantService.getVariantsByCategorySlug(slug,page,size);
        return ApiResp.<Page<VariantResponseDto>>builder().result(variantPage).build();
    }
    @GetMapping("/related")
    ApiResp<List<VariantResponseDto>> getRelatedProducts(@RequestParam UUID productId,
                                                         @RequestParam(defaultValue = "8") int limit){
        List<VariantResponseDto> variants = variantMapper.toListResponseDTO(productDetailService.getRelatedVariants(productId, limit));
        return ApiResp.<List<VariantResponseDto>>builder().result(variants).build();
    }

    @PostMapping("/by-ids")
    ApiResp<List<VariantResponseDto>> getVariantSummaries(@RequestBody List<UUID> variantIds){
        List<VariantResponseDto> variants = variantMapper.toListResponseDTO(productDetailService.getVariantSummaries(variantIds));
        return ApiResp.<List<VariantResponseDto>>builder().result(variants).build();
    }
}
