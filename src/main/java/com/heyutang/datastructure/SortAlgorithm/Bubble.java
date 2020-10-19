package com.heyutang.datastructure.SortAlgorithm;

import com.heyutang.datastructure.Utils.ArrayUtils;
import com.heyutang.datastructure.Utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bubble {

    private static final Logger LOGGER = LoggerFactory.getLogger(Bubble.class);

    public static void main(String[] args) {

        int[] randomArray = ArrayUtils.createRandomArray(80000);

        TimeUtils.before();

        sort(randomArray);

        TimeUtils.after();
    }

    public static void sort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag){
                break;
            }else{
                flag = false;
            }
        }
    }

}
