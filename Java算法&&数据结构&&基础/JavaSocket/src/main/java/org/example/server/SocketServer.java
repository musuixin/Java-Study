package org.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author musuixin
 * @date 2020-10-17 21:03
 */
public class SocketServer {
    public static void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            byte[] bytes = new byte[32];
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                int read;
                while ((read = inputStream.read(bytes)) > 0) {
                    System.err.println("client say:" + new String(bytes, 0, read));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
