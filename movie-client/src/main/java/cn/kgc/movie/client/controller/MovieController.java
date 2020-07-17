package cn.kgc.movie.client.controller;

import cn.kgc.movie.client.service.CinemaService;
import cn.kgc.movie.client.service.MovieService;
import cn.kgc.movie.client.service.OrderService;
import cn.kgc.movie.client.service.UserService;
import cn.kgc.movie.client.utils.DateUtils;
import cn.kgc.project.common.entity.Cinema;
import cn.kgc.project.common.entity.Hall;
import cn.kgc.project.common.entity.Order;
import cn.kgc.project.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxq
 * @date 2020/7/8 10:06
 * @description
 */
@Controller
public class MovieController {

    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String index(Model model) {

        //读取影院信息
        List<Cinema> cinemaList = cinemaService.getAllCinemas();
        List<String> nextWeek = DateUtils.getNextWeek();
        model.addAttribute("cinemaList", cinemaList);
        model.addAttribute("nextWeek", nextWeek);

        return "index";
    }

    @RequestMapping("hall")
    @ResponseBody
    public List<Hall> getAllHalls(Integer cinemaId) {
        return cinemaService.getAllHalls(cinemaId);
    }


    @RequestMapping("movies")
    @ResponseBody
    public Map<String, Object> getMovies(@RequestParam Map<String, String> map) {

        Integer hallId = map.get("hallId") == null ? 0 : Integer.parseInt(map.get("hallId"));
        String showTime = map.get("showTime");
        Integer pageNum = map.get("pageNum") == null ? 1 : Integer.parseInt(map.get("pageNum"));
        return movieService.getAllMovies(hallId, showTime, pageNum);
    }

    @RequestMapping("goRegister")
    public String goRegister() {
        return "register";
    }

    @RequestMapping("goLogin")
    public String goLogin() {
        return "login";
    }

    @RequestMapping("goBuy")
    public String goBuy(Integer userId,Integer siteId,Integer hallId,Model model) {

        List<String> list = orderService.selectSeatNumbersBySite(siteId);

        if (list != null){
            model.addAttribute("list",list);
        }

        model.addAttribute("userId",userId);
        model.addAttribute("siteId",siteId);
        model.addAttribute("hallId",hallId);
        return "tickets";
    }


    @RequestMapping("register")
    public String register(String username, String password, Model model) {
        User user = userService.selectUserByUsername(username);

        if (user == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            Map<String, Object> map = userService.insertOneUser(newUser);
            Integer status = (Integer) map.get("status");
            if (status == 1) {
                Object message = map.get("message");
                model.addAttribute("status", status);
                model.addAttribute("message", message);
            }
        } else {
            model.addAttribute("status", -1);
            model.addAttribute("message", "用户名存在");
        }

        return "success";
    }

    @RequestMapping("login")
    public String login(String username, String password, HttpSession session,Model model) {
        User user = userService.selectUserByUsername(username);

        if (user == null) {
            model.addAttribute("message", "用户名不存在");
        }else if (!user.getPassword().equals(password)) {
            model.addAttribute("message", "密码错误");
        }else {
            session.setAttribute("user",user);
            model.addAttribute("message", "登录成功");
            return "redirect:http://localhost:8081/";
        }

        return "success";
    }

    @RequestMapping("buy")
    public String buy(Integer userId, Integer siteId,String seatNumber,Model model) {
        model.addAttribute("message","购买成功");
        if (seatNumber != null) {
            Order order = new Order();
            order.setUserId(userId);
            order.setSiteId(siteId);

            ArrayList<String> list = new ArrayList<>();

            String[] split = seatNumber.split(",");
            for (String s : split) {
                list.add(s);
            }
            order.setSeatNumber(list);

            Map<String, Object> map = orderService.insertOneOrder(order);

            Integer status = (Integer)map.get("status");

            if (status == 1){
                 model.addAttribute("message",map.get("message").toString());
            }
        }

        return "success";
    }


    @RequestMapping("tickets")
    public String tickets(Model model) {

        //读取影院信息
        // List<Cinema> cinemaList = movieService.getAllCinemas();
        //model.addAttribute("cinemaList",cinemaList);

        return "tickets";
    }

    @RequestMapping("order")
    public String order(Model model) {

        //读取影院信息
        // List<Cinema> cinemaList = movieService.getAllCinemas();
        //model.addAttribute("cinemaList",cinemaList);

        return "order";
    }


}
