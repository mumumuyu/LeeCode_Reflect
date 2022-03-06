package lessonn_ip;

import java.net.InetSocketAddress;

/**
 * @ClassName: InetSocket_Test
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/6  12:16
 */
public class InetSocket_Test {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(inetSocketAddress);

        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getPort());
    }
}
