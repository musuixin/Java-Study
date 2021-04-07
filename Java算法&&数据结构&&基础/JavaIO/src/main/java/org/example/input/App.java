package org.example.input;

import java.io.FileReader;
import java.util.Arrays;

/**
 * @author musuixin
 * @date 2020-10-17 22:11
 */
public class App {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("text.txt");
        char[] bytes = new char[16];
        int read;
        while ((read = fileReader.read(bytes)) > 0) {
            System.err.println(new String(bytes, 0, read));
        }
    }
}
