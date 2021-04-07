package top.musuixin.basic;

import java.util.Arrays;
import java.util.Scanner;

public class BASIC13 {
    public static void main(String[] args) {
        Scanner sca=new Scanner(System.in);
        int i = sca.nextInt();
        int[] arr=new int[i];
        int j=0;
        while (j<i&&sca.hasNextInt()){
            arr[j]=sca.nextInt();
            j++;
        }
        Arrays.sort(arr);
        for (int a:
             arr) {
            System.out.print(a+" ");
        }
    }
}
