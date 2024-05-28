package LeetCode.LianBiao.ListNode;

public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static void printNodes(Node head){
        if(head == null) System.out.println("head is null");
        while(head != null){
            if(head.random != null){
                System.out.println(head.val + " " + head.random.val);
            }else {
                System.out.println(head.val + " " + "random is null");
            }
            head = head.next;
        }

    }

}