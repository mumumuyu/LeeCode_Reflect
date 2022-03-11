package lessonn_ip;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/11  14:11
 */
public class Test {
    public static void main(String[] args) throws IOException {
/*        URL url = new URL("http://www.leigd.cn");
        System.out.println(url.getProtocol()); //获取协议
        System.out.println(url.getFile());//获取全路径
        System.out.println(url.getHost());//获取端口
        System.out.println(url.getPath());//获取文件
        System.out.println(url.getQuery());//获取参数*/

        /*URL url = new URL("https://i0.hdslb.com/bfs/archive/9a30607625e6c07da570bb2eb07ebdcc4b23c759.png");
        //获取url并建立连接
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        //获取连接输入流
        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("bilibili.png");
        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,buffer.length);
        }

        inputStream.close();
        fos.close();
        urlConnection.disconnect();*/

        new Thread(new TalkSend(5555,"localhost",6666),"lgd1").start();
        new Thread(new TalkReceive(8686)).start();
    }
}
