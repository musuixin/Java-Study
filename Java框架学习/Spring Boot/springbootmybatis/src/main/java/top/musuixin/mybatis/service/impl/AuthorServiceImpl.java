package top.musuixin.mybatis.service.impl;

import top.musuixin.mybatis.entity.Author;
import top.musuixin.mybatis.mapper.AuthorMapper;
import top.musuixin.mybatis.service.IAuthorService;
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
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements IAuthorService {

}
