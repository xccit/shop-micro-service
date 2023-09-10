package io.xccit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.pojo.param.AddressListParam;
import io.xccit.pojo.param.AddressRemoveParam;
import io.xccit.pojo.user.Address;
import io.xccit.result.AjaxResult;
import io.xccit.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author CH_ywx
 * @date 2023-09-10
 * @description 地址控制器
 */
@Api(tags = "用户地址接口")
@RestController
@RequestMapping("/user/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @ApiOperation("用户地址列表")
    @PostMapping("/list")
    public AjaxResult list(
            @RequestBody
            @Validated
            @ApiParam(value = "用户列表封装参数",required = true) AddressListParam addressListParam, BindingResult result){
        if (result.hasErrors()){
            return AjaxResult.fail("参数异常,查询失败");
        }
        return addressService.list(addressListParam.getUserId());
    }

    @ApiOperation("用户地址添加")
    @PostMapping("/save")
    public AjaxResult save(
            @RequestBody
            @ApiParam(value = "地址",required = true)
            @Validated
            Address address,BindingResult result){
        if (result.hasErrors()){
            return AjaxResult.fail("参数有误,请检查");
        }
        return addressService.add(address);
    }

    @ApiOperation("用户地址删除")
    @DeleteMapping("/remove")
    public AjaxResult delete(
            @RequestBody
            @Validated
            @ApiParam(value = "用户地址删除参数",required = true) AddressRemoveParam addressRemoveParam,BindingResult result){
        if (result.hasErrors()){
            return AjaxResult.fail("参数有误,请检查");
        }
        return addressService.delete(addressRemoveParam);
    }

}
