package Lianxi.MoNi_ShuJuJieGou;

import java.util.*;

/*
5 4
1145 1200 1300 1500 1600
10 270 450 500
*/
// 算法考点：哈希表+贡献法计数+快速幂
public class AL_TT_240327_T1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        PriorityQueue<Long> heap = new PriorityQueue<>();  // 小根堆

        long res = 0;
        long[] a = new long[n];
        long[] b = new long[m];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            heap.add(a[i]);
            res = Math.max(res, a[i]); // res是a[]的最大值
        }
        for(int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
            long score = heap.poll(); // 弹出当前账号的最小值
            res = Math.max(res, score + b[i]); // 比较最小值+变化值与最大值的大小
            heap.add(score + b[i]); // 加入变化值
            System.out.println(res); // 输出最大值
        }

//        Queue<Integer> queueA = new PriorityQueue<>((v1, v2) -> v2 - v1);
//
//        PriorityQueue<Long> A = new PriorityQueue<>(new Comparator<Long>() {
//            @Override
//            public int compare(Long o1, Long o2) {
//                // 由于可能存在整数溢出，需要改写比较逻辑
//                return o2.compareTo(o1);
//            }
//        });

//        long[] c = new long[n];
//        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
//        for(int i = 0; i < n; i++) {
//            c[i] = scanner.nextLong();
//            pq.add(c[i]);
//        }
//        for(int i = 0; i < n; i++) {
//            System.out.println(pq.poll());
//        }


    }
}
