package io.xccit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.mapper.IAddressMapper;
import io.xccit.pojo.param.AddressListParam;
import io.xccit.pojo.param.AddressRemoveParam;
import io.xccit.pojo.user.Address;
import io.xccit.result.AjaxResult;
import io.xccit.service.IAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description
 */
@Slf4j
@Service
public class AddressServiceImpl extends ServiceImpl<IAddressMapper, Address> implements IAddressService {

    @Autowired
    private IAddressMapper addressMapper;

    /**
     * 用户地址列表
     * @param  userId
     */
    @Override
    public AjaxResult list(Integer userId) {
        LambdaQueryWrapper<Address> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Address::getUserId,userId);
        List<Address> addresses = addressMapper.selectList(wrapper);
        return AjaxResult.success(addresses);
    }

    /**
     * 用户地址添加,完成后返回该用户所有地址集合
     * @param address
     * @return
     */
    @Override
    public AjaxResult add(Address address) {
        addressMapper.insert(address);
        return list(address.getUserId());
    }

    /**
     * @param addressRemoveParam
     * @return
     */
    @Override
    public AjaxResult delete(AddressRemoveParam addressRemoveParam) {
        Integer id = addressRemoveParam.getId();
        int rows = addressMapper.deleteById(id);
        if (rows == 0){
            return AjaxResult.fail("地址参数有误,删除失败");
        }
        return AjaxResult.success("删除成功");
    }
}
