package top.musuixin.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("config")
@RefreshScope
public class ConfigController {

    @Value("${user.name}")
    private String name;

    @RequestMapping(value = "/get", method = GET)
    public String get() {
        return name;
    }
}