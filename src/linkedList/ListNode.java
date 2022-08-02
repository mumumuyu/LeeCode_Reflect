package linkedList;

/**
 * @Description: 链表及其基本实现方法
 * @author: LGD
 * @date:2022/7/11 9:00
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int length(){
        ListNode listNode = this;
        int length = 0;
        if(listNode == null){
            return length;
        }
        while(listNode != null){
            listNode = listNode.next;
            length ++;
        }
        return length;
    }

    public void print(){
        ListNode listNode = this;

        System.out.println(listNode.getVal());

        if(listNode.getNext() == null){
            return;
        }

        listNode.getNext().print();
    }

     ListNode init(){
        ListNode head = new ListNode(3);
        head.next=new ListNode(5);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(3);
//        head.next.next.next = head;
        return  head;
    }
}
