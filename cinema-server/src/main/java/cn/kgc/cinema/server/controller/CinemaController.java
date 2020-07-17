package cn.kgc.cinema.server.controller;

import cn.kgc.cinema.server.service.CinemaService;
import cn.kgc.project.common.entity.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxq
 * @date 2020/7/8 17:31
 * @description
 */
@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("cinemas")
    public List<Cinema> getAllCinemas(){
        return  cinemaService.selectAllCinemas();
    }

    @PostMapping("cinemas")
    public Map<String,Object> insertOneCinema(@RequestBody Cinema cinema){
        Integer result = cinemaService.insertOneCinema(cinema);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","添加影院成功");
        }else {
            map.put("status",0);
            map.put("message","添加影院失败");
        }

        return map;
    }

    @PostMapping("cinemas/{cinemaId}")
    public Map<String, Object> updateOneCinema(@PathVariable("cinemaId") Integer cinemaId,
                                               @RequestBody Cinema cinema){
        Integer result = cinemaService.updateOneCinema(cinema);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","修改影院成功");
        }else {
            map.put("status",0);
            map.put("message","修改影院失败");
        }

        return map;
    }


    @DeleteMapping("cinemas/{cinemaId}")
    public Map<String, Object> deleteOneCinema(@PathVariable("cinemaId") Integer cinemaId){

        Integer result = cinemaService.deleteOneCinema(cinemaId);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","删除影院成功");
        }else {
            map.put("status",0);
            map.put("message","删除影院失败");
        }

        return map;
    }
}
