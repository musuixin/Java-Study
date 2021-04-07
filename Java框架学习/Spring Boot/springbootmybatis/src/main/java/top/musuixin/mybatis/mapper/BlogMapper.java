package top.musuixin.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CachePut;
import top.musuixin.mybatis.entity.Blog;
import top.musuixin.mybatis.entity.pojo.BlogAndAuthorName;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-02-10
 */
@CacheNamespace//开启二级缓存
//@CachePut
public interface BlogMapper extends BaseMapper<Blog> {
    @Select("select * from blog")
    List<Blog> getList();

    Blog getbyId(int id);

    List<Blog> getBytitle(String title);

    List<Blog> selectBlogSort(String col);

    List<Blog> selectBlogByPage(@Param("offest") int offest, @Param("pageSize") int pageSize);

    //使用map方式传递参数
    List<Blog> selectBlogByPage3(HashMap<Object, Object> map);

    //获取自增Id
    int getinsertBlogId(Blog blog);

    /**
     * 修改表
     *
     * @param blog
     * @return
     */
    int updateBlog(Blog blog);

    int deleteBlogById(int id);

    /**
     * 动态sql
     * 查询已激活的，并且博客的名字是包含某个查询字符串的记录
     * 如果用户没有输入任何查询字符串，那么就显示所有已激活的博客
     *
     * @return
     */
    List<Blog> selectActiveBlogByTitle(String title);

    /**
     * 1、查询已激活的
     * 2、如果用户输入了标题的查询关键字，则根据关键字查询
     * 3、否则根据blog的风格样式查询
     * 4、如果什么都没有输入，则显示推荐的博客
     *
     * @return
     */
    List<Blog> selectActiveBlogByTitleOrStyle(Blog blog);

    /**
     * 多条件查询 根据状态，标题，是否被推荐
     */
    List<Blog> selectBlogCondition(Blog blog);

    int updateBlogByConditione(Blog blog);

    List<Blog> selectBlogByConditionTrim(Blog blog);

    int deleteBlogList(List<Integer> list);

    Blog getBlogAndAuthorById(Integer id);

    List<Blog> selectBlogList();

    Blog selectBlogAndAuthor(Integer id);

    @Select("select  * from blog,author where blog.author_id=author.author_id and blog_id=#{id}")
    BlogAndAuthorName getBlogAuthorName(Integer id);
}



