package com.heyutang.datastructure.SortAlgorithm;

import com.heyutang.datastructure.Utils.ArrayUtils;
import com.heyutang.datastructure.Utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Shell {

    private static final Logger LOGGER = LoggerFactory.getLogger(Shell.class);

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.createRandomArray(8000000);

        TimeUtils.before();
        sort(randomArray);
        TimeUtils.after();

//        LOGGER.info(Arrays.toString(randomArray));
    }

    /**
     * 交换法 (效率较低)
     * @param arr
     */
    public static void sort(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2){

            for (int i = gap; i < arr.length; i++){

                for (int j = i - gap; j >= 0; j -= gap){
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }
}
