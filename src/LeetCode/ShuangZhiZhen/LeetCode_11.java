package LeetCode.ShuangZhiZhen;

// 11. 盛最多水的容器
public class LeetCode_11 {
    public static void main(String[] args) {

    }

    // 掌握
    // 再写，核心思想是，一开始 l指向数组首位，r指向数组末位，
    // 我们记录容器的最小高度h，只有当我们找到height[x] > h，才有可能更新max值，
    // 因为底(r - l)是在变小的，只有当height[x]变大，才有可能大于原先的max值
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1; // l指向数组首位，r指向数组末位
        int resMax = 0;
        while (l < r){
            int h = Math.min(height[l], height[r]); // 记录容器的最小高度h
            int tempV = h * (r - l);
            resMax = Math.max(resMax, tempV);
            // 如果height[l] <= h最小高度，则指针右移，直到找到大于h的索引
            while (l < n && height[l] <= h){
                l++;
            }
            // 如果height[l] <= h最小高度，则指针左移，直到找到大于h的索引
            while (r >= 0 && height[r] <= h){
                r--;
            }
        }
        return resMax;
    }

    // 第一次未解出，逻辑是对的，但是会超时O(N^2)
    /*
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int temp = Math.min(height[i], height[j]) * (j-i);
                max = Math.max(temp, max);
            }
        }
        return max;
    }
     */

    // 掌握，之前写的
    /*
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = 0;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            int num = h * (right - left);
            if(num > max){
                max = num;
            }
            while(left < n && height[left] <= h){
                left++;
            }
            while(right >= 0 && height[right] <= h){
                right--;
            }
        }
        return max;
    }
     */

}
