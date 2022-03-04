package 递归;

public class deleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val)
            head = head.next;
        return head;
    }

    public static void Print(ListNode head){
        if (head == null) {
            System.out.println("EMPTY LIST!");
            return;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.val);
            System.out.print("->");
            currNode = currNode.next;
        }
        System.out.print(currNode.val);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteDuplicates(node1);
        Print(node1);
    }
}
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }