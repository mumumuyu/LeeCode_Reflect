package linkedList;

/**
 * @Description: 合并链表
 * @author: LGD
 * @date:2022/7/11 11:26
 */
public class HeBinLieBiao {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        listNode1.next = new ListNode(5);
        listNode1.next.next = new ListNode(7);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(32);

        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(5);
        listNode2.next.next = new ListNode(8);
        listNode2.next.next.next = new ListNode(9);
        listNode2.next.next.next.next = new ListNode(32);

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        listNode.print();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode newList = new ListNode(0);
        ListNode sumList = newList;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                newList.next = list2;
                list2 = list2.next;
            }else{
                newList.next = list1;
                list1 = list1.next;
            }
            newList = newList.next;
        }

        newList.next = list1 == null ?  list2 : list1;

        return sumList.next;
    }
}
