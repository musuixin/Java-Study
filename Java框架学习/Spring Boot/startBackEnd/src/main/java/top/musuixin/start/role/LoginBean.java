package top.musuixin.start.role;

import lombok.Data;

/**
 * @author musuixin
 * @date 2020-01-30 21:18
 */
@Data
public class LoginBean {
    private String userName;
    private String userPassword;
    private String Captcha;
}
