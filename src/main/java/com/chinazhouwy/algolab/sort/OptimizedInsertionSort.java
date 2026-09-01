package com.chinazhouwy.algolab.sort;

public class OptimizedInsertionSort extends SortAlgorithm {

    @Override
    public void execute(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int e = data[i];
            for (int j = 1; i > 0 && data[j] < data[j-1]; j--) {

            }
        }
    }
}
