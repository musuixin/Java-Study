package top.musuixin.lanqiao.basic;

import java.util.Scanner;

public class BASIC10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i==0){
            System.out.println(0);
        }
        StringBuffer hex=new StringBuffer();
        while (i>0) {
            hex.insert(0, toHex(i % 16));
            System.err.println(i%16);
            i = i / 16;
        }
        System.out.println(hex);
    }
    public static String  toHex(int i){
        String[] arr={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        return arr[i];
    }
}
