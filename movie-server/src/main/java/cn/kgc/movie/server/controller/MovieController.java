package cn.kgc.movie.server.controller;

import cn.kgc.movie.server.service.MovieService;
import cn.kgc.project.common.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author zhouxq
 * @date 2020/7/8 17:31
 * @description
 */
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Value("${movie.page.size}")
    private Integer pageSize;

    @GetMapping("movies/{hallId}")
    public Map<String,Object> getAllMovies(@PathVariable("hallId") Integer hallId,
                                    @RequestParam("showTime") String showTime,
                                    @RequestParam(value = "page",required = false) Integer page) {
        Map<String,Object> result = new HashMap<>();
        Integer pageNum = page == null ? 1 : page;
        List<Movie> movieList = movieService.selectMovieByHallId(hallId, showTime, pageNum);
        Integer movieCount = movieService.selectMoviceCountByHallId(hallId, showTime);
        Integer total = (movieCount%pageSize==0?(movieCount/pageSize):(movieCount/pageSize)+1);

        result.put("movieList",movieList);
        result.put("total",total);
        result.put("pageNum",pageNum);

        return result;
    }


}
