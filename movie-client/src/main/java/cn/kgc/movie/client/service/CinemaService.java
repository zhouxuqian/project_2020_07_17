package cn.kgc.movie.client.service;


import cn.kgc.project.common.entity.Cinema;
import cn.kgc.project.common.entity.Hall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/8 17:49
 * @description
 */
@FeignClient("cinema-server")
public interface CinemaService {

    @GetMapping("cinemas")
    public List<Cinema> getAllCinemas();

    @GetMapping("halls/{cinemaId}")
    public List<Hall> getAllHalls(@PathVariable("cinemaId") Integer cinemaId);


}
