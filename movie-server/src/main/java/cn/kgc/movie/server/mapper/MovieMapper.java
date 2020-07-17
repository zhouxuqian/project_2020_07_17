package cn.kgc.movie.server.mapper;

import cn.kgc.project.common.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/8 12:09
 * @description
 */
@Mapper
public interface MovieMapper {

    public List<Movie> selectMovieByHallId(@Param("hallId") Integer hallId,
                                           @Param("showTime") String showTime,
                                           @Param("start") Integer start,
                                           @Param("length") Integer length);

    public Integer selectMoviceCountByHallId(@Param("hallId") Integer hallId,
                                             @Param("showTime") String showTime);
}
