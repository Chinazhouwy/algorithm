package com.Chinazhouwy;

import com.Chinazhouwy.sorting_algorithm.InsertSortAlgorithm;
import com.Chinazhouwy.sorting_algorithm.SelectionSortAlgorithm;
import com.Chinazhouwy.sorting_algorithm.utils.DataUtil;
import org.junit.Test;

public class SortAlgorithmTest {

    @Test
    public void testSelectionSort(){
        testSort(SelectionSortAlgorithm.class,10,15,36);
    }

    @Test
    public void testInsertSort(){
        testSort(InsertSortAlgorithm.class,10,15,360);
    }


    private void testSort(Class algorithm,int num,int min,int max){
        int[] arr = DataUtil.generateRandomArray(num,min,max);
        try {
            Algorithm s = (Algorithm)algorithm.newInstance();
            s.setData(arr).run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataUtil.printArray(arr);
        }
    }

}