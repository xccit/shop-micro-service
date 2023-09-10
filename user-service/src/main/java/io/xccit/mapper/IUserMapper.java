package io.xccit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xccit.pojo.user.User;
import org.springframework.stereotype.Repository;

/**
 * @author CH_ywx
 * @date 2023-09-09
 * @description 用户Mapper
 */
@Repository
public interface IUserMapper extends BaseMapper<User> {

}
