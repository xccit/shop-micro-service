package io.xccit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.pojo.category.Category;
import io.xccit.result.AjaxResult;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
public interface ICategoryService extends IService<Category> {
    AjaxResult selectByName(String categoryName);
}
