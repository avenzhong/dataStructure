

/**
 * 基于链表实现的队列
 * @author: avenzhong
 * @create: 2019-06-25 16:21
 */
public class QueueBasedOnLinkedList {

    //队列的队头和队尾
    private Node head = null;
    private Node tail = null;


    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.dequeue();
        queue.printAll();
    }
    public void enqueue(String value){
        if (tail == null){
            Node newNode = new Node(value,null);
            head = newNode;
            tail = newNode;
        }else {
            tail.next = new Node(value,null);
            tail = tail.next;
        }
    }

    public String dequeue(){
        if (head == null) return null;

        String value = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return value;
    }

    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.println(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node{
        private String data;
        private Node next;

        public Node(String data,Node next){
            this.data = data;
            this.next = next;
        }

        public String getData(){
            return data;
        }
    }
}
