package study.base;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Server
 * @Author gaoqisen
 * @Date 2019-11-26
 * @Version 1.0
 */
public class Server {
    /*
     *	java.net.ServerSocket
     *  运行在服务端的ServerSocket的主要
     *  作用是:
     *  1:向OS申请服务端口(客户端通过该端口
     *    与服务端建立连接)
     *  2:监听服务端口,等待客户端连接,一旦一个
     *    客户端连接后,就会创建一个Socket实例
     *    与该客户端进行交互.
     */
    private ServerSocket server;
    /*
     * 共享集合,用于存放所有客户端的输出流
     * 以便广播消息
     */
    private List<PrintWriter> allOut;

    public Server() throws IOException{
        /*
         * 初始化ServerSocket需要指定服务端口
         * 若该端口已经被其他应用程序占用则会
         * 抛出异常
         */
        server = new ServerSocket(8088);
        allOut = new ArrayList<PrintWriter>();
    }
    /**
     * 将给定的输出流存入共享集合
     * @param out
     */
    public synchronized void addOut(PrintWriter out){
        allOut.add(out);
    }
    /**
     * 从共享集合中将给定输出流删除
     * @param out
     */
    public synchronized void removeOut(PrintWriter out){
        allOut.remove(out);
    }
    /**
     * 将给定的消息发送至所有客户端
     * @param message
     */
    public synchronized void sendMessage(String message){
        for (int i = 0; i< allOut.size(); i++) {
            allOut.get(i).println(message);
        }
    }
    public void start(){
        try {
            while(true){
                /*
                 * ServerSocket的方法
                 * Socket accept()
                 * 该方法用来监听申请的服务端口,
                 * 该方法是一个阻塞方法,直到一个
                 * 客户端通过该端口与服务端建立
                 * 连接,这里便会自动创建一个Socket
                 * 并返回,通过该Socket可以与刚连接
                 * 的客户端进行交互.
                 */
                System.out.println("等待客户端连接...");
                Socket socket = server.accept();
                System.out.println("一个客户端连接了!");
                //启动一个线程来处理该客户端的交互
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 该线程的任务是与指定的客户端进行交互
     * @author adminitartor
     *
     */
    class ClientHandler implements Runnable{
        //该线程通过该Socket与指定客户端交互
        private Socket socket;
        //客户端地址信息
        private String host;
        public ClientHandler(Socket socket){
            this.socket = socket;
            //获取该客户端的地址信息
            InetAddress address = socket.getInetAddress();
            //获取其IP地址的字符串形式
            host = address.getHostAddress();
        }
        @Override
        public void run(){
            PrintWriter pw = null;
            try {
                /*
                 * 获取输出流,用于将服务端的消息通过该流
                 * 发送给客户端
                 */
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
                pw = new PrintWriter(osw,true);
                addOut(pw);
                /*
                 * Socket提供的方法:
                 * InputStream getInputStream()
                 * 通过获取的输入流可以读取远端计算机
                 * 发送过来的数据
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String message = null;
                /*
                 * 在读取客户端发送过来的消息这里,由于客户端
                 * 所在操作系统不同,当客户端断开连接时,这里
                 * br.readLine的反应也不同:
                 * linux的客户端断开时:
                 * 	br.readLine方法会返回null.
                 *
                 * windows的客户端断开连接时:
                 *  br.readLine方法会直接抛出异常
                 *
                 */
                while((message = br.readLine())!=null){
					// System.out.println(host+"说:"+message);
                    sendMessage(host+"说:"+message);
                }
            } catch (Exception e) {
            } finally{
                try {
                    //处理客户端断开连接后的操作
                    System.out.println(host+"下线了");
                    removeOut(pw);
                    //将Socket关闭
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("服务端启动失败!");
        }
    }
}
