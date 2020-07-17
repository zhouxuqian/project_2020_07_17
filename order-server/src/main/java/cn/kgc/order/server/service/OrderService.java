package cn.kgc.order.server.service;

import cn.kgc.project.common.entity.Order;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/16 17:03
 * @description
 */
public interface OrderService {

    public Integer insertOneOrder(Order order);
    public List<String> selectSeatNumbersBySite(Integer siteId);
}
