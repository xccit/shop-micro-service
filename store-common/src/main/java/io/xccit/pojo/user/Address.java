package io.xccit.pojo.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 地址
 */
@ApiModel("地址实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("address")
public class Address implements Serializable {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("地址主键")
    private Integer id;
    @NotBlank
    @ApiModelProperty("联系人")
    private String linkman;
    @NotBlank
    @ApiModelProperty("手机号")
    private String phone;
    @NotBlank
    @ApiModelProperty("详细地址")
    private String address;
    @NotNull
    @ApiModelProperty("关联用户主键")
    private Integer userId;

}
