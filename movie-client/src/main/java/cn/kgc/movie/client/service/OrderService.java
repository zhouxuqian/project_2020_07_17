package cn.kgc.movie.client.service;

import cn.kgc.project.common.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author zhouxq
 * @date 2020/7/16 17:13
 * @description
 */
@FeignClient("order-server")
public interface OrderService {

    @PostMapping("orders")
    public Map<String, Object> insertOneOrder(@RequestBody Order order);

    @GetMapping("orders")
    public List<String> selectSeatNumbersBySite(@RequestParam Integer siteId);
}
