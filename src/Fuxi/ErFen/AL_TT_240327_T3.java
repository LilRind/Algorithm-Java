package Fuxi.ErFen;

import java.util.Scanner;

// 24_04_21 21:12 - 21:40
// 算法考点：二分答案
public class AL_TT_240327_T3 {
    static int n, m;
    static String s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.next();
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r){ // 左闭，右开
            int mid = l + (r-l)/2;
            if(check(mid)){ // 满足每一次修改只能将连续的mid个字符修改成R，修改次数cnt <= m，即mid比目标值大
                r = mid; // 缩小r指针，右开[l，r)，因为mid满足，所以取r=mid
            }else { // mid不满足修改次数cnt <= m，即cnt > m，mid比目标值小，左开，不能取mid，取l=mid+1
                l = mid + 1;
            }
        }
        System.out.println(r); // 输出目标值

    }
    // 满足每一次修改只能将连续的x个字符修改成R，修改次数为cnt <= m
    public static boolean check(int x){
        int cnt = 0; // 修改次数
        for (int i = 0; i<n; i++){
            if(s.charAt(i) == 'W'){ // 执行1次修改
                cnt++; // 执行次数+1
                i += x-1; // 指针移动x位(包括第i位)
            }
        }

        return cnt <= m; // cnt是否<=m，是则x比目标值大或相等，否则x比目标值小。
    }
}





