package top.musuixin.hello.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserAspect {
    @Pointcut("execution(* top.musuixin.hello.service.impl.UserServiceImpl.addUser(..))")
    public void pointUser(){}
    @Before("pointUser()")
    public void before(){
        System.out.println("添加之前");
    }

}
