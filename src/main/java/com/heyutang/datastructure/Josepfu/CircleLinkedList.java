package com.heyutang.datastructure.Josepfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CircleLinkedList {

    private Node first = null;

    private static final Logger logger = LoggerFactory.getLogger(CircleLinkedList.class);

    public void start(int sNum, int step){
        if ( sNum < 0 || step < 0 ){
            logger.error("非法传参");
            return;
        }
        /*
         * 将sup移动到first的后一个位置
         */
        Node sup = first;
        while( sup.getNext() != first ){
            sup = sup.getNext();
        }
        /**
         * 将 first 和 sup 移动到指定sNum的位置
         */
        for (int i = 0; i < sNum - 1; i++){
            first = first.getNext();
            sup = sup.getNext();
        }

        while ( sup != first ){
            for (int i = 0; i < step - 1; i++) {
                first = first.getNext();
                sup = sup.getNext();
            }
            logger.debug("淘汰者"+first.getId());

            first = first.getNext();
            sup.setNext(first);
        }
        logger.debug("最后的赢家" + first.getId());
    }

    public void remove(int index){

    }

    /**
     * 将链表以数字填充
     * @param num
     */
    public void fillByNums(int num){
        if( num < 0 ){
            logger.error("无效参数");
            return;
        }
        Node current = null;
        for (int i = 1 ; i <= num; i++){
            Node node = new Node(i);
            if (i == 1){
                first = node;
                node.setNext(first);
                current = node;
            }else{
                current.setNext(node);
                node.setNext(first);
                current = node;
            }
        }
    }

    /**
     * 遍历链表
     */
    public void show(){
        if (isEmpty()){
            logger.error("链表为空");
            return;
        }
        Node temp = first.getNext();
        logger.info(first.getId().toString());
        while ( temp != first ){
            logger.info(temp.getId().toString());
            temp = temp.getNext();
        }
    }

    /**
     * 链表判空
     * @return
     */
    public boolean isEmpty(){
        return first.getNext() == null;
    }
}
