package saltandmilk.controllers.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.product.ProductResponseDto;
import saltandmilk.dto.response.product.VariantResponseDto;
import saltandmilk.intefaces.product.ProductDetailService;
import saltandmilk.intefaces.product.ProductService;
import saltandmilk.mappers.ProductMapper;
import saltandmilk.mappers.VariantMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    final ProductService _productService;
    final ProductDetailService _productDetailService;
    final ProductMapper _productMapper;
    final VariantMapper _variantMapper;
    @GetMapping("/products")
    ApiResp<List<ProductResponseDto>> getProductsByTab(@RequestParam("tagId") String tabId){
        var result = _productService.getProductsByTab(tabId);
        return ApiResp.<List<ProductResponseDto>>builder().result(result).build();
    }

    @GetMapping("/products/getAll")
    ApiResp<List<ProductResponseDto>> getAll(){
        var result = _productService.findAll();
        return ApiResp.<List<ProductResponseDto>>builder().result(result).build();
    }

    @GetMapping("/products/{variantId}")
    ApiResp<VariantResponseDto> getProductById(@PathVariable("variantId") UUID variantId){
        var result = _productDetailService.getProductDetails(variantId);
        return ApiResp.<VariantResponseDto>builder().result(_variantMapper.toResponseDTO(result)).build();
    }
}
