package linkedList;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Description: 圆圈最后一个数 ——约瑟夫环
 * @author: LGD
 * @date:2022/8/8 9:12
 */
public class YueSeFuHuan {
    public static void main(String[] args) {
        System.out.println(lastRemaining3(70866,116922));//64165
    }

    //手撕，直接超时😡
    public static int lastRemaining(int n, int m) {
        if(n == 1) return 0;
        if(m == 1) return n-1;

        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;
        int count = n;
        while(count != 1){
            int buShu = m-2;
            while(buShu != 0){
                head = head.next;
                buShu -= 1;
            }
            head.next = head.next.next;
            head = head.next;
            count --;
        }
        return head.val;
    }

    // Array模拟链表——靠，这都比我快😭

    /**
     * 执行用时：1043 ms, 在所有 Java 提交中击败了22.40%的用户
     * 内存消耗：43.7 MB, 在所有 Java 提交中击败了8.63%的用户
     */
    public static int lastRemaining3(int n, int m) {
        List<Integer> lists = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            lists.add(i);
        }

        int index = 0;
        while(n>1){
            index = (index + m - 1) % n;
            lists.remove(index);
            n--;
        }
        return lists.get(0);
    }


    //数学解法——逆天，果然数学才是人上人😭
    public static int lastRemaining2(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
