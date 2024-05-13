package tme.bishi0328.lianxi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tanxin_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(minSwap(a));
    }

    public static int minSwap(int[] a){
        int[] b = a.clone();
        Arrays.sort(b);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<a.length; i++){
            map.put(a[i], i);
        }
        int count = 0;
        for (int i=0; i<a.length; i++){
            if(a[i] != b[i]){
                int j = map.get(b[i]);
                int tem = a[i];
                a[i] = a[j];
                a[j] = tem;
                map.put(a[i], i);
                map.put(a[j], j);
                count++;
            }
        }

        return count;
    }

}
