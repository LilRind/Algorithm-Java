package tme.bishi0418;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// https://blog.csdn.net/Qmtdearu/article/details/137965522
public class T1 {
    public ListNode insert0(ListNode head) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (head != null) {
            p.next = new ListNode(head.val);
            p = p.next;
            if (head.next != null) {
                p.next = new ListNode(0);
                p = p.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
