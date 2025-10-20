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
}
