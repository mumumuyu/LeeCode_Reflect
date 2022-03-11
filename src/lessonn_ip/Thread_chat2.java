package lessonn_ip;

/**
 * @ClassName: Thread_chat2
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/11  21:46
 */
public class Thread_chat2 {
    public static void main(String[] args) {
        new Thread(new TalkSend(6565,"localhost",8686),"lgd2").start();
        new Thread(new TalkReceive(6666)).start();
    }
}
