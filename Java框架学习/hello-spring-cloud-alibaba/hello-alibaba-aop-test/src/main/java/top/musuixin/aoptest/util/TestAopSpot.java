package top.musuixin.aoptest.util;

import org.springframework.stereotype.Service;
import top.musuixin.aoptest.annotation.HelloWorld;

/**
 * @author musuixin
 * @date 2020-11-05 18:01
 */
@Service
public class TestAopSpot {
    @HelloWorld(say = "我在北京上学？？？？no 我在")
    public void test() {
        System.err.println("呵呵呵呵呵呵呵呵呵");
    }
}
