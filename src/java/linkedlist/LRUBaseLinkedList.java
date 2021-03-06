package linked.singlelist;

import java.util.Scanner;

/**
 * 基于单链表LRU算法
 * 1.查找元素的前一个结点
 * 2.如存在则删除原元素，在头结点插入新的元素
 * 3.如不存在，判断是否超过链表长度，是就删除尾结点，然后在头部插入新结点
 * @author avenzhong
 * create 2019-6-10
 * @param <T>
 */
public class LRUBaseLinkedList<T> {


    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Node<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList(){
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity){
        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data){
        Node preNode = findPreNode(data);

        //链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null){
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        }else {
            if (length >= this.capacity){
                //删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }

    }

    private void deleteElemOptim(Node preNode){
        Node temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void insertElemAtBegin(T data){
        Node next = headNode.getNext();
        headNode.setNext(new Node(data,next));
        length++;
    }


    /**
     * 获取查找到元素的前一个结点
     * @param data
     * @return
     */
    private Node findPreNode(T data){
        Node node = headNode;
        while (node.getNext() != null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void deleteElemAtEnd(){
        Node node = headNode;

        //空链表直接返回
        if (node.getNext() == null){
            return;
        }

        while (node.getNext().getNext() != null){
            node = node.getNext();
        }

        Node tmp = node.getNext();
        node.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll(){
        Node node = headNode.getNext();
        while (node != null){
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class Node<T> {

        private T element;

        private Node next;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true){
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}
