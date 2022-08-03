package linkedList;

/**
 * @Description: 合并链表
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.6 MB, 在所有 Java 提交中击败了34.73%的用户
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

        ListNode listNode = mergeTwoLists2(listNode1, listNode2);
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

    //2刷
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(-1);
        ListNode node = merge;
        while(l1 != null || l2 != null){
            if(l1 == null){
                merge.next = l2;
                return node.next;
            }
            if(l2 == null){
                merge.next = l1;
                return node.next;
            }
            if(l1.val <= l2.val){
                merge.next = l1;
                merge = merge.next;
                l1 = l1.next;
            }else{
                merge.next = l2;
                merge = merge.next;
                l2 = l2.next;
            }
        }
        return node.next;
    }
}
