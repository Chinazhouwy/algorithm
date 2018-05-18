package com.Chinazhouwy.sorting_algorithm.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataUtilTest {
    @Test
    public void generateRandomArray() throws Exception {
        DataUtil.generateRandomArray(10,56,72);
    }

    @Test
    public void printArray() throws Exception {
        DataUtil.printArray(DataUtil.generateRandomArray(10,56,72));
    }

}