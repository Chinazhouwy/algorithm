package com.Chinazhouwy.sorting_algorithm;

import com.Chinazhouwy.sorting_algorithm.utils.DataUtil;

/**
 * Hello world!
 *
 */
public class SelectionSort {

    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length ; j++) {
                if(array[i] > array[j] ){
                    swap(array,i,j);
                }
            }
        }
//        DataUtil.printArray(array);
    }

    private static void swap(int[] array,int i, int j) {
        array[i] = array[i]^array[j];
        array[j] = array[i]^array[j];
        array[i] = array[i]^array[j];
    }

}
