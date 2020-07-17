package cn.kgc.order.server.service;

import cn.kgc.order.server.mapper.OrderMapper;
import cn.kgc.project.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/16 17:04
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer insertOneOrder(Order order) {
        return orderMapper.insertOneOrder(order);
    }

    @Override
    public List<String> selectSeatNumbersBySite(Integer siteId) {
        return orderMapper.selectSeatNumbersBySite(siteId);
    }
}
