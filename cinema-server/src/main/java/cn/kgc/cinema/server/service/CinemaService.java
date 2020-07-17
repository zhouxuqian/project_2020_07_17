package cn.kgc.cinema.server.service;

import cn.kgc.project.common.entity.Cinema;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/8 12:13
 * @description
 */
public interface CinemaService {

    public List<Cinema> selectAllCinemas();

    public Integer insertOneCinema(Cinema cinema);

    public Integer updateOneCinema(Cinema cinema);

    public Integer deleteOneCinema(Integer cinemaId);
}
