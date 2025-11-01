package saltandmilk.services.category;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import saltandmilk.dto.response.category.CategoryResponse;
import saltandmilk.entities.category.Category;
import saltandmilk.intefaces.category.CategorySerivce;
import saltandmilk.mappers.CategoryMapper;
import saltandmilk.repositories.category.CategoryRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class CategoryServiceImp implements CategorySerivce {
    final CategoryRepository _categoryRepository;

    final CategoryMapper _categoryMapper;

    @Override
    public List<CategoryResponse> findAllCategories() {
// 1. Lấy tất cả category từ DB dưới dạng danh sách phẳng
        List<Category> allCategories = _categoryRepository.findAll();

        // 2. Chuyển đổi tất cả Entity sang DTO
        List<CategoryResponse> allDtos = allCategories.stream()
                .map(_categoryMapper::toCategoryResponse)
                .collect(Collectors.toList());

        // 3. Tạo một Map để dễ dàng truy cập DTO bằng ID
        Map<Integer, CategoryResponse> dtoMap = allDtos.stream()
                .collect(Collectors.toMap(CategoryResponse::getCategory_id, dto -> dto));

        // 4. Xây dựng cây: lặp qua danh sách DTO và thêm các DTO con vào đúng cha
        allDtos.forEach(dto -> {
            Integer parentId = dto.getParent_category_id();
            if (parentId != null) {
                CategoryResponse parentDto = dtoMap.get(parentId);
                if (parentDto != null) {
                    // Thêm dto hiện tại vào danh sách children của cha
                    parentDto.getChildren().add(dto);
                }
            }
        });

        // 5. Lọc và trả về chỉ các category gốc (không có cha)
        return allDtos.stream()
                .filter(dto -> dto.getParent_category_id() == null)
                .collect(Collectors.toList());
    }
}
