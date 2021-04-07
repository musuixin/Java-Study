package top.musuixin.basic;

import java.util.Scanner;

public class BASIC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n= scanner.nextInt();
        for (int i = 0; i <m; i++) {
            int b=65+i;
            for (int j = 0; j <n ; j++) {
                int a=65+j-i;
                if (a>=65){
                    char c=(char)(a);
                    System.out.print(c);
                }else {
                    char c=(char)(b);
                    b=b-1;
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
