package top.musuixin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.musuixin.AppConfig;
import top.musuixin.Service.UserServcie;

/**
 * @author musuixin
 * @date 2020-01-10 19:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
    @Autowired

    private UserServcie userServcie;

    @Test
    public void test01() {
        userServcie.addUser();
    }
}
