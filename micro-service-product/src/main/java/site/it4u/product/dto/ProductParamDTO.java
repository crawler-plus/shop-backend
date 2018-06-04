package site.it4u.product.dto;

import lombok.Data;

@Data
public class ProductParamDTO {

    private Integer page; // 第几页

    private Integer pageSize; // 一页多少条数据

    private Integer sort; // 升序降序

    private String priceChecked; // 价格区间
}
