package com.heyutang.datastructure.Josepfu;

public class TestCircleLinkedList {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.fillByNums(5);
        circleLinkedList.start(1, 2);
        circleLinkedList.show();
    }
}
