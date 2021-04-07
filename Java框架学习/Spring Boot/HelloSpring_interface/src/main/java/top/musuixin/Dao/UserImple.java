package top.musuixin.Dao;

import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2020-01-10 21:24
 */
@Component
public class UserImple implements UserDao {
    @Override
    public void add() {
        System.out.println("数据库添加数据");
    }
}
