package saltandmilk.intefaces.category;

import saltandmilk.dto.response.category.CategoryResponse;

import java.util.List;

public interface CategorySerivce {
    List<CategoryResponse> findAllCategories();
}
