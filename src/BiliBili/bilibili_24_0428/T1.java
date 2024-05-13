package BiliBili.bilibili_24_0428;

import java.util.ArrayList;
import java.util.Scanner;

/*
有n个结点的树,每个结点为红或黑,有多少条简单路径恰好过一个红点和一个黑点。
例如:
3(节点数，1到10的5次方)
BRB(b为黑，r为红)
1 2(12之间有边)
2 3(23之间有边)
输出:
2
说明:有12，23路径恰好有一个红点和一个黑点
 */
// 反思一下，不要相信GPT
// 12:04 - 12:59
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] colors = new char[n+1];
        String s = sc.next();
        for(int i = 1; i<=n; i++){
            colors[i] = s.charAt(i-1);
        }
        // 边
        int count = 0;
        for(int i = 1; i <= n-1; i++){
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            if(colors[e1] != colors[e2]){
                count++;
            }
        }
        System.out.println(count);
    }
}

/*
3
BRB
1 2
2 3

输出:
2

4
BRRB
1 2
1 3
2 4

输出:
2

 */

/*
判断每条路径是否包含多个红节点和一个黑节点
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] colors = new char[n+1];
        String s = sc.next();
        for(int i = 1; i<=n; i++){
            colors[i] = s.charAt(i-1);
        }


        // 边
        ArrayList<Integer>[] listArray = new ArrayList[n+1];
        for (int i = 1; i <= n-1; i++) {
            listArray[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= n-1; i++){
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
        }

        int count = 0;
        for (int i = 1; i<= n-1; i++){
            for(int j = 0; j<listArray[i].size(); j++){
                if (j <= n && colors[i] != colors[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}


 */