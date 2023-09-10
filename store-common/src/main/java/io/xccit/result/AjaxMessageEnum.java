package io.xccit.result;

import lombok.Getter;
import lombok.ToString;


/**
 * @author CH_ywx
 * @date 2023-09-09
 * @description 结果枚举
 */
@Getter
@ToString
public enum AjaxMessageEnum {

    SUCCESS(200,"成功"),
    FAIL(201,"失败"),
    USER_NO_LOGIN(401,"用户未登录"),
    USER_HAS_EXIST(402,"用户已存在"),
    NO_AUTH(403,"无权访问");

    private Integer code;
    private String message;

    private AjaxMessageEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
