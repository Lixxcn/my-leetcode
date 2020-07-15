package offer;

/**
 * @program: my-leetcode
 * @author: Dawn
 * @create: 2020-07-15 15:56
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem20 {

    public boolean isNumber1(String s) {
        char[] chars = s.toCharArray();
        int numE = 0;
        int numA = 0;
        int numB = 0;
        for (int i = 0; i < chars.length; i++) {
            if((chars[i] < 48 && chars[i] != '+' && chars[i] != '-') || (chars[i] > 57 && chars[i] != 'e')){
                return false;
            }
            if(chars[i] == 'e'){
                numE ++;
            }
            if(chars[i] == '+'){
                numA ++;
            }
            if(chars[i] == '-'){
                numB ++;
            }
            if(numE > 1 || numA >2 || numB > 2){
                return false;
            }
        }
        return false;
    }

    public boolean isNumber(String s) {
        s = s.trim();
        boolean flag = true;
//        try {
//            Integer.valueOf(s);
//        } catch (NumberFormatException e) {
//            flag++;
//            e.printStackTrace();
//        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] < 48 && chars[i] != '+' && chars[i] != '-' && chars[i] != '.') || (chars[i] > 57 && chars[i] != 'e')) {
                return false;
            }
        }

        try {
            Double.valueOf(s);
        } catch (NumberFormatException e) {
            flag = false;
            e.printStackTrace();
        }

//        if(false == 0)

        return flag;
    }

    public static void main(String[] args) {
        Problem20 problem20 = new Problem20();
        System.out.println(problem20.isNumber("1 "));
    }

}
