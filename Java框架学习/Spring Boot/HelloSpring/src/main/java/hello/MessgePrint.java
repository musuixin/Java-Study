package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mojiayi
 * @date 2020-01-10 10:01
 */
@Component
public class MessgePrint {


    public MessgePrint() {

        System.out.println("MessagePrint...");
    }

    private MessgeService service;

    @Autowired
    public void setService(MessgeService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }

}

