package top.musuixin.lanqiao.basic;

import java.util.Scanner;

public class BASIC04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        if (n==1){
            System.out.println(1);
        }
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }
        System.out.println(arr[n]);
    }
}
