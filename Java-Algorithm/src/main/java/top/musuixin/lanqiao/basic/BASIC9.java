package top.musuixin.lanqiao.basic;

import java.util.LinkedList;
import java.util.Scanner;

public class BASIC9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i%2==0){
            evenNumber(i);
        }else {
            oddNumber(i);
        }
    }
    public static void oddNumber(int odd){
        LinkedList<Integer> integers=new LinkedList<>();
        for (int i = 0; i <=9 ; i++) {
            if (i%2!=0){
                int even=(odd-i)/2;
                for (int j = 1; j <=9 ; j++) {
                    if (even-j>=0&&even-j<=9){
                        int m=even-j;
                        integers.add(new Integer(""+j+m+i+m+j));
                    }
                }
            }
        }
        integers.stream().sorted().forEach(System.out::println);
    }
    public static void evenNumber(int even){
        LinkedList<Integer> strings=new LinkedList<>();
        for (int i = 0; i <=9 ; i++) {
            if (i%2==0){
                int odd=(even-i)/2;
                for (int j = 1; j <=9 ; j++) {
                    if(odd-j>=0&&odd-j<=9){
                        int m=odd-j;
                        strings.add(new Integer(""+j+m+i+m+j));
                    }
                }
            }
        }
        int half=even/2;
        for (int i = 1; i <=9; i++) {
            if (half-i<19&&half-i>0){
                for (int j = 0; j <=9 ; j++) {
                    if (half-i-j<10&&half-i-j>=0){
                        int m=half-i-j;
                        strings.add(new Integer(""+i+j+m+m+j+i));
                    }
                }
            }
        }
        strings.stream().sorted().forEach(System.out::println);
    }
}
