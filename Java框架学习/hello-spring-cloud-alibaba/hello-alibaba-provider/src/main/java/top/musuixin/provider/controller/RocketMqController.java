package top.musuixin.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author musuixin
 * @date 2020-09-11 20:57
 */
@RestController
@RequestMapping("/rocketmq")
public class RocketMqController {
    @Autowired
    private MessageChannel output;

    @GetMapping("/send")
    public String send() {
        Message message = MessageBuilder.withPayload("hello world").build();
        output.send(message);
        return "success";
    }
}
