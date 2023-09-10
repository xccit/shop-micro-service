package io.xccit.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CH_ywx
 * @date 2023-09-08
 * @description 统一返回对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResult<T> {

    private Integer code;
    private String message;
    private T data;

    public AjaxResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 全参构建
     * @param code
     * @param message
     * @param data
     * @return
     * @param <T>
     */
    public static<T> AjaxResult build(Integer code,String message,T data){
        AjaxResult ajaxResult = new AjaxResult(code, message);
        if (data != null){
            ajaxResult.setData(data);
        }
        return ajaxResult;
    }

    /**
     * 枚举构建
     * @param messageEnum
     * @param data
     * @return
     * @param <T>
     */
    public static<T> AjaxResult build(AjaxMessageEnum messageEnum,T data){
        return AjaxResult.builder()
                .code(messageEnum.getCode())
                .message(messageEnum.getMessage())
                .data(data)
                .build();
    }

    /**
     * 成功
     * @param data
     * @return
     * @param <T>
     */
    public static<T> AjaxResult success(T data){
        AjaxResult ajaxResult = new AjaxResult(200, "请求成功");
        if (data != null){
            ajaxResult.setData(data);
        }
        return ajaxResult;
    }

    /**
     * 失败
     * @param data
     * @return
     * @param <T>
     */
    public static<T> AjaxResult fail(T data){
        AjaxResult ajaxResult = new AjaxResult(201,"请求失败");
        if (data != null){
            ajaxResult.setData(data);
        }
        return ajaxResult;
    }
}
