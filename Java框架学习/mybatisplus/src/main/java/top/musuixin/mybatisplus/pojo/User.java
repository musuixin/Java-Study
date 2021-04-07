package top.musuixin.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author musuixin
 * @date 2020-02-15 21:40
 */
@Data
public class User {
    //主键
    @TableId
    private Long id;
    //名字
    @TableField("name")
    private String name;
    //年龄
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;
    @TableField(exist = false)
    private String remarks;
}
