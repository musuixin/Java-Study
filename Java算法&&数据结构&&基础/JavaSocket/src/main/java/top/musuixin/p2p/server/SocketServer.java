package top.musuixin.p2p.server;

import top.musuixin.p2p.util.OperationMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author musuixin
 * @date 2020-10-17 21:03
 */



class SocketThread implements Runnable{
    Socket socket;
    public SocketThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
            OperationMessage.receiveSend(socket);
    }
}
public class SocketServer {
    public static void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true){
                Socket socket = serverSocket.accept();
                OperationMessage.setTable(socket);
                new Thread(new SocketThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
