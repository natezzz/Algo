package com.nate.algo.sorting;

import static com.nate.algo.util.Utils.shuffle;
import static com.nate.algo.util.Utils.swap;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length <= 1)
            return;  // nothing to sort

        shuffle(arr);
        sort(arr, 0, arr.length);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int begin, int end) {
        if (begin >= end-1)
            return;

        T pivot = arr[begin];

        int j = end - 1;
        int i = begin + 1;
        while (i <= j) {
            if (arr[i].compareTo(pivot) > 0) {
                swap(arr, i, j);
                j--;
            } else {
                i++;
            }
        }

        swap(arr, i-1, begin);
        sort(arr, begin, i - 1);
        sort(arr, i, end);
    }
}
