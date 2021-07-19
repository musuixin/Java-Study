package top.musuixin.hello.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import top.musuixin.hello.service.UserService;
import top.musuixin.hello.sse.SseRest;

import java.io.IOException;

@Service(value = "user")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("添加中____");
    }

    @Override
    @Scheduled(fixedRate = 10)
    public void h() {
        SseRest.sseCache.forEach((e, g) -> {
            System.err.println(2);
            try {
                g.send("hello");
            } catch (IOException ioException) {
                SseRest.sseCache.remove(e);
                ioException.printStackTrace();
            }
        });
    }
}
