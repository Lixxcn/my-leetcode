package offer;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/7/10 17:56
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem19 {
    public static void main(String[] args) {
        Problem19 problem19 = new Problem19();
        System.out.println(problem19.isMatch("mississippi","mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

}
