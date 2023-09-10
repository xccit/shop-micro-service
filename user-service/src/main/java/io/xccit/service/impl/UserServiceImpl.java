package io.xccit.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.constant.UserConstants;
import io.xccit.mapper.IUserMapper;
import io.xccit.pojo.param.UserLoginParam;
import io.xccit.pojo.param.UserRegisterParam;
import io.xccit.pojo.user.User;
import io.xccit.result.AjaxResult;
import io.xccit.service.IUserService;
import io.xccit.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-09-09
 * @description
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {


    @Autowired
    private IUserMapper userMapper;

    @Override
    public AjaxResult check(UserRegisterParam userRegisterParam) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",userRegisterParam.getUsername());
        User user = userMapper.selectOne(wrapper);
        if (user != null){
            log.info("用户名不可用:"+userRegisterParam.getUsername());
            return AjaxResult.fail("用户名已被注册,不可使用");
        }
        log.info("用户名可用:"+userRegisterParam.getUsername());
        return AjaxResult.success("用户名可以使用");
    }

    @Override
    public AjaxResult register(User user) {
        String phoneNumber = user.getPhoneNumber();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //TODO:校验手机号和用户名是否已存在
        wrapper.eq("phone_number",phoneNumber).or().eq("username",user.getUsername());
        User u = userMapper.selectOne(wrapper);
        if (u == null){
            //TODO:密码加密加盐
            String encode = MD5Util.encode(user.getPassword(),UserConstants.USER_SALT);
            //TODO:设置加密后的密码
            user.setPassword(encode);
            userMapper.insert(user);
            return AjaxResult.success("注册成功");
        }
        return AjaxResult.fail("手机号或用户名已被注册,无法使用");
    }

    @Override
    public AjaxResult login(UserLoginParam userLoginParam) {
        String password = userLoginParam.getPassword();
        //TODO:获取加密后的密码
        String encode = MD5Util.encode(password, UserConstants.USER_SALT);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userLoginParam.getUsername());
        wrapper.eq("password", encode);
        User user = userMapper.selectOne(wrapper);
        if (user == null){
            return AjaxResult.fail("用户名或密码错误,请检查");
        }
        //TODO:登录成功后将密码设置为null,JSON返回时就不会封装password属性,在实体类中使用了注解
        user.setPassword(null);
        return AjaxResult.success(user);
    }
}
