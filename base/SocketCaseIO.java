package study.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketCaseIO {
    public static ServerSocket server = null;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        init();
        System.out.println("Finish init!");
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!" + socket.getPort());
            try {
                SocketProcess socketProcess = new SocketProcess(socket);
                System.out.println("Start thread!");
                Thread thread = new Thread(socketProcess);
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private static void init() throws IOException {
        server = new ServerSocket();
        server.setSoTimeout(0);
        server.setReuseAddress(true);
        server.bind(new InetSocketAddress(4495));

    }

}
class SocketProcess implements Runnable {

    private static Socket socket = null;

    public SocketProcess(Socket socket) {
        SocketProcess.socket = socket;
    }
    @Override
    public void run() {
        InputStream rd = null;
        OutputStream bw = null;
        try {
            rd = socket.getInputStream();
            bw = socket.getOutputStream();
            byte[] ReqBuff = new byte[1000];
            System.out.println("Ready receive the request message!");
            while (rd.read(ReqBuff) > 0) {
                System.out.println("start");
                System.out.println(new String(ReqBuff));
                System.out.println("finish");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                rd.close();
                bw.close();
                socket.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
