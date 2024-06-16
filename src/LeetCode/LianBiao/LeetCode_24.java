package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 24. 两两交换链表中的节点
/*
输入：head = [1,2,3,4]
输出：[2,1,4,3]

输入：head = []
输出：[]

输入：head = [1]
输出：[1]
 */
// 重点关注
public class LeetCode_24 {
    public static void main(String[] args) {
        // 构造链表
        ListNode a = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        ListNode b = new ListNode(1);


        // 构造链接
        a.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode head = swapPairs(a);
        printNodes(head);

    }


    // 第3次未解出，差一点点解出。
    public static ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res; // cur节点代表要交换的两个节点的前一个节点，即cur.next = first, first.next = second。

        while(cur.next != null && cur.next.next != null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            // 交换节点，注意交换之后，当前节点cur要移动
            first.next = second.next;
            second.next  = first;
            cur.next = second;
            cur = first;
        }
        return res.next;
    }


    // 第2次未解出
//    public static ListNode swapPairs(ListNode head) {
//        ListNode dum = new ListNode();
//        dum.next = head;
//        ListNode cur = dum;
//
//        while (cur.next != null && cur.next.next != null){
//            ListNode node1 = cur.next;
//            ListNode node2 = cur.next.next;
//            //
//            cur.next = node2;
//            node1.next = node2.next;
//            node2.next = node1;
//            cur = node1;
//        }
//        return dum.next;
//    }











    // 迭代
//    public static ListNode swapPairs(ListNode head) {
//        // 创建虚拟节点，next指向head
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode temp = dummyHead;
//        // 如果没有后两个节点，则提前结束
//        while (temp.next != null && temp.next.next != null) {
//            // 创建两个临时节点
//            ListNode node1 = temp.next;
//            ListNode node2 = temp.next.next;
//            // 交换temp后两个节点
//            temp.next = node2;
//            node1.next = node2.next;
//            node2.next = node1;
//            // temp节点后移动两个节点
//            temp = node1;
//        }
//        return dummyHead.next;
//    }


    /*
    用 head 表示原始链表的头节点，新的链表的第二个节点，用 newHead 表示新的链表的头节点，原始链表的第二个节点，
    则原始链表中的其余节点的头节点是 newHead.next。
    令 head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点。
    然后令 newHead.next = head，即完成了所有节点的交换。最后返回新的链表的头节点 newHead。
     */
    // 递归 O(n),O(n)，该方法返回交换过后的头节点
//    public static ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = head.next; // 记录后指针，即交换后的头节点
//        head.next = swapPairs(newHead.next); // 前指针，即交换前的头节点指向其余节点交换过后的头节点
//        newHead.next = head; // 即交换后的头节点的下一节点是交换前的头节点
//        return newHead; // 返回交换过后的头节点
//    }



    // 第一次未解出，详细看看官方答案
//    public static ListNode mySwapPairs(ListNode head) {
//        ListNode dummy = new ListNode(0, head); // 虚拟节点
//        ListNode first = head; // 后指针
//        ListNode second = dummy; // 前指针
//        while(first.next != null){
//            // 交换相邻两节点
//            ListNode temp = first.next.next;
//            ListNode temp2 = first.next; // 必须要两个临时指针
//            second.next.next = temp;
//            first.next.next = second.next;
//            second.next = first;
//
//            // 提前结束交换
//            if(second.next == null || second.next.next == null){
//                return head;
//            }
//            // 将前、后指针复位
//            second = second.next;
//            first = second.next;
//        }
//        return head;
//    }

}
