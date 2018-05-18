package com.Chinazhouwy.sorting_algorithm;

import com.Chinazhouwy.sorting_algorithm.utils.DataUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void test(){
        int[] arr = DataUtil.generateRandomArray(10,15,36);
        SelectionSort.selectionSort(arr);
        DataUtil.printArray(arr);
    }

}