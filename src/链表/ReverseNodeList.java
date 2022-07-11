package 链表;

import java.util.Stack;

/**
 * @Description: 反转链表
 * @author: LGD
 * @date:2022/7/11 9:00
 */
public class ReverseNodeList {

    static ListNode init(){
        ListNode head = new ListNode(3);
        head.next=new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(9);
//        head.next.next.next = head;
        return head;
    }

    public static void main(String[] args) {
        ListNode init = init();
//        ListNode listNode = reverseListNode1(init);
        ListNode listNode = reverseListNode2(init);
        listNode.print();
        System.out.println(listNode.length());
    }

    //1.使用栈
    public static ListNode reverseListNode1(ListNode head){
        Stack<ListNode> nodeStack = new Stack<>();
        while(head != null){
            nodeStack.push(head);
            head = head.next;
        }

        if(nodeStack.isEmpty())
            return null;

        ListNode node = nodeStack.pop();
        //记得把头结点留出来
        ListNode newHead = node;

        while(!nodeStack.isEmpty()){
            node.next = nodeStack.pop();
            node = node.next;
        }

        node.next = null;
        return newHead;
    }

    //2.双链表
    public static ListNode reverseListNode2(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;//留存
            head.next = newHead;//head指向第二个链表的旧头节点
            newHead = head;//把head变成第二个链表新的头节点
            head = next;//重新赋值head
        }
        return newHead;
    }

    //2.递归方式实现
    public static ListNode reverseListNode3(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;//留存
            head.next = newHead;//head指向第二个链表的旧头节点
            newHead = head;//把head变成第二个链表新的头节点
            head = next;//重新赋值head
        }
        return newHead;
    }

}

