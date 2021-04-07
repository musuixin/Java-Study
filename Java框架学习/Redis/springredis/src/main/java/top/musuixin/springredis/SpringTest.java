package top.musuixin.springredis;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;


class Student implements Serializable {
    private Integer id;
    private String name;
    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}


/**
 * @author musuixin
 * @date 2020-02-02 13:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void test1() {

    }

}
