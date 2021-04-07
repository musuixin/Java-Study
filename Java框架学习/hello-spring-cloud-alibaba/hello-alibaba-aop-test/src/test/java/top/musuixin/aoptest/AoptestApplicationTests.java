package top.musuixin.aoptest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.musuixin.aoptest.util.TestAopSpot;

@SpringBootTest
class AoptestApplicationTests {
    @Autowired
    TestAopSpot aopSpot;

    @Test
    void contextLoads() {
        aopSpot.test();
    }
}
