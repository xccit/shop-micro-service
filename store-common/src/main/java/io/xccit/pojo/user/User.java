package io.xccit.pojo.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author CH_ywx
 * @date 2023-09-09
 * @description 用户实体类
 */
@ApiModel("用户实体类")
@Data
@ToString
@TableName("user")
public class User implements Serializable {

    @JsonProperty("user_id") //返回的json属性为json_id
    @ApiModelProperty("用户主键")
    @TableId(type = IdType.AUTO)
    private Integer userId;

    @NotBlank
    @ApiModelProperty("用户名")
    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL) //为null时不生成json,不为null则生成,不影响JSON接收
    @NotBlank
    @ApiModelProperty("密码")
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL) //为null时不生成json,不为null则生成,不影响JSON接收
    @Length(min = 11,max = 11)
    @ApiModelProperty("手机号")
    private String phoneNumber;
}
