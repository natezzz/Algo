package com.nate.algo.sorting;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int begin, int end) {
        if (begin >= end-1)
            return;  // nothing to sort

        int mid = (begin + end) / 2;
        sort(arr, begin, mid);
        sort(arr, mid, end);
        merge(arr, begin, mid, end);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int begin, int mid, int end) {
        Object[] temp = new Object[end-begin];

        int i = begin;
        int j = mid;
        int k = 0;
        while (i < mid && j < end) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }

        while (j < end) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < (end-begin); i++) {
            arr[begin+i] = (T) temp[i];
        }
    }
}
