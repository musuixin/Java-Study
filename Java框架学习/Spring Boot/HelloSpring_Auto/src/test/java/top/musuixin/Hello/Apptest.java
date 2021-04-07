package top.musuixin.Hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author musuixin
 * @date 2020-01-10 13:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class Apptest {
    @Autowired
    private CDPlay cdPlay;

    @Test
    public void test01() {
        System.out.println(Power.class);
//        cdPlay.playCd();
    }

}
