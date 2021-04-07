package top.musuixin.start.service;

import org.springframework.stereotype.Service;
import top.musuixin.start.role.User;

/**
 * @author musuixin
 * @date 2020-01-30 20:55
 */
@Service
public interface UserService {
    User findName(String name);
}
