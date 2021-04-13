package top.musuixin.algo;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALGO4 {
    private final Scanner sc;
    private static final int MAX_N = 100001;
    private final int[][] weight;// 权值
    private List<List<Integer>> adjacencyList;// 邻接表

    public ALGO4() {
        weight = new int[MAX_N][2];// 下标从1开始
        sc = new Scanner(new InputStreamReader(System.in));
        while (sc.hasNext()) {
            adjacencyList = new ArrayList<List<Integer>>();// 头指针的线性表
            input();
            dfs(1, 0);// 1根节点，0无前驱结点
            System.out.println(Math.max(weight[1][0], weight[1][1]));
        }
        sc.close();
    }

    private void input() {
        int n = sc.nextInt();// 结点数
        adjacencyList.add(new ArrayList<Integer>());// 下标从1开始，这个不用
        for (int i = 1; i <= n; i++) {
            weight[i][0] = 0;			// 初始化为0
            weight[i][1] = sc.nextInt();// 输入权值
            adjacencyList.add(new ArrayList<>());// 创建头结点
        }
        int head, tail;// 弧的头尾
        for (int i = 1; i < n; i++) {
            tail = sc.nextInt();
            head = sc.nextInt();
            adjacencyList.get(tail).add(head);// 添加表结点
            adjacencyList.get(head).add(tail);// 无向图，添加表结点
        }
    }

    private void dfs(int root, int pre) {// root根，pre前驱结点
        List<Integer> list = adjacencyList.get(root);// 当前链表
        for (Integer i : list) {
            if (i != pre) {// 非叶子结点，继续向下递归
                dfs(i, root);
                // 不选root点，选root子结点i最大的情况
                weight[root][0] += Math.max(weight[i][0], weight[i][1]);
                // 选root点，不选root子结点i的情况
                weight[root][1] += weight[i][0];
            }
        }
    }

    public static void main(String[] args) {
        new ALGO4();
    }
}
