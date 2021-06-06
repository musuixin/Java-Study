package top.musuixin;

/**
 * @author musuixin
 * @date 2020-06-14 13:23
 */
public class App {
    public static void main(String[] args) {
        testEnum(SeasonEnum.MALE);

    }

     static void testEnum(SeasonEnum season){
         System.out.println(season);

     }
     static String testEnum(){
        return "";
     }
}
