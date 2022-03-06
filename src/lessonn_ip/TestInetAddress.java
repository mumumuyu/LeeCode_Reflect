package lessonn_ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName: TestInetAddress
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/6  11:28
 */
public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress byName1 = InetAddress.getByName("127.0.0.1");
        System.out.println(byName1);
        InetAddress byName2 = InetAddress.getByName("localhost");
        System.out.println(byName2);
        InetAddress byName3 = InetAddress.getLocalHost();
        System.out.println(byName3);

        InetAddress byName = InetAddress.getByName("www.leigd.cn");
        System.out.println(byName);///域名or电脑名 + ip
        System.out.println(byName.getCanonicalHostName());//规范的名字
        System.out.println(byName.getHostName());//域名，或者自己电脑的名字
    }
}
