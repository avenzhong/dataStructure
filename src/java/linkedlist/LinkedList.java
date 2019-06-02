package java.linkedlist;

/**
 * 1) 单链表反转
 * 2）链表中环的检测
 * 3）两个有序的链表合并
 * 4）删除链表倒数第n个结点
 * 5）求链表的中间结点
 *
 * author:avenZhong
 */
public class LinkedList {


    //单链表反转
    public static Node reverse(Node list){
        Node curr = list,pre = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1,null);
        Node pre = reverse(node);
        System.out.println(pre);
    }
    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }
}
