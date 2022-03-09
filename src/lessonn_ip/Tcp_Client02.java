package lessonn_ip;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName: Tcp_Client02
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/9  17:54
 */
public class Tcp_Client02 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8083);
        OutputStream os = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream((new File("charlotte.jpg")));

        byte[] buffer = new byte[1024];
        int len;
        while((len=fileInputStream.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        socket.shutdownOutput();

        //确认接收完毕，才能断开
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        int len2;
        while((len2=inputStream.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }

        baos.close();
        inputStream.close();
        fileInputStream.close();
        os.close();
        socket.close();
    }
}
