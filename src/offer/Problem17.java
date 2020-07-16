package offer;

import java.util.Arrays;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/7/9 18:01
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Problem17 {
    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        System.out.println(Arrays.toString(problem17.printNumbers(2)));

    }

    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10,n);
        int[] result = new int[max - 1];
        for(int i = 0; i < max - 1; i++){
            result[i] = i+1;
        }
        return result;
    }
}
