package com.nate.algo.sorting;

import static com.nate.algo.util.Utils.swap;

public class BubbleSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null)
            return;

        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i].compareTo(arr[i+1]) > 0) {
                    swap(arr, i, i+1);
                    swapped = true;
                }
            }
        }
    }
}
