package top.musuixin.lambda;

import java.util.function.Function;

/**
 * @author musuixin
 * @date 2020-10-21 10:13
 */
class Until {
    public static Integer count(String str) {
        return str.length();
    }
}


public class App {
    public static void main(String[] args) {
        System.err.println(StrOp(Until::count, "hello world"));
    }

    public static Integer StrOp(Function<String, Integer> function, String str) {
        assert true;
        return function.apply(str);
    }
}