package site.it4u.product.dao;

import org.springframework.stereotype.Repository;
import site.it4u.product.domain.Product;
import site.it4u.product.dto.ProductParamDTO;

import java.util.List;

@Repository
public interface ProductMapper {

    // 展示商品列表
    List<Product> listProducts(ProductParamDTO productParamDTO);
}
