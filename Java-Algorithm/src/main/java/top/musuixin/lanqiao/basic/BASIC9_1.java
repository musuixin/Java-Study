package top.musuixin.lanqiao.basic;

import java.util.Scanner;

public class BASIC9_1 {
    public static void main(String[] args) {
        int n = 0;
        int i = 0, j = 0, k = 0;
        Scanner m = new Scanner(System.in);
        if (m.hasNext()) {
            n = m.nextInt();
        }
        for (i = 1; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                for (k = 0; k < 10; k++) {
                    if (i * 2 + j * 2 + k == n)
                        System.out.println("" + i + j + k + j + i);
                }
            }
        }
        for (i = 1; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                for (k = 0; k < 10; k++) {
                    if (i * 2 + j * 2 + k * 2 == n)
                        System.out.println("" + i + j + k + k + j + i);
                }
            }
        }
    }
}
