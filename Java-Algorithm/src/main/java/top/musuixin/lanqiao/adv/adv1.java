package top.musuixin.lanqiao.adv;

import java.util.Arrays;
import java.util.Scanner;

class P implements Comparable<P> {
    int x;
    int y;

    @Override
    public int compareTo(P o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

class F {
    double max;
    double min;
}


public class adv1 {
    static int N = 100000;
    static F[] fl = new F[N + 5];
    static F[] fr = new F[N + 5];
    static P[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, n;
        n = scanner.nextInt();
        d = new P[n];
        for (i = 0; i < n; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            d[i] = new P();
            //将坐标轴逆时针旋转45度
            d[i].x = x + y;
            d[i].y = y - x;
        }
        Arrays.sort(d);
        init(n);    //初始化
        //二分法求出答案
        double l = 0.0;
        double r = (d[n - 1].x - d[0].x) / 2.0;
        while (r - l >= 0.01) {    //达到精度则退出迭代
            double m = (l + r) / 2;    //m为最小的距离
            if (check(m, n))        //如果这个距离满足，则缩小距离
            {
                r = m;
            } else //不满足则放大距离
            {
                l = m;
            }
        }
        System.out.printf("%.1f", r);
    }

    static void init(int n) {
        int i;
        fl[0] = new F();
        fl[0].min = fl[0].max = d[0].y;
        for (i = 1; i < n; i++) {
            fl[i] = new F();
            fl[i].max = max(fl[i - 1].max, d[i].y); //fl[i]代表着前i个y坐标里面的最大值，
            fl[i].min = min(fl[i - 1].min, d[i].y); //fl[i]代表着前i个y坐标里面的最小值。
        }
        fr[n - 1] = new F();
        fr[n - 1].min = fr[n - 1].max = d[n - 1].y;
        for (i = n - 2; i >= 0; i--) {
            fr[i] = new F();
            fr[i].max = max(fr[i + 1].max, d[i].y); //fr[i]代表着后（n-i）个y坐标里面的最大值
            fr[i].min = min(fr[i + 1].min, d[i].y);  //fr[i]代表着后（n-i)个y坐标里面的最小值
        }
    }

    static boolean check(double m, int n) {
        m *= 2;        //区间长度为m的两倍
        int i, j = 0;
        for (i = 0; i < n; i++) {        //注意：从每一个点出发（x的升序），画一个长度为2m的区间，只要有一种满足，那么就满足了
            while (j < n && d[j].x - d[i].x <= m) {
                //找出最大的xj使xj-xi<=m,所以在xi到xj的这段区间的范围,
                // 是垂直线的范围之后找出[1,i-1]以及[j+1,n-1]范围内的最大的y和最小的y值，
                // 如果最大的y值减去最小的y值<=m，则说明这是水平线的范围，则进行下一轮二分找出中点，找出更优解。
                j++;
            }
            double max = -1e10;
            double min = Double.MAX_VALUE;
            if (j != n) {        //分别在区间两端求解
                max = max(max, fr[j].max);
                min= min(min, fr[j].min);
            }
            if (i - 1 >= 0) {
                max = max(max, fl[i - 1].max);
                min = min(min, fl[i - 1].min);
            }
            //如果其y方向也满足距离小于m，则满足条件
            if (max - min <= m) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    static double max(double a, double b) {
        return Math.max(a, b);
    }

    /**
     * @param a
     * @param b
     * @return
     */
    static double min(double a, double b) {
        return Math.min(a, b);
    }
}
