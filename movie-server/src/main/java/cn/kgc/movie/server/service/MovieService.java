package cn.kgc.movie.server.service;

import cn.kgc.project.common.entity.Movie;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/8 12:13
 * @description
 */
public interface MovieService {

    public List<Movie> selectMovieByHallId(Integer hallId,
                                           String showTime,
                                           Integer page);
    public Integer selectMoviceCountByHallId(Integer hallId,
                                             String showTime);
}
