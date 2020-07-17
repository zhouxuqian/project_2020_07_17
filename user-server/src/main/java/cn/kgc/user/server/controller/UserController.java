package cn.kgc.user.server.controller;

import cn.kgc.project.common.entity.User;
import cn.kgc.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxq
 * @date 2020/7/11 9:53
 * @description
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

   /* @GetMapping("users")
    public List<User> selectAllUsers(){
        return userService.selectAllUsers();
    }*/

    @PostMapping("users")
    public Map<String, Object> insertOneUser(@RequestBody User user){
        Integer result = userService.insertOneUser(user);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","添加用户成功");
        }else {
            map.put("status",0);
            map.put("message","添加用户失败");
        }

        return map;
    }

    @PostMapping("users/{userId}")
    public Map<String, Object> updateOneUser(@PathVariable("userId") Integer userId, @RequestBody User user){

        Integer result = userService.updateOneUser(user);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","修改用户成功");
        }else {
            map.put("status",0);
            map.put("message","修改用户失败");
        }

        return map;
    }

    @DeleteMapping("users/{userId}")
    public Map<String, Object> deleteOneUser(@PathVariable("userId") Integer userId){

        Integer result = userService.deleteOneUser(userId);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","删除用户成功");
        }else {
            map.put("status",0);
            map.put("message","删除用户失败");
        }

        return map;

    }

    @GetMapping("users")
    public User selectUserByUsername(@RequestParam("username") String username){

       return userService.selectUserByUsername(username);
    }

}
