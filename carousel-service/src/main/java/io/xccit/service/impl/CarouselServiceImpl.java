package io.xccit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.mapper.ICarouselMapper;
import io.xccit.pojo.carousel.Carousel;
import io.xccit.result.AjaxResult;
import io.xccit.service.ICarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<ICarouselMapper, Carousel> implements ICarouselService {

    @Autowired
    private ICarouselMapper carouselMapper;

    /**
     * 获取轮播图,只获取优先级最高的前6条
     * @return
     */
    @Override
    public AjaxResult getCarousel() {
        LambdaQueryWrapper<Carousel> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Carousel::getPriority);
        List<Carousel> list = carouselMapper.selectList(wrapper);
        List<Carousel> carouselList = list.stream().limit(6).collect(Collectors.toList());
        return AjaxResult.success(carouselList);
    }
}
