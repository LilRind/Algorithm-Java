package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// https://leetcode.cn/problems/add-two-numbers/  （1.递归 2.迭代）

// 灵神：1.递归 2.迭代（掌握）
//https://leetcode.cn/problems/add-two-numbers/solutions/2327008/dong-hua-jian-ji-xie-fa-cong-di-gui-dao-oe0di/?envType=study-plan-v2&envId=top-100-liked

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

    // 第3次做，
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(); // 虚拟节点
        ListNode h = dummyNode;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;
            }
            if(l2 != null){
                carry += l2.val;
            }
            ListNode temp = new ListNode(carry % 10);
            carry /= 10;
            dummyNode.next = temp;
            dummyNode = dummyNode.next;
            if(l1 != null) l1 = l1.next; // 如果l1有节点，指向下一位
            if(l2 != null) l2 = l2.next; // 如果l2有节点，指向下一位
        }
        return h.next;
    }


    // 第二次做，仍然不能通过不同链表长度的情况，再重写
    /*
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(); // 虚拟节点
        ListNode h = dummyNode;
        int cur = 0;

        while (l1 != null && l2 != null){
            ListNode temp = new ListNode((l1.val+l2.val+cur)%10);
            h.next = temp;
            h = h.next;
            cur = (l1.val + l2.val+ cur)/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        h.next = l1 == null ? l2 : l1;

        return dummyNode.next;
    }
     */

    // 掌握。再写，迭代
    /*
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(); // 虚拟节点
        ListNode h = dummyNode;
        int carry = 0; // 进位

        // 四种情况，l1有节点，l2有节点，l1，l2都有节点，有进位
        while (l1 != null || l2 != null || carry != 0){
            if(l1 != null){ // l1有节点，累加到进位
                carry += l1.val;
            }
            if(l2 != null){ // l2有节点，累加到进位
                carry += l2.val;
            }
            // 创建节点，值为模除10，h.next指向temp，h指向h.next
            ListNode temp = new ListNode(carry % 10);
            h.next = temp;
            h = h.next;
            carry /= 10; // 计算进位
            if(l1 != null) l1 = l1.next; // 如果l1有节点，指向下一位
            if(l2 != null) l2 = l2.next; // 如果l2有节点，指向下一位
        }
        return dummyNode.next; // 返回头节点
    }
    */


    // 第一次未解出，官方解法，模拟的做法相比之下有点复杂
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        // head指针节点记录链表首节点(指针不动)、tail指针节点是记录两数相加的新节点（最终也是最高位节点）
//        ListNode head = null, tail = null;
//        int carry = 0;
//        while (l1 != null || l2 != null) {
//            int n1 = l1 != null ? l1.val : 0; // 不为空则为l1.val，为空则为0
//            int n2 = l2 != null ? l2.val : 0; // 不为空则为l2.val，为空则为0
//            int sum = n1 + n2 + carry;
//            // 头部节点为空，刚开始没有头部节点
//            if (head == null) {
//                head = tail = new ListNode(sum % 10);
//            } else { // 头部指针已创建，创建两数相加的新节点
//                tail.next = new ListNode(sum % 10);
//                tail = tail.next;
//            }
//            carry = sum / 10; // 更新进位
//            // 如果不为空则继续遍历下一节点
//            if (l1 != null) {
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                l2 = l2.next;
//            }
//        }
//        // 最高位还有进位，则创建新节点
//        if (carry > 0) {
//            tail.next = new ListNode(carry);
//        }
//        return head;
//    }

    // 第一次解，我的方法，能通过同长度的两条列表（例如2、4、3-----5、6、4），但无法通过两条链表不一致的情况
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
