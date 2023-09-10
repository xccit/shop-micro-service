package io.xccit.pojo.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 商品实体
 */
@ApiModel("商品实体")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("product")
public class Product implements Serializable {

    @JsonProperty("product_id")
    @ApiModelProperty("商品主键")
    @TableId(type = IdType.AUTO)
    private Integer productId;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("category_id")
    private Integer categoryId;
    @JsonProperty("product_title")
    private String productTitle;
    @JsonProperty("product_intro")
    private String productIntro;
    @JsonProperty("product_picture")
    private String productPicture;
    @JsonProperty("product_price")
    private Double productPrice;
    @JsonProperty("product_selling_price")
    private Double productSellingPrice;
    @JsonProperty("product_num")
    private Integer productNum;
    @JsonProperty("product_sales")
    private Integer productSales;
}
