package io.xccit.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.pojo.param.ProductPromoParam;
import io.xccit.result.AjaxResult;
import io.xccit.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
@ApiModel("商品接口")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ApiOperation("热门商品类别")
    @PostMapping("/promo")
    public AjaxResult promo(
                            @RequestBody
                            @ApiParam(value = "商品类别热门参数",required = true)
                            ProductPromoParam productPromoParam){

        return productService.promo(productPromoParam.getCategoryName());
    }
}
