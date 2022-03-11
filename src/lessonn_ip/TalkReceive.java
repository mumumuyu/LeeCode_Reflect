package lessonn_ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ClassName: TalkSend
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/11  13:14
 */
public class TalkReceive implements Runnable{
    private int receivePort;

    public TalkReceive(int receivePort) {
        this.receivePort = receivePort;
    }

    @Override
    public void run() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(receivePort);
        } catch (SocketException e) {
            e.printStackTrace();
        }

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
            if ("bye".equals(data2.substring(data2.indexOf(":") + 1).trim())) {
                break;
            }
        }

    }
}
