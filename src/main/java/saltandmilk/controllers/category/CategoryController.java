package saltandmilk.controllers.category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.category.CategoryResponse;
import saltandmilk.intefaces.category.CategorySerivce;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    final CategorySerivce _categoryInterface;

    @GetMapping
    ApiResp<List<CategoryResponse>> findAllCategories() {
        var result = _categoryInterface.findAllCategories();
        return ApiResp.<List<CategoryResponse>>builder().result(result).build();
    }

}
