package site.it4u.product.domain;

import lombok.Data;

@Data
public class Product {

    private Integer id;

    private Integer productId;

    private String productName;

    private Integer salePrice;

    private String productImage;
}
