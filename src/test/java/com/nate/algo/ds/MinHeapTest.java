package com.nate.algo.ds;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {

    private MinHeap<Integer> heap;

    @Before
    public void init() {
        Integer[] arr = {3, 1, 9, 2, 5, 7, 7, 4};
        heap = new MinHeap<Integer>(arr);
    }

    @Test
    public void minHeapInitializeTest() throws Exception {
        assertEquals(heap.extractMin(), (Integer)1);
        assertEquals(heap.extractMin(), (Integer)2);
        assertEquals(heap.extractMin(), (Integer)3);
        assertEquals(heap.extractMin(), (Integer)4);
        assertEquals(heap.extractMin(), (Integer)5);
        assertEquals(heap.extractMin(), (Integer)7);
        assertEquals(heap.extractMin(), (Integer)7);
        assertEquals(heap.extractMin(), (Integer)9);
    }
}