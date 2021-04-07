package top.musuixin.start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.musuixin.start.mapper.UserMapper;
import top.musuixin.start.service.UserService;
import top.musuixin.start.util.PasswordUtils;

/**
 * @author musuixin
 * @date 2020-01-28 11:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    @Autowired
    UserService userService;

    @Test
    public void hello() {
        String salt = PasswordUtils.getSalt();
        String encode = PasswordUtils.encode("123456", salt);
        System.err.println(salt);
        System.err.println(encode);
    }
}
