package com.Chinazhouwy.sorting_algorithm;

import com.Chinazhouwy.Algorithm;
import com.Chinazhouwy.sorting_algorithm.utils.DataUtil;

/**
 * Hello world!
 *
 */

public class SelectionSortAlgorithm extends Algorithm {


    @Override
    public void excute(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length ; j++) {
                if(array[i] > array[j] ){
                    DataUtil.swap(array,i,j);
                }
            }
        }
    }



}
