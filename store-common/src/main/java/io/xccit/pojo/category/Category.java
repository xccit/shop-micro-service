package io.xccit.pojo.category;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 类别
 */
@ApiModel("类别实体")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("category")
public class Category {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("类别主键")
    private Integer categoryId;
    @ApiModelProperty("类别名称")
    private String categoryName;
}
