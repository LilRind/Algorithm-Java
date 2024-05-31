package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.ListNode;

import java.util.List;

// 灵神：快慢指针，简洁代码
// https://leetcode.cn/problems/linked-list-cycle/solutions/1999269/mei-xiang-ming-bai-yi-ge-shi-pin-jiang-t-c4sw/?envType=study-plan-v2&envId=top-100-liked

// 官方：哈希表、快慢指针。 快慢指针做不出来就用哈希表，但是哈希表太简单了
// https://leetcode.cn/problems/linked-list-cycle/solutions/440042/huan-xing-lian-biao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 141. 环形链表
public class LeetCode_1471 {
    public static void main(String[] args) {

    }

    // 再写，增添条件：考虑fast != null
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // 第一次未解出，需要考虑fast == null的情况
    /*
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
     */

    // 之前写的
    /*
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow = head, fast = head;
        while(fast != null){
            if(fast.next == fast) return true;
            fast = fast.next;
            slow = head;
            while(slow.next != fast){
                if(fast.next == slow) return true;
                slow = slow.next;
            }
        }
        return false;
    }
     */

    // 官方：哈希表
    /*
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
     */

    // 官方：快慢指针
    /*
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
     */
}
