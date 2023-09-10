package io.xccit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.mapper.ICategoryMapper;
import io.xccit.pojo.category.Category;
import io.xccit.result.AjaxResult;
import io.xccit.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<ICategoryMapper,Category> implements ICategoryService {

    @Autowired
    private ICategoryMapper categoryMapper;

    /**
     * @param categoryName
     * @return
     */
    @Override
    public AjaxResult selectByName(String categoryName) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getCategoryName,categoryName);
        Category category = categoryMapper.selectOne(wrapper);
        if (category == null){
            return AjaxResult.fail("没有相关类别");
        }
        return AjaxResult.success(category);
    }
}
