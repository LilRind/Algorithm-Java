package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 19. 删除链表的倒数第 N 个结点
public class LeetCode_19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode tempNode = removeNthFromEnd(head, 2);
        printNodes(tempNode);

        // 示例2
        ListNode h1 = new ListNode(1);

        ListNode tempNode2 = removeNthFromEnd(h1, 1);
        printNodes(tempNode2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); // 虚拟节点
        ListNode first = head; // 后指针
        ListNode second = dummy; // 前指针
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


    // 第一次做法，成功是成功了，但是代码太多了
    public static ListNode myRemoveNthFromEnd(ListNode head, int n) {
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        slow.next = fast.next = head;

        while (n-- > 0){
            fast = fast.next;
        }
        // 到尾部节点截止
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // 删除头部
        if(slow.next == head){
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }

        // 删除尾部
        if(slow.next == fast){
            slow.next = null;
            return head;
        }

        // 删除非头部和尾部
        ListNode temp2 = slow.next.next;
        slow.next.next = null;
        slow.next = temp2;
        return head;
    }

    // 官方做法：计算链表长度，O(L)，O(1)
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0, head);
//        int length = getLength(head);
//        ListNode cur = dummy;
//        for (int i = 1; i < length - n + 1; ++i) {
//            cur = cur.next;
//        }
//        cur.next = cur.next.next;
//        ListNode ans = dummy.next;
//        return ans;
//    }
//
//    public int getLength(ListNode head) {
//        int length = 0;
//        while (head != null) {
//            ++length;
//            head = head.next;
//        }
//        return length;
//    }


}
