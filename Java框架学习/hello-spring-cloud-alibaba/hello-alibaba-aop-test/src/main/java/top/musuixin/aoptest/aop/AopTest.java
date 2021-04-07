package top.musuixin.aoptest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import top.musuixin.aoptest.annotation.HelloWorld;


@Aspect
@Component
public class AopTest {

    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */

    @Pointcut("@annotation(top.musuixin.aoptest.annotation.HelloWorld)")
    public void BrokerAspect() {

    }

    @Around("BrokerAspect()")
    public void handHello(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HelloWorld annotation = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getAnnotation(HelloWorld.class);
        System.err.println(annotation.say());
        proceedingJoinPoint.proceed();
    }
}
