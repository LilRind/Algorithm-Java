package CodeTop;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 灵神：先让
// https://leetcode.cn/problems/linked-list-cycle-ii/solutions/1999271/mei-xiang-ming-bai-yi-ge-shi-pin-jiang-t-nvsq/

// 返回存在环的那个节点
// 142. 环形链表 II
public class LeetCode_142 {
    public static void main(String[] args) {
        // 构造链表
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        // 构造环
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        // hash表存储
//        System.out.print("哈希表存储：");
//        System.out.println((hashDetectCycle(node1) != null) ? hashDetectCycle(node1).val : null);
        // 快慢指针
        System.out.print("快慢指针：节点值为");
        System.out.println((detectCycle(node1) != null) ? detectCycle(node1).val : null);
    }


    // 灵神：先让快、慢指针指向head节点，再判断fast、fast.next不为空，
    // 直到快、慢指针相遇，相遇后循环遍历head、慢节点，直到相遇返回 slow 节点，否则无环
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

    // 3，自己写的，成功，但要注意如果要让 fast = head.next，那么必须判断head == null
    /*
    public static ListNode detectCycle(ListNode head) {
         if(head == null){ // 如果要让 fast = head.next，那么必须判断head == null
             return null;
         }
         ListNode dummy = new ListNode(0, head);
         ListNode slow = head, fast = head.next;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast){
                 while(dummy != slow){
                     dummy = dummy.next;
                     slow = slow.next;
                 }
                 return slow;
             }
         }
         return null;
     }
     */


    /*
    第二次写，哈希表方法差不多熟悉了，但是快慢还不是很熟悉
     */
    // 哈希表存储遍历过的节点
    /*
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        Set<ListNode> set = new HashSet<>();
        while(temp != null){
            if(set.contains(temp)){ // 一旦包含，说明有环，提前返回。
                return temp;
            }
            set.add(temp); // 注意这里，可以像官方一样写在if-else里。
            temp = temp.next;
        }
        return null;
    }

    // 快慢指针 + 头指针与慢指针相遇
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return null;
            }

            if(slow == fast){
                ListNode pre = head;
                while(pre != slow){
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }
    */





    /*
    第一次写
     */
    // 哈希存储遍历过的节点，
//    public static ListNode hashDetectCycle(ListNode head) {
//        ListNode pos = head;
//        Set<ListNode> visited = new HashSet<ListNode>();
//        while (pos != null) {
//            if (visited.contains(pos)) {
//                return pos;
//            } else {
//                visited.add(pos);
//            }
//            pos = pos.next;
//        }
//        return null;
//    }
//
//    // 快慢指针
//    public static ListNode detectCycle(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode slow = head, fast = head;
//        while (fast != null) {
//            // 移动slow
//            slow = slow.next;
//            // 每一次移动fast，都要进行判断是否为null
//            if (fast.next != null) {
//                fast = fast.next.next;
//            } else {
//                return null;
//            }
//            // 当fast与slow相遇时，ptr、slow同时移动直到相遇
//            if (fast == slow) {
//                ListNode ptr = head;
//                while (ptr != slow) {
//                    ptr = ptr.next;
//                    slow = slow.next;
//                }
//                return ptr;
//            }
//        }
//        return null;
//    }

}
