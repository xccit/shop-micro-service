package io.xccit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.result.AjaxResult;
import io.xccit.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
@Api(tags = "类别接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("根据类别名查询类别")
    @GetMapping("/promo/{categoryName}")
    public AjaxResult selectByName(@PathVariable @ApiParam(value = "类别名称",required = true) String categoryName){
        return categoryService.selectByName(categoryName);
    }
}
