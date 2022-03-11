package lessonn_ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ClassName: UDP_receive
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/10  7:55
 */
public class UDP_receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(6868);

        while(true) {
            String data2 = null;
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                datagramSocket.receive(packet);
                byte[] data = packet.getData();
                data2 = new String(data, 0, data.length);
                System.out.println(data2.trim());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("接收出了问题");
            }
            if("bye".equals(data2.trim())){
                break;
            }

            String s = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                s = bufferedReader.readLine();
                byte[] bytes = s.getBytes();
                DatagramPacket packet2 = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 8686));

                datagramSocket.send(packet2);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("发送出了问题");
            }
            if("bye".equals(s.trim())){
                break;
            }
        }
        datagramSocket.close();
    }
}
