package com.heyutang.datastructure.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CusDoublyLinkedList {

    private DoublyNode header = new DoublyNode(0, "");

    private static final Logger logger = LoggerFactory.getLogger(CusDoublyLinkedList.class);

    /**
     * 添加节点到列表的尾部
     * @param node
     */
    public boolean add(DoublyNode node){
        DoublyNode temp = header;
        while( temp.getNext() != null ){
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPrev(temp);
        return true;
    }

    /**
     * 删除指定下表的节点
     * @param index
     */
    public void remove(int index){
        if (isEmpty()){
            logger.error("链表为空");
            return;
        }
        if (index < 0 || index > size()){
            logger.error("非法参数");
            return;
        }
        DoublyNode temp = header;
        int count = 0;
        while(count != index){
            count++;
            temp = temp.getNext();
        }
        if (temp.getNext() == null){
            temp.getPrev().setNext(null);
            return;
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
    }

    /**
     * 更新指定索引的节点
     * @param index
     * @param node
     */
    public void set(int index, DoublyNode node){
        if (index < 0 || index > size()){
            logger.error("非法参数");
            return;
        }
        DoublyNode temp = header;
        int count = 0;
        while (count != index){
            count++;
            temp = temp.getNext();
        }
        temp.setId(node.getId());
        temp.setName(node.getName());
    }

    /**
     * 遍历链表
     */
    public void show(){
        DoublyNode temp = header.getNext();
        while (temp != null){
            logger.info(temp.toString());
            temp = temp.getNext();
        }
    }

    public int size() {
        if (isEmpty()){
            return 0;
        }
        int count = 0;
        DoublyNode temp = header.getNext();
        while(temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }


    public DoublyNode getHeader() {
        return header;
    }

    /**
     * 链表判空
     * @return
     */
    public boolean isEmpty(){
        return header.getNext() == null;
    }
}
