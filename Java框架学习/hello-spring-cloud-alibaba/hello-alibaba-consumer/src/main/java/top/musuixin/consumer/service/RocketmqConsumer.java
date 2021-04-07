package top.musuixin.consumer.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author musuixin
 * @date 2020-09-22 21:31
 */
@Component
public class RocketmqConsumer {
    @StreamListener("input")
    public void helloRock(String receiveMsg) {
        System.err.println(receiveMsg);
    }
}
