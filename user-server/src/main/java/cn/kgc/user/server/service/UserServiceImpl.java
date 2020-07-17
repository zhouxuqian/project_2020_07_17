package cn.kgc.user.server.service;

import cn.kgc.project.common.entity.User;
import cn.kgc.user.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/11 9:50
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public Integer insertOneUser(User user) {
        return userMapper.insertOneUser(user);
    }

    @Override
    public Integer updateOneUser(User user) {
        return userMapper.updateOneUser(user);
    }

    @Override
    public Integer deleteOneUser(Integer userId) {
        return userMapper.deleteOneUser(userId);
    }

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
