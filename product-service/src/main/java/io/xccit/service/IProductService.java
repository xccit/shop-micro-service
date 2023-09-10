package io.xccit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.pojo.product.Product;
import io.xccit.result.AjaxResult;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
public interface IProductService extends IService<Product> {

    /**
     * 获取热门商品
     * @param categoryName
     * @return
     */
    AjaxResult promo(String categoryName);
}
