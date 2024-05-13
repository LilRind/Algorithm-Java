package Lianxi.ErFen;

import java.util.Scanner;

// 算法考点：二分答案
//类似题目练习
public class AL_TT_240327_T3 {
    static int n, m;
    static String s;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 读取字符串长度
        m = scanner.nextInt(); // 最大修改次数
        s = scanner.next();
        int l = 0, r = (int)1e9;
        while (l<r){
            int mid = l + (r - l) / 2;
            if(check(mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(r);
        // 读取数组元素并添加到列表
    }

    // 判断是否x长度的修改次数是否<=m
    public static boolean check(int x){
        int cnt = 0;
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == 'W'){
                cnt++;
                if(x==0) return false;
                i += x - 1; // 跳过x个字符，即假设x个字符变为'R'
            }
        }
        return cnt <= m; // 判断修改数是否 <= m
    }
}





