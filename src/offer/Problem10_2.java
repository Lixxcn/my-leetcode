package offer;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/5/26 18:47
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem10_2 {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    public static int numWays(int n) {//1,2,3,5,
        /*
        1 -> 1
        2 -> 2
        3 -> 3
        4 -> 5
        5 -> 8
        6 -> 13
        7 -> 21
         */
        int[] array = new int[n+1];
        if(n == 0){
            return 1;
        }
        array[0] = 1;
        array[1] = 1;
        if(n >= 2){
            array[2] = 2;
        }
        for (int i = 3; i < n+1; i++) {
            array[i] = (array[i-1] + array[i-2]) % 1000000007;
        }

        return array[n];
    }
}
