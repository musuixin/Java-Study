package top.musuixin.mybatis.service.impl;

import top.musuixin.mybatis.entity.Comment;
import top.musuixin.mybatis.mapper.CommentMapper;
import top.musuixin.mybatis.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-02-10
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
