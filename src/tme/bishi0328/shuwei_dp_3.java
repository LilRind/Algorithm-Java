package tme.bishi0328;

// 数位dp，暂时不会
class shuwei_dp_3 {
    private static char[] s;  // 定义字符数组s，用于存储数字字符串的字符数组
    private static Integer[][][][] memo;  // 定义一个四维数组memo，用于记忆化搜索结果

    public static void main(String[] args) {
        System.out.println(countLuckyNumbers(500, 980060000));
    }

    public static int countLuckyNumbers(long l, long r) {
        s = String.valueOf(l - 1).toCharArray();  // 将l-1转换为字符数组存储在s中
        memo = new Integer[20][2][2][20];  // 初始化memo数组，20表示数字长度的最大值，2表示true/false，20表示幸运数字的数量范围
        int lCnt = dfs(0, true, false, 0);  // 调用dfs函数计算区间[l,r]内幸运数字的数量
        s = String.valueOf(r).toCharArray();  // 将r转换为字符数组存储在s中
        memo = new Integer[20][2][2][20];  // 重新初始化memo数组
        int rCnt = dfs(0, true, false, 0);  // 调用dfs函数计算区间[l,r]内幸运数字的数量
        return rCnt - lCnt;  // 返回区间内幸运数字的数量
    }

    private static int dfs(int pos, boolean limit, boolean num, int cnt) {
        if (pos == s.length) {  // 如果遍历到数字的最后一位
            return cnt == 0 ? 1 : 0;  // 如果幸运数字的数量为0，则返回1，否则返回0
        }
        if (memo[pos][limit ? 1 : 0][num ? 1 : 0][cnt + 9] != null) {  // 如果当前状态已经计算过
            return memo[pos][limit ? 1 : 0][num ? 1 : 0][cnt + 9];  // 直接返回已计算的结果
        }
        int res = 0;  // 初始化结果为0
        if (!num) {  // 如果当前位数字未确定
            res = dfs(pos + 1, false, false, cnt);  // 继续向后递归，当前位数字未确定
        }
        int up = limit ? s[pos] - '0' : 9;  // 根据limit确定当前位数字的范围
        for (int i = num ? 0 : 1; i <= up; i++) {  // 遍历当前位数字可能的取值
            res += dfs(pos + 1, limit && i == up, true, cnt + (i % 2 == 0 ? -1 : 1));  // 递归计算结果并累加到res中
        }
        memo[pos][limit ? 1 : 0][num ? 1 : 0][cnt + 9] = res;  // 将计算结果存储到memo数组中
        return res;  // 返回计算结果
    }
}

