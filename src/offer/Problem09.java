package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/5/26 11:44
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem09 {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        System.out.println(obj.deleteHead());
        obj.appendTail(3);
        obj.appendTail(4);
        System.out.println(obj.deleteHead());
        obj.appendTail(1);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        obj.appendTail(0);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}

class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1= new ArrayDeque<Integer>();
        stack2= new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()){
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int num = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return num;
    }
}

class CQueue1 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public CQueue1() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }
}

class CQueue2 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;

    public CQueue2() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        s1.push(value);
        size++;
    }

    public int deleteHead() {
        if(size==0){
            return -1;
        }
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        size--;
        return s2.pop();

    }

}

