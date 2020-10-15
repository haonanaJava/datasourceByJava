package com.heyutang.datastructure.Recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 回溯 算法解决 八皇后问题
 */
public class EightQueens {
    int max = 8;
    int[] checkerboard = new int[max];

    static int count = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(EightQueens.class);

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        LOGGER.info("总共的解法有：" + count);
    }

    /**
     * 放置 queen
     */
    public void check(int n){
        if (n == max){
            show();
            return;
        }
        for (int i = 0; i < max; i++){
            checkerboard[n] = i;
            if (judge(n)){
                check(n + 1);
            }
        }
    }

    /**
     * 判断皇后的位置是否符合规则
     * @param n
     * @return
     */
    private boolean judge(int n ){
        for (int i = 0; i < n;i++){
            if (checkerboard[i] == checkerboard[n] || Math.abs(n - i) == Math.abs(checkerboard[n] - checkerboard[i])){
                return false;
            }
        }
        return true;
    }

    private void show(){
        count++;
        for (int j : checkerboard) {
            System.out.print(j);
        }
        System.out.println();
    }
}
