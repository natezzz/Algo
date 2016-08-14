package com.nate.algo.sorting;

import static com.nate.algo.util.Utils.swap;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null)
            return;

        for (int i = 0; i < arr.length; i++) {
            int toSwap = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[toSwap]) < 0) {
                    toSwap = j;
                }
            }

            swap(arr, i, toSwap);
        }
    }
}
