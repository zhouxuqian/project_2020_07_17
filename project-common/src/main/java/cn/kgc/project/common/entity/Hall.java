package cn.kgc.project.common.entity;

/**
 * @author zhouxq
 * @date 2020/7/10 10:40
 * @description 影厅
 */
public class Hall {

    private Integer id;
    private String name;
    private Integer cinemaId;

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
