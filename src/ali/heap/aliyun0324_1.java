package ali.heap;

import java.util.*;

public class aliyun0324_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        PriorityQueue<Long> heap = new PriorityQueue<>();  // 小根堆
        long res = 0;
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            heap.add(a[i]);
            res = Math.max(res, a[i]); // 保存最大值
        }
        long[] b = new long[m];
        for(int i = 0; i < m; i++) {
            b[i] = scanner.nextLong();
            long score = heap.poll(); // 弹出最小值
            res = Math.max(res, score + b[i]); // 更新最大值
            heap.add(score + b[i]); // 加入(最小值+变化值)
            System.out.println(res);
        }
    }
}