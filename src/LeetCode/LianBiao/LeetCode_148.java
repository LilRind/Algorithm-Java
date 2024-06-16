package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;


// 求..卷了：归并排序自顶向下（掌握）。 归并排序自底向上
/*
在实际应用中，我们绝大多数情况都不会直接对链表进行排序，而是将链表转为数组再进行排序，然后还原链表，
这样的速度要比我们直接对链表排序要更快。
实际上我们可以从力扣的通过记录里看到，排名靠前的有些就是这么写的。不过对于这种题目来说，这应该算作作弊吧。
 */
// https://leetcode.cn/problems/sort-list/solutions/2358097/ru-he-zheng-ming-pai-xu-lian-biao-shi-ku-tf9m/?envType=study-plan-v2&envId=top-100-liked

// K神：归并排序（递归法）
// https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/?envType=study-plan-v2&envId=top-100-liked

// 148. 排序链表
/*
输入：head = [4,2,1,3]
输出：[1,2,3,4]

输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]

输入：head = []
输出：[]
 */
// 第1次未解出，重点关注
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

    // 第2次未解出
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; // 单个节点无需排序

        // 使用快慢指针，寻找中间节点（涉及题目《876. 链表的中间结点》）
        // slow 后移动一位，fast移动两位，奇数个节点找到中点，偶数个节点找到中心左边的节点。
        ListNode s = head, f = head.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        // 分割链表（利用 ps，与题目《206. 反转链表》有异曲同工之处）
        // 找到中点 slow 后，执行 slow.next = null 将链表切断。
        ListNode tmp = s.next; // tmp为右半段头节点
        s.next = null; // s为左半段末尾节点

        // 继续分割链表（涉及归并排序）
        var l = sortList(head);
        var r = sortList(tmp);

        // 合并有序链表（涉及题目《21. 合并两个有序链表》）
        return merge(l, r);
    }

    static ListNode merge(ListNode l, ListNode r) {
        var dummy = new ListNode(); // 虚拟节点，记录头节点
        var curr = dummy; // 当前指针，合并时构造链表
        while (l != null && r != null) {
            if (l.val <= r.val) {
                curr.next = l;
                l = l.next;
            } else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        // 将剩余的节点接到结果链表中
        curr.next = l != null ? l : r;
        return dummy.next;
    }

    // 第1次未解出
    // K神：归并排序（递归法）
    // 递归 + 归并，返回排序后(子)链表的头节点
//    public static ListNode sortList(ListNode head) {
//        // cut 递归终止条件： 当 head.next == null 时，说明只有一个节点了，直接返回此节点。
//        if (head == null || head.next == null)
//            return head;
//        // 使用 fast,slow 快慢双指针找到链表的中点
//        ListNode fast = head.next, slow = head;
//        // slow 后移动一位，fast移动两位，奇数个节点找到中点，偶数个节点找到中心左边的节点。
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        // 找到中点 slow 后，执行 slow.next = null 将链表切断。
//        ListNode tmp = slow.next;
//        slow.next = null;
//        // 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
//        // 递归分割链表，分别对左半部分和右半部分进行排序
//        ListNode left = sortList(head);
//        ListNode right = sortList(tmp);
//        // 准备头节点，合并两个已排序的子链表
//        ListNode h = new ListNode(0); // 虚拟头节点
//        ListNode res = h; // 返回头节点指针
//        // 合并过程：比较两个子链表的节点值，将较小的节点接到结果链表中
//        while (left != null && right != null) {
//            if (left.val < right.val) {
//                h.next = left;
//                left = left.next;
//            } else {
//                h.next = right;
//                right = right.next;
//            }
//            // 虚拟头节点后移一位
//            h = h.next;
//        }
//        // 将剩余的节点接到结果链表中
//        h.next = left != null ? left : right;
//        // 返回排序后的链表
//        return res.next;
//    }


}
