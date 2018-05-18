package com.Chinazhouwy.sorting_algorithm.utils;

import java.text.MessageFormat;
import java.util.Arrays;

public class DataUtil {


    /**
     * generate an n-array ,each value >= min ,<= max
     * @param num
     * @param min
     * @param max
     * @return
     */
    public static int[] generateRandomArray(int num,int min,int max){

        assert min <= max;
        int[] array = new int[num];
        /**
         *  [0,1) => [2,5]
         *  [0,1) => 4 => [0,4) + 2 = > [2,6)
         *
         *  [0,1) * (max - min + 1) = [0,max -min + 1)
         *  [0,max -min + 1) + min = [min,max+1)
         */
        System.out.print("generate array: ");
        for (int i = 0; i < num ; i++) {
            double a = Math.random();
            array[i] = (int) (a*(max-min+1) + min);
            System.out.print(array[i]+" ");
        }
        System.out.println();

        return array;
    }

    public static void printArray(int[] array){
        System.out.print("sorted array: ");
        Arrays.stream(array).forEach(e -> System.out.print(e+" "));
        System.out.println();
    }

}
