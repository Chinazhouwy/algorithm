package com.chinazhouwy.sorting_algorithm;

import com.Chinazhouwy.Algorithm;
import com.Chinazhouwy.sorting_algorithm.utils.DataUtil;

/**
 *
 *   56 62 64 65 61 63 61 66 70 61
 *    0  1  2  3  4  5  6  7  8  9
 *       i
 *  i-1
 */
public class InsertSortAlgorithm extends Algorithm {
    @Override
    public void excute(int[] data) {
        for(int i = 1; i < data.length;i++){
            for (int j = i; j > 0 ; j--) {
                if(data[j] < data[j-1]){
                    DataUtil.swap(data,j,j-1);
                }
            }
        }
    }
}
