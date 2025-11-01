package saltandmilk.controllers.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.product.VariantResponseDto;
import saltandmilk.intefaces.product.VariantService;

import java.util.List;

@RestController
@RequestMapping("/api/variants")
@RequiredArgsConstructor
public class VariantController {
    final VariantService variantService;

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
    ApiResp<List<VariantResponseDto>> getVariantsByCategoryId(@RequestParam(name = "category_id") int category_id) {
        var result = variantService.getVariantsByCategoryId(category_id);
        return ApiResp.<List<VariantResponseDto>>builder().result(result).build();
    }

    @GetMapping("/search")
    ApiResp<List<VariantResponseDto>> search(@RequestParam("q") String query,
                                             @RequestParam(value = "limit", defaultValue = "5") int limit){
        List<VariantResponseDto> suggestions = variantService.findSuggestions(query,limit);
        return ApiResp.<List<VariantResponseDto>>builder().result(suggestions).build();
    }
}
