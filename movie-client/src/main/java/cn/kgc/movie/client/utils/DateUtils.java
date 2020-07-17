package cn.kgc.movie.client.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by teacher ZHANG on 2020/2/21
 */
public class DateUtils {
    //获取下一周的日期
    public static List<String> getNextWeek() {
        List<String> days = new ArrayList<>();

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance(); //获取日历（单例模式）

        days.add(fmt.format(calendar.getTime())); //加入今天的日期

        for(int i = 0; i < 6; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            days.add(fmt.format(calendar.getTime()));
        }

        return days;
    }
}
