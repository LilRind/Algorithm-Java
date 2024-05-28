package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 148. 排序链表
/*
输入：head = [4,2,1,3]
输出：[1,2,3,4]

输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]

输入：head = []
输出：[]
 */
// 第一次未解出，重点关注
public class LeetCode_148 {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        a.next = node2;
        node2.next = node3;
        node3.next = node4;

        printNodes(sortList(a));

        ListNode b = new ListNode(-1);
        ListNode nodeB2 = new ListNode(5);
        ListNode nodeB3 = new ListNode(3);
        ListNode nodeB4 = new ListNode(4);
        ListNode nodeB5 = new ListNode(0);

        b.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = nodeB4;
        nodeB4.next = nodeB5;

        printNodes(sortList(b));

    }

    // 递归 + 归并，返回排序后(子)链表的头节点
    public static ListNode sortList(ListNode head) {
        // cut 递归终止条件： 当 head.next == null 时，说明只有一个节点了，直接返回此节点。
        if (head == null || head.next == null)
            return head;
        // 使用 fast,slow 快慢双指针找到链表的中点
        ListNode fast = head.next, slow = head;
        // slow 后移动一位，fast移动两位，奇数个节点找到中点，偶数个节点找到中心左边的节点。
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 找到中点 slow 后，执行 slow.next = null 将链表切断。
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
        // 递归分割链表，分别对左半部分和右半部分进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 准备头节点，合并两个已排序的子链表
        ListNode h = new ListNode(0); // 虚拟头节点
        ListNode res = h; // 返回头节点指针
        // 合并过程：比较两个子链表的节点值，将较小的节点接到结果链表中
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            // 虚拟头节点后移一位
            h = h.next;
        }
        // 将剩余的节点接到结果链表中
        h.next = left != null ? left : right;
        // 返回排序后的链表
        return res.next;
    }


}
