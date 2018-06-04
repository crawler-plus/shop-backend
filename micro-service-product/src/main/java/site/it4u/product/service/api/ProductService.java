package site.it4u.product.service.api;

import site.it4u.product.domain.Product;
import site.it4u.product.dto.ProductParamDTO;

import java.util.List;

public interface ProductService {

    // 展示商品列表
    List<Product> listProducts(ProductParamDTO productParamDTO);
}
