package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;


/*
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

输入: numRows = 1
输出: [[1]]
 */

// 灵神：数学，拆解成每列
// https://leetcode.cn/problems/pascals-triangle/solutions/2784222/jian-dan-ti-jian-dan-zuo-pythonjavaccgoj-z596/?envType=study-plan-v2&envId=top-100-liked

// 官方：数学
// https://leetcode.cn/problems/pascals-triangle/solutions/510638/yang-hui-san-jiao-by-leetcode-solution-lew9/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 118. 杨辉三角
public class LeetCode_118 {
    public static void main(String[] args) {
        System.out.println(generate(5));

        System.out.println(generate(1));
    }

    // 更改后：掌握。类似于官方，O(numRows^2)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) { // i为当前行数
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++){ // j为当前列数
                if(j == 0 || j == i){ // 第一行元素为1，每行首元素和末元素为1
                    temp.add(1);
                }else {
                    temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j)); // 利用数学关系填充
                }
            }
            res.add(temp); // 添加当前行
        }
        return  res;
    }

    // 第一次未解出，边界有问题
    /*
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) { // i为当前行数
            for (int j = 0; j < i+1; j++){ // j为当前列数
                List<Integer> temp = new ArrayList<>();
                if(i == 0 || j == 0 || j == i){ // 第一行元素为1，每行首元素和末元素为1
                    temp.add(1);
                }else {
                    temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
                res.add(temp);
            }
        }
        return  res;
    }
     */

    // 灵神：O(numRows^2)
    /*
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> c = new ArrayList<>(numRows); // 预分配空间
        c.add(List.of(1));
        for (int i = 1; i < numRows; i++) { // 每一列的填充
            List<Integer> row = new ArrayList<>(i + 1); // 预分配空间
            row.add(1); // 首列
            for (int j = 1; j < i; j++) { // 中间列
                // 左上方的数 + 正上方的数
                row.add(c.get(i - 1).get(j - 1) + c.get(i - 1).get(j));
            }
            row.add(1); // 末尾列
            c.add(row);
        }
        return c;
    }
     */

}
