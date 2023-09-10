package io.xccit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.pojo.carousel.Carousel;
import io.xccit.result.AjaxResult;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
public interface ICarouselService extends IService<Carousel> {

    /**
     * 获取轮播图,只获取优先级最高的前6条
     * @return
     */
    AjaxResult getCarousel();
}
