

/**
 * 基于链表实现的队列
 *
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
        queue.enqueue("e");
        queue.enqueue("f");
        queue.dequeue();
        queue.printAll();
    }

    public void enqueue(String value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {

            tail.next = newNode;
            tail =  tail.next;

        }
    }

    public String dequeue() {
        if (head == null) return null;

        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        return value;
    }

    public void printAll(){
        while (head != null){
            System.out.println(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
