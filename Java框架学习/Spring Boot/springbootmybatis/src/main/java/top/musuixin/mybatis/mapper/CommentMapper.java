package top.musuixin.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.musuixin.mybatis.entity.Comment;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-02-10
 */
public interface CommentMapper extends BaseMapper<Comment> {

    //    @Select("select * from comment where post_id=#{id}  ;")
    List<Comment> selectCommentList(Integer id);
}
