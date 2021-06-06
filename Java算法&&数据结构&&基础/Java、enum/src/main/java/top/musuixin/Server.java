package top.musuixin;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author musuixin
 * @date 2020-06-14 17:57
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        while (true) {
            Socket accept = serverSocket.accept();
            PrintStream printStream = new PrintStream(accept.getOutputStream());
            printStream.println("hello socket");
            printStream.close();
            accept.close();
        }
    }
}
