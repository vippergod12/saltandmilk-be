package saltandmilk.intefaces.product;

import saltandmilk.entities.product.Product;
import saltandmilk.entities.product.ProductVariant;

import java.util.List;
import java.util.UUID;

public interface ProductDetailService {
    ProductVariant getProductDetails(UUID variantId);
    List<ProductVariant> getRelatedVariants(UUID productId, int limit);
    List<ProductVariant> getVariantSummaries(List<UUID> variantIds);
}
