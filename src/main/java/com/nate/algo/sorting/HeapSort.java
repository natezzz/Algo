package com.nate.algo.sorting;

import com.nate.algo.ds.MinHeap;

public class HeapSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        MinHeap<T> heap = new MinHeap<T>(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.extractMin();
        }
    }
}
