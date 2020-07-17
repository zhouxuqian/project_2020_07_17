package cn.kgc.order.server.mapper;

import cn.kgc.project.common.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/16 16:52
 * @description
 */
@Mapper
public interface OrderMapper {

    public Integer insertOneOrder(Order order);
    public List<String> selectSeatNumbersBySite(Integer siteId);
}
