package saltandmilk.intefaces.category;

import saltandmilk.dto.response.category.CategoryRespone;

import java.util.List;

public interface ICategoryInterface {
    List<CategoryRespone> findAllCategories();
}
