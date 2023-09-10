package io.xccit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.pojo.param.UserLoginParam;
import io.xccit.pojo.param.UserRegisterParam;
import io.xccit.pojo.user.User;
import io.xccit.result.AjaxResult;
import io.xccit.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CH_ywx
 * @date 2023-09-08
 * @description 用户接口
 */
@Slf4j
@Api(tags = "前台用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 账号可用性校验
     * @param userRegisterParam
     * @param result 接收校验结果,要与被校验的参数相邻
     * @return
     */
    @ApiOperation("账号可用性校验")
    @PostMapping("/check")
    public AjaxResult check(
                            @Validated
                            @ApiParam(value = "用户参数校验对象",required = true)
                            @RequestBody UserRegisterParam userRegisterParam, BindingResult result){
        log.info("校验的用户名:"+userRegisterParam.getUsername());
        boolean hasErrors = result.hasErrors();
        if (hasErrors){
            return AjaxResult.fail("参数有误");
        }
        return userService.check(userRegisterParam);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public AjaxResult register(
                                @RequestBody
                                @Validated
                                @ApiParam(value = "用户实体",required = true)
                                User user,BindingResult result){
        boolean hasErrors = result.hasErrors();
        if (hasErrors){
            return AjaxResult.fail("参数有误,请检查");
        }
        return userService.register(user);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public AjaxResult login(
            @RequestBody
            @ApiParam(value = "用户登录实体",required = true)
            @Validated UserLoginParam userLoginParam,BindingResult result
            ){
        boolean hasErrors = result.hasErrors();
        if (hasErrors){
            return AjaxResult.fail("参数有误,请检查");
        }

        return userService.login(userLoginParam);
    }
}
