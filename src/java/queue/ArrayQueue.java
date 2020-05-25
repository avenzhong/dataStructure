
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * 用数组实现的队列
 *
 * @author: avenzhong
 * @create: 2019-06-14 17:09
 */
public class ArrayQueue {

    private String[] items;

    //数组大小
    private int n = 0;

    //队头下标
    private int head = 0;

    //队尾下标
    private int tail = 0;

    //申请一个大小为capacity的数组
    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
        // 如果tail == n 表示队尾没空间了
        if (tail == n) {
            //tail == n && head == 0表示整个队列都占满了
            if (head == 0){
                return false;
            }
            //数据搬移
            for (int i = head;i < tail;++i){
                items[i - head] = items[i];
            }
            //搬移完之后更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String dequeue(){
        //如果head == tail 表示队列为空
        if (head == tail) return null;

        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " " + "i=" + i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue("4");
        queue.enqueue("4");
        queue.enqueue("4");

        queue.enqueue("5");

        queue.printAll();

    }
}
