package saltandmilk.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import saltandmilk.dto.request.product.ProductRequestDto;
import saltandmilk.dto.response.product.ProductResponseDto;
import saltandmilk.entities.category.Category;
import saltandmilk.entities.product.Product;
import saltandmilk.entities.tag.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, TagMapper.class})
public interface ProductMapper {
    // --- ÁNH XẠ TỪ REQUEST DTO SANG ENTITY ---
    @Mapping(target = "product_id", ignore = true)     // 1. Bỏ qua các trường tự sinh
    @Mapping(target = "slug", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "variants", ignore = true)

    @Mapping(source = "category", target = "category.category_id") // 2. Ánh xạ categoryId -> category.category_id
    @Mapping(source = "tags", target = "tags") // 3. MapStruct sẽ tự động dùng helper `fromId` trong TagMapper
    Product toProduct(ProductRequestDto productRequestDto);

    ProductResponseDto toProductResponseDto(Product product);

    List<ProductResponseDto> toProductResponseDto(List<Product> products);

    @Named("mapCategory")
    default Category mapCategory(int categoryId) {
        if (categoryId == 0) return null;
        Category category = new Category();
        category.setCategory_id(categoryId);
        return category;
    }

    // 🔧 Helper method để ánh xạ danh sách tag IDs → Set<Tag>
    @Named("mapTags")
    default Set<Tag> mapTags(List<Integer> tagIds) {
        if (tagIds == null || tagIds.isEmpty()) return new HashSet<>();
        return tagIds.stream()
                .map(id -> {
                    Tag tag = new Tag();
                    tag.setTag_id(id);
                    return tag;
                })
                .collect(Collectors.toSet());
    }
}
