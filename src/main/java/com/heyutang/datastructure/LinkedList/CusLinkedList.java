package com.heyutang.datastructure.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class CusLinkedList {

    private Node header = new Node(0,"");

    private static final Logger logger = LoggerFactory.getLogger(CusLinkedList.class);
    /**
     * 添加节点到链表的最后
     * @param node
     */
    public void add(Node node){
        Node temp = header;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    /**
     * 根据node Id 的循序添加
     * @param node
     */
    public void addSorted(Node node){
        Node temp = header;
        Boolean flag = false;
        while (temp.getNext() != null){
            if (temp.getNext().getId() > node.getId()){
                break;
            }else if (temp.getNext().getId() == node.getId()){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            logger.info("该节点ID已存在");
        }else{
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
    }

    /**
     * 更新指定索引的节点
     * @param index
     * @param node
     */
    public void set(int index, Node node){
        if (index < 0 || index > size()){
            logger.error("非法参数");
            return;
        }
        Node temp = header;
        int count = 0;
        while (count != index){
            count++;
            temp = temp.getNext();
        }
        temp.setId(node.getId());
        temp.setName(node.getName());
    }

    /**
     * 删除指定下表的节点
     * @param index
     */
    public void remove(int index){
        if (index < 0 || index > size()){
            logger.error("非法参数");
            return;
        }
        Node temp = header;
        int count = 0;
        while(count != index - 1){
            count++;
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
    }

    public int size() {
        if (isEmpty()){
            return 0;
        }
        int count = 0;
        Node temp = header.getNext();
        while(temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }


    /**
     * 遍历链表
     */
    public void show(){
        Node temp = header.getNext();
        while (temp != null){
            logger.info(temp.toString());
            temp = temp.getNext();
        }
    }

    /**
     * 链表判空
     * @return
     */
    public boolean isEmpty(){
        return header.getNext() == null;
    }
}
