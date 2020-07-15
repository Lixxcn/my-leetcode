package offer;

import java.util.Arrays;

/**
 * @program: my-leetcode
 * @author: Dawn
 * @create: 2020-07-15 16:37
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Problem21 {
    public int[] exchange(int[] nums) {
        int fin = nums.length - 1;
        for (int fir = 0; fir < fin; fir++) {
            if(nums[fir] % 2 == 0){
                while (true) {
                    if(fin <= fir) break;
                    if (fin == 0 || nums[fin] % 2 == 1) {
                        int tem = nums[fir];
                        nums[fir] = nums[fin];
                        nums[fin] = tem;
                        fin--;
                        break;
                    }
                    else fin--;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }

    public int[] exchange1(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString((new Problem21()).exchange1(new int[]{1,2,3,4})));
//        System.out.println(Arrays.toString((new Problem21()).exchange(new int[]{2,4,6})));
//        System.out.println(Arrays.toString((new Problem21()).exchange(new int[]{1,3,5})));
//        System.out.println(Arrays.toString((new Problem21()).exchange(new int[]{8,10,3,20,12,4,10,8,4,0,5,17,7,20,3})));

    }
}
