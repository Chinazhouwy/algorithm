package com.chinazhouwy.algolab.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilsTest {
    @Test
    public void generateRandomArray() throws Exception {
        ArrayUtils.generateRandomArray(10,56,72);
    }

    @Test
    public void printArray() throws Exception {
        ArrayUtils.printArray(ArrayUtils.generateRandomArray(10,56,72));
    }

}
