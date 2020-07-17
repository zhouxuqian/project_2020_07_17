package cn.kgc.cinema.server.service;

import cn.kgc.project.common.entity.Cinema;
import cn.kgc.project.common.entity.Hall;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/8 12:13
 * @description
 */
public interface HallService {

    public List<Hall> selectHallByCinemaId(Integer cinemaId);

    public Integer insertOneHall(Hall hall);

    public Integer updateOneHall(Hall hall);

    public Integer deleteOneHall(Integer hallId);
}
