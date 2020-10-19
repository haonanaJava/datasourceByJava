package com.heyutang.datastructure.SortAlgorithm;

import com.heyutang.datastructure.Utils.ArrayUtils;
import com.heyutang.datastructure.Utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Quick {

    private static final Logger LOGGER = LoggerFactory.getLogger(Quick.class);

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.createRandomArray(8000000);

//        LOGGER.info("排序前" + Arrays.toString(randomArray));
        TimeUtils.before();
        sort(randomArray, 0, randomArray.length - 1);
        TimeUtils.after();
//        LOGGER.info("排序后" + Arrays.toString(randomArray));
    }


    public static void sort(int[] arr, int left, int right){
        int l = left;
        int r = right;

        //中轴
        int pivot = arr[(left + right) / 2];

        //临时变量， 用于交换
        int temp = 0;

        while ( l < r ){

            while ( arr[l] < pivot){
                l += 1;
            }
            while ( arr[r] > pivot){
                r -= 1;
            }

            if (l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if ( arr[l] == pivot ){
                r -= 1;
            }
            if ( arr[r] == pivot ){
                l += 1;
            }
        }

        if ( l == r ){
            l += 1;
            r -= 1;
        }
        if ( left < r ){
            sort(arr, left, r);
        }
        if ( right > l ){
            sort(arr, l, right);
        }
    }

}
