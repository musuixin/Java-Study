package top.musuixin.mybatis.service.impl;

import top.musuixin.mybatis.entity.Post;
import top.musuixin.mybatis.mapper.PostMapper;
import top.musuixin.mybatis.service.IPostService;
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
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
