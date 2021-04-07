package top.musuixin.start.role;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2020-01-28 11:07
 */

@Data
@TableName("user")
@Component
public class User {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userSalt;
    private Integer userStatus;
    private String userRole;
}
