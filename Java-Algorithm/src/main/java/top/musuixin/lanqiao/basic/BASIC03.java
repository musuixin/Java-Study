package top.musuixin.lanqiao.basic;

import java.util.Scanner;

public class BASIC03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextInt();
        System.out.printf("%.7f",r*r*3.14159265358979323);
    }
}
