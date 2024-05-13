package TengXunYunZhi.bishi_24_0429;

import java.util.*;
/*
正整数x，将一些染红，使染红数位数字之和等于没染红数位数字之和。x范围1到10的18次方，
例如；1234567
输出yes
说明3，4，7染红，则1+2+5+6=3+4+7。
例如；23
输出No
 */

public class T2 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] nums = in.nextLine().toCharArray();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += (nums[i] - '0');
        }
        boolean flag = false;
        for(int i = 1; i <= n; i++){
            if(check(0, 0, i, 0, n, nums)){
                flag = true;
                break;
            }
        }

        System.out.println(flag? "Yes":"No");;
    }

    static boolean check(int cnt, int curLen ,int len, int idx, int n, char[] nums){
        if(cnt == sum - cnt){
            return true;
        }
        if(sum - cnt < cnt)
            return false;

        if(curLen >= len)
            return false;
        for(int i = idx; i < n; i++){
            if(check(cnt + nums[i] - '0', curLen + 1, len, i + 1, n, nums))
                return true;
        }

        return false;
    }

}