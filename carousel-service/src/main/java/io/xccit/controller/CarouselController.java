package io.xccit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xccit.result.AjaxResult;
import io.xccit.service.ICarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
@Api(tags = "轮播图接口")
@RestController
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private ICarouselService carouselService;

    @ApiOperation("轮播图列表")
    @PostMapping("/list")
    public AjaxResult list(){
        return carouselService.getCarousel();
    }
}
