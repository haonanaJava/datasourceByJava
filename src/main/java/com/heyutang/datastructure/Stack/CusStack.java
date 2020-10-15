package com.heyutang.datastructure.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EmptyStackException;

public class CusStack<E> {
    private int maxSize;

    private Object array[];

    private int top;

    private static final Logger logger = LoggerFactory.getLogger(CusStack.class);

    public CusStack(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.top = -1;
    }

    /**
     * 向栈中压入一个数据
     */
    public E push(E value){
        if (isFull()){
            logger.error("stack 已满");
            throw new StackOverflowError();
        }
        array[++top] = value;
        return value;
    }

    public E pop(){
        if (isEmpty()){
            logger.error("stack 为空");
            throw new EmptyStackException();
        }

        return elementData(top--);
    }

    public boolean isOperator(char operator ){
        return operator == '*' || operator == '/' || operator == '+' || operator == '-';
    }

    /**
     * 判断操作符的优先级
     * @param operator
     * @return 返回值越高，优先级越高 , -1 表示非法操作符
     */
    public int priority(int operator){
        if (operator == '*' || operator == '/'){
            return 1;
        }else if (operator == '+' || operator == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 计算方法
     * @param n1
     * @param n2
     * @param operator
     * @return 计算结果
     */
    public int calculate(int n1, int n2, char operator){
        int result = 0;
        switch (operator){
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n2 / n1;
                break;
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n2 - n1;
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 得到当前栈的栈顶元素，并不是pop
     * @return
     */
    public E peek(){
        return elementData(top);
    }

    @SuppressWarnings("unchecked")
    public E elementData(int index){
        return (E) array[index];
    }


    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

}
