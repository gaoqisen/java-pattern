package study.base;

import java.io.*;

/**
 * @ClassName IO
 * @Author gaoqisen
 * @Date 2019-11-16
 * @Version 1.0
 */
public class IO {

    public static void main(String[] args) throws Exception{
        // byteStream();
        //character();
        file();
    }

    private static void file() throws IOException{
        String path = "/Users/jasongao/Desktop/test.txt";
        File myFile = new File(path);
        //判断文件是否存在
        if (!myFile.exists()) {
            // 创建文件夹， mkdir()只会建立一级的文件夹
            myFile.mkdir();
            // mkdirs()可以建立多级文件夹
            myFile.mkdirs();
            // 创建新文件
            myFile.createNewFile();
            // 删除文件夹
            myFile.delete();
            //读取文件名称
            myFile.getName();
            //读取文件路径(相对路径)
            myFile.getPath();
            //读取文件绝对路径
            myFile.getAbsolutePath();
            //读取文件的父级路径
            new File(myFile.getAbsolutePath()).getParent();
            //读取文件的大小
            myFile.length();
            //判断文件是否被隐藏
            myFile.isHidden();
            //判断文件是否可读
            myFile.canRead();
            //判断文件是否可写
            myFile.canWrite();
            //判断文件是否为文件夹
            myFile.isDirectory();
        }
    }
    private static void character() throws IOException{
        //—————————— Writer, write输出byte[]
        File f= new File("/Users/jasongao/Desktop/test.txt");

        Writer out = new FileWriter(f)  ;	// 通过对象多态性，进行实例化
        // 第3步、进行写操作
        String str = "Hello World!!!666" ;		// 准备一个字符串
        out.write(str);
        out.close();

        //—————————— Reader, write输出byte[]
        Reader input = new FileReader(f) ;
        // 所有的内容都读到此数组之中
        char c[] = new char[1024] ;
        int len = input.read(c) ;
        input.close() ;
        System.out.println("内容为：" + new String(c,0,len));
    }
    private static void byteStream() throws IOException {
        //—————————— OutputStream, write输出byte[]
        // 文件本身不存在，则会为用户自动创建新文件
        File f= new File("/Users/jasongao/Desktop/test.txt") ;
        // 通过子类实例化父类对象, 通过对象多态性，进行实例化。
        // new FileOutputStream(f,true)  ;	// 此处表示在文件末尾追加内容
        OutputStream out = new FileOutputStream(f);
        String str = "Hello World!!!" ;
        // 只能输出byte数组，所以将字符串变为byte数组
        byte b[] = str.getBytes() ;
        // 将内容输出，保存文件
        out.write(b) ;

        //—————————— OutputStream, write输出byte
        String str2 = "\r\nHello World2!!!" ;
        byte c[] = str2.getBytes() ;
        // 采用循环方式写入,每次只写入一个内容
        for(int i=0;i<c.length;i++){
            out.write(c[i]) ;
        }
        out.close() ;

        //—————————— InputStream, read输入byte[]
        InputStream input =  new FileInputStream(f)  ;
        // 所有的内容都读到此数组之中
        byte d[] = new byte[1024] ;
        // 读取内容,可以 返回长度、byte等
        int len =input.read(d) ;
        input.close() ;
        System.out.println("读入数据的长度：" + len);
        System.out.println("内容为：" + new String(d)) ;
        System.out.println("内容为：" + new String(d,0,len));
    }
    /**
     * 将str转换为inputStream
     * @param str
     * @return
     */
    public static InputStream strConvertInputStream(String str) {
        ByteArrayInputStream is = new ByteArrayInputStream(str.getBytes());
        return is;
    }
    /**
     * 将inputStream转换为str
     * @param is
     * @return
     * @throws IOException
     */
    public static String inputStreamConvertStr(InputStream is) throws IOException {
        StringBuffer sb;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is));

            sb = new StringBuffer();

            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
        } finally {
            br.close();
        }

        return sb.toString();
    }
    /**
     * 将file转换为inputStream
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static InputStream fileConvertInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
    /**
     * 将inputStream转化为file
     * @param is
     * @param file 要输出的文件目录
     */
    public static void inputStreamConvertFile(InputStream is, File file) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int len = 0;
            byte[] buffer = new byte[8192];

            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } finally {
            os.close();
            is.close();
        }
    }
}
