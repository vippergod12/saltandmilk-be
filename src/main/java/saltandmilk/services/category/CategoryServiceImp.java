package saltandmilk.services.category;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saltandmilk.dto.response.category.CategoryRespone;
import saltandmilk.entities.category.Category;
import saltandmilk.intefaces.category.ICategoryInterface;
import saltandmilk.mappers.CategoryMapper;
import saltandmilk.repositories.category.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class CategoryService implements ICategoryInterface {
    final CategoryRepository _categoryRepository;

    final CategoryMapper _categoryMapper;

    @Override
    public List<CategoryRespone> findAllCategories() {
        List<Category> list = _categoryRepository.findAll();
        return _categoryMapper.toListCategoryRespone(list);
    }
}
