package top.musuixin.output;

import java.io.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        byte[] chars=new byte[999];
        FileInputStream fileReader=new FileInputStream("F:\\Java\\Java算法&&数据结构&&基础\\棉花病虫草害全程综合防控技术_闵文江.pdf");
        int offest=0;
        while ((offest=fileReader.read(chars))>=0){
            System.err.println(new String(chars,0,offest,"gbk"));
        }
    }
}
