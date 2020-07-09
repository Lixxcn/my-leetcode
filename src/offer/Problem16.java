package offer;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/7/9 17:13
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem16 {
    public static void main(String[] args) {
        Problem16 problem16 = new Problem16();
        System.out.println(problem16.myPow1(2.0,-2));
        System.out.println(Math.pow(2.0,-2));
    }
    public double myPow(double x, int n) {
        double res = 1;
        if(n == 0){
            return 1;
        }
        if(x == 1.0){
            return 1.0;
        }
        if(n > 0) {
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
        }else if(n < 0 && x != 0){
            for (int i = 0; i > n; i--){
                res = res / x;
            }
        }
        return res;
    }



    public double myPow1(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
