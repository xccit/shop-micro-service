package io.xccit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.pojo.param.UserLoginParam;
import io.xccit.pojo.param.UserRegisterParam;
import io.xccit.pojo.user.User;
import io.xccit.result.AjaxResult;

/**
 * @author CH_ywx
 * @date 2023-09-09
 * @description 用户Service
 */
public interface IUserService extends IService<User> {
    AjaxResult check(UserRegisterParam userRegisterParam);

    AjaxResult register(User user);

    AjaxResult login(UserLoginParam userLoginParam);
}
