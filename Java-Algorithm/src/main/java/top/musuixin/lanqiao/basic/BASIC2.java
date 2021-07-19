package top.musuixin.lanqiao.basic;
public class BASIC2 {
    public static void main(String[] args) {
        for (int i = 0; i <=31; i++) {
            String s = Integer.toBinaryString(i);
            if(s.length()!=5){
                for (int j = 0; j < (5 - s.length()); j++) {
                    System.out.print(0);
                }
                System.out.println(s);
            }else {
                System.out.println(s);
            }

        }
    }
}
