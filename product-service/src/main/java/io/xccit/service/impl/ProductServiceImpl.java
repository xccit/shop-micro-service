package io.xccit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.xccit.clients.ICategoryClients;
import io.xccit.mapper.IProductMapper;
import io.xccit.pojo.product.Product;
import io.xccit.result.AjaxResult;
import io.xccit.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<IProductMapper, Product> implements IProductService {

    @Autowired
    private ICategoryClients categoryClients;

    @Autowired
    private IProductMapper productMapper;

    /**
     * 获取热门商品 每页最多七条数据
     *
     * @param categoryName
     * @return
     */
    @Override
    public AjaxResult promo(String categoryName) {
        AjaxResult ajaxResult = categoryClients.selectByName(categoryName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(ajaxResult);
            log.info(s);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //TODO 失败返回
//        if (ajaxResult.getCode() == AjaxMessageEnum.FAIL.getCode()){
//            return ajaxResult;
//        }
        //TODO 成功返回
        /**
         * 注意:feign调用之后返回的数据是一串JSON,Java会解析为LinkedHashMap对象,此处处理ajaxResult.getData()需要格外注意
         * 如果直接强转成Category获取其id,会造成类型转换异常
         * TODO错误示例: Category category = (Category) ajaxResult.getData();
         */
        LinkedHashMap<String,Object> linkedHashMap = (LinkedHashMap<String, Object>) ajaxResult.getData();
        Integer categoryId = (Integer) linkedHashMap.get("categoryId");
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        //TODO 根据商品销量倒序排序 首页展示取前七条数据
        wrapper.eq(Product::getCategoryId,categoryId).orderByDesc(Product::getProductSales);
        Page<Product> productPage = new Page<>(1, 7);
        productPage = productMapper.selectPage(productPage, wrapper);
        //TODO:前端规则,只需要数据,不需要其他属性,getRecords()
        return AjaxResult.success(productPage.getRecords());
    }
}
