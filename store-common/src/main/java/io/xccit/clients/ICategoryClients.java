package io.xccit.clients;

import io.xccit.result.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 类别远程调用接口
 */
@FeignClient("category-service")
public interface ICategoryClients {

    @GetMapping("/category/promo/{categoryName}")
    AjaxResult selectByName(@PathVariable String categoryName);

}
