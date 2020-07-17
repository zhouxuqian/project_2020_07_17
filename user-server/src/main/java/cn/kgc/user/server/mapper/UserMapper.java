package cn.kgc.user.server.mapper;

import cn.kgc.project.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/11 9:32
 * @description
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAllUsers();

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Integer insertOneUser(User user);

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    public Integer updateOneUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public Integer deleteOneUser(Integer userId);

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    public User selectUserByUsername(String username);

}
