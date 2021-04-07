package top.musuixin.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.musuixin.mybatis.entity.Author;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-02-10
 */
public interface AuthorMapper extends BaseMapper<Author> {
    Author selectAuthorById(int id);
}
