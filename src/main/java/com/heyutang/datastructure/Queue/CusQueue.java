package com.heyutang.datastructure.Queue;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CusQueue {

    public int maxSize;
    public int front;
    public int rear;
    public Object[] array;

    public static final Logger logger = LoggerFactory.getLogger(CusQueue.class);

    public CusQueue(){}

    /**
     * 初始化队列
     * @param maxSize
     */
    public CusQueue(int maxSize){
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.front = -1;
        this.rear = -1;

    }

    public void add(Object value){
        if (isFull()){
            logger.debug("队列以满");
            return;
        }
        this.array[++rear] = value;
    }

    public Object get(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return this.array[++front];
    }

    /**
     * 遍历队列
     */
    public void show(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = front + 1; i < this.rear + 1; i++) {
            System.out.printf("arr[%d] = %s\n", i, array[i].toString());
        }
    }

    /**
     * 查看头数据
     * @return
     */
    public Object peak(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return this.array[front + 1];
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }


}
