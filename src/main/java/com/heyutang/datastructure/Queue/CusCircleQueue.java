package com.heyutang.datastructure.Queue;

public class CusCircleQueue extends CusQueue{

    /**
     * 初始化队列
     *
     * @param maxSize
     */
    public CusCircleQueue(int maxSize) {
        this.maxSize = maxSize;
        rear = 0;
        front = 0;
        array = new Object[maxSize];
    }

    @Override
    public void add(Object value) {
        if (isFull()){
            logger.debug("队列已满");
            return;
        }
        array[rear] = value;
        //考队列是否有空间
        rear = (rear + 1) % maxSize;
    }

    @Override
    public Object get() {
        if (isFull()){
            logger.debug("队列已满");
            return null;
        }
        Object temp = array[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    @Override
    public void show() {
        if (isEmpty()){
            logger.debug("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            logger.info(i % maxSize + (String) array[i % maxSize]);
        }
    }

    public int size(){
        return (rear - front + maxSize) % maxSize;
    }

    @Override
    public Object peak() {
        if (isEmpty()){
            logger.debug("数组为空");
        }
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
}
