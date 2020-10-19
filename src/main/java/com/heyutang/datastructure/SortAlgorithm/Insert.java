package com.heyutang.datastructure.SortAlgorithm;

import com.heyutang.datastructure.Utils.ArrayUtils;
import com.heyutang.datastructure.Utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Insert {

    private static final Logger LOGGER = LoggerFactory.getLogger(Insert.class);

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.createRandomArray(80000);

        TimeUtils.before();
        sort(randomArray);
        TimeUtils.after();

//        LOGGER.info(Arrays.toString(randomArray));
    }

    public static void sort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] < insertValue){
                //这里不能是arr[i] 因为在向有序列表插入时， 还要进行排序
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i)
                arr[insertIndex + 1] = insertValue;

        }


    }
}
