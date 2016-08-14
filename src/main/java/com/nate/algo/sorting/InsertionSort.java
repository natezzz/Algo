package com.nate.algo.sorting;

import static com.nate.algo.util.Utils.*;

public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null)
            return;

        for (int i = 1; i < arr.length; i++) {
            T target = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].compareTo(target) > 0)) {
                swap(arr, j, j+1);
                j--;
            }
            arr[j+1] = target;
        }
    }

}
