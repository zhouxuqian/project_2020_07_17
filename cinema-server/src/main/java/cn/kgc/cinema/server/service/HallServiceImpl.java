package cn.kgc.cinema.server.service;

import cn.kgc.cinema.server.mapper.CinemaMapper;
import cn.kgc.cinema.server.mapper.HallMapper;
import cn.kgc.project.common.entity.Cinema;
import cn.kgc.project.common.entity.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/8 17:29
 * @description
 */
@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallMapper hallMapper;

    @Override
    public List<Hall> selectHallByCinemaId(Integer cinemaId) {
        return hallMapper.selectHallByCinemaId(cinemaId);
    }

    @Override
    public Integer insertOneHall(Hall hall) {
        return hallMapper.insertOneHall(hall);
    }

    @Override
    public Integer updateOneHall(Hall hall) {
        return hallMapper.updateOneHall(hall);
    }

    @Override
    public Integer deleteOneHall(Integer hallId) {
        return hallMapper.deleteOneHall(hallId);
    }
}
