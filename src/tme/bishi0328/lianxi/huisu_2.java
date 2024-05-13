package tme.bishi0328.lianxi;

import java.util.Scanner;

public class huisu_2 {
    static int n;
    static int[] nums;
    static boolean[] vis;
    static int sum = 0;


    public static boolean isPrime(int x){
        if(x<2) return false;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x % i == 0) return false;
        }
        return true;
    }

    public static void back(int idx, int pre){
        if(idx == n){
            sum++;
            return;
        }
        for (int i=0; i<n; i++){
            if(!vis[i]){
                if(idx == 0 || isPrime(nums[i]+pre)){
                    vis[i] = true;
                    back(idx+1, nums[i]);
                    vis[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        back(0, 0);
        System.out.println(sum);
        scanner.close();

    }
}

