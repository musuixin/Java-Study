package top.musuixin.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.musuixin.hello.aop.UserAspect;

@Configuration
public class AopConfig {
    @Bean
    public UserAspect initUserAspect() {
        return new UserAspect();
    }
}
