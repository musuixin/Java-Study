package top.musuixin.p2p.client;

import cn.hutool.json.JSONUtil;
import top.musuixin.p2p.util.Message;
import top.musuixin.p2p.util.OperationMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;




class ClientSocketThread implements Runnable{
    Socket socket;
    public ClientSocketThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        OperationMessage.receiveMessage(socket);
    }
}

/**
 * @author musuixin
 * @date 2020-10-17 21:12
 */
public class SocketClient {
    public static void init() {
        char[] c = new char[32];
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9000);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println(JSONUtil.parse(new Message(1,"hello 我连接上了")));
            new Thread(new ClientSocketThread(socket)).start();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("请输入对方id:");
                int id = scanner.nextInt();
                System.out.print("请输入输入通信内容:");
                String content = scanner.next();
                System.out.println("**************************");
                printStream.println(JSONUtil.parse(new Message(id,content)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
