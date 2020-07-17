package cn.kgc.cinema.server.service;

import cn.kgc.cinema.server.mapper.CinemaMapper;
import cn.kgc.project.common.entity.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/8 17:29
 * @description
 */
@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public List<Cinema> selectAllCinemas() {
        return cinemaMapper.selectAllCinemas();
    }

    @Override
    public Integer insertOneCinema(Cinema cinema) {
        return cinemaMapper.insertOneCinema(cinema);
    }

    @Override
    public Integer updateOneCinema(Cinema cinema) {
        return cinemaMapper.updateOneCinema(cinema);
    }

    @Override
    public Integer deleteOneCinema(Integer cinemaId) {
        return cinemaMapper.deleteOneCinema(cinemaId);
    }
}
