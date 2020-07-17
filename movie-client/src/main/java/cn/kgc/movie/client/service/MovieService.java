package cn.kgc.movie.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author zhouxq
 * @date 2020/7/10 19:20
 * @description
 */
@FeignClient("movie-server")
public interface MovieService {

    @GetMapping("movies/{hallId}")
    public Map<String,Object> getAllMovies(@PathVariable("hallId") Integer hallId,
                                           @RequestParam("showTime") String showTime,
                                           @RequestParam(value = "page",required = false) Integer page);
}
