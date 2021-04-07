package top.musuixin.basic;

import java.util.HashMap;
import java.util.Scanner;

public class BASIC11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Character,Integer> toTable=new HashMap<>();
        toTable.put('0', 0);
        toTable.put('1',1);
        toTable.put('2', 2);
        toTable.put('3', 3);
        toTable.put('4', 4);
        toTable.put('5', 5);
        toTable.put('6', 6);
        toTable.put('7', 7);
        toTable.put('8', 8);
        toTable.put('9', 9);
        toTable.put('A', 10);
        toTable.put('B', 11);
        toTable.put('C', 12);
        toTable.put('D', 13);
        toTable.put('E', 14);
        toTable.put('F', 15);
        char[] charArray = s.toCharArray();
        double num=0;
        for (int i = charArray.length-1; i >=0; i--) {
            num=num+toTable.get(charArray[i])*Math.pow(16,charArray.length-1-i);
        }
        System.out.print((long) num);
}
    }
