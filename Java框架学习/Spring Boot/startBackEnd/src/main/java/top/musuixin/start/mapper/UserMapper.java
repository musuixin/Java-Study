package top.musuixin.start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.musuixin.start.role.User;

/**
 * @author musuixin
 * @date 2020-01-28 11:06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    
}
