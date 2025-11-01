package saltandmilk.controllers.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.product.ProductResponseDto;
import saltandmilk.intefaces.product.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    final ProductService _productService;

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
}
