package com.Chinazhouwy.sorting_algorithm;

import com.Chinazhouwy.Algorithm;

public class InsertSortAlgorithmOptimization extends Algorithm {
    @Override
    public void excute(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int e = data[i];
            for (int j = 1; i > 0 && data[j] < data[j-1]; j--) {

            }
        }
    }
}
