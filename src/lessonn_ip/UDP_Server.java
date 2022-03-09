package lessonn_ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName: UDP_Server
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/9  19:25
 */
public class UDP_Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8085);
        //接收数据
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        datagramSocket.close();
    }
}
