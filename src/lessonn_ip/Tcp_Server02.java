package lessonn_ip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: Tcp_Server02
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/9  17:55
 */
public class Tcp_Server02 {
    public static void main(String[] args) throws IOException {
        //创建服务
        ServerSocket serverSocket = new ServerSocket(8083);
        //监听客户端的连接
        Socket socket = serverSocket.accept();//阻塞式监听
        //获取输入流
        InputStream inputStream = socket.getInputStream();
        //文件输出
        FileOutputStream receive = new FileOutputStream(new File("receive.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer))!= -1){
            receive.write(buffer,0,len);
        }

        //通知接收完毕
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("接收完毕，可以断开".getBytes(StandardCharsets.UTF_8));
        System.out.println("接收完毕，可以断开");

        outputStream.close();
        inputStream.close();
        receive.close();
        socket.close();
    }
}
