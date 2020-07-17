package cn.kgc.comment.server.mapper;

import cn.kgc.project.common.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhouxq
 * @date 2020/7/11 10:24
 * @description
 */
@Mapper
public interface CommentMapper {

    public List<Comment> selectCommentByUserId(Integer userId);

    public Integer insertOneComment(Comment comment);

    public Integer updateOneComment(Comment comment);

    public Integer deleteOneComment(Integer commentId);


}
