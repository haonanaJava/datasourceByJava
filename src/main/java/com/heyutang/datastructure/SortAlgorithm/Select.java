package com.heyutang.datastructure.SortAlgorithm;

import com.heyutang.datastructure.Utils.ArrayUtils;
import com.heyutang.datastructure.Utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Select {

    private static final Logger LOGGER = LoggerFactory.getLogger(Select.class);

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.createRandomArray(80000);

        TimeUtils.before();

        sort(randomArray);

        TimeUtils.after();

//        LOGGER.info(Arrays.toString(randomArray));
    }


    private static void sort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i + 1; j < arr.length;j++){
                if (minValue > arr[j]){
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }
}
