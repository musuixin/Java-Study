package top.musuixin.start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.musuixin.start.mapper.UserMapper;
import top.musuixin.start.role.User;
import top.musuixin.start.service.UserService;

import java.sql.Wrapper;

/**
 * @author musuixin
 * @date 2020-01-30 20:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    User user;

    @Override
    public User findName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, name);
        return userMapper.selectOne(queryWrapper);
    }
}
