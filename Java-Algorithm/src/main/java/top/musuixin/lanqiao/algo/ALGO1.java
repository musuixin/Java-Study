package top.musuixin.lanqiao.algo;

import java.util.ArrayList;
import java.util.Scanner;

public class ALGO1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        int i = 1;
        while (i <= n && scanner.hasNextInt()) {
            arr[i] = scanner.nextInt();
            i++;
        }
        int m = scanner.nextInt();
        int[][] arr1 = new int[m][3];
        int j = 0;
        while (j < m && scanner.hasNextInt()) {
            arr1[j][0] = scanner.nextInt();
            arr1[j][1] = scanner.nextInt();
            arr1[j][2] = scanner.nextInt();
            j++;
        }
        for (int k = 0; k < m; k++) {
            int star = arr1[k][0];
            int end = arr1[k][1];
            int target = arr1[k][2];
            ArrayList<Integer> integers = new ArrayList<>();
            for (int l = star; l <= end; l++) {
                integers.add(arr[l]);
            }
            integers.sort((o1, o2) -> {
                return o2-o1;
            });
            System.out.println(integers.get(target - 1));
        }
    }
}