package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

import static LeetCode.LianBiao.ListNode.ListNode.printNodes;

// 19. 删除链表的倒数第 N 个结点
// 做出来了，但是代码可以精简
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

        // 示例3
        ListNode c = new ListNode(1);
        ListNode c2 = new ListNode(2);

        c.next = c2;

        ListNode tempNode3 = removeNthFromEnd(c, 1);
        printNodes(tempNode3);
    }

    // 第3次写。成功解出
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode();
        dum.next = head;

        ListNode s = dum, f = head;
        while (n-- > 0){
            f = f.next;
        }

        while (f != null){
            s = s.next;
            f = f.next;
        }

        s.next = s.next.next;
        /* 将被删除的节点的next置为null
        ListNode delNext = s.next.next;
        s.next.next = null; // 可以不需要这一步
        s.next = delNext;
         */

        return dum.next;
    }



    // 第二次写，部分示例通过，再思考再写一遍
    /*
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = dummyNode;
        while(fast.next != null && n-- > 0){
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = fast;

        return dummyNode.next;
    }
    // 再写，成功了，添加了切割被节点的引用代码
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode slow = dummyNode, fast = head;
        while(n-- > 0){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        // 删除间隔节点，切割被删除节点的引用
        ListNode temp = slow.next; // 暂时保存需要删除节点的指向原链表的引用
        slow.next = slow.next.next;
        temp.next = null; // 切割被删除节点的指向原链表的引用
        return dummyNode.next;
    }
     */


    // 第一次写，官方的写法
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0, head); // 虚拟节点
//        ListNode first = head; // 后指针
//        ListNode second = dummy; // 前指针
//        for (int i = 0; i < n; ++i) {
//            first = first.next;
//        }
//        while (first != null) {
//            first = first.next;
//            second = second.next;
//        }
//        second.next = second.next.next; // 删除了间隔的节点，但是间隔的节点.next指向没有删除
//        ListNode ans = dummy.next;
//        return ans;
//    }


    // 第一次做法，成功是成功了，但是代码太多了
    /*
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
    */

    // 官方做法：计算链表长度，这种方法逻辑上很简单，但需要遍历1-2次链表，O(L)，O(1)
    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
     */


}
