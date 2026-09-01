package com.chinazhouwy.algolab.sort;

import com.chinazhouwy.algolab.utils.ArrayUtils;
import org.junit.Test;

public class SortTest {

    @Test
    public void testSelectionSort(){
        testSort(SelectionSort.class,10,15,36);
    }

    @Test
    public void testInsertSort(){
        testSort(InsertionSort.class,10,15,360);
    }


    private void testSort(Class algorithm,int num,int min,int max){
        int[] arr = ArrayUtils.generateRandomArray(num,min,max);
        try {
            SortAlgorithm s = (SortAlgorithm)algorithm.newInstance();
            s.setData(arr).run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ArrayUtils.printArray(arr);
        }
    }

}
