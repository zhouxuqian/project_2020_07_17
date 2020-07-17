package cn.kgc.cinema.server.mapper;

import cn.kgc.project.common.entity.Cinema;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/10 10:00
 * @description 影院
 */
@Mapper
public interface CinemaMapper {
    /**
     * 查询所有影院
     * @return
     */
    public List<Cinema> selectAllCinemas();

    /**
     * 添加一个影院
     * @param cinema
     * @return
     */
    public Integer insertOneCinema(Cinema cinema);

    /**
     * 修改一个影院
     * @param cinema
     * @return
     */
    public Integer updateOneCinema(Cinema cinema);

    /**
     * 删除一个影院
     * @param cinemaId
     * @return
     */
    public Integer deleteOneCinema(Integer cinemaId);
}
