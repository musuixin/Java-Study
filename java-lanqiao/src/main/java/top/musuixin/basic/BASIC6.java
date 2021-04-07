package top.musuixin.basic;

import java.util.Scanner;

public class BASIC6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr=new int[n][n];
        for (int i = 0; i <n; i++) {
                arr[i][0]=1;
                arr[i][i]=1;
        }
        for (int i = 1; i <n; i++) {
            for (int j = 1; j <i; j++) {
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
