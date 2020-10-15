package com.heyutang.datastructure.Stack;

public class TestCusStack {
    public static void main(String[] args) {
        CusStack<String> cusStack = new CusStack<>(4);
        cusStack.push("何育堂");
        cusStack.push("knight");
        cusStack.push("TheShy");
        cusStack.push("TheShy1");
        cusStack.push("TheShy2");

        String pop = cusStack.pop();
        String pop1 = cusStack.pop();
        System.out.println(pop);
        System.out.println(pop1);
    }
}
