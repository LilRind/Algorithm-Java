package Fuxi.MoNi_ShuJuJieGou;

import java.util.*;

// 不熟练，还得继续练习
// 24_04_22 9:45 - 9:54
// 算法考点：模拟 自定义排序
public class ELeMe_240327_T2 {
    // 主方法用于循环处理多个测试用例
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] q = new int[n];
        List<Pair> ans = new ArrayList<>();
        for (int i = 0; i<n; i++){
            q[i] = scanner.nextInt();
            ans.add(new Pair((q[i] + m - 1) / m, i + 1));
        }
        Collections.sort(ans);
        for (Pair i: ans){
            System.out.print(i.second + " ");
        }


    }
}
class Pair implements Comparable<Pair>{
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public int compareTo(Pair o){
        return Integer.compare(this.first, o.first); // 升序
    }
}
