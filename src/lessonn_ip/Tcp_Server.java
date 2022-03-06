package lessonn_ip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: Tcp_Server
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/6  12:41
 */
public class Tcp_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        //获取到连过来的客户端
        Socket accept = serverSocket.accept();
        // 读取客户端消息
        InputStream inputStream = accept.getInputStream();
        //管道流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            byteArrayOutputStream.write(buffer,0,len);
        }
        System.out.println(byteArrayOutputStream.toString());

        inputStream.close();
        accept.close();
        byteArrayOutputStream.close();
    }
}
