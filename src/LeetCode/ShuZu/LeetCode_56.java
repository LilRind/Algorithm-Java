package LeetCode.ShuZu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


// 灵神：左端点排序。掌握
// https://leetcode.cn/problems/merge-intervals/solutions/2798138/jian-dan-zuo-fa-yi-ji-wei-shi-yao-yao-zh-f2b3/?envType=study-plan-v2&envId=top-100-liked

// 官方解法：排序，太繁琐了
//https://leetcode.cn/problems/merge-intervals/solutions/203562/he-bing-qu-jian-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

// 56. 合并区间
// https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-100-liked

public class LeetCode_56 {
    public static void main(String[] args) {

        // 测试
        int[][] n1 = {{1,3}, {2,6}, {8,10}, {15,18}};
        for (int[] d1 : merge(n1)){
            for(int d2 : d1){
                System.out.print(d2 + ",");
            }
            System.out.print(" ");
        }

    }

    // 2
    // 掌握。 灵神：左端点排序
    public static int[][] merge(int[][] intervals) {
        // lambda 表达式代表一个 Comparator<int[]>，用于比较两个 int[] 数组的第一个元素，从而对 intervals 数组进行排序。
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序
        List<int[]> ans = new ArrayList<>(); // 返回的数组 ans
        for (int[] p : intervals) { // 遍历每个intervals数组中的元素p
            int m = ans.size(); // 拿到二维数组的个数 m
            // 检查 m > 0，并且该 p 的左节点值 <= ans 最后一个元素的右节点值，那么可以合并
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) {
                // 更新ans最后一个元素的右端点最大值。比较大小是因为可能出现比如：[1, 4]包含[2, 3] 的情况
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]);
            } else { // 不相交，无法合并。或者是第1个区间
                ans.add(p); // 直接将数组 p 加入合并数组 ans
            }
        }
        return ans.toArray(new int[ans.size()][]); // 返回前需要做变换
        /*
        new int[ans.size()][] 创建的是一个二维数组，但它的第二维度（内部的数组）还没有初始化。
        toArray 会将 ans 中的所有 int[]数组复制到一个新的 int[][] 数组中。

         */
    }



    // 1
    // 官方解法：排序
//    public static int[][] merge(int[][] intervals) {
//        // 如果 intervals 为空数组，则直接返回空数组
//        if (intervals.length == 0) {
//            return new int[0][2];
//        }
//        // 按照区间的起始位置进行排序
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[0] - interval2[0];
//            }
//        });
//        // 创建一个列表来存储合并后的区间
//        List<int[]> merged = new ArrayList<int[]>();
//        // 遍历排序后的区间数组
//        for (int i = 0; i < intervals.length; ++i) {
//            int L = intervals[i][0], R = intervals[i][1];
//            // 如果 merged 列表为空或者当前区间的起始位置大于 merged 列表中最后一个区间的结束位置
//            // 则将当前区间加入到 merged 列表中
//            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
//                merged.add(new int[]{L, R});
//            } else {
//                // 否则，更新 merged 列表中最后一个区间的结束位置为当前区间的结束位置与原结束位置的最大值，因为可能会出现如[1, 6]、[2, 4]的情况。
//                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
//            }
//        }
//        // 将列表转换为数组并返回
//        return merged.toArray(new int[merged.size()][]);
//    }
}
