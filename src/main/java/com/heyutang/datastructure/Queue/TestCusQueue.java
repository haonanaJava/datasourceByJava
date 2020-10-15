package com.heyutang.datastructure.Queue;


public class TestCusQueue {
    public static void main(String[] args) {
        CusCircleQueue queue = new CusCircleQueue(5);
        queue.add("heyutang");
        queue.add("xiangtianzaijie5cm");
        queue.add("asdasdas");
        //测试队列满的情况
        queue.add("asdasd");
//        String o = (String) queue.get();
//        String o1 = (String) queue.get();
//        System.out.println("get queue:"+ o + o1);
        System.out.println("queue's size is " + queue.size());
        System.out.println("queue's header is " + queue.peak());
        queue.show();
    }
}
