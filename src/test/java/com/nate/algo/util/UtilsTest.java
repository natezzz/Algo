package com.nate.algo.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UtilsTest {
    @Test
    public void swap() throws Exception {
        Integer[] arr = {1, 3, 2, 4, 5};
        Utils.swap(arr, 1, 2);
        assertArrayEquals("Result ", new Integer[]{1, 2, 3, 4, 5},
                          arr);
    }

    @Test
    public void shuffleTest() {
        Integer[] arr = {1, 2, 3, 4, 5};
        Utils.shuffle(arr);
        System.out.println(Arrays.asList(arr));
    }
}