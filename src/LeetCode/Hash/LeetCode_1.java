package LeetCode.Hash;


import java.util.*;

// 1. 两数之和
public class LeetCode_1 {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {3, 2, 4};
        int[] c = {3, 3};

        System.out.println(Arrays.toString(twoSum(a, 9)));
        System.out.println(Arrays.toString(twoSum(b, 6)));
        System.out.println(Arrays.toString(twoSum(c, 6)));

    }

    // 第一次解出，注意map的用法名称
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // 之前写的
    /*
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
     */
}
