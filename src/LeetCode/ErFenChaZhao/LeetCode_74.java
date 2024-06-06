package LeetCode.ErFenChaZhao;


// 灵神：一维数组二分查找、排除法
// https://leetcode.cn/problems/search-a-2d-matrix/solutions/2783931/liang-chong-fang-fa-er-fen-cha-zhao-pai-39d74/

// 官方：方法一：两次二分查找
// https://leetcode.cn/problems/search-a-2d-matrix/solutions/688117/sou-suo-er-wei-ju-zhen-by-leetcode-solut-vxui/

// 重点关注
// 74. 搜索二维矩阵
public class LeetCode_74 {
    public static void main(String[] args) {
        int[][] a1 = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(a1, 3));

        int[][] b1 = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(b1, 13));
    }
    // 第二次做，解出
    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            int x = matrix[mid / n][mid % n]; // 假如3行2列的数组，可以很快推导出来行i=mid/n，列j=mid%n
            if(x == target){
                return true;
            }
            if(x < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return false;
    }
     */

    // 第一次未解出，再写
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while(l <= r){
            int mid = (l + r) >>> 1;
            int res = matrix[mid / n][mid % n];
            if(res == target){
                return true;
            }
            if(res < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }

    // 灵神：一维二分查找
    // 掌握
    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = -1;
        int right = m * n;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }
            if (x < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return false;
    }
     */

    // 灵神：排除法
    // 掌握
    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) { // 还有剩余元素
            if (matrix[i][j] == target) {
                return true; // 找到 target
            }
            if (matrix[i][j] < target) {
                i++; // 这一行剩余元素全部小于 target，排除
            } else {
                j--; // 这一列剩余元素全部大于 target，排除
            }
        }
        return false;
    }
     */

}
