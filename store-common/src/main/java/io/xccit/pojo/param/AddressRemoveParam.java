package io.xccit.pojo.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 地址删除参数封装
 */
@ApiModel("地址删除参数封装")
@Data
public class AddressRemoveParam {
    @NotNull
    private Integer id;
}
