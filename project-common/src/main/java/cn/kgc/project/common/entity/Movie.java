package cn.kgc.project.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhouxq
 * @date 2020/7/9 21:57
 * @description 电影
 */
public class Movie {
    private Integer id;
    private String name;
    /**
     * 上映时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    /**
     * 简介
     */
    private String briefIntroduction;
    /**
     * 主演
     */
    private String protagonist;
    private String categoryName;
    private Integer siteId;
    private Float price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showTime;

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
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

    public Date releaseDate() {
        return releaseDate;
    }

    public void releaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String briefIntroduction() {
        return briefIntroduction;
    }

    public void briefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }
}
