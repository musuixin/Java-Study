package top.musuixin.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.musuixin.common.service.HelloService;

/**
 * @author musuixin
 * @date 2020-09-02 20:36
 */
@RestController
public class Hello {
    @Reference
    private HelloService helloService;

    @GetMapping("/hello-sentinel")
    public String helloSentinel() {
        return "hello sentinel";
    }

    @GetMapping("/hello-dubbo")
    public String helloDubbo() {
        System.err.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return helloService.say();
    }
}
