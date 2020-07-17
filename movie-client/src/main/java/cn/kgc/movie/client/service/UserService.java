package cn.kgc.movie.client.service;

import cn.kgc.project.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author zhouxq
 * @date 2020/7/16 9:43
 * @description
 */
@FeignClient("user-server")
public interface UserService {

    @GetMapping("users")
    public User selectUserByUsername(@RequestParam("username") String username);

    @PostMapping("users")
    public Map<String, Object> insertOneUser(@RequestBody User user);
}
