package io.xccit.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 类别热门商品参数
 */
@ApiModel("类别热门商品参数")
@Data
public class ProductPromoParam {

    @ApiModelProperty("类别名称")
    private String categoryName;
}
