package top.musuixin.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.util.StringUtils;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.musuixin.mybatisplus.mapper.UserMapper;
import top.musuixin.mybatisplus.pojo.User;
import top.musuixin.mybatisplus.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusApplicationTests {
    @Autowired
    UserMapper userMapper;


    @Test
    /**
     *1、名字中包含雨并且年龄小于40
     * 	name like '%雨%' and age<40
     */
    void test1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "雨").lt("age", 40);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
     * name like '%雨%' and age between 20 and 40 and email is not null
     */
    @Test
    void test2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 3、名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
     * name like '王%' or age>=25 order by age desc,id asc
     */
    @Test
    void test3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").or().ge("age", 25).orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 4、创建日期为2019年2月14日并且直属上级为名字为王姓
     * date_format(create_time,'%Y-%m-%d')='2019-02-14' and manager_id in (select id from user where name like '王%')
     */
    @Test
    void test4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-02-14").inSql("manager_id", "select id from user where name like '王%'");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 5、名字为王姓并且（年龄小于40或邮箱不为空）
     * name like '王%' and (age<40 or email is not null)
     */
    @Test
    void test5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").and(userQueryWrapper -> userQueryWrapper.lt(
                "age", 40
        ).or().isNotNull("email"));
        List<User> users = userMapper.selectList(queryWrapper);
    }

    /**
     * 6、名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
     * name like '王%' or (age<40 and age>20 and email is not null)
     */
    @Test
    void test6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").or(userQueryWrapper -> userQueryWrapper.
                between("age", 20, 40).isNotNull("email"));
        List<User> users = userMapper.selectList(queryWrapper);
    }

    /**
     * 7、（年龄小于40或邮箱不为空）并且名字为王姓
     * (age<40 or email is not null) and name like '王%'
     */
    @Test
    void test7() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(userQueryWrapper -> userQueryWrapper.lt("age", 40).or().isNotNull("email")).likeRight("name", "王");
        List<User> users = userMapper.selectList(queryWrapper);
    }

    /**
     * 8、年龄为30、31、34、35
     * age in (30、31、34、35)
     */
    @Test
    void test8() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.array(40, 31));
        List<User> users = userMapper.selectList(queryWrapper);
    }

    /**
     * limit 1
     */
    @Test
    void test9() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("limit 1");
        List<User> users = userMapper.selectList(queryWrapper);
    }

    /**
     * limit 1
     */
    @Test
    void test10() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String name = "王";
        String email = "@qq";
        queryWrapper.like(StringUtils.isNullOrEmpty(name), "name", name)
        List<User> users = userMapper.selectList(queryWrapper);
    }

    List<User> filteruser(List<User> lists, UserService<User> service) {
        ArrayList<User> list = new ArrayList<>();
        for (User user :
                lists) {
            if (service.test(user)) {
                list.add(user);
            }
        }
        return list;
    }

    @Test
    void test() {
        System.err.println(filteruser(userMapper.selectList(null), user -> (user.getAge() < 30)));
    }
}
