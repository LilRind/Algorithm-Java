package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 反转链表
public class LeetCode_206 {
    public static void main(String[] args) {
        // 构造链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        // 构造链接关系
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = reverseList(node1);
        printNodes(head);
    }
    // 第3次做，通过。
    public static ListNode reverseList(ListNode head) {
        ListNode dum = null;
        while (head != null){
            ListNode tempNext = head.next;
            head.next = dum;
            dum = head;
            head = tempNext;
        }
        return dum;
    }


    // 第二次做，通过
    /*
    public static ListNode reverseList(ListNode head) {
        ListNode dummyNode = null;

        while (head != null){
            ListNode temp = head.next;
            head.next = dummyNode;
            dummyNode = head;
            head = temp;
        }
        return dummyNode;
    }
    */

    // 第一次做
//    public static ListNode reverseList(ListNode head) {
//        ListNode pre = null; // 注意是null
//        while(head != null){
//            ListNode temp = head.next;
//            head.next = pre;
//            pre = head;
//            head = temp;
//        }
//        return pre;
//    }

}
