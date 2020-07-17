package cn.kgc.cinema.server.controller;

import cn.kgc.cinema.server.service.HallService;
import cn.kgc.project.common.entity.Hall;
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
public class HallController {

    @Autowired
    private HallService hallService;

    @GetMapping("halls/{cinemaId}")
    public List<Hall> getAllHalls(@PathVariable("cinemaId") Integer cinemaId){
        return  hallService.selectHallByCinemaId(cinemaId);
    }

    @PostMapping("halls")
    public Map<String, Object> insertOneHall(@RequestBody Hall hall){

        Integer result = hallService.insertOneHall(hall);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","添加影厅成功");
        }else {
            map.put("status",0);
            map.put("message","添加影厅失败");
        }

        return map;
    }

    @PostMapping("halls/{hallId}")
    public Map<String, Object> updateOneHall(@PathVariable("hallId") Integer hallId,
                                             @RequestBody Hall hall){

        Integer result = hallService.updateOneHall(hall);

        Map<String, Object> map = new HashMap<>();

        if (result == 1){
            map.put("status",result);
            map.put("message","修改影厅成功");
        }else {
            map.put("status",0);
            map.put("message","修改影厅失败");
        }

        return map;
    }

    @DeleteMapping("halls/{hallId}")
    public Map<String, Object> deleteOneHall(@PathVariable("hallId") Integer hallId){

        Integer result = hallService.deleteOneHall(hallId);

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
