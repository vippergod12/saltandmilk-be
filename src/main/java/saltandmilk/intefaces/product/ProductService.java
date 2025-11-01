package saltandmilk.intefaces.product;

import saltandmilk.dto.response.product.ProductResponseDto;
import saltandmilk.entities.product.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> findAll();
    List<ProductResponseDto> getProductsByTab(String tabName);
    List<ProductResponseDto> getBestSellers();
}
