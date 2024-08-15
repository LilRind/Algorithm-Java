package CodeTop;

// K神：
// https://leetcode.cn/problems/implement-queue-using-stacks/solutions/2363977/232-yong-zhan-shi-xian-dui-lie-qing-xi-t-pi4l/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 232. 用栈实现队列
// https://leetcode.cn/problems/implement-queue-using-stacks/description/
public class LeetCode_232 {

    public static void main(String[] args) {
        // 输入
        String[] commands = {"MyQueue", "push", "push", "peek", "pop", "empty"}; // 操作名称
        int[][] arguments = { {}, {1}, {2}, {}, {}, {} }; // 每个操作名称对应的参数

        // 输出列表
        List<Object> output = new ArrayList<>();

        // 构造 MyQueue 对象
        MyQueue obj = null;

        // 遍历所有的命令和对应的参数
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "MyQueue":
                    obj = new MyQueue();
                    output.add(null); // 构造函数没有返回值
                    break;
                case "push":
                    int x = arguments[i][0];
                    obj.push(x);
                    output.add(null); // push 操作没有返回值
                    break;
                case "peek":
                    int peekResult = obj.peek();
                    output.add(peekResult); // 添加 peek 的返回值
                    break;
                case "pop":
                    int popResult = obj.pop();
                    output.add(popResult); // 添加 pop 的返回值
                    break;
                case "empty":
                    boolean emptyResult = obj.empty();
                    output.add(emptyResult); // 添加 empty 的返回值
                    break;
            }
        }

        // 输出结果
        System.out.println(output);
    }

    // K神：双栈 实现队列
    static class MyQueue {
        private Stack<Integer> A; // 输入栈
        private Stack<Integer> B; // 输出栈

        public MyQueue() { // 构造方法，创建双栈
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) { // 输入栈装入元素
            A.push(x);
        }

        public int pop() { // 弹出栈
            int peek = peek(); // 调用查看栈顶方法，拿到栈顶元素
            B.pop(); // 输出栈弹出栈顶元素
            return peek;
        }

        public int peek() { // 查看栈顶元素，栈内元素不弹出
            if (!B.isEmpty()) return B.peek(); // 如果 B 不为空，返回 B 栈顶元素
            if (A.isEmpty()) return -1; // B 为空的情况下，A 也为空，则没有元素，返回 -1
            while (!A.isEmpty()){ // A 不为空，这时需要把 A 的全部元素放入 B 中
                B.push(A.pop()); // 弹出 A 的元素，放入 B 中
            }
            return B.peek(); // 返回 B 的栈顶元素
        }

        public boolean empty() { // 判断是否为空，要判断 A、 B 是否都为空
            return A.isEmpty() && B.isEmpty();
        }
    }


}

// 2
/*
class MyQueue {
    private Stack<Integer> A;
    private Stack<Integer> B;

    public MyQueue(){
        A = new Stack<>();
        B = new Stack<>();
    }

    public int pop(){
        int peek = peek();
        B.pop();
        return peek;
    }

    public int peek(){
        if(!B.isEmpty()) return B.peek();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty()) B.push(A.pop());
        return B.peek();
    }

    public void push(int x){
        A.push(x);
    }

    public boolean empty(){
        return A.empty() && B.empty();
    }

}

 */
