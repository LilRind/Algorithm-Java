package CodeTop;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.HashSet;
import java.util.Set;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 灵神：
// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/solutions/2004067/ru-he-qu-zhong-yi-ge-shi-pin-jiang-tou-p-2ddn/

// 注意：链表是排序后的，说明值重复的节点是连续的。
// 删除节点很方便的做法是获取要删除的节点的前一个节点，然后让前一个节点的 next 指向 当前节点的 next 节点。

// 82. 删除排序链表中的重复元素 II
public class LeetCode_82 {
    public static void main(String[] args) {
        // 构造链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        // 构造链接关系
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode head = deleteDuplicates(node1);
        printNodes(head);
    }

    // 2


    // 灵神：
    // 先创建哨兵节点（其next指向头节点）和循环遍历的哨兵节点，循环条件是至少当前节点和下一个节点存在，然后记录当前的值，
    // 如果当前值与下一个值相等，循环判断当前节点不为空且值是否与记录值相等，相等则说明该节点仍然重复，需要将当前节点指向下一个节点
    // 否则正常移动，直到（当前节点和下一个节点都存在）的条件不满足，跳出循环，返回哨兵节点的next节点（即头节点）
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = dummy; // dummy.next指向 head，需要虚拟头节点，方便删除跳过当前节点
        while (cur.next != null && cur.next.next != null) { // 前一个节点和后一个节点不为空
            int val = cur.next.val; // 记录当前节点的值，来判断是否值重复
            if (cur.next.next.val == val) // 如果当前节点和后一个节点值相等
                // 循环判断当前节点是否存在，然后与记录值比较，相等则要删除(cur的next 指向 cur的next的next)
                while (cur.next != null && cur.next.val == val) // 如果当前节点不为空且仍然与记录值重复，那么删除（会删除一开始记录值的节点）
                    cur.next = cur.next.next; // 跳过当前重复的节点，指向下一个，下一个如果值重复，还是会跳过
            else
                cur = cur.next; // 值没有重复，继续遍历下个节点
        }
        return dummy.next; // 返回删除重复节点之后的头节点
    }

}
