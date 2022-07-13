package linkedList;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/11 11:03
 */
public class HuiWenLianBiao {

    public static void main(String[] args) {
        ListNode init = new  ListNode().init();
        boolean palindrome = isPalindrome(init);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        //先找中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //fast为null说明为偶数个，否则为奇数个slow需要+1
        if(fast != null){
            slow = slow.next;
        }
        slow = ReverseNodeList.reverseListNode3(slow);

        fast = head;
        while(slow != null){
            if(fast.val != slow.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}
