package offer;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/5/25 10:46
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 *
 */
public class Problem05 {
    public static void main(String[] args) {
        String string = "We are happy.";
        String s = replaceSpace(string);
        System.out.println(s);
    }
    public static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
