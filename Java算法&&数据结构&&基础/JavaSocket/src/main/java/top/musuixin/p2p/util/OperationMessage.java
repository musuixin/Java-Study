package top.musuixin.p2p.util;

import cn.hutool.json.JSONUtil;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author musuixin
 */
public class OperationMessage {
    public static void receiveSend(Socket socket) {
        char[] bytes = new char[999];
        try {
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            int read;
            while ((read = bufferedReader.read(bytes)) > 0) {
                if (read <= 2) {
                    continue;
                }
                System.out.println(new String(bytes, 0, read));
                Message message = JSONUtil.toBean(new String(bytes, 0, read), Message.class);
                sendMessage(message);
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

    public static void setTable(Socket socket) {
        char[] bytes = new char[999];
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            int read = inputStreamReader.read(bytes);
            Message message = JSONUtil.toBean(new String(bytes, 0, read), Message.class);
            ServerSupport.CLIENTLISTS.put(message.getId(), socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(Message message) {
        Socket socket=null;
        if (ServerSupport.CLIENTLISTS.containsKey(message.getId())){
            socket = ServerSupport.CLIENTLISTS.get(message.getId());
        }else {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            Scanner scanner = new Scanner(System.in);
            printStream.println(JSONUtil.parse(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receiveMessage(Socket socket) {
        char[] bytes = new char[999];
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            int read;
            while ((read = inputStreamReader.read(bytes)) > 0) {
                if (read <= 2) {
                    continue;
                }
                Message message = JSONUtil.toBean(new String(bytes, 0, read), Message.class);
                System.out.println("输出:" + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
