package top.musuixin.lanqiao.algo;

import java.util.Scanner;

/**
 * 如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好
 * 数。求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，
 * 所有K好数为11、13、20、22、30、31、33 共7个。
 * 由于这个数目很大，请你输出它对1000000007取模后的值。
 * <p>
 * 动态规划
 */
public class ALGO3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int K = scanner.nextInt();
        final int L = scanner.nextInt();
        int[][] arr = new int[L + 1][K];
        for (int i = 0; i < K; i++) {
            arr[1][i] = 1;
        }
        for (int i = 2; i < L + 1; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < K; k++) {
                    if (k != j + 1 && k != j - 1) {
                        arr[i][j] += arr[i - 1][k];
                        arr[i][j] = arr[i][j] % 1000000007;
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 1; i < K; i++) {
            sum = sum + arr[L][i];
            sum %= 1000000007;
        }
        System.out.println(sum);
    }
}
