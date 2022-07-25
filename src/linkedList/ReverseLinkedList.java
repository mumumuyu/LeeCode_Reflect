package linkedList;

/**
 * @Description:    反转链表（双链表）
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了23.63%
 * 的用户
 * @author: LGD
 * @date:2022/7/25 9:22
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode init = ReverseLinkedList.init();

        System.out.println(isPalindrome(init));
    }

     static ListNode init(){
        ListNode head = new ListNode(1);
        head.next=new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next = head;
        return  head;
    }

    // 复习
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;
        while ( cur != null){
            ListNode temp = cur.next; //存
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //回文快慢指针

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了83.80%的用户
     * 内存消耗：57.9 MB, 在所有 Java 提交中击败了26.62%的用户
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        //先找中点
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode reverseEndList = reverseList(mid);
        ListNode temp = head;
        while(reverseEndList != null && temp != null){
            if (reverseEndList.val != temp.val)
                return false;
            reverseEndList = reverseEndList.next;
            temp = temp.next;
        }
        return true;
    }

    /**
     * 天才sb版，执行用时：16 ms, 在所有 Java 提交中击败了17.20%的用户
     * 内存消耗：63.4 MB, 在所有 Java 提交中击败了5.01%的用户
     */
    public static boolean isPalindrome2(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder("");
        while(head != null){
            stringBuilder.append(head.val);
            head = head.next;
        }
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}
