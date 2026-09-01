package com.chinazhouwy.algolab.sort;

import com.chinazhouwy.algolab.utils.ArrayUtils;

/**
 * Hello world!
 *
 */

public class SelectionSort extends SortAlgorithm {


    @Override
    public void execute(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length ; j++) {
                if(array[i] > array[j] ){
                    ArrayUtils.swap(array,i,j);
                }
            }
        }
    }



}
