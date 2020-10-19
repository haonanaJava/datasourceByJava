package com.heyutang.datastructure.Utils;

public class ArrayUtils {

    public static int[] createRandomArray(int size){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 800000);
        }
        return arr;
    }
}
