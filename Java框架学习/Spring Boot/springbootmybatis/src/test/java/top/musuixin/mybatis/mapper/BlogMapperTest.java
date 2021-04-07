package top.musuixin.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.musuixin.mybatis.entity.Blog;

@SpringBootTest
public class BlogMapperTest {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    PostMapper postMapper;

    @Test
//    @Transactional
    /**
     *
     *延迟加载的测试
     *
     */
    void testLazyLoading() {
        Blog blog = blogMapper.getBlogAndAuthorById(1);
    }
}
