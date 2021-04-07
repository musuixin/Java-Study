package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class test1 {
    public static void main(String[] args) {
        System.out.println("applactoionspring");
        //初始化是spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(test1.class);
        MessgeService messgeService = context.getBean(MessgeService.class);
        MessgePrint print = context.getBean(MessgePrint.class);

        print.printMessage();


    }
}
