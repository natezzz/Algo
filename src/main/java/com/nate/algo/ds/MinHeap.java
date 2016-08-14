package com.nate.algo.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

    private List<T> heap;
    private int size;

    public MinHeap() {
        // creates an empty min-heap
        heap = new ArrayList<T>();
        heap.add(null);   // dummy for 1-indexing
        size = 0;
    }

    public MinHeap(T[] arr) {
        // creates a min-heap with given data arr
        heap = new ArrayList<T>();
        heap.add(null);   // dummy element for 1-indexing
        size = 0;
        makeHeap(arr);
    }

    private void printHeap() {
        for (T t : heap) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private void makeHeap(T[] arr) {
        for (T t : arr) {
            insert(t);
        }
    }

    public void insert(T t) {
        // insert t into heap
        heap.add(t);
        size++;
        swimUp(size);
    }

    public T extractMin() {
        if (size == 0) {
            return null;
        }

        T t = heap.get(1);
        heap.set(1, heap.get(size));
        heap.remove(size);
        size--;
        sinkDown(1);
        return t;
    }

    private void swimUp(int which) {
        if (which == 1)
            return;

        int parent = parent(which);
        if (heap.get(which).compareTo(heap.get(parent)) < 0) {
            Collections.swap(heap, which, parent);
            swimUp(parent);
        }
    }

    private void sinkDown(int which) {
        int minIndex = which;
        int lChild = leftChild(which);

        for (int i = 0; i <= 1; i++) {
            if ((lChild + i) <= size()) {
                if (heap.get(lChild+i).compareTo(heap.get(minIndex)) < 0) {
                    minIndex = lChild + i;
                }
            }
        }

        if (minIndex != which) {
            Collections.swap(heap, which, minIndex);
            sinkDown(minIndex);
        }
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public boolean hasMore() {
        return !empty();
    }

    private int parent(int which) {
        return which/2;
    }

    private int leftChild(int which) {
        return which*2;
    }

    private int rightChild(int which) {
        return which*2 + 1;
    }
}
