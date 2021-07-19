package top.musuixin.leetcode.easy;

public class E405 {
    /**
     * 十转十六
     *
     * @param num
     * @return
     */
    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int temp;
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            temp = num & 15;
            ans.insert(0, chars[temp]);
            num >>>= 4;
        }
        return ans.toString();
    }
    /**
     * 十转八
     *
     * @param num
     * @return
     */
    public static String toOctal(int num) {
        if (num == 0) {
            return "0";
        }
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7'};
        int temp;
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            temp = num & 7;
            ans.insert(0, chars[temp]);
            num >>>= 3;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int num = -8;
        System.err.println(toHex(num) + " " + Integer.toHexString(num));
        System.err.println(toOctal(num) + " " + Integer.toOctalString(num));

    }
}
