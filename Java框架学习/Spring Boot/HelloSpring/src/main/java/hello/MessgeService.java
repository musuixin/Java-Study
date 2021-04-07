package hello;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 打印服务
 */
@Component
//自动创建类
public class MessgeService {
    public MessgeService() {
        super();
        System.out.println("MessageService!!");
    }

    public String getMessage() {
        return "Hello World!";
    }
}
