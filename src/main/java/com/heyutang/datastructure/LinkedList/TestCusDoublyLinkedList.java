package com.heyutang.datastructure.LinkedList;

import java.util.LinkedList;

public class TestCusDoublyLinkedList {
    public static void main(String[] args) {
        CusDoublyLinkedList doublyLinkedList = new CusDoublyLinkedList();
        doublyLinkedList.add(new DoublyNode(1, "knight"));
        doublyLinkedList.add(new DoublyNode(2, "Tian"));
        doublyLinkedList.add(new DoublyNode(3, "Doinb"));
        doublyLinkedList.add(new DoublyNode(4, "TheShy"));
        doublyLinkedList.add(new DoublyNode(5, "UZI"));
        doublyLinkedList.set(4, new DoublyNode(4, "TheBin"));
        doublyLinkedList.remove(3);
        doublyLinkedList.show();
        new LinkedList<String>();
    }
}
