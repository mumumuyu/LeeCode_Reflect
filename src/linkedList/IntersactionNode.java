package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:    两链表是否相交
 * 很简单，用Set判断一下即可
 * 执行用时：6 ms, 在所有 Java 提交中击败了10.89%的用户
 * 内存消耗：43.8 MB, 在所有 Java 提交中击败了96.82%的用户
 * @author: LGD
 * @date:2022/8/5 15:58
 */
public class IntersactionNode {
    public static void main(String[] args) {

    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();
        while(headA!=null){
            hashSet.add(headA);
            headA = headA.next;
        }

        while(headB!=null){
            if(hashSet.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    //双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode pA = headA,pB = headB;
        while(pA!=pB){
            pA = pA == null ? headB:pA.next;
            pB = pB == null ? headA:pB.next;
        }
        return pA;
    }

    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        HashSet<ListNode> nodes = new HashSet<>();
        while(headA != null){
            nodes.add(headA);
            headA = headA.next;
        }

        while(headB!=null) {
            if (nodes.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

}
