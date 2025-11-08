package saltandmilk.services.product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saltandmilk.dto.response.product.ProductResponseDto;
import saltandmilk.entities.product.Product;
import saltandmilk.entities.product.ProductVariant;
import saltandmilk.intefaces.product.ProductDetailService;
import saltandmilk.intefaces.product.ProductService;
import saltandmilk.repositories.product.ProductRepository;
import saltandmilk.repositories.product.VariantRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductRepository productRepository;
    private final VariantRepository variantRepository;

    @Override
    public ProductVariant getProductDetails(UUID variantId) {
        return variantRepository.findWithDetailsByVariantId(variantId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + variantId));
        // Bạn nên tạo một Exception tùy chỉnh (ví dụ: ResourceNotFoundException)
    }

    @Override
    public List<ProductVariant> getRelatedVariants(UUID productId, int limit) {
        Pageable pageable = PageRequest.of(0, limit); // Chỉ lấy trang đầu tiên, giới hạn số lượng
        return variantRepository.findByProductId(productId, pageable);
    }

    @Override
    public List<ProductVariant> getVariantSummaries(List<UUID> variantIds) {
        return variantRepository.findByVariantIdIn(variantIds);
    }


}
