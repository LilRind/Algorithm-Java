package Lianxi.ErFen;

import java.util.*;

// 注意这里删除的是[l, r]的区间
// 算法考点：双指针 二分查找
public class AL_TT_240327_T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取数组长度
        List<Integer> nums = new ArrayList<>(); // 创建一个动态数组用于存储数组元素
        // 读取数组元素并添加到列表中
        for (int i = 0; i < n; i++)
            nums.add(scanner.nextInt());

        int i = 1, j = n - 2; // 初始化两个指针 i 和 j，用于找到需要删除的区间
        // 找到第一个逆序对的起始位置
        while (nums.get(i) >= nums.get(i - 1))
            ++i;
        // 找到最后一个逆序对的结束位置
        while (nums.get(j) <= nums.get(j + 1))
            --j;
        --i; // 调整 i 的位置，使其指向逆序对的起始位置
        ++j; // 调整 j 的位置，使其指向逆序对的结束位置

        if (i > j) { // 如果整个数组都是升序的，即没有逆序对
            long cur = (1L + n) * n / 2L; // 计算有序数组的和
            System.out.println(cur); // 输出结果
        } else { // 如果存在逆序对
            int ans = i + 1 + n - j; // 计算第一种方案的结果（即删除区间外的元素数量）
            ++ans; // 特殊情况：数组可以全部删除，增加一个单位

            // 将数组分为左右两部分
            List<Integer> lft = nums.subList(0, i + 1);
            List<Integer> rgt = nums.subList(j, n);

            // 遍历左半部分的元素，统计右半部分中大于当前元素的个数
            for (int l : lft) {
                // 使用二分查找在右半部分找到第一个大于当前元素的位置
                int it = Collections.binarySearch(rgt, l);
                // 未找到元素（l大于rgt所有元素，插入点为rgt.size()），
                // 其值为 - (插入点) - 1，，处理二分查找返回的负数索引，ans会加上0
                if (it < 0) it = -(it + 1);
                // 统计右半部分中大于当前元素的元素个数，并累加到答案中
                ans += rgt.size() - it;
            }
            System.out.println(ans); // 输出结果
        }
    }
}





