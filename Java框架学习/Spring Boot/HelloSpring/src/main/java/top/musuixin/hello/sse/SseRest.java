package top.musuixin.hello.sse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(path = "sse")
@CrossOrigin
public class SseRest {
    public static final Map<String, SseEmitter> sseCache = new ConcurrentHashMap<>();

    @GetMapping(path = "subscribe")
    public SseEmitter push(String id) throws IOException {
        // 超时时间设置为3s，用于演示客户端自动重连
        SseEmitter sseEmitter = new SseEmitter(3331_000L);
        // 设置前端的重试时间为1s

        sseEmitter.send(SseEmitter.event().reconnectTime(1000).data("连接成功"));
        sseCache.put(id, sseEmitter);
//        sseEmitter.onTimeout(() -> {
//            System.out.println(id + "超时");
//            sseCache.remove(id);
//        });
//        sseEmitter.onCompletion(() -> System.out.println("完成！！！"));
        return sseEmitter;
    }
    @GetMapping(path = "send")
    public String push(String id,String content) throws IOException {
        SseEmitter sseEmitter = sseCache.get(id);
        sseEmitter.send(content);
        return "成功";
    }

}
