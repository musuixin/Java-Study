package top.musuixin.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream("text.txt");
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("hello world");
//            printStream.print("hello worldio");
//            FileInputStream fileInputStream = new FileInputStream("text.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
