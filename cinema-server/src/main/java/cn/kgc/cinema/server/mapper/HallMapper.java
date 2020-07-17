package cn.kgc.cinema.server.mapper;

import cn.kgc.project.common.entity.Hall;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/10 10:39
 * @description 影厅
 */
@Mapper
public interface HallMapper {

    /**
     * 通过影院id查询影厅
     * @param cinemaId
     * @return
     */
    public List<Hall> selectHallByCinemaId(Integer cinemaId);

    /**
     * 添加影厅
     * @param hall
     * @return
     */
    public Integer insertOneHall(Hall hall);

    /**
     * 修改影厅
     * @param hall
     * @return
     */
    public Integer updateOneHall(Hall hall);

    /**
     * 删除影厅
     * @param hallId
     * @return
     */
    public Integer deleteOneHall(Integer hallId);
}
