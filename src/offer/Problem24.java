package offer;

import java.util.ArrayList;

/**
 * @program: my-leetcode
 * @author: Dawn
 * @create: 2020-07-15 18:16
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem24 {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        ListNode temp1 = head;
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        while (temp1 != null){
            temp1.val = list.get(--n);
            temp1 = temp1.next;
        }


        return temp;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode temp = head;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        Problem24 problem24 = new Problem24();
        head = problem24.reverseList(head);
        System.out.println("+++++++++++++++++");
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
