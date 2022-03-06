package lessonn_ip;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: Tcp_Client
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/6  12:41
 */
public class Tcp_Client {
    public static void main(String[] args) throws IOException {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        int port = 9999;
        Socket socket = new Socket(byName,port);
        //发消息 IO流
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("你好，这里是客户端".getBytes(StandardCharsets.UTF_8));

        socket.close();
        outputStream.close();

    }
}
