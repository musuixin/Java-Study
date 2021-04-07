package top.musuixin.basic;

import java.util.Scanner;

public class BASIC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if((i%4==0&&i%100!=0)||(i%400==0)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }
}
