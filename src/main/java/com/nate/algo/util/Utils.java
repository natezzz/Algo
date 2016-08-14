package com.nate.algo.util;

public final class Utils {

    private Utils() {}

    public static <T> void swap(T[] arr, int i, int j) {
        assert (arr != null);
        assert (i >= 0 && i < arr.length);
        assert (j >= 0 && j < arr.length);

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
