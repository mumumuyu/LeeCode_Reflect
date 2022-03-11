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
public class TalkSend implements Runnable{
    private int fromPort;
    private String toIp;
    private int toPort;

    public TalkSend(int fromPort,String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
    }

    @Override
    public void run() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(this.fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while(true) {
            String s = null;
            String msg = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                msg = bufferedReader.readLine();
                s = Thread.currentThread().getName() + ":" + msg;
                byte[] bytes = s.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(this.toIp, this.toPort));
                assert datagramSocket != null;
                datagramSocket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("发送出了问题");
            }
            assert msg != null;
            if ("bye".equals(msg.trim())) {
                break;
            }
        }
        datagramSocket.close();
    }
}
