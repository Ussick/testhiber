package ua.itea.service;

import ua.itea.component.ProductEntityManager;
import ua.itea.component.ProductMapper;
import ua.itea.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private final ProductEntityManager productEm;
    private final ProductMapper productMapper;

    public ProductService(ProductEntityManager productEm, ProductMapper productMapper) {
        this.productEm = productEm;
        this.productMapper = productMapper;
    }

    public ProductDto getProductById(int id) {
        return productMapper.entityToDto(productEm.getProductById(id));
    }

    public List<ProductDto> getProducts() {
        return productEm.getProducts().stream()
                .map(productEntity -> productMapper.entityToDto(productEntity))
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductsByCategory(int categoryId) {
        return productEm.getProductsByCategoryId(categoryId).stream()
                .map(productEntity -> productMapper.entityToDto(productEntity))
                .collect(Collectors.toList());
    }
}
