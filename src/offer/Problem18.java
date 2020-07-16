package offer;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/7/10 9:55
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem18 {
    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode listNode = problem18.deleteNode(head, 5);
        while (true){
            System.out.println(listNode.val);
            listNode = listNode.next;
            if(listNode == null) break;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {

        ListNode temp = head;
        if(head.val == val){
            return head.next;
        }

        while (head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
                break;
            }

            head = head.next;
        }
        return temp;
    }
}
