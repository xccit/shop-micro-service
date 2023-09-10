package io.xccit.pojo.carousel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 轮播图
 */
@Data
@ApiModel("轮播图")
@TableName("carousel")
public class Carousel {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("轮播图主键")
    @JsonProperty("carousel_id")
    private Integer carouselId;
    @ApiModelProperty("图片路径")
    private String imgPath;
    @ApiModelProperty("描述")
    private String describes;
    @JsonProperty("product_id")
    @ApiModelProperty("关联商品ID")
    private String productId;
    @ApiModelProperty("优先级")
    private Integer priority;
}
