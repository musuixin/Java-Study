package top.musuixin.Service.imple;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.musuixin.Service.UserServcie;

/**
 * @author musuixin
 * @date 2020-01-10 19:46
 */
@Component
public class UserServiceimple implements UserServcie {
    @Override
    public void addUser() {
        System.out.println("增加用户成功");
    }
}
