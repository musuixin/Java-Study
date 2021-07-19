package top.musuixin.lanqiao.basic;

import java.math.BigInteger;
import java.util.Scanner;

public class BASIC12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=  scanner.nextInt();
        String[] arr=new String[num];
        int j=0;
        while (j<num&&scanner.hasNext()){
            arr[j]=scanner.next();
            j++;
        }
        String[] newarr=new String[num];
        for (int i = 0; i < num; i++) {
            BigInteger bigInteger=new BigInteger(arr[i],16);
            newarr[i]=bigInteger.toString(8);
        }
        for (int i = 0; i < num; i++) {
            System.out.println(newarr[i]);
        }
    }
}
