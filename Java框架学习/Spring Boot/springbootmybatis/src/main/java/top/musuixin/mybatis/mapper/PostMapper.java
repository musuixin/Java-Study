package top.musuixin.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.musuixin.mybatis.entity.Post;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-02-10
 */
public interface PostMapper extends BaseMapper<Post> {
    Post selectById(Integer id);
}
