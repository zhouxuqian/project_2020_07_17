package cn.kgc.user.server.service;

import cn.kgc.project.common.entity.User;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/11 9:47
 * @description
 */
public interface UserService {

    public List<User> selectAllUsers();

    public Integer insertOneUser(User user);

    public Integer updateOneUser(User user);

    public Integer deleteOneUser(Integer userId);

    public User selectUserByUsername(String username);
}
