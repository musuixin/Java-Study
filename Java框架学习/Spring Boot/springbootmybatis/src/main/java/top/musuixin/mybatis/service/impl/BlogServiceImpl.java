package top.musuixin.mybatis.service.impl;

import top.musuixin.mybatis.entity.Blog;
import top.musuixin.mybatis.mapper.BlogMapper;
import top.musuixin.mybatis.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-02-10
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
