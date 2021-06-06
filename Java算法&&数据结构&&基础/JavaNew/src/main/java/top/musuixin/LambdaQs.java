package top.musuixin;


interface Eatable {
    void taste();
}

@FunctionalInterface
interface Flyable {
    Integer fly(String form);
}


/**
 * @author musuixin
 * @date 2020-06-14 13:36
 */
public class LambdaQs {
    public static void main(String[] args) {
        
        Flyable flyable = Integer::valueOf;
        Flyable flyable1 = "hello world"::indexOf;
    }
}
