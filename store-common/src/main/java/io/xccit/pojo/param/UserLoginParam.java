package io.xccit.pojo.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author CH_ywx
 * @date 2023-09-09
 * @description 用户登录实体
 */
@Data
@ApiModel("用户登录实体")
public class UserLoginParam {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
