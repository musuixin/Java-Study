package top.musuixin.lanqiao.basic;

import java.util.Arrays;
import java.util.Scanner;

public class BASIC4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr=new int[n];
        int j=0;
        while (j<n&&scanner.hasNextInt()){
            arr[j]=scanner.nextInt();
            j++;
        }
       Arrays.stream(arr).max().ifPresent(System.out::println);
       Arrays.stream(arr).min().ifPresent(System.out::println);
       System.out.println(Arrays.stream(arr).sum());
    }
}
