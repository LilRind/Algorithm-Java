package tme.bishi0328;

import java.util.*;

// 哈希表+升序排序+映射
public class tanxin_4 {
    // 主函数，处理输入和输出
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 读取节点数量
        int[] nums = new int[n]; // 创建数组存储节点分类编号
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt(); // 读取每个节点的分类编号
        }
        System.out.println(minSwaps(nums)); // 输出最少交换次数
    }

    // 计算最少交换次数的方法
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone(); // 复制原始数组
        Arrays.sort(sorted); // 对复制数组排序
        Map<Integer, Integer> pos = new HashMap<>(); // 创建映射存储数字位置

        // 初始化映射
        for (int i = 0; i < n; i++) {
            pos.put(nums[i], i);
        }

        int swaps = 0; // 初始化交换次数为0
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) { // 如果当前位置的数字不等于排序后对应位置的数字
                int j = pos.get(sorted[i]); // 获取需要交换的位置
                int temp = nums[i]; // 交换数字
                nums[i] = nums[j];
                nums[j] = temp;
                pos.put(nums[i], i); // 更新映射
                pos.put(nums[j], j);
                swaps++; // 增加交换次数
            }
        }

        return swaps; // 返回交换次数
    }
}
