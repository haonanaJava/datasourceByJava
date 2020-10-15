package com.heyutang.datastructure.Recursion;

public class Labyrinth {

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][2] = 1;
        map[3][1] = 1;

        setWay(map, 1, 1);

        show(map);

    }

    /**
     * 使用递归 找到迷宫的出口
     * 策略 down -> right -> top -> left
     * @param map
     * @param x
     * @param y
     * @return
     */
    public static boolean setWay(int[][] map, int x, int y){
        if (map[6][5] == 2){
            return true;
        }else{
            if (map[x][y] == 0){
                //此时 说明这条路可以走， 并将当前路置为2 表示走过
                map[x][y] = 2;
                if (setWay(map, x + 1, y)){
                    return true;
                }else if (setWay(map, x, y + 1)){
                    return true;
                }else if (setWay(map, x - 1, y)){
                    return true;
                }else if (setWay(map, x, y - 1)){
                    return true;
                }else{
                    map[x][y] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }


    /**
     * 打印地图
     * @param arr
     */
    public static void show(int[][] arr){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
