package com.heyutang.datastructure.Algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用 分治算法(Divide and Conquer) 解决汉诺塔问题 （有点没有听懂 -_-! 难受啊）
 */
public class Hanoi {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hanoi.class);

    public static void main(String[] args) {
        move(5, 'A', 'B', 'C');
    }

    public static void move(int num, char A, char B, char C){
        if (num == 1){
            LOGGER.info("移动" + A + "到" + C);
        }else{
            move(num - 1, A, C, B);
            LOGGER.info("移动" + A + "到" + C);
            move(num - 1, B, A, C);
        }
    }

}
