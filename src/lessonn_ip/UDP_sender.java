package lessonn_ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: UDP_sender
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/9  19:35
 */
public class UDP_sender {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(8686);
        while(true) {
            String s = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                s = bufferedReader.readLine();
                byte[] bytes = s.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 6868));
                datagramSocket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("发送出了问题");
            }
            if("bye".equals(s.trim())){
                break;
            }

            String data2 = null;
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket packet2 = new DatagramPacket(buffer, 0, buffer.length);
                datagramSocket.receive(packet2);

                byte[] data = packet2.getData();
                data2 = new String(data, 0, data.length);
                System.out.println(data2.trim());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("接收出了问题");
            }
            if("bye".equals(data2.trim())){
                break;
            }
        }
        datagramSocket.close();
    }
}
