package top.musuixin.aoptest.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HelloWorld {
    String say() default "Hello World";
}
