
/**
 * 基于链表实现的栈
 *
 * @author: avenzhong
 * @create: 2019-06-14 16:45
 */
public class StackBasedOnLinkedList {

    private Node top = null;

    public void push(int value){
        Node newNode = new Node(value,null);
        //判断是否栈空
        if (top == null){
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 我用-1表示栈中没有数据。
     */
    public int pop(){
        if (top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }

    public void pringAll(){
        Node p = top;
        while (p != null){
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node{
        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList list = new StackBasedOnLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.pop();
        list.pringAll();
    }
}
