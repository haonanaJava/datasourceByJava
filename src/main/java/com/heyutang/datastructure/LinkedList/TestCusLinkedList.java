package com.heyutang.datastructure.LinkedList;


import java.util.LinkedList;

public class TestCusLinkedList {
    public static void main(String[] args) {
        CusLinkedList cusLinkedList = new CusLinkedList();
        cusLinkedList.addSorted(new Node(1,"heyutang"));
        cusLinkedList.addSorted(new Node(5,"369"));
        cusLinkedList.addSorted(new Node(3,"xiaohong"));
        cusLinkedList.addSorted(new Node(2,"xiaoming"));
        cusLinkedList.addSorted(new Node(4,"knight"));
        cusLinkedList.set(3, new Node(3, "xiaolongbao"));
        cusLinkedList.remove(4);
        cusLinkedList.show();

        LinkedList<Object> linkedList = new LinkedList<>();
    }
}
