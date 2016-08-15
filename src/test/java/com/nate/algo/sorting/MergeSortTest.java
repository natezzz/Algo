package com.nate.algo.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sortTest() {
        Integer[] arr = {3, 1, 2, 5, 4};
        MergeSort.sort(arr);
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, arr);

        String[] sArr = {"bubble", "bacon", "cheese", "array", "cake"};
        MergeSort.sort(sArr);
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