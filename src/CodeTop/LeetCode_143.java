package CodeTop;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 灵神：快慢指针找寻链表中间节点 + 反转链表 + 依次组装链表
// https://leetcode.cn/problems/reorder-list/solutions/1999276/mei-xiang-ming-bai-yi-ge-shi-pin-jiang-t-u66q/

// 143. 重排链表
public class LeetCode_143 {
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

    public static void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode rever = reverseList(mid);
        while(rever.next != null){ // 到中间节点就结束了，不用继续循环
            ListNode nxt1 = head.next; // 记录左链表的下一个节点
            ListNode nxt2 = rever.next; // 记录右链表的下一个节点
            head.next = rever; // 左链表的next指向右链表的同位置节点
            rever.next = nxt1; // 右链表的next指向左链表的下一个节点
            head = nxt1;
            rever = nxt2;
        }
    }

    // 876. 链表的中间结点
    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){ // fast != null 对应偶数长度，fast.next != null 对应奇数长度
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // 206. 反转链表
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }





}
