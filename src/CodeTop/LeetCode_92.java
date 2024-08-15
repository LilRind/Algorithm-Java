package CodeTop;


import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 灵神：先找到left-1节点，再反转left到right+1节点，最后根据left-1、pre、cur节点重新组装
// https://leetcode.cn/problems/reverse-linked-list-ii/solutions/1992226/you-xie-cuo-liao-yi-ge-shi-pin-jiang-tou-teqq/

// 92. 反转链表 II
public class LeetCode_92 {
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

        ListNode head = reverseBetween(node1, 2 , 4);
        printNodes(head);
    }

    // 3
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), p0 = dummy;
        for(int i = 0; i < left - 1; i++){
            p0 = p0.next;
        }
        ListNode pre = null, cur = p0.next;
        for(int j = left; j < right + 1; j++){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

    // 2
    /*
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), p0 = dummy;
        for(int i = 0; i < left - 1; i++){
            p0 = p0.next;
        }
        ListNode pre = null, cur = p0.next;
        for(int j = left; j < right + 1; j++){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
     */

    // 灵神：先找到left-1节点，再反转left到right+1节点，最后根据left-1、pre、cur节点重新组装
    /*
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // dummy 是为了只有两个元素[3,5]准备的，不然会有错
        ListNode dummy = new ListNode(0, head), p0 = dummy; // p0的位置是 left - 1
        for (int i = 0; i < left - 1; ++i)
            p0 = p0.next;
        // pre是哨兵节点，方便让 left 节点的 next 置为 null。 cur 初始化为 left 节点。
        ListNode pre = null, cur = p0.next;
        for (int i = 0; i < right - left + 1; ++i) {
            ListNode nxt = cur.next; // 首先，记录下一个节点
            cur.next = pre; // 当前节点指向前一个节点
            pre = cur; // 前一个节点设为当前节点，最后 pre 的位置是 right
            cur = nxt; // 当前节点设为下一个节点，最后 cur 的位置是 right + 1
        }
        // 将反转后的子链表正确连接到原链表中，这两步不能交换，交换会错乱
        p0.next.next = cur; // left节点（p0.next）的下一个节点指向 right + 1。
        p0.next = pre; // left - 1节点的下一个节点指向反转完成后的 right
        return dummy.next;
    }
    */

}

// 解释：
/*
现在让我们分步骤理解代码是如何实现这一目标的。

初始化阶段
dummy -> 1 -> 2 -> 3 -> 4 -> 5
p0 = dummy
cur = 2 (反转开始的位置)
反转链表
在每一步反转过程中，我们将 cur 节点的 next 指向 pre，并移动 cur 和 pre 指针。

第 1 步反转：
cur = 2, pre = null, nxt = 3
操作: 2 -> null （将 2 的 next 指向 pre）
状态: pre = 2, cur = 3
当前链表: 1 -> 2 <- 3 -> 4 -> 5 (2 的 next 已指向 null)

第 2 步反转：
cur = 3, pre = 2, nxt = 4
操作: 3 -> 2 （将 3 的 next 指向 pre）
状态: pre = 3, cur = 4
当前链表: 1 -> 2 <- 3 <- 4 -> 5

第 3 步反转：
cur = 4, pre = 3, nxt = 5
操作: 4 -> 3 （将 4 的 next 指向 pre）
状态: pre = 4, cur = 5
当前链表: 1 -> 2 <- 3 <- 4 <- 5
连接反转后的部分
现在 pre 是新反转部分的头节点，cur 是 right + 1 位置的节点。

操作 1: p0.next.next = cur
p0.next 是 2， cur 是 5
结果: 2 -> 5
当前链表: 1 -> 2， 4 -> 3 -> 2 -> 5

操作 2: p0.next = pre
p0.next 原本指向 2，现在指向 4 (反转后的新头)
结果: 1 -> 4
当前链表: 1 -> 4 -> 3 -> 2 -> 5
 */
