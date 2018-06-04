package site.it4u.product.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.it4u.domain.RetEntity;
import site.it4u.product.domain.Product;
import site.it4u.product.dto.ProductParamDTO;
import site.it4u.product.service.api.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value="list", notes="list")
    @GetMapping("/list")
    public RetEntity list(ProductParamDTO productParamDTO) {
        // 分页查询
        PageHelper.startPage(productParamDTO.getPage(), productParamDTO.getPageSize());
        List<Product> productList = productService.listProducts(productParamDTO);
        // 得到分页后信息
        PageInfo<Product> p = new PageInfo<>(productList);
        RetEntity retEntity = new RetEntity();
        Map<String, Object> retBody = new HashMap<>();
        retBody.put("count", p.isIsLastPage() ? 0 : productList.size());
        retBody.put("list", productList);
        retEntity.setResult(retBody);
        return retEntity;
    }
}
