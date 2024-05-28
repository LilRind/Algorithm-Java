package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 两数相加-链表
/*
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

输入：l1 = [0], l2 = [0]
输出：[0]

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
 */
// 重点关注
public class LeetCode_2 {
    public static void main(String[] args) {
        // 构造链表
        ListNode a = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        ListNode b = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        // 构造链接
        a.next = node2;
        node2.next = node3;

        b.next = node5;
        node5.next = node6;

        ListNode head = addTwoNumbers(a,b);
        printNodes(head);

    }

    // 官方解法
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // head指针节点记录链表首节点(指针不动)、tail指针节点是记录两数相加的新节点（最终也是最高位节点）
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0; // 不为空则为l1.val，为空则为0
            int n2 = l2 != null ? l2.val : 0; // 不为空则为l2.val，为空则为0
            int sum = n1 + n2 + carry;
            // 头部节点为空，刚开始没有头部节点
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else { // 头部指针已创建，创建两数相加的新节点
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10; // 更新进位
            // 如果不为空则继续遍历下一节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 最高位还有进位，则创建新节点
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    // 第一次解，能通过同长度的两条列表（例如2、4、3-----5、6、4），但无法通过两条链表不一致的情况
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode();
//        ListNode pos = head;
//        int temp = 0; // 记录低位的进位
//
//        while(l1 != null || l2 != null){
//            if(l1 != null && l2 != null){
//                pos.val = (l1.val + l2.val + temp)%10;
//                temp = (l1.val + l2.val + temp)/10;
//
//                // 制造新节点
//                if(l1.next != null || l2.next != null){
//                    ListNode nex = new ListNode();
//                    pos.next = nex;
//                    pos = pos.next;
//                }
//            }else {
//                ListNode xx = l1 == null ? l2 : l1;
//                while(xx != null){
//                    pos.val = xx.val;
//                    ListNode nex = new ListNode();
//                    pos.next = nex;
//                    pos = pos.next;
//                    xx = xx.next;
//                }
//                return head;
//            }
//
//            // l1，l2后移
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        return head;
//    }


}
