package LeetCode.LianBiao.ListNode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }


    public static void printNodes(ListNode head){
        if(head == null) System.out.println("head is null");
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
