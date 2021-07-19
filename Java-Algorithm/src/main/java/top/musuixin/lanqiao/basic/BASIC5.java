package top.musuixin.lanqiao.basic;

import java.util.Scanner;

public class BASIC5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr=new int[n];
        int i=0;
        while (i<n&&scanner.hasNextInt()){
            arr[i]=scanner.nextInt();
            i++;
        }
        int m = scanner.nextInt();
        for (int j = 0; j <n; j++) {
            if(arr[j]==m){
                System.out.println(j+1);
                return;
            }
        }
        System.out.println(-1);
    }
}
