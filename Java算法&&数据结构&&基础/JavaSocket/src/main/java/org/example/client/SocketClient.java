package org.example.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author musuixin
 * @date 2020-10-17 21:12
 */
public class SocketClient {
    public static void init() {
        try {
            Socket socket = new Socket("127.0.0.1", 9000);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("hello world");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
