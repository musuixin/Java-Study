package top.musuixin.mybatis.entity.pojo;

import lombok.Data;
import top.musuixin.mybatis.entity.Blog;

import java.io.Serializable;

/**
 * @author musuixin
 * @date 2020-02-12 11:11
 */
@Data
public class BlogAndAuthorName extends Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
}
