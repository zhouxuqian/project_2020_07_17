package cn.kgc.order.server.controller;

import cn.kgc.order.server.service.OrderService;
import cn.kgc.project.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxq
 * @date 2020/7/16 17:05
 * @description
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("orders")
    public Map<String, Object> insertOneOrder(@RequestBody Order order){
        Integer result = orderService.insertOneOrder(order);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","添加订单成功");
        }else {
            map.put("status",0);
            map.put("message","添加订单失败");
        }

        return map;
    }

    @GetMapping("orders")
    public List<String> selectSeatNumbersBySite(@RequestParam Integer siteId){
        return orderService.selectSeatNumbersBySite(siteId);
    }
}
