package io.xccit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.pojo.param.AddressListParam;
import io.xccit.pojo.param.AddressRemoveParam;
import io.xccit.pojo.user.Address;
import io.xccit.result.AjaxResult;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 地址Service
 */
public interface IAddressService extends IService<Address> {
    /**
     * 用户地址列表
     */
    AjaxResult list(Integer userId);

    /**
     * 用户地址添加
     * @param address
     * @return
     */
    AjaxResult add(Address address);

    AjaxResult delete(AddressRemoveParam addressRemoveParam);
}
