package io.xccit.pojo.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author CH_ywx
 * @date 2023-09-09
 * @description 用户注册参数校验
 * TODO: 使用JSR303注解进行参数校验
 */
@ApiModel("用户注册参数校验")
@Data
public class UserRegisterParam {
    @NotBlank //不可为null及""
    private String username;
}
