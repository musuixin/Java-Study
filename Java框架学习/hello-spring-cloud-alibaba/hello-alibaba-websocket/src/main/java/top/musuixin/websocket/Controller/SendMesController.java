package top.musuixin.websocket.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author musuixin
 * @date 2020-09-27 16:02
 */
@Controller
@CrossOrigin
public class SendMesController {

    @MessageMapping("/hello-one")
    @SendTo("/topic/greeting-one")
    public String sendMsg(String msg) {
        return msg;
    }

    @MessageMapping("/hello-two")
    @SendTo("/topic/greeting-two")
    public String sendMsgs(String msg) {
        return msg;
    }
}

class Mes {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
