package study.base;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Author gaoqisen
 * @Date 2019-11-26
 * @Version 1.0
 */
public class Client {
    /*
     * java.net.Socket
     * 封装了TCP协议
     * 使用它可以与远程计算机连接并进行
     * 数据交换,实现通讯的目的
     */
    private Socket socket;
    /**
     * 构造方法,用来初始化客户端
     * @throws IOException
     * @throws UnknownHostException
     */
    public Client() throws UnknownHostException, IOException{
        /*
         * 初始化Socket
         * 初始化需要传入两个参数
         * 参数1:远端计算机IP地址
         * 参数2:远端计算机的服务端口
         *
         * IP地址用来找到服务端所在的计算机
         * 端口用来连接上该计算机上的服务端
         * 应用程序
         *
         * 实例化Socket的过程就是连接的过程
         * 若远端计算机没有响应会抛出异常
         */
        System.out.println("正在连接服务端...");
        socket = new Socket("localhost",4496);
        System.out.println("与服务端建立连接!");
    }
    /**
     * 客户端开始工作的方法
     */
    public void start(){
        try {
            //启动读取服务端消息的线程
            ServerHandler handler = new ServerHandler();
            Thread t = new Thread(handler);
            t.start();
            Scanner scanner = new Scanner(System.in);
            /*
             * Socket的方法:
             * OutputStream getOutputStream()
             * 用于获取一个输出流,通过该输出流写出的字节
             * 会发送至远端计算机.而远端计算机可以通过
             * 输入流读取.
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
            PrintWriter pw = new PrintWriter(osw,true);
            String message = null;
            while(true){
                message = scanner.nextLine();
                pw.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端运行失败!");
        }
    }
    /**
     * 该线程的任务是读取服务端发送过来的
     * 每一条消息,并输出到控制台
     * @author adminitartor
     *
     */
    class ServerHandler implements Runnable{
        @Override
        public void run(){
            try {
                InputStream in
                        = socket.getInputStream();
                InputStreamReader isr
                        = new InputStreamReader(in,"UTF-8");
                BufferedReader br
                        = new BufferedReader(isr);
                String message = null;
                //读取服务端发送的每一条消息并输出
                while((message=br.readLine())!=null){
                    System.out.println(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
