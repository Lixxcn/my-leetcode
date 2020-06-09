package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/5/25 11:02
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem06 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        int[] ints = reversePrint1(listNode1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        int num = stack.size();
        int[] ints = new int[num];
        for (int i = 0; i < num; i++) {
            ints[i] = stack.pop().val;
        }
        return ints;
    }

    public static int[] reversePrint1(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
//        ListNode temp = head;
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        int num = stack.size();
        int[] ints = new int[num];
        for (int i = 0; i < num; i++) {
            ints[i] = stack.pop().val;
        }
        return ints;
    }

    public static int[] reversePrint2(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int num = stack.size();
        int[] ints = new int[num];
        for (int i = 0; i < num; i++) {
            ints[i] = stack.pop();
        }
        return ints;
    }
}
