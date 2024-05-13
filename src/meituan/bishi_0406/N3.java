package meituan.bishi_0406;

import java.util.*;

public class N3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n-1];
        int[] c = new int[n-1];

        for (int i = 0; i < n-1; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < n-1; i++) {
            c[i] = scanner.nextInt();
        }

        // Sort the arrays
        Arrays.sort(b);
        Arrays.sort(c);

        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        nums1[0] = b[0];
        nums2[0] = c[0];

        for (int i = 1; i < n - 1; i++) {
            nums1[i] = b[i] - b[i - 1];
            nums2[i] = c[i] - c[i - 1];
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        for(int i = 0; i < n-1; i++){
            // 如果nums1 不包含 nums2[i]，则说明这个值是缺失的那个并且唯一
            if(!set.contains(nums2[i])){ // 8 18 14（6，4） 15 9 1（8，6）
                if(i == n-1){
                    // 先打印完nums1，再打印nums2[i]，例如1 8 6 4
                    for (int num : nums1) {
                        System.out.print(num + " ");
                    }
                    // 再打印nums2[i]
                    System.out.print(nums2[i]);
                    break;
                }else{ // 没到末尾就出现了唯一的缺少值
                    int index = Arrays.asList(nums1).indexOf(nums2[i + 1]);
                    // 先打印nums1[0] 到[index]的结果，再打印nums2[i]，再打印nums1[index]到nums1末尾
                    for (int j = 0; j <= index; j++) {
                        System.out.print(nums1[j] + " ");
                    }
                    // 再打印nums2[i]
                    System.out.print(nums2[i] + " ");
                    // 最后打印nums1[index]到nums1末尾
                    for (int j = index + 1; j < nums1.length; j++) {
                        System.out.print(nums1[j] + " ");
                    }
                    break;
                }
            }
        }

    }
}
