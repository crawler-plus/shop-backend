package site.it4u.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.it4u.product.dao.ProductMapper;
import site.it4u.product.domain.Product;
import site.it4u.product.dto.ProductParamDTO;
import site.it4u.product.service.api.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> listProducts(ProductParamDTO productParamDTO) {
        return productMapper.listProducts(productParamDTO);
    }
}
