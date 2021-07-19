package top.musuixin.lanqiao.basic;

import java.util.Scanner;

public class BASIC02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long i = scanner.nextLong();
        long sum = 0;
        for (long j = 1; j <= i; j++) {
            sum = j + sum;
        }
        System.out.println(sum);
    }
}
