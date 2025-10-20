package saltandmilk.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import saltandmilk.dto.request.category.CategoryRequest;
import saltandmilk.dto.response.category.CategoryResponse;
import saltandmilk.entities.category.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "category_id", ignore = true) // Bỏ qua id khi tạo mới
    @Mapping(target = "children", ignore = true)  // Bỏ qua children khi tạo/cập nhật
    @Mapping(source = "parent_category_id", target = "parent.category_id") // Map parentId sang object Category
    Category toCategory(CategoryRequest categoryRequest);

    @Mapping(source = "imgUrl", target = "imgUrl")
    @Mapping(source = "category_id", target = "category_id")
    @Mapping(source = "parent.category_id", target = "parent_category_id")
    CategoryResponse toCategoryResponse(Category category);

    List<CategoryResponse> toListCategoryResponse(List<Category> categories);
}
