package Fuxi.DP;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_674 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i-1] < nums[i]){
                f[i] = f[i-1] + 1;
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}
