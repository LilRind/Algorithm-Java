package meituan.bishi_0324;

import java.util.*;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入数组的长度
        int[] w = new int[n]; // 创建一个整型数组w，用于存储输入的数组元素
        for(int i = 0; i < n; i++) {
            w[i] = scanner.nextInt(); // 循环读取输入的数组元素并存储到数组w中
        }
        scanner.nextLine(); // 读取输入的换行符

        String s = scanner.nextLine(); // 读取输入的字符串，表示颜色
        HashMap<Integer, Character> color = new HashMap<>(); // 创建HashMap，用于存储每个数字对应的颜色
        HashMap<Integer, Integer> pos = new HashMap<>(); // 创建HashMap，用于存储每个数字在数组中的位置
        for(int i = 0; i < n; i++) {
            pos.put(w[i], i); // 将数字及其位置存储到pos中
            color.put(w[i], s.charAt(i)); // 将数字及其对应的颜色存储到color中
        }
        boolean flag = true; // 标志变量，用于判断是否可以排序
        int cnt = 0; // 计数器，记录排序的次数
        for(int i = 0; i < n; i++) {
            if(w[i] == i + 1) { // 如果当前数字已经在正确的位置上，则跳过
                continue;
            }
            // w[i] != i+1，需要交换w[i]的位置和i+1的位置，(i，w[i])和(pos1，i+1)
            int pos1 = pos.get(i + 1); // 获取数字i+1在数组中的位置pos1
            if(color.get(i + 1) == 'W' || color.get(w[i]) == 'W') { // 如果数字i+1或当前数字的颜色为白色，则无法交换，退出循环
                flag = false;
                break;
            }
            // 交换位置（值所对应的），即更新pos<值，位置>
            pos.put(w[i], pos1); // 更新当前数字的位置(pos1，w[i])
            pos.put(i + 1, i); // 更新数字i+1的位置（i+1，i）
            // 交换数字i和数字i+1的位置，即交换值
            int temp = w[i];
            w[i] = w[pos1];
            w[pos1] = temp;
            cnt++; // 计数器加一
        }
        if(!flag) // 如果无法排序，则输出-1
            System.out.println(-1);
        else // 否则输出排序的次数
            System.out.println(cnt);
    }
}
