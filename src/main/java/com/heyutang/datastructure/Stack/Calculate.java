package com.heyutang.datastructure.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(Calculate.class);
        logger.info("请输入计算表达式:");
        //用户输入 运算表达式
        String expression = "";
        Scanner sc = new Scanner(System.in);
        expression = sc.nextLine();

        CusStack<Integer> numberStack = new CusStack<>(10);
        CusStack<Character> operatorStack = new CusStack<>(10);

        //用于扫描的下标
        int index = 0;
        int n1 = 0;
        int n2 = 0;
        char operator = ' ';
        int result = 0;
        char ch = ' ';
        StringBuilder multiple = new StringBuilder();

        while ( true ){
            ch = expression.substring(index, index + 1).charAt(0);
            if (operatorStack.isOperator(ch)){
                if (operatorStack.isEmpty()){
                    operatorStack.push(ch);
                }else{
                    if (operatorStack.priority(operatorStack.peek()) >= operatorStack.priority(ch)){
                        //此时 从操作符stack中pop出 ，和数stack pop出两个数进行运算， 再push进数stack
                        n1 = numberStack.pop();
                        n2 = numberStack.pop();
                        operator = operatorStack.pop();
                        result = numberStack.calculate(n1, n2, operator);
                        numberStack.push(result);
                        operatorStack.push(ch);
                    }else{
                        operatorStack.push(ch);
                    }
                }
            }else{
                multiple.append(ch);
                if (index == expression.length() - 1){
                    numberStack.push(Integer.parseInt(String.valueOf(multiple)));
                }else{
                    char c = expression.substring(index + 1, index + 2).charAt(0);
                    if(operatorStack.isOperator(c)){
                        numberStack.push(Integer.parseInt(String.valueOf(multiple)));
                        multiple.setLength(0);
                    }
                }
                //清空
            }
            index++;
            if (index >= expression.length())
                break;
        }
        while( !operatorStack.isEmpty() ){
            n1 = numberStack.pop();
            n2 = numberStack.pop();
            operator = operatorStack.pop();
            //此处有坑， 应该是n2 - n1 后pop出的减去先pop出的
            result = numberStack.calculate(n1, n2, operator);
            numberStack.push(result);
        }
        logger.info("最后的计算结果是" + numberStack.pop());
    }


}
