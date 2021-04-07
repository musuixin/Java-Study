package top.musuixin.Service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import top.musuixin.Dao.UserDao;
import top.musuixin.Service.UserServcie;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author musuixin
 * @date 2020-01-10 19:53
 */
@Component
//@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
@Primary
@Lazy
public class UserServcieFestival implements UserServcie {
    private UserDao userDao;

    public UserServcieFestival() {

    }

    @Autowired
    public UserServcieFestival(UserDao userDao) {
        System.out.println("构造函数");
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        userDao.add();
        System.out.println("hello 给用户发优惠券了");
    }

    @PostConstruct
    public void Init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destory() {
        System.out.println("destory");
    }
}
