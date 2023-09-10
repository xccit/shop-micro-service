package io.xccit.pojo.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 地址集合接收
 */
@Data
@ApiModel("地址集合接收")
public class AddressListParam {
    @JsonProperty("user_id")
    @NotNull
    private Integer userId;
}
