package 链表;

/**
 * @Description: 判断是否有环
 * @author: LGD
 * @date:2022/7/10 20:11
 */
public class HasCycle {
    static ListNode init(){
        ListNode head = new ListNode(3);
        head.next=new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = head;

        return head;
    }

    public static void main(String[] args) {
        ListNode init = init();
        boolean b = hasCycle(init);
        System.out.println(b);

    }

    public static boolean hasCycle(ListNode head){
        /**
         * 记得判断是否为空
         */
        if(head == null){
            return  false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
