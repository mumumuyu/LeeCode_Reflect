package lessonn_ip;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: UDP_Client
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/9  19:20
 */
public class UDP_Client {
    public static void main(String[] args) throws IOException {
        //建立一个Socket
        DatagramSocket datagramSocket = new DatagramSocket();

        //建个包
        String msg = "hello~,server";
        //发送人地址
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 8085;
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8),0,msg.getBytes(StandardCharsets.UTF_8).length,localhost,port);
        //发送包
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
