package top.musuixin.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.musuixin.hello.service.UserService;

@RestController
public class TestDataApi {
    @Autowired
    @Qualifier("user")
    UserService userServiceImpl;

    @GetMapping("/test_data")
    public String testData() {
        userServiceImpl.addUser();
        return "Hello Spring ";
    }
}
