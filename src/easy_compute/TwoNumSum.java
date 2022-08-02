package easy_compute;

import linkedList.ListNode;

/**
 * @Description:    两数之和
 * @author: LGD
 * @date:2022/8/1 16:53
 */
public class TwoNumSum {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(9);
        ListNode listNode2 = new ListNode(1);
        listNode2.setNext(new ListNode(9));
        ListNode listNode1 = addTwoNumbers(listNode, listNode2);
        listNode1.print();
    }

    /**
     * 死在
     * [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
     * [5,6,4]
     * 上，Long都撑不住
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while(l1 != null){
            s1.append(l1.getVal());
            l1 = l1.getNext();
        }
        while(l2 != null){
            s2.append(l2.getVal());
            l2 = l2.getNext();
        }
        Long i1 = Long.valueOf(s1.reverse().toString());
        Long i2 = Long.valueOf(s2.reverse().toString());
        Long i3 = i1 + i2;
        String s = String.valueOf(i3);
        String s3 = new StringBuilder(s).reverse().toString();
        char[] chars = s3.toCharArray();
        ListNode listNode = new ListNode(chars[0]-48);
        ListNode head = listNode;
        for(int i = 1;i<chars.length;i++){
            ListNode node = new ListNode();
            node.setVal(chars[i]-48);
            listNode.setNext(node);
            listNode = node;
        }

        return head;
    }
}
