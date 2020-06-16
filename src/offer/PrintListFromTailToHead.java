package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description 输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：这是典型的后进先出，我们可以用栈实现这种顺序。每经过一个结点的时候，把该结点放到一个栈中。
 * 当遍历完整个链表后，再从栈顶开始逐个输出节点的值，此时输出的节点顺讯已经反转过来了
 * @author: zhongwenjian
 * @create: 2020-06-16 22:32
 */
public class PrintListFromTailToHead {

    public static ArrayList<Integer> printListFromTailToHead(Node listNode){
        Stack<Integer> stack = new Stack<>();

        while (listNode != null){
            stack.push(listNode.data);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;

    }

    public static class Node{
        private int data;
        private Node next = null;

        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {

    }
}
