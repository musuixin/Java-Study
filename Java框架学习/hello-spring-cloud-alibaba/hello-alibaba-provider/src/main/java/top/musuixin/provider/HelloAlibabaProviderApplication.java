package top.musuixin.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableDubbo
@EnableBinding({Source.class})
public class HelloAlibabaProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloAlibabaProviderApplication.class, args);
    }
}
