package cn.kgc.movie.server.service;

import cn.kgc.movie.server.mapper.MovieMapper;
import cn.kgc.project.common.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/8 17:29
 * @description
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Value("${movie.page.size}")
    private Integer pageSize;

    @Override
    public List<Movie> selectMovieByHallId(Integer hallId, String showTime,Integer page) {

        Integer start = (page-1)*pageSize;

        return movieMapper.selectMovieByHallId(hallId,showTime,start,pageSize);
    }

    @Override
    public Integer selectMoviceCountByHallId(Integer hallId, String showTime) {
        return movieMapper.selectMoviceCountByHallId(hallId, showTime);
    }
}
