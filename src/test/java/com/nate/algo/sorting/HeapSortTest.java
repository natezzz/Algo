package com.nate.algo.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapSortTest {
    @Test
    public void sort() throws Exception {
        Integer[] arr = {3, 1, 2, 5, 4};
        HeapSort.sort(arr);
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, arr);

        String[] sArr = {"bubble", "bacon", "cheese", "array", "cake"};
        HeapSort.sort(sArr);
        assertArrayEquals(new String[] {
                        "array",
                        "bacon",
                        "bubble",
                        "cake",
                        "cheese"
                },
                sArr);
    }

}