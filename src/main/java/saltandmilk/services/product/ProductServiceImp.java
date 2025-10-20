package saltandmilk.services.product;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import saltandmilk.dto.response.product.ProductResponseDto;
import saltandmilk.entities.product.Product;
import saltandmilk.intefaces.product.ProductService;
import saltandmilk.mappers.ProductMapper;
import saltandmilk.mappers.VariantMapper;
import saltandmilk.repositories.product.ProductRepository;
import saltandmilk.repositories.product.VariantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductServiceImp implements ProductService {

    final ProductRepository productRepository;
    final VariantRepository variantRepository;
    final ProductMapper productMapper;
    final VariantMapper variantMapper;

    @Override
    public List<ProductResponseDto> findAll() {

        return null;
    }

    @Override
    public List<ProductResponseDto> getProductsByTab(String tabName) {
        List<Product> products = productRepository.getProductsByName(tabName);
        return productMapper.toProductResponseDto(products);
    }

    @Override
    public List<ProductResponseDto> getBestSellers() {
        return List.of();
    }
}
