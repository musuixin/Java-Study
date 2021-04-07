package top.musuixin.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2020-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "author_id", type = IdType.AUTO)
    private Integer authorId;

    private String username;

    private String password;

    private String email;

    private String bio;

    private String favouriteSection;

    private String nickname;
}
