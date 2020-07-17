package cn.kgc.project.common.entity;

/**
 * @author zhouxq
 * @date 2020/7/11 10:31
 * @description
 */
public class Comment {

    private Integer id;
    private String content;
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




}
