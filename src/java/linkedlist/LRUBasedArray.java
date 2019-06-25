package java.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author: avenzhong
 * @create: 2019-06-10 17:32
 *
 * 基于数组实现的LRU缓存
 *  1. 空间复杂度为O(n)
 *  2. 时间复杂度为O(n)
 *  3. 不支持null的缓存
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T,Integer> holder;

    public LRUBasedArray(){
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity){
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T,Integer>(capacity);
    }

    public void offer(T object){
        if (object == null){
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        Integer index = holder.get(object);
        if (index == null){
            if (true){

            }else {

            }
        }else {

        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     * @param end
     */
    public void update(int end){
        T target = value[end];

    }

    public void cache(T object,int end){

    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     * @param object
     */
    public void removeAndCache(T object){

    }

    private void rightShift(int end){

    }




}
