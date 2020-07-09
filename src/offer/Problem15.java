package offer;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/7/9 16:29
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem15 {

    public static void main(String[] args) {
        Problem15 problem15 = new Problem15();
        System.out.println(problem15.hammingWeight1(9));
        System.out.println(problem15.hammingWeight(00000000000000000000000000001011));
    }

    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        System.out.println(binaryString);
        char[] chars = binaryString.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '1'){
                sum++;
            }
        }
        return sum;
    }

    public int hammingWeight1(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
